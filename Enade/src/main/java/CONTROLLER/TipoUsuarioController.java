/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

/**
 *
 * @author joaod
 */

import DAO.TipoUsuarioDAO;
import MODEL.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoUsuarios")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioDAO tipoUsuarioDAO;

    @GetMapping
    public List<TipoUsuario> getAll() {
        return tipoUsuarioDAO.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> getById(@PathVariable int id) {
        TipoUsuario tipoUsuario = tipoUsuarioDAO.getById(id);
        if (tipoUsuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tipoUsuario);
        }
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> insert(@RequestBody TipoUsuario tipoUsuario) {
        try {
            tipoUsuarioDAO.insert(tipoUsuario);
            return ResponseEntity.ok(tipoUsuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> update(@PathVariable int id, @RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario existingTipoUsuario = tipoUsuarioDAO.getById(id);
        if (existingTipoUsuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            tipoUsuario.setIdTipoUsuario(id);
            tipoUsuarioDAO.update(tipoUsuario);
            return ResponseEntity.ok(tipoUsuario);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        TipoUsuario existingTipoUsuario = tipoUsuarioDAO.getById(id);
        if (existingTipoUsuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            tipoUsuarioDAO.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
}
