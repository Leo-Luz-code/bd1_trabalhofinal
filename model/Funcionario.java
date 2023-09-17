package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Funcionario {
    private SimpleIntegerProperty idFuncionario;
    private SimpleIntegerProperty idGerente;
    private SimpleStringProperty nome;
    private SimpleStringProperty cpf;
    private SimpleStringProperty telefone;
    private SimpleStringProperty email;

    // Construtor para quem tem gerente
    public Funcionario(Integer idFuncionario, String nome, String email, String cpf, String telefone,
            Integer idGerente) {
        this.idFuncionario = new SimpleIntegerProperty(idFuncionario);
        this.nome = new SimpleStringProperty(nome);
        this.email = new SimpleStringProperty(email);
        this.telefone = new SimpleStringProperty(telefone);
        this.cpf = new SimpleStringProperty(cpf);
        this.idGerente = new SimpleIntegerProperty(idGerente);
    }

    // Construtor para quem nao tem nenhum gerente
    public Funcionario(int idFuncionario, String nome, String email, String cpf, String telefone) {
        this.idFuncionario = new SimpleIntegerProperty(idFuncionario);
        this.nome = new SimpleStringProperty(nome);
        this.email = new SimpleStringProperty(email);
        this.telefone = new SimpleStringProperty(telefone);
        this.cpf = new SimpleStringProperty(cpf);
    }

    public Integer getIdGerente() {
        return idGerente.get();
    }

    public void setIdGerente(Integer idGerente) {
        this.idGerente.set(idGerente);
    }

    public String getCpf() {
        return cpf.get();
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public String getTelefone() {
        return telefone.get();
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public int getIdFuncionario() {
        return idFuncionario.get();
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario.set(idFuncionario);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}