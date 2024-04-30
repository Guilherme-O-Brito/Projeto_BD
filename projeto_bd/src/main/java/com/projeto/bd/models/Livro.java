package com.projeto.bd.models;

public class Livro {
    
    private int id;
    private String nome;
    private String autor;
    private String genero;
    private String assunto;
    private String edicao;
    private int estoque;
    private String editora_nome;
    
    public Livro(int id, String nome, String autor, String genero, String assunto, String edicao, int estoque, String editora_nome) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.assunto = assunto;
        this.edicao = edicao;
        this.estoque = estoque;
        this.editora_nome = editora_nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getEdicao() {
        return edicao;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getEditoraNome(){
        return editora_nome;
    }

}
