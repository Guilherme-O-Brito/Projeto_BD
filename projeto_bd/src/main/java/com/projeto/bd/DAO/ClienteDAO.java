package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.Cliente;

public class ClienteDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertCliente(Cliente Cliente) {

        connectToDB();

        String sql = "INSERT INTO cliente (nome, email, telefone, endereco, data_de_nascimento) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,Cliente.getNome());
            pst.setString(2, Cliente.getEmail());
            pst.setString(3, Cliente.getTelefone());
            pst.setString(4, Cliente.getEndereco());
            pst.setString(5, Cliente.getData_de_nascimento());
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
    public boolean updateClienteNome(String nome, String email, String telefone, String endereco, String data_de_nascimento, String novoNome) {
        connectToDB();
        String sql = "UPDATE cliente SET nome=?, email=?, telefone=?, endereco=?, data_de_nascimento=? where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoNome);
            pst.setString(2, email);
            pst.setString(3, telefone);
            pst.setString(4, endereco);
            pst.setString(5, data_de_nascimento);
            pst.setString(6, nome);
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
    public boolean deleteCliente(String nome) {
        connectToDB();
        String sql = "DELETE FROM cliente where nome=?";
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
    public ArrayList<Cliente> selectCliente() {
        ArrayList<Cliente> Clientes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM cliente";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Chefes De Departamento: ");

            while (rs.next()) {

                Cliente ClienteAux = new Cliente(rs.getString("nome"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"),rs.getString("data_de_nascimento"));

                System.out.println("nome = " + ClienteAux.getNome());
                System.out.println("email = " + ClienteAux.getEmail());
                System.out.println("telefone = " + ClienteAux.getTelefone());
                System.out.println("endereco = " + ClienteAux.getEndereco());
                System.out.println("data de nascimento = " + ClienteAux.getData_de_nascimento());
                System.out.println("--------------------------------");

                Clientes.add(ClienteAux);
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
        return Clientes;
    }

}
