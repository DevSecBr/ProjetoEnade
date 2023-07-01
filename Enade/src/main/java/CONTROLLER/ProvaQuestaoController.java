/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

/**
 *
 * @author joaod
 */
import DAO.ProvaQuestaoDAO;
import MODEL.ProvaQuestao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provaQuestoes")
public class ProvaQuestaoController {

    @Autowired
    private ProvaQuestaoDAO provaQuestaoDAO;

    @GetMapping
    public List<ProvaQuestao> getAll() {
        return provaQuestaoDAO.getAll();
    }

    @GetMapping("/{provaId}/{questaoId}")
    public ResponseEntity<ProvaQuestao> getById(@PathVariable int provaId, @PathVariable int questaoId) {
        ProvaQuestao provaQuestao = provaQuestaoDAO.getById(provaId, questaoId);
        if (provaQuestao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(provaQuestao);
        }
    }

    @PostMapping
    public ResponseEntity<ProvaQuestao> insert(@RequestBody ProvaQuestao provaQuestao) {
        try {
            provaQuestaoDAO.insert(provaQuestao);
            return ResponseEntity.ok(provaQuestao);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{provaId}/{questaoId}")
    public ResponseEntity<ProvaQuestao> update(@PathVariable int provaId, @PathVariable int questaoId, @RequestBody ProvaQuestao provaQuestao) {
        ProvaQuestao existingProvaQuestao = provaQuestaoDAO.getById(provaId, questaoId);
        if (existingProvaQuestao == null) {
            return ResponseEntity.notFound().build();
        } else {
            provaQuestao.setProva_idProva(provaId);
            provaQuestao.setQuestao_idQuestao(questaoId);
            provaQuestaoDAO.update(provaQuestao);
            return ResponseEntity.ok(provaQuestao);
        }
    }

    @DeleteMapping("/{provaId}/{questaoId}")
    public ResponseEntity<Void> delete(@PathVariable int provaId, @PathVariable int questaoId) {
        ProvaQuestao existingProvaQuestao = provaQuestaoDAO.getById(provaId, questaoId);
        if (existingProvaQuestao == null) {
            return ResponseEntity.notFound().build();
        } else {
            provaQuestaoDAO.delete(provaId, questaoId);
            return ResponseEntity.noContent().build();
        }
    }
}

