/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

/**
 *
 * @author joaod
 */
import DAO.QuestaoDAO;
import MODEL.Questao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoDAO questaoDAO;

    @GetMapping
    public List<Questao> getAll() {
        return questaoDAO.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> getById(@PathVariable int id) {
        Questao questao = questaoDAO.getById(id);
        if (questao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(questao);
        }
    }

    @PostMapping
    public ResponseEntity<Questao> insert(@RequestBody Questao questao) {
        try {
            questaoDAO.insert(questao);
            return ResponseEntity.ok(questao);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questao> update(@PathVariable int id, @RequestBody Questao questao) {
        Questao existingQuestao = questaoDAO.getById(id);
        if (existingQuestao == null) {
            return ResponseEntity.notFound().build();
        } else {
            questao.setIdQuestao(id);
            questaoDAO.update(questao);
            return ResponseEntity.ok(questao);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Questao existingQuestao = questaoDAO.getById(id);
        if (existingQuestao == null) {
            return ResponseEntity.notFound().build();
        } else {
            questaoDAO.delete(existingQuestao);
            return ResponseEntity.noContent().build();
        }
    }
}
