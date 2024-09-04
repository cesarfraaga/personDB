import org.testconnection.Pessoa;
import org.testconnection.PessoaDao;

import java.util.List;

public class App {
    public static void main(String[] args) {
        PessoaDao pd = new PessoaDao();

        try {
            Pessoa p1 = new Pessoa("kaleb2", "kaleb2@gmail.com");
            pd.incluirPessoa(p1);

            List<Pessoa> listaPessoas = pd.ListarPessoas();

            if (listaPessoas.isEmpty()) {
                System.out.println("Não tem pessoas cadastradas");
            } else {
                for (Pessoa p : listaPessoas) {
                    System.out.println(p);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}