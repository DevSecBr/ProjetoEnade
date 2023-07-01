/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

/**
 *
 * @author joaod
 */
import DAO.ResultadoDAO;
import MODEL.Resultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoDAO resultadoDAO;

    @GetMapping
    public List<Resultado> getAll() {
        return resultadoDAO.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultado> getById(@PathVariable int id) {
        Resultado resultado = resultadoDAO.getById(id);
        if (resultado == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }
    }

    @PostMapping
    public ResponseEntity<Resultado> insert(@RequestBody Resultado resultado) {
        try {
            resultadoDAO.insert(resultado);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultado> update(@PathVariable int id, @RequestBody Resultado resultado) {
        Resultado existingResultado = resultadoDAO.getById(id);
        if (existingResultado == null) {
            return ResponseEntity.notFound().build();
        } else {
            resultado.setIdResultado(id);
            resultadoDAO.update(resultado);
            return ResponseEntity.ok(resultado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Resultado existingResultado = resultadoDAO.getById(id);
        if (existingResultado == null) {
            return ResponseEntity.notFound().build();
        } else {
            resultadoDAO.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
}

