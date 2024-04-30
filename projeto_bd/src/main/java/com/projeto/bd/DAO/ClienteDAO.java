package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.Cliente;

public class ClienteDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertCliente(Cliente cliente) {

        connectToDB();

        String sql = "INSERT INTO cliente (nome, email, telefone, endereco, data_de_nascimento) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEndereco());
            pst.setString(5, cliente.getData_de_nascimento());
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
    public boolean updateClienteNome(String nome, String email, String telefone, String endereco, String data_de_nascimento) {
        connectToDB();
        String sql = "UPDATE cliente SET email=?, telefone=?, endereco=?, data_de_nascimento=? where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, telefone);
            pst.setString(3, endereco);
            pst.setString(4, data_de_nascimento);
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
        ArrayList<Cliente> clientes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM cliente";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Clientes: ");

            while (rs.next()) {

                Cliente clienteAux = new Cliente(rs.getString("nome"), rs.getString("email"), rs.getString("telefone"), rs.getString("endereco"),rs.getString("data_de_nascimento"));

                System.out.println("nome = " + clienteAux.getNome());
                System.out.println("email = " + clienteAux.getEmail());
                System.out.println("telefone = " + clienteAux.getTelefone());
                System.out.println("endereco = " + clienteAux.getEndereco());
                System.out.println("data de nascimento = " + clienteAux.getData_de_nascimento());
                System.out.println("--------------------------------");

                clientes.add(clienteAux);
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
        return clientes;
    }

}
