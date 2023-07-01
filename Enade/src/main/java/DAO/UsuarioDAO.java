/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author joaod
 */
import MODEL.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Usuario insert(Usuario usuario) {
    String sql = "INSERT INTO usuario (nome, email, senha, TipoUsuario_idTipoUsuario) VALUES (?, ?, ?, ?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.setInt(4, usuario.getTipoUsuario_idTipoUsuario());

        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                usuario.setIdUsuario(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        stmt.close();
        return usuario;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    public List<Usuario> getAll() {
    List<Usuario> usuarios = new ArrayList<>();

    String sql = "SELECT * FROM usuario";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setTipoUsuario_idTipoUsuario(rs.getInt("TipoUsuario_idTipoUsuario"));
            
            usuarios.add(usuario);
        }

        rs.close();
        stmt.close();

        return usuarios;

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

public Usuario getById(int id) {
    Usuario usuario = null;

    String sql = "SELECT * FROM usuario WHERE idUsuario = ?";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setTipoUsuario_idTipoUsuario(rs.getInt("TipoUsuario_idTipoUsuario"));
        }

        rs.close();
        stmt.close();

        return usuario;

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

public void update(Usuario usuario) {
    String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, TipoUsuario_idTipoUsuario = ? WHERE idUsuario = ?";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.setInt(4, usuario.getTipoUsuario_idTipoUsuario());
        stmt.setInt(5, usuario.getIdUsuario());

        stmt.execute();
        stmt.close();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

public void delete(int id) {
    String sql = "DELETE FROM usuario WHERE idUsuario = ?";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    public Usuario save(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
