package controller.gui.forms;

import java.net.URL;
import java.util.ResourceBundle;

import dao.FuncionarioSqlJdbc;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entities.Funcionario;

public class MainFormController implements Initializable {

    FuncionarioSqlJdbc funcionarioSqlJdbc = new FuncionarioSqlJdbc();

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfIdGerente;

    @FXML
    private Button buttonSalvar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonSalvar.setOnAction(e -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(tfNome.getText());
            funcionario.setEmail(tfEmail.getText());
            funcionario.setIdGerente(Integer.valueOf(tfIdGerente.getText()));

            funcionarioSqlJdbc.createFuncionario(funcionario);

        });
    }
}
