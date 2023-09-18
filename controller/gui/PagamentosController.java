package controller.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.TableView;

import application.Principal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class PagamentosController implements Initializable {

    @FXML
    private Button buttonClientes;

    @FXML
    private Button buttonHotel;

    @FXML
    private Button buttonEmpresaTransporte;

    @FXML
    private Button buttonPacotesVendidos;

    @FXML
    private Button buttonPacotesDisponiveis;

    @FXML
    private Button buttonFuncionarios;

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView tableView;
    // private final ObservableList<Funcionario> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // data = FXCollections.observableArrayList(null);

        buttonClientes.setOnAction(e -> {
            loadScene("/view/fxml/clientes.fxml");
        });

        buttonHotel.setOnAction(e -> {
            loadScene("/view/fxml/hoteis.fxml");
        });

        buttonEmpresaTransporte.setOnAction(e -> {
            loadScene("/view/fxml/empresaTransporte.fxml");
        });

        buttonPacotesVendidos.setOnAction(e -> {
            loadScene("/view/fxml/pacotesVendidos.fxml");
        });

        buttonPacotesDisponiveis.setOnAction(e -> {
            loadScene("/view/fxml/pacotesDisponiveis.fxml");
        });

        buttonFuncionarios.setOnAction(e -> {
            loadScene("/view/fxml/main.fxml");
        });
    }

    public void loadScene(String absoluteName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
            Principal.getMainStage().setScene(scene);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}
