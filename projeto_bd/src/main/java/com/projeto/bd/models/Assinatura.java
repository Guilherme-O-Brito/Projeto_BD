package com.projeto.bd.models;

public class Assinatura {
    
    private int id;
    private String tema;
    private int livro_id;
    
    public Assinatura(int id, String tema, int livro_id) {
        this.id = id;
        this.tema = tema;
        this.livro_id = livro_id;
    }

    public int getId() {
        return id;
    }

    public String getTema() {
        return tema;
    }

    public int getLivro_id(){
        return livro_id;
    }

}
