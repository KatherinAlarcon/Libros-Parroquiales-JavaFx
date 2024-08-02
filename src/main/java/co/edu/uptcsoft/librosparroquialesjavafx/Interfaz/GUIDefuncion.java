package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIDefuncion extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Label label = new Label("Registro de Defunciones");
        label.setStyle("-fx-font-size: 24px; -fx-font-family: 'Inter';");
        root.setCenter(label);
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        Scene scene = new Scene(root, 1400, 750);

        primaryStage.setTitle("Defunción");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
