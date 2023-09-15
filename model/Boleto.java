package model;

import java.util.Date;

public class Boleto extends Pacote_Pagamento {
    private String codBarras;

    public Boleto(int idPacote, Date dataCriacao, int idPagamento, String cpfCliente, double valor, double desconto,
            String status, Date dataPagamento, String codBarras) {
        super(idPacote, dataCriacao, idPagamento, cpfCliente, valor, desconto, status, dataPagamento);
        this.codBarras = codBarras;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

}
