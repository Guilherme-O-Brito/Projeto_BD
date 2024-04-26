package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.ChefeDeDepartamento;

public class ChefeDeDepartamentoDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertChefeDeDepartamento(ChefeDeDepartamento ChefeDeDepartamento) {

        connectToDB();

        String sql = "INSERT INTO chefe_de_departamento (nome, matricula, email, telefone) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,ChefeDeDepartamento.getNome());
            pst.setInt(2, ChefeDeDepartamento.getMatricula());
            pst.setString(3, ChefeDeDepartamento.getEmail());
            pst.setString(4, ChefeDeDepartamento.getTelefone());
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
        ArrayList<ChefeDeDepartamento> ChefeDeDepartamentos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM chefe_de_departamento";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Chefes De Departamento: ");

            while (rs.next()) {

                ChefeDeDepartamento ChefeDeDepartamentoAux = new ChefeDeDepartamento(rs.getString("nome"), rs.getInt("matricula"), rs.getString("email"), rs.getString("telefone"));

                System.out.println("nome = " + ChefeDeDepartamentoAux.getNome());
                System.out.println("matricula = " + ChefeDeDepartamentoAux.getMatricula());
                System.out.println("email = " + ChefeDeDepartamentoAux.getEmail());
                System.out.println("email = " + ChefeDeDepartamentoAux.getTelefone());
                System.out.println("--------------------------------");

                ChefeDeDepartamentos.add(ChefeDeDepartamentoAux);
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
        return ChefeDeDepartamentos;
    }

}
