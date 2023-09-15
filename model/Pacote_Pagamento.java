package model;

import java.util.Date;

public class Pacote_Pagamento {
    private int idPacote;
    private Date dataCriacao;
    private int idPagamento;
    private String cpfCliente;
    private double valor;
    private double desconto;
    private String status;
    private Date dataPagamento;

    public Pacote_Pagamento(int idPacote, Date dataCriacao, int idPagamento, String cpfCliente, double valor,
            double desconto, String status, Date dataPagamento) {
        this.idPacote = idPacote;
        this.dataCriacao = dataCriacao;
        this.idPagamento = idPagamento;
        this.cpfCliente = cpfCliente;
        this.valor = valor;
        this.desconto = desconto;
        this.status = status;
        this.dataPagamento = dataPagamento;
    }

    public int getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getCPFCliente() {
        return cpfCliente;
    }

    public void setIdPacote(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
