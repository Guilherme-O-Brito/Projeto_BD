package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.Editora;

public class EditoraDAO extends ConnectionDAO{
    
    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertEditora(Editora editora) {

        connectToDB();

        String sql = "INSERT INTO editora (nome, email, telefone, livro_id) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, editora.getNome());
            pst.setString(2, editora.getEmail());
            pst.setString(3, editora.getTelefone());
            pst.setInt(4, editora.getLivro_id());
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
    public boolean updateEditoraNome(String nome, String email, String telefone, int livro_id, String novoNome) {
        connectToDB();
        String sql = "UPDATE editora SET nome=?, email=?, telefone=?, livro_id=? where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoNome);
            pst.setString(2, email);
            pst.setString(3, telefone);
            pst.setInt(4, livro_id);
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
    public boolean deleteEditora(String nome) {
        connectToDB();
        String sql = "DELETE FROM editora where nome=?";
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
    public ArrayList<Editora> selectEditora() {
        ArrayList<Editora> editoras = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM editora";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Editoras: ");

            while (rs.next()) {

                Editora editoraAux = new Editora(rs.getString("nome"), rs.getString("email"), rs.getString("telefone"), rs.getInt("livro_id"));

                System.out.println("nome = " + editoraAux.getNome());
                System.out.println("email = " + editoraAux.getEmail());
                System.out.println("telefone = " + editoraAux.getTelefone());
                System.out.println("Livro_id = " + editoraAux.getLivro_id());
                System.out.println("--------------------------------");

                editoras.add(editoraAux);
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
        return editoras;
    }

}
