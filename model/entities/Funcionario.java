package model.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Funcionario {
    private SimpleIntegerProperty id_func;
    private SimpleIntegerProperty id_gerente;
    private SimpleStringProperty nome;
    private SimpleStringProperty email;

    public Funcionario() {
        this.id_func = new SimpleIntegerProperty();
        this.id_gerente = new SimpleIntegerProperty();
        this.nome = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
    }

    public Funcionario(Integer id_func, String nome, String email, Integer id_gerente) {
        this.id_func = new SimpleIntegerProperty(id_func);
        this.id_gerente = new SimpleIntegerProperty(id_gerente);
        this.nome = new SimpleStringProperty(nome);
        this.email = new SimpleStringProperty(email);
    }

    public Integer getIdGerente() {
        return id_gerente.get();
    }

    public void setIdGerente(Integer idGerente) {
        this.id_gerente.set(idGerente);
    }

    public int getIdFuncionario() {
        return id_func.get();
    }

    public void setIdFuncionario(int idFuncionario) {
        this.id_func.set(idFuncionario);
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