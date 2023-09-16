package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Hotel;

public class HotelController {
    @FXML
    private Label nomeLabel;

    @FXML
    private Label cidadeLabel;

    @FXML
    private Label estadoLabel;

    @FXML
    private Label cnpjLabel;

    // Método para inicializar os dados do hotel
    public void init(Hotel hotel) {
        nomeLabel.setText("Nome: " + hotel.getNome());
        cidadeLabel.setText("Cidade: " + hotel.getCidade());
        estadoLabel.setText("Estado: " + hotel.getEstado());
        cnpjLabel.setText("CNPJ: " + hotel.getCnpj());
    }
}
