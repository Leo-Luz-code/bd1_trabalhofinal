package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.entities.Reservas;

public class ReservasController {
    @FXML
    private Label idReservaLabel;

    @FXML
    private Label dataReservaLabel;

    @FXML
    private Label checkInLabel;

    @FXML
    private Label checkOutLabel;

    @FXML
    private Label valorLabel;

    // Método para inicializar os dados da reserva
    public void init(Reservas reserva) {
        idReservaLabel.setText("ID da Reserva: " + reserva.getIdReserva());
        dataReservaLabel.setText("Data da Reserva: " + reserva.getDataReserva().toString());
        checkInLabel.setText("Check-In: " + reserva.getCheck_in().toString());
        checkOutLabel.setText("Check-Out: " + reserva.getCheck_out().toString());
        valorLabel.setText("Valor: " + reserva.getValor());
    }
}
