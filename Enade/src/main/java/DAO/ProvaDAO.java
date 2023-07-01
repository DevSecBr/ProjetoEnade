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
import MODEL.Prova;
import java.sql.Date;

public class ProvaDAO {

    private Connection conn;

    public ProvaDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insert(Prova prova) {
        String sql = "INSERT INTO Prova(idProva, dataProva) VALUES(?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, prova.getIdProva());
            stmt.setDate(2, (Date) prova.getDataProva());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prova> getAll() {
        try {
            List<Prova> provas = new ArrayList<Prova>();
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM Prova");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Prova prova = new Prova();
                prova.setIdProva(rs.getInt("idProva"));
                prova.setDataProva(rs.getDate("dataProva"));

                provas.add(prova);
            }
            rs.close();
            stmt.close();
            return provas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Prova getById(int id) {
        try {
            Prova prova = new Prova();
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM Prova WHERE idProva=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                prova.setIdProva(rs.getInt("idProva"));
                prova.setDataProva(rs.getDate("dataProva"));
            }
            rs.close();
            stmt.close();
            return prova;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Prova prova) {
        String sql = "UPDATE Prova SET dataProva=? WHERE idProva=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, (Date) prova.getDataProva());
            stmt.setInt(2, prova.getIdProva());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Prova WHERE idProva=?");
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
