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
import MODEL.Questao;

public class QuestaoDAO {

    private Connection conn;

    public QuestaoDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insert(Questao questao) {
        String sql = "INSERT INTO Questao(idQuestao, descricaoQuestao, alternativaA, alternativaB, alternativaC, alternativaD, alternativaE, questaoCorreta, estadoQuestao, TipoQuestao_idTipoQuestao) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, questao.getIdQuestao());
            stmt.setString(2, questao.getDescricaoQuestao());
            stmt.setString(3, questao.getAlternativaA());
            stmt.setString(4, questao.getAlternativaB());
            stmt.setString(5, questao.getAlternativaC());
            stmt.setString(6, questao.getAlternativaD());
            stmt.setString(7, questao.getAlternativaE());
            stmt.setString(8, String.valueOf(questao.getQuestaoCorreta())); // change here
            stmt.setInt(9, questao.getEstadoQuestao());
            stmt.setInt(10, questao.getTipoQuestao_idTipoQuestao());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Questao> getAll() {
        String sql = "SELECT * FROM Questao";
        List<Questao> questoes = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Questao questao = new Questao();
                questao.setIdQuestao(rs.getInt("idQuestao"));
                questao.setDescricaoQuestao(rs.getString("descricaoQuestao"));
                questao.setAlternativaA(rs.getString("alternativaA"));
                questao.setAlternativaB(rs.getString("alternativaB"));
                questao.setAlternativaC(rs.getString("alternativaC"));
                questao.setAlternativaD(rs.getString("alternativaD"));
                questao.setAlternativaE(rs.getString("alternativaE"));
                questao.setQuestaoCorreta(rs.getString("questaoCorreta").charAt(0));
                questao.setEstadoQuestao(rs.getInt("estadoQuestao"));
                questao.setTipoQuestao_idTipoQuestao(rs.getInt("TipoQuestao_idTipoQuestao"));

                questoes.add(questao);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return questoes;
    }

    public Questao getById(int id) {
        String sql = "SELECT * FROM Questao WHERE idQuestao = ?";
        Questao questao = new Questao();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                questao.setIdQuestao(rs.getInt("idQuestao"));
                questao.setDescricaoQuestao(rs.getString("descricaoQuestao"));
                questao.setAlternativaA(rs.getString("alternativaA"));
                questao.setAlternativaB(rs.getString("alternativaB"));
                questao.setAlternativaC(rs.getString("alternativaC"));
                questao.setAlternativaD(rs.getString("alternativaD"));
                questao.setAlternativaE(rs.getString("alternativaE"));
                questao.setQuestaoCorreta(rs.getString("questaoCorreta").charAt(0));
                questao.setEstadoQuestao(rs.getInt("estadoQuestao"));
                questao.setTipoQuestao_idTipoQuestao(rs.getInt("TipoQuestao_idTipoQuestao"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return questao;
    }

    public void update(Questao questao) {
        String sql = "UPDATE Questao SET descricaoQuestao = ?, alternativaA = ?, alternativaB = ?, alternativaC = ?, alternativaD = ?, alternativaE = ?, questaoCorreta = ?, estadoQuestao = ?, TipoQuestao_idTipoQuestao = ? WHERE idQuestao = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, questao.getDescricaoQuestao());
            stmt.setString(2, questao.getAlternativaA());
            stmt.setString(3, questao.getAlternativaB());
            stmt.setString(4, questao.getAlternativaC());
            stmt.setString(5, questao.getAlternativaD());
            stmt.setString(6, questao.getAlternativaE());
            stmt.setString(7, String.valueOf(questao.getQuestaoCorreta()));
            stmt.setInt(8, questao.getEstadoQuestao());
            stmt.setInt(9, questao.getTipoQuestao_idTipoQuestao());
            stmt.setInt(10, questao.getIdQuestao());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Questao questao) {
        String sql = "DELETE FROM Questao WHERE idQuestao = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, questao.getIdQuestao());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
