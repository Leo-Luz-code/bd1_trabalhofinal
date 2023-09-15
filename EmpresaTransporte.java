package modelo;

public class EmpresaTransporte {
    private int idEmpresa;
    private String nome;
    private String cidade;
    private String estado;
    private String cnpj;

    public EmpresaTransporte (int idEmpresa, String nome, String cidade, String estado, String cnpj) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
    }
    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
