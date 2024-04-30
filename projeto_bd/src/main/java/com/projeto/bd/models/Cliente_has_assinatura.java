package com.projeto.bd.models;

public class Cliente_has_assinatura {

    private int assinatura_id;
    private String cliente_nome;

    public Cliente_has_assinatura(int assinatura_id, String cliente_nome){
        this.assinatura_id = assinatura_id;
        this.cliente_nome = cliente_nome;
    }

    public int getAssinatura_id() {
        return assinatura_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }
    
}
