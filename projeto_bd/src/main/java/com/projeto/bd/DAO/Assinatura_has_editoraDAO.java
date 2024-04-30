package com.projeto.bd.DAO;

import java.sql.SQLException;

public class Assinatura_has_editoraDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertAssinatura_has_editora(int assinatura_id, String editora_nome) {

        connectToDB();

        String sql = "INSERT INTO assinatura_has_editora (assinatura_id, editora_nome) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,assinatura_id);
            pst.setString(2, editora_nome);
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
    public boolean deleteAssinatura_has_editoraByAssinatura(int assinatura_id) {
        connectToDB();
        String sql = "DELETE FROM assinatura_has_editora where assinatura_id=?";
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
    public boolean deleteAssinatura_has_editoraByEditora(String editora_nome) {
        connectToDB();
        String sql = "DELETE FROM assinatura_has_editora where editora_nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, editora_nome);
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
