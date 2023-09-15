package modelo;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String email;
    
    public Funcionario (int idFuncionario, String nome, String email) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
    }

    public int getIdFuncionario () {
        return idFuncionario;
    }

    public void setIdFuncionario (int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getEmail () {
        return email;
    }  
    
    public void setEmail(String email) {
        this.email = email;
    }
}