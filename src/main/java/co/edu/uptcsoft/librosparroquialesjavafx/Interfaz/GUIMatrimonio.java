package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import co.edu.uptcsoft.librosparroquialesjavafx.Control.ControlMatrimonio;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Matrimonio;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class GUIMatrimonio extends Application {

    private TextField libroText;
    private TextField folioText;
    private TextField numeroText;
    private TextField nombreNovioText;
    private TextField apellidoNovioText;
    private TextField padreNovioText;
    private TextField madreNovioText;
    private TextField lugarBautismoNovioText;
    private TextField parroquiaBautismoNovioText;
    private DatePicker fechaNacimientoNovio;
    private DatePicker fechaBautismoNovio;
    private ComboBox<String> estadoCivilNovio;
    private ComboBox<String> ministroComboBox;
    private TextField nombreNoviaText;
    private TextField apellidoNoviaText;
    private TextField padreNoviaText;
    private TextField madreNoviaText;
    private TextField lugarBautismoNoviaText;
    private TextField parroquiaBautismoNoviaText;
    private DatePicker fechaNacimientoNovia;
    private DatePicker fechaBautismoNovia;
    private ComboBox<String> estadoCivilNovia;
    private ComboBox<String> daFe;
    private TextArea notaMarginal;
    private Button btnEditar;
    private Button btnRegresar;
    private Button btnImprimir;
    private Button btnEliminar;
    Label textLibrosEcle;
    Label textMenu;
    Button textInicio;
    Button btnBautismo;
    Button btnConfirmacion ;
    Button btnMatrimonio;
    Button btnDefuncion ;
    Button btnSacerdote;
    Button btnSalir;
    Region flexibleRegion;
    Label titulo;

    @Override
    public void start(Stage stage) {
        libroText = new TextField();
        folioText = new TextField();
        numeroText = new TextField();
        nombreNovioText = new TextField();
        apellidoNovioText = new TextField();
        fechaNacimientoNovio = new DatePicker();
        padreNovioText = new TextField();
        madreNovioText = new TextField();
        lugarBautismoNovioText = new TextField();
        parroquiaBautismoNovioText = new TextField();
        fechaBautismoNovio = new DatePicker();
        estadoCivilNovio = new ComboBox<>();
        ministroComboBox = new ComboBox<>();
        nombreNoviaText = new TextField();
        apellidoNoviaText = new TextField();
        fechaNacimientoNovia = new DatePicker();
        padreNoviaText = new TextField();
        madreNoviaText = new TextField();
        lugarBautismoNoviaText = new TextField();
        parroquiaBautismoNoviaText = new TextField();
        fechaBautismoNovia = new DatePicker();
        estadoCivilNovia = new ComboBox<>();
        daFe = new ComboBox<>();
        notaMarginal = new TextArea();
        ControlMatrimonio matrimonio = new ControlMatrimonio();




        // menu lateral
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
        btnBautismo = createMenuButton("Bautismo", "/Imagenes/Sol.png", stage, GUIBautismo.class);
        btnConfirmacion = createMenuButton("Confirmación", "/Imagenes/paloma.png", stage, GUIConfirmacion.class);
        btnMatrimonio = createMenuButton("Matrimonio", "/Imagenes/Anillo.png", stage, GUIMatrimonioBuscar.class);
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
        menuLateral.setPrefHeight(730);
        //menu horizontal
        titulo = new Label("Matrimonio");
        titulo.setFont(new Font("Arial",30));

        //libro
        libroText = new TextField();
        libroText.setPromptText("Libro:");
        libroText.setMaxWidth(250);
        libroText.setStyle("-fx-background-color: #2e3c85; -fx-border-color: transparent;-fx-text-fill: white;-fx-font-size: 15");
        libroText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                libroText.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        //folio
        folioText = new TextField();
        folioText.setPromptText("Folio:");
        folioText.setMaxWidth(250);
        folioText.setStyle("-fx-background-color: #2e3c85; -fx-border-color: transparent;-fx-text-fill: white;-fx-font-size: 15");
        folioText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                folioText.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        //numero
        numeroText = new TextField();
        numeroText.setPromptText("Numero:");
        numeroText.setMaxWidth(250);
        numeroText.setStyle("-fx-background-color: #2e3c85; -fx-border-color: transparent;-fx-text-fill: white;-fx-font-size: 15");
        numeroText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                numeroText.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        HBox hBoxLibro = new HBox(120);
        hBoxLibro.getChildren().addAll(libroText, folioText, numeroText);
        hBoxLibro.setAlignment(Pos.CENTER);
        hBoxLibro.setTranslateX(50);

        // Primera Columna
        nombreNovioText = new TextField();
        nombreNovioText.setPromptText("Nombre Novio");
        nombreNovioText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        nombreNovioText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                nombreNovioText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        apellidoNovioText = new TextField();
        apellidoNovioText.setPromptText("Apellidos Novio");
        apellidoNovioText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        apellidoNovioText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoNovioText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        fechaNacimientoNovio = new DatePicker();
        fechaNacimientoNovio.setPromptText("Fecha de Nacimiento Novio");
        fechaNacimientoNovio.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaNacimientoNovio.setPrefWidth(540);
        fechaNacimientoNovio.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });


        padreNovioText = new TextField();
        padreNovioText.setPromptText("Padre Novio");
        padreNovioText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        padreNovioText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                padreNovioText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        madreNovioText = new TextField();
        madreNovioText.setPromptText("Madre Novio");
        madreNovioText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        madreNovioText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                madreNovioText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        lugarBautismoNovioText = new TextField();
        lugarBautismoNovioText.setPromptText("Lugar Bautismo");
        lugarBautismoNovioText.setStyle("--fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        lugarBautismoNovioText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                lugarBautismoNovioText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        parroquiaBautismoNovioText = new TextField();
        parroquiaBautismoNovioText.setPromptText("Parroquia de Bautismo");
        parroquiaBautismoNovioText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        parroquiaBautismoNovioText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                parroquiaBautismoNovioText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        fechaBautismoNovio = new DatePicker();
        fechaBautismoNovio.setPromptText("Fecha Bautismo");
        fechaBautismoNovio.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaBautismoNovio.setPrefWidth(540);
        fechaBautismoNovio.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        estadoCivilNovio = new ComboBox<>();
        estadoCivilNovio.setPromptText("Estado civil");
        estadoCivilNovio.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        estadoCivilNovio.getItems().addAll("Soltera","Divorciada","Viuda");
        estadoCivilNovio.setPrefWidth(540);

        ministroComboBox = new ComboBox<>();
        ministroComboBox.setPromptText("Ministro");
        ministroComboBox.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        ministroComboBox.getItems().addAll("Ministro 1", "Ministro 2");
        ministroComboBox.setPrefWidth(540);

        VBox columna1 = new VBox(15);
        columna1.getChildren().addAll(
                nombreNovioText,
                apellidoNovioText,
                fechaNacimientoNovio,
                padreNovioText,
                madreNovioText,
                lugarBautismoNovioText,
                parroquiaBautismoNovioText,
                fechaBautismoNovio,
                estadoCivilNovio,
                ministroComboBox
        );
        columna1.setPrefWidth(540);
        columna1.setAlignment(Pos.TOP_LEFT);

        // Segunda Columna
        nombreNoviaText = new TextField();
        nombreNoviaText.setPromptText("Nombre Novia");
        nombreNoviaText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        nombreNoviaText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                nombreNoviaText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        apellidoNoviaText = new TextField();
        apellidoNoviaText.setPromptText("Apellidos Novia");
        apellidoNoviaText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        apellidoNoviaText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoNoviaText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        fechaNacimientoNovia = new DatePicker();
        fechaNacimientoNovia.setPromptText("Fecha de Nacimiento");
        fechaNacimientoNovia.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaNacimientoNovia.setPrefWidth(540);
        fechaNacimientoNovia.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        padreNoviaText = new TextField();
        padreNoviaText.setPromptText("Padre Novia");
        padreNoviaText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        padreNoviaText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                padreNoviaText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        madreNoviaText = new TextField();
        madreNoviaText.setPromptText("Madre Novia");
        madreNoviaText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        madreNoviaText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                madreNoviaText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        lugarBautismoNoviaText = new TextField();
        lugarBautismoNoviaText.setPromptText("Lugar Bautismo");
        lugarBautismoNoviaText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        lugarBautismoNoviaText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                lugarBautismoNoviaText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        parroquiaBautismoNoviaText = new TextField();
        parroquiaBautismoNoviaText.setPromptText("Parroquia de Bautismo");
        parroquiaBautismoNoviaText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        parroquiaBautismoNoviaText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                parroquiaBautismoNoviaText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        fechaBautismoNovia = new DatePicker();
        fechaBautismoNovia.setPromptText("Fecha Bautismo");
        fechaBautismoNovia.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaBautismoNovia.setPrefWidth(540);
        fechaBautismoNovia.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        estadoCivilNovia = new ComboBox<>();
        estadoCivilNovia.setPromptText("Estado civil");
        estadoCivilNovia.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        estadoCivilNovia.getItems().addAll("Soltera","Divorciada","Viuda");
        estadoCivilNovia.setPrefWidth(540);

        daFe = new ComboBox<>();
        daFe.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        daFe.getItems().addAll("1","2","3");
        daFe.setValue("DaFe");
        daFe.setPrefWidth(540);

        VBox columna2 = new VBox(15);
        columna2.getChildren().addAll(
                nombreNoviaText,
                apellidoNoviaText,
                fechaNacimientoNovia,
                padreNoviaText,
                madreNoviaText,
                lugarBautismoNoviaText,
                parroquiaBautismoNoviaText,
                fechaBautismoNovia,
                estadoCivilNovia,
                daFe
        );
        columna2.setPrefWidth(520);
        columna2.setAlignment(Pos.TOP_LEFT);

        HBox columnas = new HBox(60);
        columnas.getChildren().addAll(columna1,columna2);
        columnas.setAlignment(Pos.CENTER);
        columnas.setTranslateX(20);

        // Nota Marginal
        notaMarginal = new TextArea();
        notaMarginal.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-color: #2e3c85;-fx-border-radius:10;");
        notaMarginal.setPromptText("Nota Marginal");
        notaMarginal.setPrefHeight(70);
        notaMarginal.setTranslateX(20);


        //boton regresar
        btnRegresar = new Button("Regresar");
        btnRegresar.setFont(new Font(20));
        btnRegresar.setPrefWidth(200);
        btnRegresar.setCursor(Cursor.OPEN_HAND);
        btnRegresar.setStyle("-fx-background-color: #2e3c85;-fx-text-fill: white");
        btnRegresar.setOnMouseEntered(e -> btnRegresar.setStyle("-fx-background-color: #9aa3d3; -fx-text-fill: white;"));
        btnRegresar.setOnMouseExited(e -> btnRegresar.setStyle("-fx-background-color: #2e3c85; -fx-text-fill: white;"));

        btnRegresar.setAlignment(Pos.CENTER);
        btnRegresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmación");
                alert.setHeaderText(null);
                alert.setContentText("¿Estás seguro de que desea regresar?");

                // Esperar a que el usuario haga clic en un botón
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    try {
                        GUIMenu menu = new GUIMenu();
                        menu.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    // El usuario presionó "Cancelar" o cerró la alerta
                    Alert cancelAlert = new Alert(Alert.AlertType.INFORMATION);
                    cancelAlert.setTitle("Cancelado");
                    cancelAlert.setHeaderText(null);
                    cancelAlert.showAndWait();
                }
            }
        });

        //boton imprimir
        btnImprimir = new Button("Imprimir");
        btnImprimir.setFont(new Font(20));
        btnImprimir.setPrefWidth(200);
        btnImprimir.setCursor(Cursor.OPEN_HAND);
        btnImprimir.setStyle("-fx-background-color: #2e3c85;-fx-text-fill: white");
        btnImprimir.setOnMouseEntered(e -> btnImprimir.setStyle("-fx-background-color: #9aa3d3; -fx-text-fill: white;"));
        btnImprimir.setOnMouseExited(e -> btnImprimir.setStyle("-fx-background-color: #2e3c85; -fx-text-fill: white;"));

        btnImprimir.setAlignment(Pos.CENTER);
        btnImprimir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Matrimonio");
                alert.setHeaderText(null);
                alert.setContentText("¿Seguro que deseas imprimir esta partida?");

                // Esperar a que el usuario haga clic en un botón
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    try {
                        GUIMenu menu = new GUIMenu();
                        menu.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    // El usuario presionó "Cancelar" o cerró la alerta
                    Alert cancelAlert = new Alert(Alert.AlertType.INFORMATION);
                    cancelAlert.setTitle("Cancelado");
                    cancelAlert.setHeaderText(null);
                    cancelAlert.showAndWait();
                }
            }
        });

        //boton Editar
        btnEditar = new Button("Editar");
        btnEditar.setFont(new Font(20));
        btnEditar.setPrefWidth(200);
        btnEditar.setCursor(Cursor.OPEN_HAND);
        btnEditar.setStyle("-fx-background-color: #2e3c85;-fx-text-fill: white");
        btnEditar.setOnMouseEntered(e -> btnEditar.setStyle("-fx-background-color: #9aa3d3; -fx-text-fill: white;"));
        btnEditar.setOnMouseExited(e -> btnEditar.setStyle("-fx-background-color: #2e3c85; -fx-text-fill: white;"));

        btnEditar.setAlignment(Pos.CENTER);
        btnEditar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Matrimonio");
                alert.setHeaderText(null);
                alert.setContentText("¿Seguro que deseas editar esta partida?");

                // Esperar a que el usuario haga clic en un botón
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    try {
                        GUIMatrimonio matriEditar = new GUIMatrimonio();
                        matriEditar.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    // El usuario presionó "Cancelar" o cerró la alerta
                    Alert cancelAlert = new Alert(Alert.AlertType.INFORMATION);
                    cancelAlert.setTitle("Cancelado");
                    cancelAlert.setHeaderText(null);
                    cancelAlert.showAndWait();
                }
            }
        });

        // Botón Eliminar
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(new Font(20));
        btnEliminar.setPrefWidth(200);
        btnEliminar.setCursor(Cursor.HAND);
        btnEliminar.setStyle("-fx-background-color: #2e3c85; -fx-text-fill: white;");
        btnEliminar.setOnMouseEntered(e -> btnEliminar.setStyle("-fx-background-color: #9aa3d3; -fx-text-fill: white;"));
        btnEliminar.setOnMouseExited(e -> btnEliminar.setStyle("-fx-background-color: #2e3c85; -fx-text-fill: white;"));

        btnEliminar.setAlignment(Pos.CENTER);
        btnEliminar.setOnAction(event -> {
            String folio = folioText.getText();
            String numero = numeroText.getText();

            int index = matrimonio.buscarMatrimonio(numero);;
            if (index >= 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmar Eliminación");
                alert.setHeaderText(null);
                alert.setContentText("¿Estás seguro de que deseas eliminar este registro?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    matrimonio.eliminarMatrimonio( numero);
                    limpiarCampos();

                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Éxito");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Registro eliminado con éxito.");
                    successAlert.showAndWait();

                    try {
                        GUIMatrimonioBuscar matriBuscar = new GUIMatrimonioBuscar();
                        matriBuscar.start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } else {
                Alert notFoundAlert = new Alert(Alert.AlertType.INFORMATION);
                notFoundAlert.setTitle("No encontrado");
                notFoundAlert.setHeaderText(null);
                notFoundAlert.setContentText("No se encontró ningún registro con ese folio y número.");
                notFoundAlert.showAndWait();
            }
        });



        HBox botones = new HBox(50);
        botones.getChildren().addAll(btnRegresar, btnEliminar, btnEditar, btnImprimir);
        botones.setAlignment(Pos.CENTER);
        botones.setPrefWidth(1000);
        VBox.setMargin(botones, new Insets(5, 0, 0, 0));


        VBox informacion = new VBox(10);
        informacion.getChildren().addAll(titulo,hBoxLibro,columnas, notaMarginal,botones);
        informacion.setAlignment(Pos.TOP_LEFT);

        HBox menuHorizontal = new HBox(15);
        menuHorizontal.getChildren().addAll(menuLateral,informacion);
        menuHorizontal.setAlignment(Pos.BASELINE_LEFT);
        menuHorizontal.setStyle("-fx-background-color: white");

        Scene scene = new Scene(menuHorizontal, 1400, 730);
        stage.setScene(scene);
        stage.setTitle("Matrimonio");
        stage.setResizable(false);
        stage.show();
    }


    private void limpiarCampos() {
        libroText.clear();
        folioText.clear();
        numeroText.clear();

        nombreNovioText.clear();
        apellidoNovioText.clear();
        padreNovioText.clear();
        madreNovioText.clear();
        lugarBautismoNovioText.clear();
        parroquiaBautismoNovioText.clear();
        fechaNacimientoNovio.setValue(null);
        fechaBautismoNovio.setValue(null);
        estadoCivilNovio.getSelectionModel().clearSelection();
        ministroComboBox.getSelectionModel().clearSelection();

        nombreNoviaText.clear();
        apellidoNoviaText.clear();
        padreNoviaText.clear();
        madreNoviaText.clear();
        lugarBautismoNoviaText.clear();
        parroquiaBautismoNoviaText.clear();
        fechaNacimientoNovia.setValue(null);
        fechaBautismoNovia.setValue(null);
        estadoCivilNovia.getSelectionModel().clearSelection();
        daFe.getSelectionModel().clearSelection();
        notaMarginal.clear();
    }


    public void initData2(String numero) {
        // Fetch data based on the numero and populate the fields
        ControlMatrimonio ctrlMatrimonio = new ControlMatrimonio();
        Matrimonio matrimonio = ctrlMatrimonio.getMatrimonioByNumero(numero);

        if (matrimonio != null) {
            mostrarDatosMatrimonio(matrimonio);
        }
    }

    private void mostrarDatosMatrimonio(Matrimonio matrimonio) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        libroText.setText(matrimonio.getLibro());
        folioText.setText(matrimonio.getFolio());
        numeroText.setText(matrimonio.getNumero());
        nombreNovioText.setText(matrimonio.getNombreNovio());
        apellidoNovioText.setText(matrimonio.getApellidoNovio());
        fechaNacimientoNovio.setValue(LocalDate.parse(matrimonio.getFechaDeNacimientoNovio(), formatter));
        padreNovioText.setText(matrimonio.getPadreNovio());
        madreNovioText.setText(matrimonio.getMadreNovio());
        lugarBautismoNovioText.setText(matrimonio.getLugarBautismoNovio());
        parroquiaBautismoNovioText.setText(matrimonio.getParroquiaDeBautismoNovio());
        fechaBautismoNovio.setValue(LocalDate.parse(matrimonio.getFechadeBautismoNovio(), formatter));
        estadoCivilNovio.setValue(matrimonio.getEstadoCivilNovio());
        ministroComboBox.setValue(matrimonio.getMinistro());

        nombreNoviaText.setText(matrimonio.getNombreNovia());
        apellidoNoviaText.setText(matrimonio.getApellidoNovia());
        fechaNacimientoNovia.setValue(LocalDate.parse(matrimonio.getFechaDeNacimientoNovia(), formatter));
        padreNoviaText.setText(matrimonio.getPadreNovia());
        madreNoviaText.setText(matrimonio.getMadreNovia());
        lugarBautismoNoviaText.setText(matrimonio.getLugarBautismoNovia());
        parroquiaBautismoNoviaText.setText(matrimonio.getParroquiaDeBautismoNovia());
        fechaBautismoNovia.setValue(LocalDate.parse(matrimonio.getFechadeBautismoNovia(), formatter));
        estadoCivilNovia.setValue(matrimonio.getEstadoCivilNovia());
        daFe.setValue(matrimonio.getDaFe());
        notaMarginal.setText(matrimonio.getNotaMarginal());


    }


    // Método auxiliar para parsear fechas
    private LocalDate parseDate(String dateString, DateTimeFormatter formatter) {
        if (dateString != null && !dateString.isEmpty()) {
            return LocalDate.parse(dateString, formatter);
        }
        return null;
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

    public void initData(String numero) {

    }

    public class Validator {

        public boolean areTextFieldsFilled(TextField[] requiredFields) {
            for (TextField field : requiredFields) {
                if (field.getText().trim().isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public boolean areComboBoxesAndDatesValid(ComboBox<String> estadoCivilNovio, ComboBox<String> ministroComboBox,
                                                  DatePicker fechaNacimientoNovio, DatePicker fechaBautismoNovio,
                                                  ComboBox<String> estadoCivilNovia,  ComboBox<String> daFe,
                                                  DatePicker fechaNacimientoNovia, DatePicker fechaBautismoNovia) {
            return estadoCivilNovio.getValue() != null && !estadoCivilNovio.getValue().equals("*Estado Civil Novio") &&
                    ministroComboBox.getValue() != null && !ministroComboBox.getValue().equals("*Ministro") &&
                    fechaNacimientoNovio.getValue() != null &&
                    fechaBautismoNovio.getValue() != null &&
                    estadoCivilNovia.getValue() != null && !estadoCivilNovia.getValue().equals("*Estado Civil Novia") &&
                    daFe.getValue() != null && !daFe.getValue().trim().isEmpty() &&
                    fechaNacimientoNovia.getValue() != null &&
                    fechaBautismoNovia.getValue() != null;
        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}