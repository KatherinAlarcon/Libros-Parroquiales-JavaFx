package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUIRegistro extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // Labels
        Label titleLabel = new Label("Iniciar Sesión");
        titleLabel.setFont(new Font("Arial", 24));
        Label registerLabel = new Label("Si no tienes una cuenta registrada");
        Hyperlink registerLink = new Hyperlink("Registrar aquí!");

        // User field
        TextField userField = new TextField();
        userField.setPromptText("Ingresa tu Usuario");


        // Password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Ingresa tu Contraseña");

        // Login button
        Button loginButton = new Button("Acceso");
        loginButton.setPrefWidth(200);

        // Layouts
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        HBox userBox = new HBox(10);
        userBox.setAlignment(Pos.CENTER_LEFT);
        userBox.getChildren().addAll(new Label("Usuario: "), userField);

        HBox passBox = new HBox(10);
        passBox.setAlignment(Pos.CENTER_LEFT);
        passBox.getChildren().addAll(new Label("Contraseña: "), passwordField);

        VBox registerBox = new VBox(5);
        registerBox.setAlignment(Pos.CENTER);
        registerBox.getChildren().addAll(registerLabel, registerLink);

        vbox.getChildren().addAll(titleLabel, registerBox, userBox, passBox, loginButton);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
