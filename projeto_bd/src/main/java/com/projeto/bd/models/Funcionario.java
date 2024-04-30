package com.projeto.bd.models;

public class Funcionario {
    
    private String nome;
    private String data_de_nascimento;
    private String cargo;
    private int matricula;
    private String email;
    private String telefone;
    private String departamento_nome;

    public Funcionario(String nome, String data_de_nascimento,String cargo,int matricula,String email,String telefone, String departamento_nome){
        this.nome = nome;
        this.data_de_nascimento = data_de_nascimento;
        this.cargo = cargo;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
        this.departamento_nome = departamento_nome;
    }

    public String getNome(){
        return nome;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public String getCargo() {
        return cargo;
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
    public String getDepartamento_nome(){
        return departamento_nome;
    }

}
