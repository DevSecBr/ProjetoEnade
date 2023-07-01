/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

/**
 *
 * @author joaod
 */
import DAO.TipoQuestaoDAO;
import MODEL.TipoQuestao;
import java.util.List;

public class TipoQuestaoController {
    private TipoQuestaoDAO tipoQuestaoDAO;

    public TipoQuestaoController() {
        this.tipoQuestaoDAO = new TipoQuestaoDAO();
    }

    public TipoQuestao createTipoQuestao(int id, String nome) {
        TipoQuestao tipoQuestao = new TipoQuestao();
        tipoQuestao.setIdTipoQuestao(id);
        tipoQuestao.setNomeTipoQuestao(nome);
        tipoQuestaoDAO.insert(tipoQuestao);
        return tipoQuestao;
    }

    public List<TipoQuestao> getAllTipoQuestoes() {
        return tipoQuestaoDAO.getAll();
    }

    public TipoQuestao getTipoQuestaoById(int id) {
        return tipoQuestaoDAO.getById(id);
    }

    public TipoQuestao updateTipoQuestao(int id, String nome) {
        TipoQuestao tipoQuestao = tipoQuestaoDAO.getById(id);
        if(tipoQuestao != null) {
            tipoQuestao.setNomeTipoQuestao(nome);
            tipoQuestaoDAO.update(tipoQuestao);
        }
        return tipoQuestao;
    }

    public void deleteTipoQuestao(int id) {
        tipoQuestaoDAO.delete(id);
    }
}

