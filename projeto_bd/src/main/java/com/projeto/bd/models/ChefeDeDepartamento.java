package com.projeto.bd.models;

public class ChefeDeDepartamento {
    
    private String nome;
    private int matricula;
    private String email;
    private String telefone;
    private String departamento_nome;
    
    public ChefeDeDepartamento(String nome, int matricula, String email, String telefone, String departamento_nome) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
        this.departamento_nome = departamento_nome;
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

    public String getDepartamentoNome(){
        return departamento_nome;
    }

}
