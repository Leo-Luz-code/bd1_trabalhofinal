package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application {

    public static double x, y = 0;

    private static Stage mainStage;

    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/main.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene mainScene = new Scene(root);

            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Travels N' Travels!");
            primaryStage.getIcons().add(new Image("view/icons/icon.png"));
            primaryStage.show();
            primaryStage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getMainStage() {
        return mainStage;
    }

}