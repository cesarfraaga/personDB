package org.testconnection;

import java.sql.*;

import static java.lang.Class.forName;

// Conexão ao banco de dados
public class Dao {
    Connection connection; // Conexão ao banco de dados;
    PreparedStatement stmt; // Acessa a tabela;
    ResultSet rs; // Consulta a tabela;
    CallableStatement call; // Procedures e Functions

    public void open() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/cadastros";
        String user = "postgres";
        String password = "123";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar ao banco de dados");
        }
    }

}
