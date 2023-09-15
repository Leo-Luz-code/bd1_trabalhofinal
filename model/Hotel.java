package model;

public class Hotel {
    private int idHotel;
    private String nome;
    private String cidade;
    private String estado;
    private String cnpj;

    public Hotel(int idHotel, String nome, String cidade, String estado, String cnpj) {
        this.idHotel = idHotel;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
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
