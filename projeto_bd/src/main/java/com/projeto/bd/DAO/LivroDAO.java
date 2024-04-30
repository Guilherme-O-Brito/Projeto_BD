package com.projeto.bd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.projeto.bd.models.Livro;

public class LivroDAO extends ConnectionDAO {

    //DAO - Data Access Object
    private boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertLivro(Livro Livro) {

        connectToDB();

        String sql = "INSERT INTO livros (id, nome, autor, genero, assunto, edicao, estoque, editora_nome) values(?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, Livro.getId());
            pst.setString(2, Livro.getNome());
            pst.setString(3, Livro.getAutor());
            pst.setString(4, Livro.getGenero());
            pst.setString(5, Livro.getAssunto());
            pst.setString(6, Livro.getEdicao());
            pst.setInt(7, Livro.getEstoque());
            pst.setString(8, Livro.getEditoraNome());
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
    public boolean updateLivroNome(int id, String nome, String autor, String genero, String assunto, String edicao, int estoque, String editora_nome) {
        connectToDB();
        String sql = "UPDATE livros SET nome=?, autor=?, genero=?, assunto=?, edicao=?, estoque=?, editora_nome=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, autor);
            pst.setString(3, genero);
            pst.setString(4, assunto);
            pst.setString(5, edicao);
            pst.setInt(6, estoque);
            pst.setString(7, editora_nome);
            pst.setInt(8, id);
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
    public boolean deleteLivro(int id) {
        connectToDB();
        String sql = "DELETE FROM livros where id=?";
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
    public ArrayList<Livro> selectLivro() {
        ArrayList<Livro> livros = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM livros";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Livros: ");

            while (rs.next()) {

                Livro livroAux = new Livro(rs.getInt("id"), rs.getString("nome"), rs.getString("autor"), rs.getString("genero"), rs.getString("assunto"), rs.getString("edicao"),rs.getInt("estoque"),rs.getString("editora_nome"));

                System.out.println("id = " + livroAux.getId());
                System.out.println("nome = " + livroAux.getNome());
                System.out.println("autor = " + livroAux.getAutor());
                System.out.println("genero = " + livroAux.getGenero());
                System.out.println("assunto = " + livroAux.getAssunto());
                System.out.println("edicao = " + livroAux.getEdicao());
                System.out.println("Estoque = " + livroAux.getEstoque());
                System.out.println("Editora = " + livroAux.getEditoraNome());
                System.out.println("--------------------------------");

                livros.add(livroAux);
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
        return livros;
    }
    
}
