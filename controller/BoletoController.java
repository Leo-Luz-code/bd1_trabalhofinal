package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.entities.Boleto;

public class BoletoController {
    @FXML
    private Label idPacoteLabel;

    @FXML
    private Label valorLabel;

    @FXML
    private Label dataCriacaoLabel;

    // Método para inicializar os dados do boleto
    public void init(Boleto boleto) {
        idPacoteLabel.setText("ID do Pacote: " + boleto.getIdPacote());
        valorLabel.setText("Valor: " + boleto.getValor());
        dataCriacaoLabel.setText("Data de Criação: " + boleto.getDataCriacao().toString());
    }
}
