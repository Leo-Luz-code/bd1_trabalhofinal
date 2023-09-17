import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Principal extends Application {

    double x, y = 0;

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/fxml/main.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene mainScene = new Scene(root);

            root.setOnMousePressed(e -> {
                x = e.getSceneX();
                y = e.getSceneY();
            });

            root.setOnMouseDragged(e -> {
                primaryStage.setX(e.getScreenX() - x);
                primaryStage.setY(e.getScreenY() - y);

            });

            primaryStage.initStyle(StageStyle.UNDECORATED);
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

}