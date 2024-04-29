package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.Funcionario;

public class FuncionarioDAO extends ConnectionDAO {

    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertFuncionario(Funcionario funcionario) {

        connectToDB();

        String sql = "INSERT INTO funcionario (nome, data_de_nascimento, cargo, matricula, email, telefone) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getData_de_nascimento());
            pst.setString(3, funcionario.getCargo());
            pst.setInt(4, funcionario.getMatricula());
            pst.setString(5, funcionario.getEmail());
            pst.setString(6, funcionario.getTelefone());
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
    public boolean updateFuncionarioNome(String nome, String email, String cargo, int matricula, String telefone, String data_de_nascimento, String novoNome) {
        connectToDB();
        String sql = "UPDATE funcionario SET nome=?, data_de_nascimento=?, cargo=?, matricula=?, email=?, telefone=?, where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoNome);
            pst.setString(2, data_de_nascimento);
            pst.setString(3, cargo);
            pst.setInt(4, matricula);
            pst.setString(5, email);
            pst.setString(6, telefone);
            pst.setString(7, nome);
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
    public boolean deleteFuncionario(String nome) {
        connectToDB();
        String sql = "DELETE FROM funcionario where nome=?";
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
    public ArrayList<Funcionario> selectFuncionario() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM funcionario";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Chefes De Departamento: ");

            while (rs.next()) {

                Funcionario funcionarioAux = new Funcionario(rs.getString("nome"), rs.getString("data_de_nascimento"), rs.getString("cargo"), rs.getInt("matricula"), rs.getString("email"),rs.getString("telefone"));

                System.out.println("nome = " + funcionarioAux.getNome());
                System.out.println("data de nascimento = " + funcionarioAux.getData_de_nascimento());
                System.out.println("cargo = " + funcionarioAux.getCargo());
                System.out.println("matricula = " + funcionarioAux.getMatricula());
                System.out.println("email = " + funcionarioAux.getEmail());
                System.out.println("telefone = " + funcionarioAux.getTelefone());
                System.out.println("--------------------------------");

                funcionarios.add(funcionarioAux);
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
        return funcionarios;
    }
    
}
