package com.projeto.bd.models;

public class ChefeDeDepartamento {
    
    private String nome;
    private int matricula;
    private String email;
    private String telefone;
    
    public ChefeDeDepartamento(String nome, int matricula, String email, String telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

}
