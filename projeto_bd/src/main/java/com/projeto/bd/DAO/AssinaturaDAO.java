package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.Assinatura;

public class AssinaturaDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertAssinatura(Assinatura assinatura) {

        connectToDB();

        String sql = "INSERT INTO assinatura (id, tema, livro_id) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,assinatura.getId());
            pst.setString(2, assinatura.getTema());
            pst.setInt(3, assinatura.getLivro_id());
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

    //UPDATE
    public boolean updateAssinaturaNome(int id, String tema) {
        connectToDB();
        String sql = "UPDATE assinatura SET tema=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, tema);
            pst.setInt(2, id);
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
    public boolean deleteAssinatura(int id) {
        connectToDB();
        String sql = "DELETE FROM assinatura where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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

    //SELECT
    public ArrayList<Assinatura> selectAssinatura() {
        ArrayList<Assinatura> assinaturas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM assinatura";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de assinaturas: ");

            while (rs.next()) {

                Assinatura assinaturaAux = new Assinatura(rs.getInt("id"), rs.getString("tema"), rs.getInt("livro_id"));

                System.out.println("id = " + assinaturaAux.getId());
                System.out.println("tema = " + assinaturaAux.getTema());
                System.out.println("livro_id = " + assinaturaAux.getLivro_id());
                System.out.println("--------------------------------");

                assinaturas.add(assinaturaAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return assinaturas;
    }

}
