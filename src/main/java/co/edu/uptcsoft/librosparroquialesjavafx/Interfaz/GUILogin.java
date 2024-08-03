package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import co.edu.uptcsoft.librosparroquialesjavafx.Interfaz.GUIRegistro;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Usuario;
import co.edu.uptcsoft.librosparroquialesjavafx.Persistencia.RegistroPersistencia;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;

public class GUILogin extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Iniciar Sesion");
        titulo.setFont(new Font(35));
        titulo.setTranslateX(-25);
        Label descripcion = new Label("Si no tiene una cuenta registrada");
        descripcion.setFont(new Font(20));
        descripcion.setTranslateX(20);
        Button btnRegistrar = new Button("Registrarse aqui!");
        btnRegistrar.setCursor(Cursor.HAND);
        btnRegistrar.setOnAction(actionEvent -> {
            try {
                GUIRegistro registro = new GUIRegistro();
                Stage newStage = new Stage();
                registro.start(newStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnRegistrar.setTranslateX(-53);
        btnRegistrar.setTranslateY(-10);
        VBox.setMargin(descripcion, new Insets(10, 0, 0, 0));
        btnRegistrar.setFont(new Font(20));
        btnRegistrar.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: #246eba;");

        // Campo usuario
        Label nombre = new Label("Usuario");
        nombre.setFont(new Font(15));
        nombre.setTranslateX(150);
        TextField nombreText = new TextField();
        nombreText.setPromptText("Ingresa tu usuario");
        nombreText.setFont(new Font(15));
        nombreText.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");

        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/usuario.jpeg")));
        icon.setFitHeight(16);
        icon.setFitWidth(16);

        HBox hBoxUsuario = new HBox(icon, nombreText);
        hBoxUsuario.setMaxWidth(250);
        hBoxUsuario.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");
        hBoxUsuario.setTranslateX(150);
        VBox vBoxUsuario = new VBox(nombre, hBoxUsuario);
        VBox.setMargin(vBoxUsuario, new Insets(10, 0, 0, 0));

        // Campo contraseña
        Label contraseña = new Label("Contraseña");
        contraseña.setFont(new Font(15));
        contraseña.setTranslateX(150);
        PasswordField contraseñaText = new PasswordField();
        contraseñaText.setPromptText("Ingresa tu contraseña");
        contraseñaText.setFont(new Font(15));
        contraseñaText.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");

        ImageView iconContraseña = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/candado.jpeg")));
        iconContraseña.setFitHeight(16);
        iconContraseña.setFitWidth(16);

        HBox hBoxContraseña = new HBox(iconContraseña, contraseñaText);
        hBoxContraseña.setAlignment(Pos.CENTER_LEFT);
        hBoxContraseña.setMaxWidth(250);
        hBoxContraseña.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");
        hBoxContraseña.setTranslateX(150);
        VBox vBoxContraseña = new VBox(contraseña, hBoxContraseña);
        vBoxContraseña.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(vBoxContraseña, new Insets(20, 0, 0, 0));

        // Botón
        Button btnEntrar = new Button("Acceso");
        btnEntrar.setFont(new Font(18));
        btnEntrar.setMaxWidth(200);
        btnEntrar.setCursor(Cursor.OPEN_HAND);
        btnEntrar.setStyle("-fx-background-color: #2e3c85;-fx-text-fill: white");
        VBox.setMargin(btnEntrar, new Insets(40, 0, 0, 0));

        btnEntrar.setOnAction(actionEvent -> {

            String nombreUsuario = nombreText.getText().trim();
            String contraseñaUsuario = contraseñaText.getText().trim();
            RegistroPersistencia registroPersistencia = new RegistroPersistencia();
            Usuario usuario = registroPersistencia.obtenerUsuario(nombreUsuario);

            if (usuario == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Acceso");
                alert.setHeaderText(null);
                alert.setContentText("¡Nombre de usuario incorrecto!");
                alert.showAndWait();
                nombreText.clear();
                contraseñaText.clear();
            } else if (!usuario.getPassword().equals(contraseñaUsuario)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Acceso");
                alert.setHeaderText(null);
                alert.setContentText("¡Contraseña incorrecta!");
                alert.showAndWait();
                contraseñaText.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Acceso correcto");
                alert.setHeaderText(null);
                alert.setContentText("¡Bienvenido, " + nombreUsuario + "!");
                alert.showAndWait();
                try {
                    GUIRegistro registro = new GUIRegistro();
                    Stage newStage = new Stage();
                    registro.start(newStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        VBox v1 = new VBox();
        v1.getChildren().addAll(titulo, descripcion, btnRegistrar, vBoxUsuario, vBoxContraseña, btnEntrar);
        v1.setAlignment(Pos.CENTER);
        v1.setPrefWidth(550);
        v1.setStyle("-fx-background-color: white;");

        ImageView logo;
        InputStream inputStream = getClass().getResourceAsStream("/Imagenes/Inicio.jpg");
        Image image = new Image(inputStream);
        logo = new ImageView(image);
        logo.setFitWidth(850);
        logo.setFitHeight(750);
        logo.setPreserveRatio(true);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(logo);
        StackPane.setAlignment(logo, Pos.CENTER);
        stackPane.setStyle("-fx-background-color: white;");

        VBox v2 = new VBox();
        v2.getChildren().add(stackPane);
        v2.setAlignment(Pos.CENTER);
        v2.setPrefWidth(750);

        HBox h1 = new HBox();
        h1.getChildren().addAll(v1, v2);
        HBox.setHgrow(v1, Priority.ALWAYS);
        HBox.setHgrow(v2, Priority.ALWAYS);

        Scene scene = new Scene(h1, 1400, 700);
        stage.setTitle("Administrador De Libros Parroquiales");
        stage.setScene(scene);
        stage.show();
    }
}