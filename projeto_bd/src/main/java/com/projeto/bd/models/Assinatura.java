package com.projeto.bd.models;

public class Assinatura {
    
    private int id;
    private String tema;
    
    public Assinatura(int id, String tema) {
        this.id = id;
        this.tema = tema;
    }

    public int getId() {
        return id;
    }

    public String getTema() {
        return tema;
    }
}
