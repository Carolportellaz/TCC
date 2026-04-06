package com.example.myapplication.model;

public class MainQuestion {
    private int id;
    private String texto;
    private String exemplo;

    public MainQuestion(int id, String texto, String exemplo) {
        this.id = id;
        this.texto = texto;
        this.exemplo = exemplo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getExemplo() {
        return exemplo;
    }

    public void setExemplo(String exemplo) {
        this.exemplo = exemplo;
    }
}
