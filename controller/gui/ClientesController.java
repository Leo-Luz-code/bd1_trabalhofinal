package controller.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Principal;
import dao.ClienteSqlJdbc;
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
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.entities.Cliente;

public class ClientesController implements Initializable {

    ClienteSqlJdbc clienteSqlJdbc = new ClienteSqlJdbc();

    @FXML
    private Button buttonNovo;

    @FXML
    private Button buttonFuncionarios;

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
    private TableView<Cliente> tableView;

    @FXML
    private TableColumn<Cliente, Integer> tcIdCliente;

    @FXML
    private TableColumn<Cliente, String> tcNome;

    @FXML
    private TableColumn<Cliente, String> tcCpf;

    @FXML
    private TableColumn<Cliente, String> tcTelefone;

    @FXML
    private TableColumn<Cliente, String> tcEmail;

    private ObservableList<Cliente> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // data = FXCollections.observableArrayList(null);

        buttonFuncionarios.setOnAction(e -> {
            loadScene("/view/fxml/main.fxml");
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

        buttonNovo.setOnAction(e -> {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/forms/clienteForm.fxml"));
            Parent root;
            try {
                root = loader.load();
                Scene mainScene = new Scene(root);

                stage.initOwner(Principal.getMainStage());
                stage.setScene(mainScene);
                stage.setTitle("Travels N' Travels!");
                stage.getIcons().add(new Image("view/icons/icon.png"));
                stage.showAndWait();
                stage.setResizable(false);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        tcIdCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        data = FXCollections.observableArrayList(clienteSqlJdbc.getAllClientes());
        tableView.setItems(data);
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
