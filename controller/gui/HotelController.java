package controller.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Principal;
import dao.HotelSqlJdbc;
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
import model.entities.Hotel;

public class HotelController implements Initializable {

    HotelSqlJdbc hotelSqlJdbc = new HotelSqlJdbc();

    @FXML
    private Button buttonClientes;

    @FXML
    private Button buttonFuncionarios;

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
    private TableView<Hotel> tableView;

    @FXML
    private TableColumn<Hotel, Integer> tcIdHotel;

    @FXML
    private TableColumn<Hotel, String> tcNome;

    @FXML
    private TableColumn<Hotel, String> tcCidade;

    @FXML
    private TableColumn<Hotel, String> tcEstado;

    @FXML
    private TableColumn<Hotel, String> tcCpnj;

    @FXML
    private TableColumn<Funcionario, Integer> columnIdGerente;
    private ObservableList<Hotel> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // data = FXCollections.observableArrayList(null);

        buttonClientes.setOnAction(e -> {
            loadScene("/view/fxml/clientes.fxml");
        });

        buttonFuncionarios.setOnAction(e -> {
            loadScene("/view/fxml/main.fxml");
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

        tcIdHotel.setCellValueFactory(new PropertyValueFactory<>("idHotel"));
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        tcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tcCpnj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));

        data = FXCollections.observableArrayList(hotelSqlJdbc.getAllHoteis());
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
            e1.printStackTrace();
        }
    }

}
