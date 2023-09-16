import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modelo.Transporta;

public class TransportaController {
    @FXML
    private Label idViagemLabel;

    @FXML
    private Label dataViagemLabel;

    @FXML
    private Label checkInLabel;

    @FXML
    private Label valorLabel;

    @FXML
    private Label meioTransporteLabel;

    // Método para inicializar os dados da viagem
    public void init(Transporta viagem) {
        idViagemLabel.setText("ID da Viagem: " + viagem.getIdViagem());
        dataViagemLabel.setText("Data da Viagem: " + viagem.getDataViagem().toString());
        checkInLabel.setText("Check-In: " + viagem.getCheck_in().toString());
        valorLabel.setText("Valor: " + viagem.getValor());
        meioTransporteLabel.setText("Meio de Transporte: " + viagem.getMeioTransporte());
    }
}
