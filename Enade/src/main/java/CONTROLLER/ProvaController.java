/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

/**
 *
 * @author joaod
 */
import DAO.ProvaDAO;
import MODEL.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provas")
public class ProvaController {

    @Autowired
    private ProvaDAO provaDAO;

    @GetMapping
    public List<Prova> getAll() {
        return provaDAO.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prova> getById(@PathVariable int id) {
        Prova prova = provaDAO.getById(id);
        if (prova == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(prova);
        }
    }

    @PostMapping
    public ResponseEntity<Prova> insert(@RequestBody Prova prova) {
        try {
            provaDAO.insert(prova);
            return ResponseEntity.ok(prova);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prova> update(@PathVariable int id, @RequestBody Prova prova) {
        Prova existingProva = provaDAO.getById(id);
        if (existingProva == null) {
            return ResponseEntity.notFound().build();
        } else {
            prova.setIdProva(id);
            provaDAO.update(prova);
            return ResponseEntity.ok(prova);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Prova existingProva = provaDAO.getById(id);
        if (existingProva == null) {
            return ResponseEntity.notFound().build();
        } else {
            provaDAO.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
}

