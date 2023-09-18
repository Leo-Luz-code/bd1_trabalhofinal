package model.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Funcionario {
    private SimpleStringProperty idFunc;
    private SimpleStringProperty idGerente;
    private SimpleStringProperty nome;
    private SimpleStringProperty email;

    public Funcionario() {
    }

    public Funcionario(Integer id_func, String nome, String email, Integer id_gerente) {
        this.idFunc = new SimpleStringProperty(String.valueOf(id_func));
        this.nome = new SimpleStringProperty(nome);
        this.email = new SimpleStringProperty(email);
        this.idGerente = new SimpleStringProperty(String.valueOf(id_gerente));
    }

    // public Integer getIdGerente() {
    // return id_gerente.get();
    // }

    // public void setIdGerente(Integer idGerente) {
    // this.id_gerente.set(idGerente);
    // }

    // public int getIdFuncionario() {
    // return id_func.get();
    // }

    // public void setIdFuncionario(int idFuncionario) {
    // this.id_func.set(idFuncionario);
    // }

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