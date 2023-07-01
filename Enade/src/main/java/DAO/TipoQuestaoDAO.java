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
import MODEL.TipoQuestao;

public class TipoQuestaoDAO {

    private Connection conn;

    public TipoQuestaoDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insert(TipoQuestao tipoQuestao) {
        String sql = "INSERT INTO TipoQuestao(idTipoQuestao, nomeTipoQuestao) VALUES(?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tipoQuestao.getIdTipoQuestao());
            stmt.setString(2, tipoQuestao.getNomeTipoQuestao());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TipoQuestao> getAll() {
        List<TipoQuestao> tipoQuestoes = new ArrayList<>();

        String sql = "SELECT * FROM TipoQuestao";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TipoQuestao tipoQuestao = new TipoQuestao();
                tipoQuestao.setIdTipoQuestao(rs.getInt("idTipoQuestao"));
                tipoQuestao.setNomeTipoQuestao(rs.getString("nomeTipoQuestao"));

                tipoQuestoes.add(tipoQuestao);
            }

            rs.close();
            stmt.close();

            return tipoQuestoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoQuestao getById(int id) {
        TipoQuestao tipoQuestao = new TipoQuestao();

        String sql = "SELECT * FROM TipoQuestao WHERE idTipoQuestao = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tipoQuestao.setIdTipoQuestao(rs.getInt("idTipoQuestao"));
                tipoQuestao.setNomeTipoQuestao(rs.getString("nomeTipoQuestao"));
            }

            rs.close();
            stmt.close();

            return tipoQuestao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(TipoQuestao tipoQuestao) {
        String sql = "UPDATE TipoQuestao SET nomeTipoQuestao = ? WHERE idTipoQuestao = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoQuestao.getNomeTipoQuestao());
            stmt.setInt(2, tipoQuestao.getIdTipoQuestao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TipoQuestao WHERE idTipoQuestao = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
