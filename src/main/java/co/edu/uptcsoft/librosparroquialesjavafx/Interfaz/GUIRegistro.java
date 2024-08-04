package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import co.edu.uptcsoft.librosparroquialesjavafx.Interfaz.GUIRegistro;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Usuario;
import co.edu.uptcsoft.librosparroquialesjavafx.Control.ControlRegistro;
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

public class GUIRegistro extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Iniciar Sesion");
        titulo.setFont(new Font(35));
        titulo.setTranslateX(-25);
        Label descripcion = new Label("Si ya tienes una cuenta creada");
        descripcion.setFont(new Font(20));
        descripcion.setTranslateX(5);
        Button btniniciarSesion = new Button("!Puedes Iniciar Sesión Aquí!");
        btniniciarSesion.setCursor(Cursor.HAND);
        btniniciarSesion.setOnAction(actionEvent -> {
            try {
                GUILogin login = new GUILogin();
                Stage newStage = new Stage();
                login.start(newStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btniniciarSesion.setTranslateX(-10);
        btniniciarSesion.setTranslateY(-10);
        VBox.setMargin(descripcion, new Insets(10, 0, 0, 0));
        btniniciarSesion.setFont(new Font(20));
        btniniciarSesion.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: #246eba;");

        // Campo usuario
        Label nombre = new Label("Usuario");
        nombre.setFont(new Font(15));
        nombre.setTranslateX(150);
        TextField nombreText = new TextField();
        nombreText.setPromptText("Ingresa un nombre de usuario");
        nombreText.setFont(new Font(15));
        nombreText.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");

        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/usuario.jpeg")));
        icon.setFitHeight(16);
        icon.setFitWidth(16);

        HBox hBoxUsuario = new HBox(icon, nombreText);
        hBoxUsuario.setAlignment(Pos.CENTER_LEFT);
        hBoxUsuario.setMaxWidth(250);
        hBoxUsuario.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");
        hBoxUsuario.setTranslateX(150);

        VBox vBoxUsuario = new VBox(nombre, hBoxUsuario);
        VBox.setMargin(vBoxUsuario, new Insets(10, 0, 0, 0));
        nombreText.setMinWidth(230);

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

// Campo confirmar contraseña
        Label confirmarContraseñaLabel = new Label("Confirmar Contraseña");
        confirmarContraseñaLabel.setFont(new Font(15));
        confirmarContraseñaLabel.setTranslateX(150);
        PasswordField confirmarContraseñaText = new PasswordField();
        confirmarContraseñaText.setPromptText("Confirma tu contraseña");
        confirmarContraseñaText.setFont(new Font(15));
        confirmarContraseñaText.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");

        ImageView iconContraseña2 = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/candado.jpeg")));
        iconContraseña2.setFitHeight(16);
        iconContraseña2.setFitWidth(16);

        HBox hBoxConfirmarContraseña = new HBox(iconContraseña2, confirmarContraseñaText);
        hBoxConfirmarContraseña.setAlignment(Pos.CENTER_LEFT);
        hBoxConfirmarContraseña.setMaxWidth(250);
        hBoxConfirmarContraseña.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");
        hBoxConfirmarContraseña.setTranslateX(150);

        VBox vBoxConfirmarContraseña = new VBox(confirmarContraseñaLabel, hBoxConfirmarContraseña);
        vBoxConfirmarContraseña.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(vBoxConfirmarContraseña, new Insets(20, 0, 0, 0));

// Botón
        Button btnEntrar = new Button("Crear Cuenta");
        btnEntrar.setFont(new Font(18));
        btnEntrar.setMaxWidth(200);
        btnEntrar.setCursor(Cursor.OPEN_HAND);
        btnEntrar.setStyle("-fx-background-color: #2e3c85; -fx-text-fill: white");
        VBox.setMargin(btnEntrar, new Insets(40, 0, 0, 0));

        btnEntrar.setOnAction(actionEvent -> {
            String nombreUsuario = nombreText.getText().trim();
            String contraseñaUsuario = contraseñaText.getText().trim();
            String confirmarContraseña = confirmarContraseñaText.getText().trim(); // Cambiar el nombre de la variable en esta línea

            ControlRegistro controlRegistro = new ControlRegistro();

            // Validar el nombre de usuario
            if (!nombreUsuario.contains(" ")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Registro");
                alert.setHeaderText(null);
                alert.setContentText("El nombre de usuario debe contener nombre y apellidos.");
                alert.showAndWait();
                nombreText.clear();
                return;
            }

            // Validar la contraseña
            if (contraseñaUsuario.length() < 6) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Registro");
                alert.setHeaderText(null);
                alert.setContentText("La contraseña debe tener al menos 6 caracteres.");
                alert.showAndWait();
                contraseñaText.clear();
                return;
            }

            // Verificar que las contraseñas coincidan
            if (!contraseñaUsuario.equals(confirmarContraseña)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Registro");
                alert.setHeaderText(null);
                alert.setContentText("Las contraseñas no coinciden.");
                alert.showAndWait();
                contraseñaText.clear();
                confirmarContraseñaText.clear();
                return;
            }

            // Intentar registrar el usuario
            boolean exito = controlRegistro.registrarUsuario(nombreUsuario, contraseñaUsuario, confirmarContraseña);

            if (exito) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro Exitoso");
                alert.setHeaderText(null);
                alert.setContentText("Usuario registrado con éxito.");
                alert.showAndWait();
                try {
                    GUILogin login = new GUILogin();
                    Stage newStage = new Stage();
                    login.start(newStage);
                    ((Stage) btnEntrar.getScene().getWindow()).close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Registro");
                alert.setHeaderText(null);
                alert.setContentText("!Error¡ Usuario Ya Registrado.");
                alert.showAndWait();
                nombreText.clear();
                contraseñaText.clear();
                confirmarContraseñaText.clear();
            }
        });

        VBox v1 = new VBox();
        v1.getChildren().addAll(titulo, descripcion, btniniciarSesion, vBoxUsuario, vBoxContraseña, vBoxConfirmarContraseña, btnEntrar);

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