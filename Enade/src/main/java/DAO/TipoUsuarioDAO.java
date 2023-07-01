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
import MODEL.TipoUsuario;

public class TipoUsuarioDAO {

    private Connection conn;

    public TipoUsuarioDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insert(TipoUsuario tipoUsuario) {
        String sql = "INSERT INTO TipoUsuario(idTipoUsuario, nomeTipoUsuario) VALUES(?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tipoUsuario.getIdTipoUsuario());
            stmt.setString(2, tipoUsuario.getNomeTipoUsuario());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TipoUsuario> getAll() {
        String sql = "SELECT * FROM TipoUsuario";
        List<TipoUsuario> tipoUsuarios = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                tipoUsuario.setNomeTipoUsuario(rs.getString("nomeTipoUsuario"));

                tipoUsuarios.add(tipoUsuario);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tipoUsuarios;
    }

    public TipoUsuario getById(int id) {
        String sql = "SELECT * FROM TipoUsuario WHERE idTipoUsuario = ?";
        TipoUsuario tipoUsuario = new TipoUsuario();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tipoUsuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                tipoUsuario.setNomeTipoUsuario(rs.getString("nomeTipoUsuario"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tipoUsuario;
    }

    public void update(TipoUsuario tipoUsuario) {
        String sql = "UPDATE TipoUsuario SET nomeTipoUsuario = ? WHERE idTipoUsuario = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipoUsuario.getNomeTipoUsuario());
            stmt.setInt(2, tipoUsuario.getIdTipoUsuario());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TipoUsuario WHERE idTipoUsuario = ?";

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
