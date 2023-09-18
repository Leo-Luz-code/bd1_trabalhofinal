package model.entities;

import java.util.Date;

public class Boleto {
    private String codBarras;

    public Boleto(int idPacote, Date dataCriacao, int idPagamento, String cpfCliente, double valor, double desconto,
            String status, Date dataPagamento, String codBarras) {
        this.codBarras = codBarras;
    }

    public Boleto() {
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

}
