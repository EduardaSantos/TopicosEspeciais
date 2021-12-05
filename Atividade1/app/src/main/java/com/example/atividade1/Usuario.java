package com.example.atividade1;

public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private String dataNasc;
    private String genero;
    private Boolean interesseMusica;
    private Boolean interesseFilme;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, String dataNasc, String genero, Boolean interesseMusica, Boolean interesseFilme) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.interesseMusica = interesseMusica;
        this.interesseFilme = interesseFilme;
    }

    public String getNome(String s) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getInteresseMusica() {
        return interesseMusica;
    }

    public void setInteresseMusica(Boolean interesseMusica) {
        this.interesseMusica = interesseMusica;
    }

    public Boolean getInteresseFilme() {
        return interesseFilme;
    }

    public void setInteresseFilme(Boolean interesseFilme) {
        this.interesseFilme = interesseFilme;
    }
}
