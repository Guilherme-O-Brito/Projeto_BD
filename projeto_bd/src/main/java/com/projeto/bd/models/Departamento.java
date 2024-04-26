package com.projeto.bd.models;

public class Departamento {
    
    private String nome;
    private String area;
    private String email;
    private String telefone;
    private String funcionario_id;
    private String chefe_de_departamento_nome;
    public Departamento(String nome, String area, String email, String telefone, String funcionario_id,
            String chefe_de_departamento_nome) {
        this.nome = nome;
        this.area = area;
        this.email = email;
        this.telefone = telefone;
        this.funcionario_id = funcionario_id;
        this.chefe_de_departamento_nome = chefe_de_departamento_nome;
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
    public String getFuncionario_id() {
        return funcionario_id;
    }
    public String getChefe_de_departamento_nome() {
        return chefe_de_departamento_nome;
    }

}


