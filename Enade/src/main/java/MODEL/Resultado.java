/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author joaod
 */
public class Resultado {
    private int idResultado;
    private double valorObtido;
    private int Usuario_idUsuario;
    private int Prova_idProva;

    
    public Resultado() {
    }

    public Resultado(int idResultado, double valorObtido, int Usuario_idUsuario, int Prova_idProva) {
        this.idResultado = idResultado;
        this.valorObtido = valorObtido;
        this.Usuario_idUsuario = Usuario_idUsuario;
        this.Prova_idProva = Prova_idProva;
    }

    
    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public double getValorObtido() {
        return valorObtido;
    }

    public void setValorObtido(double valorObtido) {
        this.valorObtido = valorObtido;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    public int getProva_idProva() {
        return Prova_idProva;
    }

    public void setProva_idProva(int Prova_idProva) {
        this.Prova_idProva = Prova_idProva;
    }
}

