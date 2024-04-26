package com.projeto.bd.models;

public class Editora {
    
    private String nome;
    private String email;
    private String telefone;
    private int livro_id;
    
    public Editora(String nome, String email, String telefone, int livro_id) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.livro_id = livro_id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getLivro_id() {
        return livro_id;
    }

}
