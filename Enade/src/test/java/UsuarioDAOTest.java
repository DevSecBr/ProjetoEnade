/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import DAO.UsuarioDAO;
import MAIN.EnadeApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joaod
 */
import MODEL.Usuario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EnadeApplication.class)
public class UsuarioDAOTest {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Test
    public void testCriarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setEmail("joao@teste.com");
        usuario.setSenha("senha123");

        Usuario savedUser = usuarioDAO.insert(usuario);

        assertNotNull(savedUser);
        assertEquals(usuario.getNome(), savedUser.getNome());
        assertEquals(usuario.getEmail(), savedUser.getEmail());
    }

}
