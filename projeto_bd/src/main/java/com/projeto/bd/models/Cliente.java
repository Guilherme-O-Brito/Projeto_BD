package com.projeto.bd.models;

public class Cliente {
    
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String data_de_nascimento;
    
    public Cliente(String nome, String email, String telefone, String endereco, String data_de_nascimento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.data_de_nascimento = data_de_nascimento;
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

    public String getEndereco() {
        return endereco;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }
    
    

}
