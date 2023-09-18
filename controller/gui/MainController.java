package controller.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Principal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.entities.Funcionario;

public class MainController implements Initializable {

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
    private Button buttonPagamentos;

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<Funcionario> tableView;

    @FXML
    private TableColumn<Funcionario, Integer> columnId;

    @FXML
    private TableColumn<Funcionario, String> columnNome;

    @FXML
    private TableColumn<Funcionario, String> columnEmail;

    @FXML
    private TableColumn<Funcionario, Integer> columnIdGerente;

    private ObservableList<Funcionario> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = FXCollections.observableArrayList(data);

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

        buttonPagamentos.setOnAction(e -> {
            loadScene("/view/fxml/pagamentos.fxml");
        });

        columnId.setCellValueFactory(new PropertyValueFactory<>("id_func"));
        columnId.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnId.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnId.setCellValueFactory(new PropertyValueFactory<>("id_gerente"));

    }

    public void loadScene(String absoluteName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
            Principal.getMainStage().setScene(scene);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
