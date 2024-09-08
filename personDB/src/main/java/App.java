import org.testconnection.Pessoa;
import org.testconnection.PessoaDao;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        PessoaDao pd = new PessoaDao();

        try {
            //Pessoa p1 = new Pessoa("samuka", "samuka@gmail.com");
            //pd.incluirPessoa(p1);

            List<Pessoa> listaPessoas = pd.ListarPessoas();

            if (listaPessoas.isEmpty()) {
                System.out.println("Não tem pessoas cadastradas");
            } else {
                for (Pessoa p : listaPessoas) {
                    System.out.println(p);
                }
            }

            //Alterar uma pessoa;
            try {
                Pessoa pessoaAtualizada = new Pessoa(9, "Kalebinho", "lebinho@gmail.com");
                pd.alterarPessoa(pessoaAtualizada);
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }


            // Consultar individualmente
            //Pessoa pessoa = pd.consultarPessoaIndividual(8);
            //System.out.println("Pessoa: " + pessoa);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}