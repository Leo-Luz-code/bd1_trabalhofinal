package controller.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Funcionario;

public class MainController implements Initializable {

    @FXML
    private TableView tableView;
    private final ObservableList<Funcionario> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = FXCollections.observableArrayList(null);
    }

}
