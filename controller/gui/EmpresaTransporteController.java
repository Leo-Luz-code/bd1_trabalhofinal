package controller.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Principal;
import dao.EmpresaTransporteSqlJdbc;
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
import model.entities.EmpresaTransporte;

public class EmpresaTransporteController implements Initializable {

    EmpresaTransporteSqlJdbc empresaTransporteSqlJdbc = new EmpresaTransporteSqlJdbc();

    @FXML
    private Button buttonClientes;

    @FXML
    private Button buttonHotel;

    @FXML
    private Button buttonFuncionario;

    @FXML
    private Button buttonPacotesVendidos;

    @FXML
    private Button buttonPacotesDisponiveis;

    @FXML
    private Button buttonPagamentos;

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<EmpresaTransporte> tableView;

    @FXML
    private TableColumn<EmpresaTransporte, Integer> tcIdEmpresa;

    @FXML
    private TableColumn<EmpresaTransporte, String> tcNome;

    @FXML
    private TableColumn<EmpresaTransporte, String> tcCidade;

    @FXML
    private TableColumn<EmpresaTransporte, String> tcEstado;

    @FXML
    private TableColumn<EmpresaTransporte, String> tcCnpj;

    private ObservableList<EmpresaTransporte> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // data = FXCollections.observableArrayList(null);

        buttonClientes.setOnAction(e -> {
            loadScene("/view/fxml/clientes.fxml");
        });

        buttonHotel.setOnAction(e -> {
            loadScene("/view/fxml/hoteis.fxml");
        });

        buttonFuncionario.setOnAction(e -> {
            loadScene("/view/fxml/main.fxml");
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

        tcIdEmpresa.setCellValueFactory(new PropertyValueFactory<>("idEmpresa"));
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        tcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tcCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));

        data = FXCollections.observableArrayList(empresaTransporteSqlJdbc.getAllEmpresaTransportes());
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
