import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modelo.EmpresaTransporte;

public class EmpresaTransporteController {
    @FXML
    private Label nomeLabel;

    @FXML
    private Label cidadeLabel;

    @FXML
    private Label estadoLabel;

    @FXML
    private Label cnpjLabel;

    // Método para inicializar os dados da empresa de transporte
    public void init(EmpresaTransporte empresaTransporte) {
        nomeLabel.setText("Nome: " + empresaTransporte.getNome());
        cidadeLabel.setText("Cidade: " + empresaTransporte.getCidade());
        estadoLabel.setText("Estado: " + empresaTransporte.getEstado());
        cnpjLabel.setText("CNPJ: " + empresaTransporte.getCnpj());
    }
}
