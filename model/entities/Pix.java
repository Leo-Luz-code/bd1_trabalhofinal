package model.entities;

import java.util.Date;

public class Pix {
    private String instituicao;
    private String numConta;

    public Pix(int idPacote, Date dataCriacao, int idPagamento, String cpfCliente, double valor, double desconto,
            String status, Date dataPagamento, String instituicao, String numConta) {
        super();
        this.instituicao = instituicao;
        this.numConta = numConta;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }
}
