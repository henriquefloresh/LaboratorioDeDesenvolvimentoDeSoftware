package dao;

import beans.Aluno;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final Connection conn;

    public AlunoDAO() {
        this.conn = new Conexao().getConexao();
    }

    public boolean inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno(nome, matricula, email, curso) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getCurso());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir aluno: " + ex.getMessage());
            return false;
        }
    }

    public List<Aluno> consultar() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT id, nome, matricula, email, curso FROM aluno ORDER BY nome";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setMatricula(rs.getString("matricula"));
                a.setEmail(rs.getString("email"));
                a.setCurso(rs.getString("curso"));
                alunos.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar alunos: " + ex.getMessage());
        }
        return alunos;
    }

    public boolean atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome=?, matricula=?, email=?, curso=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getCurso());
            stmt.setInt(5, aluno.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar aluno: " + ex.getMessage());
            return false;
        }
    }
}
