import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modelo.Cartao;

public class CartaoController {
    @FXML
    private Label idPacoteLabel;

    @FXML
    private Label valorLabel;

    @FXML
    private Label dataCriacaoLabel;

    @FXML
    private Label numCartaoLabel;

    // Método para inicializar os dados do cartão
    public void init(Cartao cartao) {
        idPacoteLabel.setText("ID do Pacote: " + cartao.getIdPacote());
        valorLabel.setText("Valor: " + cartao.getValor());
        dataCriacaoLabel.setText("Data de Criação: " + cartao.getDataCriacao().toString());
        numCartaoLabel.setText("Número do Cartão: " + cartao.getNumCartao());
    }
}
