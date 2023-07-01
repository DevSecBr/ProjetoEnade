/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author joaod
 */
public class ProvaQuestao {
    private int Prova_idProva;
    private int Questao_idQuestao;

    public ProvaQuestao() {
    }

    public ProvaQuestao(int Prova_idProva, int Questao_idQuestao) {
        this.Prova_idProva = Prova_idProva;
        this.Questao_idQuestao = Questao_idQuestao;
    }

    public int getProva_idProva() {
        return Prova_idProva;
    }

    public void setProva_idProva(int Prova_idProva) {
        this.Prova_idProva = Prova_idProva;
    }

    public int getQuestao_idQuestao() {
        return Questao_idQuestao;
    }

    public void setQuestao_idQuestao(int Questao_idQuestao) {
        this.Questao_idQuestao = Questao_idQuestao;
    }
}

