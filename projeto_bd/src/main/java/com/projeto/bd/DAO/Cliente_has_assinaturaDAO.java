package com.projeto.bd.DAO;

import java.sql.SQLException;

public class Cliente_has_assinaturaDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertCliente_has_assinatura(int assinatura_id, String cliente_nome) {

        connectToDB();

        String sql = "INSERT INTO cliente_has_assinatura (assinatura_id, cliente_nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,assinatura_id);
            pst.setString(2, cliente_nome);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //DELETE
    public boolean deleteCliente_has_assinaturaByAssinatura(int assinatura_id) {
        connectToDB();
        String sql = "DELETE FROM cliente_has_assinatura where assinatura_id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, assinatura_id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //DELETE
    public boolean deleteCliente_has_assinaturaByCliente(String cliente_nome) {
        connectToDB();
        String sql = "DELETE FROM cliente_has_assinatura where cliente_nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente_nome);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

}
