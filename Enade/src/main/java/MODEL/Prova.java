/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author joaod
 */
import java.util.Date;

public class Prova {
    private int idProva;
    private Date dataProva;

    
    public Prova() {
    }

    public Prova(int idProva, Date dataProva) {
        this.idProva = idProva;
        this.dataProva = dataProva;
    }

    
    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }
}

