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
import MODEL.Resultado;

public class ResultadoDAO {

    private Connection conn;

    public ResultadoDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insert(Resultado resultado) {
        String sql = "INSERT INTO Resultado(valorObtido, Usuario_idUsuario, Prova_idProva) VALUES(?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, resultado.getValorObtido());
            stmt.setInt(2, resultado.getUsuario_idUsuario());
            stmt.setInt(3, resultado.getProva_idProva());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Resultado> getAll() {
        String sql = "SELECT * FROM Resultado";
        List<Resultado> resultados = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Resultado resultado = new Resultado();
                resultado.setIdResultado(rs.getInt("idResultado"));
                resultado.setValorObtido(rs.getDouble("valorObtido"));
                resultado.setUsuario_idUsuario(rs.getInt("Usuario_idUsuario"));
                resultado.setProva_idProva(rs.getInt("Prova_idProva"));
                resultados.add(resultado);
            }

            rs.close();
            stmt.close();
            return resultados;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Resultado getById(int id) {
        String sql = "SELECT * FROM Resultado WHERE idResultado = ?";
        Resultado resultado = new Resultado();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                resultado.setIdResultado(rs.getInt("idResultado"));
                resultado.setValorObtido(rs.getDouble("valorObtido"));
                resultado.setUsuario_idUsuario(rs.getInt("Usuario_idUsuario"));
                resultado.setProva_idProva(rs.getInt("Prova_idProva"));
            }

            rs.close();
            stmt.close();
            return resultado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Resultado resultado) {
        String sql = "UPDATE Resultado SET valorObtido = ?, Usuario_idUsuario = ?, Prova_idProva = ? WHERE idResultado = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, resultado.getValorObtido());
            stmt.setInt(2, resultado.getUsuario_idUsuario());
            stmt.setInt(3, resultado.getProva_idProva());
            stmt.setInt(4, resultado.getIdResultado());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Resultado WHERE idResultado = ?";

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
