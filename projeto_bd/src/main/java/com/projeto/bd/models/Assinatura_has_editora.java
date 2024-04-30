package com.projeto.bd.models;

public class Assinatura_has_editora {
    
    private int assinatura_id;
    private String editora_nome;

    public Assinatura_has_editora(int assinatura_id, String editora_nome){
        this.assinatura_id = assinatura_id;
        this.editora_nome = editora_nome;
    }

    public int getAssinatura_id() {
        return assinatura_id;
    }

    public String getEditora_nome() {
        return editora_nome;
    }

}
