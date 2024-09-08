package org.testconnection;

public class Pessoa {
    private int idpessoa;
    private String nome;
    private String email;

    public Pessoa () {
    }
    public Pessoa (int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public Pessoa (String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
    }
    public Pessoa (int idpessoa, String nome, String email) {
        super();
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "============================" +
                "\nDados da pessoa:" +
                "\nid: " + idpessoa +
                "\nnome: " + nome +
                "\nemail: " + email;
    }
}
