/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author joaod
 */
public class TipoQuestao {
    private int idTipoQuestao;
    private String nomeTipoQuestao;

    // Construtores
    public TipoQuestao() {
    }

    public TipoQuestao(int idTipoQuestao, String nomeTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    // Getters and Setters
    public int getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(int idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public String getNomeTipoQuestao() {
        return nomeTipoQuestao;
    }

    public void setNomeTipoQuestao(String nomeTipoQuestao) {
        this.nomeTipoQuestao = nomeTipoQuestao;
    }
}

