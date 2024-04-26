package com.projeto.bd.DAO;

import java.sql.*;

public class ConnectionDAO {
    
    Connection con; // conexao
    PreparedStatement pst; // declaracao(query) preparada - codigo sql
    Statement st; // declaracao(query) - codigo sql
    ResultSet rs; // resposta do banco

    private String database = "integracao"; // nome do banco
    private String user = "root"; 
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrival=true";

    public void connectToDB(){
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao Banco " + database + " com sucesso");
        } catch (SQLException exc) {
            System.out.println("Erro: "+exc.getMessage());
        }
    }

}
