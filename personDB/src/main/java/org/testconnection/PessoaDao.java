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
                p.setIdpessoa(generatedKeys.getInt(1));
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

    public List<Pessoa> ListarPessoas() {
        try {
            open();
            stmt = connection.prepareStatement("select * from pessoa");
            rs = stmt.executeQuery();

            List<Pessoa> listaPessoas = new ArrayList<>();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setIdpessoa(rs.getInt("idPessoa"));
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

    public void alterarPessoa(Pessoa p) throws Exception {
        open();
        try {
            stmt = connection.prepareStatement("update pessoa set nome = ?, email = ? where idpessoa = ?");

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setInt(3, p.getIdpessoa());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Pessoa atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma pessoa encontrada com esse id.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void excluirPessoa(Pessoa p) throws Exception {
        open();

        try {
            stmt = connection.prepareStatement("delete from pessoa where idpessoa = ?");
            stmt.setInt(1, p.getIdpessoa());
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Pessoa excluída com sucesso!");
            } else {
                System.out.println("Nenhuma pessoa encontrada com esse ID");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (stmt != null && !stmt.isClosed()) {
            stmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public Pessoa consultarPessoaIndividual(int cod) throws Exception {
        open();

        Pessoa p = null;

        try {
            // Prepara a consulta com o parâmetro idpessoa
            stmt = connection.prepareStatement("SELECT * FROM pessoa WHERE idpessoa = ?");
            stmt.setInt(1, cod); // Define o valor para o parâmetro idpessoa

            rs = stmt.executeQuery();

            // Verifica se a pessoa foi encontrada
            if (rs.next()) {
                p = new Pessoa();
                p.setIdpessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar pessoa: " + e.getMessage());
            throw e;
        } finally {
            // Fecha a conexão e os recursos adequadamente
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return p;
    }

}
