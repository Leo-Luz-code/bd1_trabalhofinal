package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.entities.Pacote_Pagamento;

public class PacotePagamentoController {
    @FXML
    private Label idPacoteLabel;

    @FXML
    private Label dataCriacaoLabel;

    @FXML
    private Label idPagamentoLabel;

    @FXML
    private Label cpfClienteLabel;

    @FXML
    private Label valorLabel;

    @FXML
    private Label descontoLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label dataPagamentoLabel;

    // Método para inicializar os dados do pacote de pagamento
    public void init(Pacote_Pagamento pacotePagamento) {
        idPacoteLabel.setText("ID do Pacote: " + pacotePagamento.getIdPacote());
        dataCriacaoLabel.setText("Data de Criação: " + pacotePagamento.getDataCriacao().toString());
        idPagamentoLabel.setText("ID do Pagamento: " + pacotePagamento.getIdPagamento());
        cpfClienteLabel.setText("CPF do Cliente: " + pacotePagamento.getCPFCliente());
        valorLabel.setText("Valor: " + pacotePagamento.getValor());
        descontoLabel.setText("Desconto: " + pacotePagamento.getDesconto());
        statusLabel.setText("Status: " + pacotePagamento.getStatus());
        dataPagamentoLabel.setText("Data do Pagamento: " + pacotePagamento.getDataPagamento().toString());
    }
}
