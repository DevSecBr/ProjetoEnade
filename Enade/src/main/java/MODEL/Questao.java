/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author joaod
 */
public class Questao {
    private int idQuestao;
    private String descricaoQuestao;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;
    private char questaoCorreta;
    private int estadoQuestao;
    private int TipoQuestao_idTipoQuestao;

    
    public Questao() {
    }

    public Questao(int idQuestao, String descricaoQuestao, String alternativaA, String alternativaB, 
                   String alternativaC, String alternativaD, String alternativaE, 
                   char questaoCorreta, int estadoQuestao, int TipoQuestao_idTipoQuestao) {
        this.idQuestao = idQuestao;
        this.descricaoQuestao = descricaoQuestao;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.alternativaE = alternativaE;
        this.questaoCorreta = questaoCorreta;
        this.estadoQuestao = estadoQuestao;
        this.TipoQuestao_idTipoQuestao = TipoQuestao_idTipoQuestao;
    }

    
    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public char getQuestaoCorreta() {
        return questaoCorreta;
    }

    public void setQuestaoCorreta(char questaoCorreta) {
        this.questaoCorreta = questaoCorreta;
    }

    public int getEstadoQuestao() {
        return estadoQuestao;
    }

    public void setEstadoQuestao(int estadoQuestao) {
        this.estadoQuestao = estadoQuestao;
    }

    public int getTipoQuestao_idTipoQuestao() {
        return TipoQuestao_idTipoQuestao;
    }

    public void setTipoQuestao_idTipoQuestao(int TipoQuestao_idTipoQuestao) {
        this.TipoQuestao_idTipoQuestao = TipoQuestao_idTipoQuestao;
    }
}

