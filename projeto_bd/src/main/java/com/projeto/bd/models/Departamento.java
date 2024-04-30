package com.projeto.bd.models;

public class Departamento {
    
    private String nome;
    private String area;
    private String email;
    private String telefone;
    
    public Departamento(String nome, String area, String email, String telefone) {
        this.nome = nome;
        this.area = area;
        this.email = email;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public String getArea() {
        return area;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }

}


