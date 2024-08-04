package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import co.edu.uptcsoft.librosparroquialesjavafx.Control.ControlBautismo;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Bautismo;
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

public class GUIAgregarBautismo extends Application {
    private TextField libroText;
    private TextField folioText;
    private TextField numeroText;
    private TextField nombreText;
    private TextField apellidoText;
    private TextField papaText;
    private TextField abueloPaternoText;
    private TextField abueloMaternoText;
    private TextField padrinoText;
    private TextField lugarNacimiento;
    private TextField mamaText;
    private TextField abuelaPaterna;
    private TextField abuelaMaterna;
    private TextField madrina;
    private ComboBox<String> genero;
    private ComboBox<String> ministro;
    private ComboBox<String> daFe;
    private DatePicker fechaNacimiento;
    private DatePicker fechaBautismo;
    private TextArea notaMarginal;
    private Button btnAgregar;
    private Button btnRegresar;
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
        btnBautismo = createMenuButton("Bautismo", "/Imagenes/Sol.png", stage, GUIAgregarBautismo.class);
        btnConfirmacion = createMenuButton("Confirmación", "/Imagenes/paloma.png", stage, GUIAgregarConfirmacion.class);
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
        //menu horizontal
        titulo = new Label("Bautismo");
        titulo.setFont(new Font("Arial", 30));

        //libro
        libroText = new TextField();
        libroText.setPromptText("*Libro: ");
        libroText.setMaxWidth(250);
        libroText.setStyle("-fx-background-color: #2e3c85; -fx-border-color: transparent;-fx-text-fill: white;-fx-font-size: 15");
        libroText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                libroText.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //folio
        folioText = new TextField();
        folioText.setPromptText("*Folio:");
        folioText.setMaxWidth(250);
        folioText.setStyle("-fx-background-color: #2e3c85; -fx-border-color: transparent;-fx-text-fill: white;-fx-font-size: 15");
        folioText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                folioText.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //numero
        numeroText = new TextField();
        numeroText.setPromptText("*Numero:");
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

        //primera Columna
        nombreText = new TextField();
        nombreText.setPromptText("*Nombres");
        nombreText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        nombreText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                nombreText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });
        apellidoText = new TextField();
        apellidoText.setPromptText("*Apellidos");
        apellidoText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        apellidoText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        genero = new ComboBox<>();
        genero.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        genero.getItems().addAll("Femenino", "Masculino");
        genero.setValue("*Genero");
        genero.setPrefWidth(540);

        papaText = new TextField();
        papaText.setPromptText("Nombre del padre");
        papaText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        papaText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        abueloPaternoText = new TextField();
        abueloPaternoText.setPromptText("Abuelo Paterno");
        abueloPaternoText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        abueloPaternoText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        abueloMaternoText = new TextField();
        abueloMaternoText.setPromptText("Abuelo Materno");
        abueloMaternoText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        abueloMaternoText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        padrinoText = new TextField();
        padrinoText.setPromptText("Padrino");
        padrinoText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        padrinoText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        ministro = new ComboBox<>();
        ministro.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        ministro.getItems().addAll("ministro 1", "ministo 2");
        ministro.setValue("*Ministro");
        ministro.setPrefWidth(540);

        VBox columna1 = new VBox(15);
        columna1.getChildren().addAll(nombreText, apellidoText, genero, papaText, abueloPaternoText, abueloMaternoText, padrinoText, ministro);
        columna1.setPrefWidth(540);
        columna1.setAlignment(Pos.TOP_LEFT);


        //columna 2
        fechaNacimiento = new DatePicker();
        fechaNacimiento.setPromptText("*Fecha de Nacimiento");
        fechaNacimiento.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaNacimiento.setPrefWidth(520);
        fechaNacimiento.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        lugarNacimiento = new TextField();
        lugarNacimiento.setPromptText("Lugar de Nacimiento");
        lugarNacimiento.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        lugarNacimiento.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        fechaBautismo = new DatePicker();
        fechaBautismo.setPromptText("*Fecha de Bautismo");
        fechaBautismo.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaBautismo.setPrefWidth(520);
        fechaBautismo.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        mamaText = new TextField();
        mamaText.setPromptText("Nombre de la Madre");
        mamaText.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        mamaText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        abuelaPaterna = new TextField();
        abuelaPaterna.setPromptText("Abuela Paterna");
        abuelaPaterna.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        abuelaPaterna.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        abuelaMaterna = new TextField();
        abuelaMaterna.setPromptText("Abuela Materna");
        abuelaMaterna.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        abuelaMaterna.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        madrina = new TextField();
        madrina.setPromptText("Madrina");
        madrina.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        madrina.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellidoText.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        daFe = new ComboBox<>();
        daFe.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        daFe.getItems().addAll("1", "2", "3");
        daFe.setValue("*Da fe");
        daFe.setPrefWidth(520);

        VBox columna2 = new VBox(15);
        columna2.getChildren().addAll(fechaNacimiento, lugarNacimiento, fechaBautismo, mamaText, abuelaPaterna, abuelaMaterna, madrina, daFe);
        columna2.setAlignment(Pos.TOP_LEFT);
        columna2.setPrefWidth(520);

        HBox columnas = new HBox(60);
        columnas.getChildren().addAll(columna1, columna2);
        columnas.setAlignment(Pos.CENTER);
        columnas.setTranslateX(20);

        notaMarginal = new TextArea();
        notaMarginal.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-color: #2e3c85;-fx-border-radius:10;");
        notaMarginal.setPromptText("Nota Marginal");
        notaMarginal.setPrefHeight(70);
        notaMarginal.setTranslateX(20);

        btnAgregar = new Button("Agregar");
        btnAgregar.setFont(new Font(20));
        btnAgregar.setPrefWidth(200);
        btnAgregar.setCursor(Cursor.OPEN_HAND);
        btnAgregar.setStyle("-fx-background-color: #2e3c85;-fx-text-fill: white");
        btnAgregar.setOnMouseEntered(e -> btnAgregar.setStyle("-fx-background-color: #9aa3d3; -fx-text-fill: white;"));
        btnAgregar.setOnMouseExited(e -> btnAgregar.setStyle("-fx-background-color: #2e3c85; -fx-text-fill: white;"));
        btnAgregar.setAlignment(Pos.CENTER);
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TextField[] requiredFields = {libroText, folioText, numeroText, nombreText, apellidoText};

                Validator validator = new Validator();
                boolean allFieldsFilled = validator.areTextFieldsFilled(requiredFields) &&
                        validator.areComboBoxesAndDatesValid(genero, ministro, fechaNacimiento, fechaBautismo);
                boolean guardarPersistencia = actualizarBautismoDesdeInterfaz();
                if (allFieldsFilled && guardarPersistencia) {
                    if (fechaNacimiento.getValue().isAfter(fechaBautismo.getValue())) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Error en las fechas");
                        alert.setHeaderText(null);
                        alert.setContentText("La fecha de nacimiento no puede ser posterior a la fecha de bautismo.");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Acceso correcto");
                        alert.setHeaderText(null);
                        alert.setContentText("Cambios guardados correctamente");
                        alert.showAndWait();
                        try {
                            GUIMenu menu = new GUIMenu();
                            menu.start(stage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Campos incompletos");
                    alert.setHeaderText(null);
                    alert.setContentText("Por favor, completa todos los campos necesarios.");
                    alert.showAndWait();
                }

            }
        });


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
                alert.setContentText("¿Estás seguro de que desea regresar?\n Se perderan los cambios");

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
        HBox botones = new HBox(50);
        botones.getChildren().addAll(btnAgregar, btnRegresar);
        botones.setAlignment(Pos.CENTER);
        botones.setPrefWidth(1000);
        VBox.setMargin(botones, new Insets(40, 0, 0, 0));

        VBox informacion = new VBox(10);
        informacion.getChildren().addAll(titulo, hBoxLibro, columnas, notaMarginal, botones);
        informacion.setAlignment(Pos.TOP_LEFT);


        HBox menuHorizontal = new HBox(15);
        menuHorizontal.getChildren().addAll(menuLateral, informacion);
        menuHorizontal.setAlignment(Pos.BASELINE_LEFT);
        menuHorizontal.setStyle("-fx-background-color: white");


        Scene scene = new Scene(menuHorizontal, 1400, 700);

        stage.setTitle("Bautismo");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
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
    class Validator {

        public boolean areTextFieldsFilled(TextField[] requiredFields) {
            for (TextField field : requiredFields) {
                if (field.getText().trim().isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public boolean areComboBoxesAndDatesValid(ComboBox<String> genero, ComboBox<String> minisitro,
                                                  DatePicker fechaNacimiento, DatePicker fechaBautismo) {
            return genero.getValue() != null && !genero.getValue().equals("*Genero") &&
                    minisitro.getValue() != null && !minisitro.getValue().equals("*Ministro") &&
                    daFe.getValue() != null && !daFe.getValue().equals("*Da fe") &&
                    fechaNacimiento.getValue() != null &&
                    fechaBautismo.getValue() != null;
        }

    }
    public boolean actualizarBautismoDesdeInterfaz() {
        try {
            ControlBautismo ctrlBautismo = new ControlBautismo();
            Bautismo bautismo = new Bautismo();
            if (bautismo != null) {
                bautismo.setLibro(libroText.getText());
                bautismo.setFolio(folioText.getText());
                bautismo.setNumero(numeroText.getText());
                bautismo.setNombres(nombreText.getText());
                bautismo.setApellidos(apellidoText.getText());
                bautismo.setPadre(papaText.getText());

                LocalDate selectedDate = fechaNacimiento.getValue();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = selectedDate.format(formatter);
                bautismo.setFechaNacimiento(formattedDate);
                bautismo.setLugarNacimiento(lugarNacimiento.getText());
                bautismo.setGenero((String) genero.getValue());
                bautismo.setMadre(mamaText.getText());
                bautismo.setAbueloPaterno(abueloPaternoText.getText());
                bautismo.setAbuelaPaterna(abuelaPaterna.getText());
                bautismo.setAbueloMaterno(abueloMaternoText.getText());
                bautismo.setAbuelaMaterna(abuelaMaterna.getText());
                bautismo.setPadrinos(padrinoText.getText());
                bautismo.setMadrina(madrina.getText());
                bautismo.setMinistro((String) ministro.getValue());
                bautismo.setDaFe((String) daFe.getValue());
                bautismo.setNotaMarginal(notaMarginal.getText());

                if (ctrlBautismo.agregarBautismo(bautismo)) {
                    return true; // Guardado exitoso
                } else {
                    // Muestra un mensaje de advertencia si ya existe el bautismo
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Bautismo duplicado");
                    alert.setHeaderText("El bautismo ya existe");
                    alert.setContentText("Ya existe un bautismo con el mismo libro, número y folio.");
                    alert.showAndWait();
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            // Muestra un mensaje de advertencia si ocurre una excepción
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al guardar los datos");
            alert.setHeaderText("No se pudieron guardar los datos.");
            alert.setContentText("Ocurrió un error al intentar guardar los datos. Por favor, intente nuevamente.");
            alert.showAndWait();
            e.printStackTrace();
            return false;
        }
    }



}

