package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.ChefeDeDepartamento;

public class ChefeDeDepartamentoDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertChefeDeDepartamento(ChefeDeDepartamento chefeDeDepartamento) {

        connectToDB();

        String sql = "INSERT INTO chefe_de_departamento (nome, matricula, email, telefone, departamento_nome) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, chefeDeDepartamento.getNome());
            pst.setInt(2, chefeDeDepartamento.getMatricula());
            pst.setString(3, chefeDeDepartamento.getEmail());
            pst.setString(4, chefeDeDepartamento.getTelefone());
            pst.setString(5, chefeDeDepartamento.getDepartamentoNome());
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
    public boolean updateChefeDeDepartamentoNome(String nome, int matricula, String email, String telefone, String novoNome) {
        connectToDB();
        String sql = "UPDATE chefe_de_departamento SET nome=?, matricula=?, email=?, telefone=? where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoNome);
            pst.setInt(2, matricula);
            pst.setString(3, email);
            pst.setString(4, telefone);
            pst.setString(5, nome);
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
    public boolean deleteChefeDeDepartamento(String nome) {
        connectToDB();
        String sql = "DELETE FROM chefe_de_departamento where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
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
    public ArrayList<ChefeDeDepartamento> selectChefeDeDepartamento() {
        ArrayList<ChefeDeDepartamento> chefeDeDepartamentos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM chefe_de_departamento";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Chefes De Departamento: ");

            while (rs.next()) {

                ChefeDeDepartamento chefeDeDepartamentoAux = new ChefeDeDepartamento(rs.getString("nome"), rs.getInt("matricula"), rs.getString("email"), rs.getString("telefone"),rs.getString("departamento_nome"));

                System.out.println("nome = " + chefeDeDepartamentoAux.getNome());
                System.out.println("matricula = " + chefeDeDepartamentoAux.getMatricula());
                System.out.println("email = " + chefeDeDepartamentoAux.getEmail());
                System.out.println("telefone = " + chefeDeDepartamentoAux.getTelefone());
                System.out.println("departamento = " + chefeDeDepartamentoAux.getDepartamentoNome());
                System.out.println("--------------------------------");

                chefeDeDepartamentos.add(chefeDeDepartamentoAux);
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
        return chefeDeDepartamentos;
    }

}
