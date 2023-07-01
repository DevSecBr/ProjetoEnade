/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author joaod
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import MODEL.ProvaQuestao;

public class ProvaQuestaoDAO {

    private Connection conn;

    public ProvaQuestaoDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insert(ProvaQuestao provaQuestao) {
        String sql = "INSERT INTO Prova_has_Questao(Prova_idProva, Questao_idQuestao) VALUES(?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, provaQuestao.getProva_idProva());
            stmt.setInt(2, provaQuestao.getQuestao_idQuestao());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProvaQuestao> getAll() {
        String sql = "SELECT * FROM Prova_has_Questao";
        List<ProvaQuestao> provaQuestoes = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProvaQuestao provaQuestao = new ProvaQuestao();
                provaQuestao.setProva_idProva(rs.getInt("Prova_idProva"));
                provaQuestao.setQuestao_idQuestao(rs.getInt("Questao_idQuestao"));

                provaQuestoes.add(provaQuestao);
            }

            rs.close();
            stmt.close();
            return provaQuestoes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ProvaQuestao getById(int provaId, int questaoId) {
        String sql = "SELECT * FROM Prova_has_Questao WHERE Prova_idProva = ? AND Questao_idQuestao = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, provaId);
            stmt.setInt(2, questaoId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ProvaQuestao provaQuestao = new ProvaQuestao();
                provaQuestao.setProva_idProva(rs.getInt("Prova_idProva"));
                provaQuestao.setQuestao_idQuestao(rs.getInt("Questao_idQuestao"));
                rs.close();
                stmt.close();
                return provaQuestao;
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(ProvaQuestao provaQuestao) {
        String sql = "UPDATE Prova_has_Questao SET Prova_idProva = ?, Questao_idQuestao = ? WHERE Prova_idProva = ? AND Questao_idQuestao = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, provaQuestao.getProva_idProva());
            stmt.setInt(2, provaQuestao.getQuestao_idQuestao());
            stmt.setInt(3, provaQuestao.getProva_idProva());
            stmt.setInt(4, provaQuestao.getQuestao_idQuestao());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int provaId, int questaoId) {
        String sql = "DELETE FROM Prova_has_Questao WHERE Prova_idProva = ? AND Questao_idQuestao = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, provaId);
            stmt.setInt(2, questaoId);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
