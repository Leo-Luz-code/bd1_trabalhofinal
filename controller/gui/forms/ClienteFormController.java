package controller.gui.forms;

import java.net.URL;
import java.util.ResourceBundle;

import dao.ClienteSqlJdbc;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entities.Cliente;

public class ClienteFormController implements Initializable {

    ClienteSqlJdbc clienteSqlJdbc = new ClienteSqlJdbc();

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfTelefone;

    @FXML
    private Button buttonSalvar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonSalvar.setOnAction(e -> {
            Cliente cliente = new Cliente();
            cliente.setNome(tfNome.getText());
            cliente.setEmail(tfEmail.getText());
            cliente.setTelefone(tfTelefone.getText());
            cliente.setCpf(tfCpf.getText());

            clienteSqlJdbc.createCliente(cliente);

        });
    }
}
