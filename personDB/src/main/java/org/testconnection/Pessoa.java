package org.testconnection;

public class Pessoa {
    private int idPessoa;
    private String nome;
    private String email;

    public Pessoa () {
    }

    public Pessoa (String nome, String email) {
        super(); // Ainda precisa entender o porque;
        this.nome = nome;
        this.email = email;
    }
    public Pessoa (int idPessoa, String nome, String email) {
        super(); // Ainda precisa entender o porque;
        this.nome = nome;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Dados da pessoa: \n" +
                "id: " + idPessoa +
                "\nnome: " + nome +
                "\nemail: " + email;
    }
}
