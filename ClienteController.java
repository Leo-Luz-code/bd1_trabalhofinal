import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modelo.Cliente;

public class ClienteController {
    @FXML
    private Label nomeLabel;

    @FXML
    private Label cpfLabel;

    @FXML
    private Label telefoneLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label idClienteLabel;

    @FXML
    private Label idAtendimentoLabel;

    @FXML
    private Label dataAtendimentoLabel;

    // Método para inicializar os dados do cliente
    public void init(Cliente cliente) {
        nomeLabel.setText("Nome: " + cliente.getNome());
        cpfLabel.setText("CPF: " + cliente.getCpf());
        telefoneLabel.setText("Telefone: " + cliente.getTelefone());
        emailLabel.setText("Email: " + cliente.getEmail());
        idClienteLabel.setText("ID do Cliente: " + cliente.getIdCliente());
        idAtendimentoLabel.setText("ID do Atendimento: " + cliente.getIdAtendimento());
        dataAtendimentoLabel.setText("Data do Atendimento: " + cliente.getDataAtendimento().toString());
    }
}
