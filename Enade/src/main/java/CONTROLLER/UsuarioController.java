/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

/**
 *
 * @author joaod
 */
import DAO.UsuarioDAO;
import MODEL.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioDAO.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable int id) {
        Usuario usuario = usuarioDAO.getById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @PostMapping
    public Usuario insert(@RequestBody Usuario usuario) {
        return usuarioDAO.insert(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioDAO.getById(id);
        if (existingUsuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            usuario.setIdUsuario(id);
            usuarioDAO.update(usuario);
            return ResponseEntity.ok(usuario);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Usuario existingUsuario = usuarioDAO.getById(id);
        if (existingUsuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            usuarioDAO.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
}
