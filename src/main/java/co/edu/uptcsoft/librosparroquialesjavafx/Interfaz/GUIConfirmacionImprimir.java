package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Optional;

public class GUIConfirmacionImprimir extends Application {
    Label textLibrosEcle;
    Label textMenu;
    Label nombreLabel;
    Label apellidoLabel;
    Button textInicio;
    Button btnBautismo;
    Button btnConfirmacion;
    Button btnMatrimonio;
    Button btnDefuncion;
    Button btnSacerdote;
    Button btnSalir;
    Region flexibleRegion;
    @Override
    public void start(Stage stage) throws Exception {

        VBox menuLateral = new VBox(2);
        menuLateral.setStyle("-fx-background-color: #2e3c85");
        menuLateral.setPrefWidth(220);
        menuLateral.setAlignment(Pos.BASELINE_LEFT);
        menuLateral.setPadding(new Insets(20, 10, 20, 10)); // Añadir relleno al VBox

        textLibrosEcle = new Label("Libros Eclesiasticos");
        textLibrosEcle.setTextFill(Color.WHITE);
        textLibrosEcle.setStyle("-fx-font-size: 22px;");

        textMenu = new Label("Menu");
        textMenu.setTextFill(Color.WHITE);
        textMenu.setStyle("-fx-font-size: 20px;");
        textMenu.setAlignment(Pos.TOP_CENTER);

        textInicio = createMenuButton("Inicio", "/Imagenes/hogar.png", stage, GUIMenu.class);
        btnBautismo = createMenuButton("Bautismo", "/Imagenes/Sol.png", stage, GUIAgregarBautismo.class);
        btnConfirmacion = createMenuButton("Confirmación", "/Imagenes/paloma.png", stage, GUIConfirmacionAgregar.class);
        btnMatrimonio = createMenuButton("Matrimonio", "/Imagenes/Anillo.png", stage, GUIMatrimonio.class);
        btnDefuncion = createMenuButton("Defunción", "/Imagenes/ataud.png", stage, GUIDefuncion.class);
        btnSacerdote = createMenuButton("Sacerdotes", "/Imagenes/Cruz.png", stage, GUISacerdotes.class);

        flexibleRegion = new Region();
        VBox.setVgrow(flexibleRegion, Priority.ALWAYS);
        btnSalir = createMenuButton("Salir", "/Imagenes/cerrar-sesion.png", stage, GUILogin.class);
        btnSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmación");
                alert.setHeaderText(null);
                alert.setContentText("¿Estás seguro de que desea salir?");

                // Esperar a que el usuario haga clic en un botón
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    try {
                        GUILogin login = new GUILogin();
                        login.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        menuLateral.getChildren().addAll(
                textLibrosEcle,
                textMenu,
                textInicio,
                btnBautismo,
                btnConfirmacion,
                btnMatrimonio,
                btnDefuncion,
                btnSacerdote,
                flexibleRegion,
                btnSalir
        );
        menuLateral.setPrefHeight(700);

        VBox vbox = new VBox(10);  // Espaciado entre elementos
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center-left;");

        // Creación de labels con estilos y textos
        Label textTitle = new Label("ARQUIDIOCESIS DE TUNJA");
        textTitle.setFont(Font.font("Inter", FontWeight.BOLD, 20));
        textTitle.setTranslateX(220);


        Label textSubtitle = new Label("PARROQUIA NUESTRA SEÑORA DE LOS DOLORES DE TOTA");
        textSubtitle.setFont(Font.font("Inter", FontWeight.BOLD, 16));
        textSubtitle.setTranslateX(170);

        Label textDireccion = new Label("CALLE 5# 3-32 – teléfono 3208397715");
        textDireccion.setFont(Font.font("Inter", 14));
        textDireccion.setTranslateX(250);

        Label textLocation = new Label("TOTA – BOYACÁ");
        textLocation.setFont(Font.font("Inter", FontWeight.BOLD, 18));
        textLocation.setTranslateX(260);

        Label textTituloPartida = new Label("PARTIDA DE CONFIRMACIÓN");
        textTituloPartida.setFont(Font.font("Inter", FontWeight.BOLD, 18));
        textTituloPartida.setTranslateX(250);

        Label textLibro = new Label("LIBRO");
        textLibro.setFont(Font.font("Inter", FontWeight.BOLD, 18));
        textLibro.setPrefWidth(200);

        Label textFolio = new Label("FOLIO");
        textFolio.setFont(Font.font("Inter", FontWeight.BOLD, 18));
        textFolio.setPrefWidth(200);

        Label textNumero = new Label("NUMERO");
        textNumero.setFont(Font.font("Inter", FontWeight.BOLD, 18));
        textNumero.setPrefWidth(200);

        HBox hBoxLibro = new HBox();
        hBoxLibro.setAlignment(Pos.CENTER);
        hBoxLibro.getChildren().addAll(textLibro,textFolio,textNumero);
        hBoxLibro.setTranslateX(100);


        Label textInfFecha = new Label("El día ");
        textInfFecha.setFont(Font.font("Inter", 14));

        Label textMinistro = new Label("El ministro:");
        textMinistro.setFont(Font.font("Inter", 14));

        Label textNombre = new Label("El bautismo de ");
        textNombre.setFont(Font.font("Inter", 14));

        Label textEdad = new Label("Edad:");
        textEdad.setFont(Font.font("Inter", 14));

        Label textPadres = new Label("Hijo de: ");
        textPadres.setFont(Font.font("Inter", 14));

        Label textEstadoCivil = new Label("Estado civil: ");
        textEstadoCivil.setFont(Font.font("Inter", 14));

        Label fechaDeceso = new Label("Fecha del Deceso:");
        fechaDeceso.setFont(Font.font("Inter", 14));

        Label textCausaMuerte = new Label("Causa de la muerte: ");
        textCausaMuerte.setFont(Font.font("Inter", 14));

        Label textDaFe = new Label("Da Fe: PBRO. JULIO ENRIQUE LEAL M.");
        textDaFe.setFont(Font.font("Inter", 14));

        Label textNotaMarginal = new Label("Nota Marginal: Sin nota marginal a la fecha.");
        textNotaMarginal.setFont(Font.font("Inter", 14));

        Label textFechaFirma = new Label("Es fiel copia del original. Expedida en Tota – BOYACÁ a fecha treinta de julio de dos mil veintiuno.");
        textFechaFirma.setFont(Font.font("Inter", 14));
        textFechaFirma.setTranslateY(20);

        Label firmaSacerdote = new Label("Doy fe: PÁRROCO, JORGE ALBEIRO MOTAVITA MORENO");
        firmaSacerdote.setFont(Font.font("Inter", FontWeight.BOLD, 18));
        firmaSacerdote.setTranslateX(150);
        firmaSacerdote.setTranslateY(80);

        // Agregando todos los Labels al VBox
        vbox.getChildren().addAll(textTitle, textSubtitle, textDireccion, textLocation, textTituloPartida, hBoxLibro, textInfFecha, textMinistro, textNombre, textEdad, textPadres,
                textEstadoCivil, fechaDeceso, textCausaMuerte, textDaFe, textNotaMarginal,
                textFechaFirma, firmaSacerdote);
        vbox.setTranslateX(100);
        vbox.setTranslateY(-50);

        HBox menuHorizontal = new HBox();
        menuHorizontal.getChildren().addAll(menuLateral,vbox);

        Scene scene = new Scene(menuHorizontal, 1400, 700);
        stage.setTitle("Confirmacion");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    private Button createMenuButton(String text, String imagePath, Stage currentStage, Class<? extends Application> targetClass) {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageView.setFitWidth(24);
        imageView.setFitHeight(24);

        Button button = new Button(text, imageView);
        button.setStyle("-fx-font-size: 16px; -fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: transparent; -fx-alignment: CENTER-LEFT;");
        button.setCursor(Cursor.HAND);
        button.setOnAction(e -> cambiarEscena(currentStage, targetClass));

        return button;
    }
    private void cambiarEscena(Stage currentStage, Class<? extends Application> targetClass) {
        try {
            Application targetApp = targetClass.getDeclaredConstructor().newInstance();
            Stage newStage = new Stage();
            targetApp.start(newStage);
            currentStage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
