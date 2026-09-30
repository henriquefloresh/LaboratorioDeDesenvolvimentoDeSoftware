package dao;

import beans.Aluno;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir aluno: " + ex.getMessage());
            return false;
        }
    }
}
