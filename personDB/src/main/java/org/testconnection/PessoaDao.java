package org.testconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao extends Dao {
    public void incluirPessoa(Pessoa p) throws Exception {
        open();
        try {
            stmt = connection.prepareStatement(
                    "insert into pessoa (nome, email) values(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.execute(); // Update?
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                p.setIdPessoa(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
            throw e;

        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }

    /* ANTES
    public void incluirPessoa(Pessoa p) throws Exception {
        open();
        stmt = connection.prepareStatement("insert into pessoa (nome, email) values(?,?)");
        //stmt.setInt(1, p.getIdPessoa());
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEmail());
        stmt.execute();
        stmt.close();
        connection.close();

        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            p.setIdPessoa(generatedKeys.getInt(1));
        }

    }*/
    public List<Pessoa> ListarPessoas() {
        try {
            open();
            stmt = connection.prepareStatement("select * from pessoa");
            rs = stmt.executeQuery();

            List<Pessoa> listaPessoas = new ArrayList<>();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                listaPessoas.add(p);
            }
            connection.close();
            return listaPessoas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
