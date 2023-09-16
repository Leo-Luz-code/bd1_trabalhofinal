package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Pix;

public class PixController {
    @FXML
    private Label instituicaoLabel;

    @FXML
    private Label numContaLabel;

    // Método para inicializar os dados do pagamento Pix
    public void init(Pix pix) {
        instituicaoLabel.setText("Instituição: " + pix.getInstituicao());
        numContaLabel.setText("Número da Conta: " + pix.getNumConta());
    }
}
