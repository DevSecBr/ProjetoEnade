/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author joaod
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private int TipoUsuario_idTipoUsuario;

    
    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String email, String senha, int TipoUsuario_idTipoUsuario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.TipoUsuario_idTipoUsuario = TipoUsuario_idTipoUsuario;
    }

    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoUsuario_idTipoUsuario() {
        return TipoUsuario_idTipoUsuario;
    }

    public void setTipoUsuario_idTipoUsuario(int TipoUsuario_idTipoUsuario) {
        this.TipoUsuario_idTipoUsuario = TipoUsuario_idTipoUsuario;
    }
}

