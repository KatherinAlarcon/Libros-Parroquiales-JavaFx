package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIConfirmacion extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Menu Lateral
        VBox menuLateral = new VBox(2);
        menuLateral.setBackground(new Background(new BackgroundFill(Color.rgb(46, 60, 134), null, null)));
        menuLateral.setPrefWidth(256);
        menuLateral.setAlignment(Pos.BASELINE_LEFT);
        menuLateral.setPadding(new Insets(20, 10, 20, 10)); // Añadir relleno al VBox

        Label textLibrosEcle = new Label("Libros Eclesiasticos");
        textLibrosEcle.setTextFill(Color.WHITE);
        textLibrosEcle.setStyle("-fx-font-size: 20px; -fx-font-family: 'Inter'; -fx-font-weight: bold;");

        Label textMenu = new Label("Menu");
        textMenu.setTextFill(Color.WHITE);
        textMenu.setStyle("-fx-font-size: 16px; -fx-font-family: 'Inter'; -fx-font-weight: bold;");
        textMenu.setAlignment(Pos.TOP_CENTER);

        Button textInicio = createMenuButton("Inicio", "/Imnagenes/hogar.png", primaryStage, GUIMenu.class);
        Button btnBautismo = createMenuButton("Bautismo", "/Imnagenes/Sol.png", primaryStage, GUIBautismo.class);
        Button btnConfirmacion = createMenuButton("Confirmación", "/Imnagenes/paloma.png", primaryStage, GUIConfirmacion.class);
        Button btnMatrimonio = createMenuButton("Matrimonio", "/Imnagenes/Anillo.png", primaryStage, GUIMatrimonio.class);
        Button btnDefuncion = createMenuButton("Defunción", "/Imnagenes/ataud.png", primaryStage, GUIDefuncion.class);
        Button btnSacerdote = createMenuButton("Sacerdotes", "/Imnagenes/Cruz.png", primaryStage, GUISacerdotes.class);
        Button btnBuscar = createMenuButton("Buscar", "/Imnagenes/lupa.png", primaryStage, GUIBuscar.class);

        // Espacio flexible para empujar el botón "Salir" hacia abajo
        Region flexibleRegion = new Region();
        VBox.setVgrow(flexibleRegion, Priority.ALWAYS);

        Button btnSalir = createMenuButton("Salir", "/Imnagenes/cerrar-sesion.png", primaryStage, GUILogin.class);

        menuLateral.getChildren().addAll(
                textLibrosEcle,
                textMenu,
                textInicio,
                btnBautismo,
                btnConfirmacion,
                btnMatrimonio,
                btnDefuncion,
                btnSacerdote,
                btnBuscar,
                flexibleRegion,
                btnSalir
        );

        HBox menuHorizontal = new HBox(15);
        menuHorizontal.setAlignment(Pos.BASELINE_LEFT);

        BorderPane root = new BorderPane();
        root.setLeft(menuLateral);
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        Scene scene = new Scene(root, 1400, 750);  // Ensure the scene is large enough

        primaryStage.setTitle("Confirmación");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createMenuButton(String text, String imagePath, Stage currentStage, Class<? extends Application> targetClass) {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageView.setFitWidth(24);
        imageView.setFitHeight(24);

        Button button = new Button(text, imageView);
        button.setStyle("-fx-font-size: 16px; -fx-font-family: 'Inter'; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: transparent;");
        button.setAlignment(Pos.CENTER_LEFT);
        button.setCursor(javafx.scene.Cursor.HAND);

        button.setOnAction(e -> {
            try {
                Application targetApp = targetClass.getDeclaredConstructor().newInstance();
                Stage newStage = new Stage();
                targetApp.start(newStage);
                currentStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
