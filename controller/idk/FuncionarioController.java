package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.entities.Funcionario;

public class FuncionarioController {
    @FXML
    private Label nomeLabel;

    @FXML
    private Label emailLabel;

    // Método para inicializar os dados do funcionário
    public void init(Funcionario funcionario) {
        nomeLabel.setText("Nome: " + funcionario.getNome());
        emailLabel.setText("Email: " + funcionario.getEmail());
    }
}
