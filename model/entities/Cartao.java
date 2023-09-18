package model.entities;

import java.util.Date;

public class Cartao extends Pacote_Pagamento {
    private String numCartao;

    public Cartao(int idPacote, Date dataCriacao, int idPagamento, String cpfCliente, double valor, double desconto,
            String status, Date dataPagamento, String numCartao) {
        super(idPacote, dataCriacao, idPagamento, cpfCliente, valor, desconto, status, dataPagamento);
        this.numCartao = numCartao;
    }

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }
}
