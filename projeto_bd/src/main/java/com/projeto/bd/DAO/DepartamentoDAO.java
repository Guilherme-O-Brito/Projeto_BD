package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.Departamento;

public class DepartamentoDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertDepartamento(Departamento departamento) {

        connectToDB();

        String sql = "INSERT INTO departamento (nome, area, email, telefone) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, departamento.getNome());
            pst.setString(2, departamento.getArea());
            pst.setString(3, departamento.getEmail());
            pst.setString(4, departamento.getTelefone());
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
    public boolean updateDepartamentoNome(String nome, String area, String email, String telefone) {
        connectToDB();
        String sql = "UPDATE departamento SET area=?, email=?, telefone=? where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, area);
            pst.setString(2, email);
            pst.setString(3, telefone);
            pst.setString(4, nome);
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
    public boolean deleteDepartamento(String nome) {
        connectToDB();
        String sql = "DELETE FROM departamento where nome=?";
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
    public ArrayList<Departamento> selectDepartamento() {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM departamento";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista Departamentos: ");

            while (rs.next()) {

                Departamento departamentoAux = new Departamento(rs.getString("nome"), rs.getString("area"),rs.getString("email"), rs.getString("telefone"));

                System.out.println("nome = " + departamentoAux.getNome());
                System.out.println("area = " + departamentoAux.getArea());
                System.out.println("email = " + departamentoAux.getEmail());
                System.out.println("telefone = " + departamentoAux.getTelefone());
                System.out.println("--------------------------------");

                departamentos.add(departamentoAux);
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
        return departamentos;
    }

}
