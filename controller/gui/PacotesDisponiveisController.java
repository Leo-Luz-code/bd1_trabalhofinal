package controller.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import application.Principal;
import dao.PacotePagamentoSqlJdbc;
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
import model.entities.Funcionario;
import model.entities.Hotel;
import model.entities.PacoteView;

public class PacotesDisponiveisController implements Initializable {

    PacotePagamentoSqlJdbc pacotePagamentoSqlJdbc = new PacotePagamentoSqlJdbc();

    // @FXML
    // private Button buttonNovo;

    @FXML
    private Button buttonClientes;

    @FXML
    private Button buttonHotel;

    @FXML
    private Button buttonEmpresaTransporte;

    @FXML
    private Button buttonPacotesVendidos;

    @FXML
    private Button buttonFuncionarios;

    @FXML
    private Button buttonPagamentos;

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<PacoteView> tableView;

    @FXML
    private TableColumn<PacoteView, Integer> tcIdPacote;

    @FXML
    private TableColumn<PacoteView, String> tcFunc;

    @FXML
    private TableColumn<PacoteView, Double> tcValor;

    @FXML
    private TableColumn<PacoteView, Date> tcCheckin;

    @FXML
    private TableColumn<PacoteView, Date> tcCheckout;

    @FXML
    private TableColumn<PacoteView, String> tcHotel;

    private ObservableList<PacoteView> data;

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

        buttonFuncionarios.setOnAction(e -> {
            loadScene("/view/fxml/main.fxml");
        });

        buttonPagamentos.setOnAction(e -> {
            loadScene("/view/fxml/pagamentos.fxml");
        });

        tcIdPacote.setCellValueFactory(new PropertyValueFactory<>("idPacote"));
        tcFunc.setCellValueFactory(new PropertyValueFactory<>("func"));
        tcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tcCheckin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        tcCheckout.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        tcHotel.setCellValueFactory(new PropertyValueFactory<>("hotel"));

        data = FXCollections.observableArrayList(pacotePagamentoSqlJdbc.getAllPacotes());
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
