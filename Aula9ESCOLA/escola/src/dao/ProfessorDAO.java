package dao;

import beans.Professor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorDAO {
    private final Connection conn;

    public ProfessorDAO() {
        this.conn = new Conexao().getConexao();
    }

    public boolean inserir(Professor professor) {
        String sql = "INSERT INTO professor(nome, email, departamento, titulacao) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDepartamento());
            stmt.setString(4, professor.getTitulacao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir professor: " + ex.getMessage());
            return false;
        }
    }
}
