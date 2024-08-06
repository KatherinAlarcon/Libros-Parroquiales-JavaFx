package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import co.edu.uptcsoft.librosparroquialesjavafx.Control.ControlConfirmacion;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Confirmacion;
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

public class GUIConfirmacionAgregar extends Application {
    private TextField libroText;
    private TextField folioText;
    private TextField numeroText;
    private TextField nombre;
    private TextField apellido;
    private TextField padre;
    private TextField padrino;
    private TextField lugarBautismo;
    private TextField madre;
    private TextField parroquiaBautismo;
    private ComboBox<String> genero;
    private ComboBox<String> ministro;
    private ComboBox<String> daFe;
    private DatePicker fechaNacimiento;
    private DatePicker fechaConfirmacion;
    private TextArea notaMarginal;
    private Button btnAgregar;
    private Button btnRegresar;
    private Label textLibrosEcle;
    private Label textMenu;
    private Button textInicio;
    private Button btnBautismo;
    private Button btnConfirmacion ;
    private Button btnMatrimonio;
    private Button btnDefuncion ;
    private Button btnSacerdote;
    private Button btnSalir;
    private Region flexibleRegion;
    private Label titulo;
    private TextField lugarNacimiento;
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
        //menu horizontal
        titulo = new Label("Confirmacion/Agregar");
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
        hBoxLibro.setTranslateY(20);

        //primera Columna
        nombre = new TextField();
        nombre.setPromptText("*Nombres");
        nombre.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        nombre.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                nombre.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });
        apellido = new TextField();
        apellido.setPromptText("*Apellidos");
        apellido.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        apellido.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellido.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        genero = new ComboBox<>();
        genero.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        genero.getItems().addAll("Femenino", "Masculino");
        genero.setValue("*Genero");
        genero.setPrefWidth(540);

        padre = new TextField();
        padre.setPromptText("Nombre del padre");
        padre.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        padre.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                padre.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        padrino = new TextField();
        padrino.setPromptText("Padrino");
        padrino.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        padrino.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                padrino.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        lugarBautismo = new TextField();
        lugarBautismo.setPromptText("Lugar de bautismo");
        lugarBautismo.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        lugarBautismo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                lugarBautismo.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        ministro = new ComboBox<>();
        ministro.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        ministro.getItems().addAll("ministro 1", "ministo 2");
        ministro.setValue("*Ministro");
        ministro.setPrefWidth(540);

        VBox columna1 = new VBox(15);
        columna1.getChildren().addAll(nombre, apellido, genero, padre, padrino, lugarBautismo, ministro);
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
                lugarNacimiento.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        fechaConfirmacion = new DatePicker();
        fechaConfirmacion.setPromptText("*Fecha de confirmacion");
        fechaConfirmacion.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaConfirmacion.setPrefWidth(520);
        fechaConfirmacion.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        madre = new TextField();
        madre.setPromptText("Nombre de la Madre");
        madre.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        madre.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellido.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        parroquiaBautismo = new TextField();
        parroquiaBautismo.setPromptText("Parroquia de bautismo");
        parroquiaBautismo.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        parroquiaBautismo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z ]*")) {
                apellido.setText(newValue.replaceAll("[^a-zA-Z ]", ""));
            }
        });

        daFe = new ComboBox<>();
        daFe.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        daFe.getItems().addAll("1", "2", "3");
        daFe.setValue("*Da fe");
        daFe.setPrefWidth(520);

        VBox columna2 = new VBox(15);
        columna2.getChildren().addAll(fechaNacimiento, lugarNacimiento, fechaConfirmacion, madre, parroquiaBautismo, daFe);
        columna2.setAlignment(Pos.TOP_LEFT);
        columna2.setPrefWidth(520);

        HBox columnas = new HBox(60);
        columnas.getChildren().addAll(columna1, columna2);
        columnas.setAlignment(Pos.CENTER);
        columnas.setTranslateX(20);
        columnas.setTranslateY(35);

        notaMarginal = new TextArea();
        notaMarginal.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-color: #2e3c85;-fx-border-radius:10;");
        notaMarginal.setPromptText("Nota Marginal");
        notaMarginal.setPrefHeight(70);
        notaMarginal.setTranslateX(20);
        notaMarginal.setTranslateY(40);

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
                TextField[] requiredFields = {libroText, folioText, numeroText, nombre, apellido};
                Validator validator = new Validator();

                boolean allFieldsFilled = validator.areTextFieldsFilled(requiredFields) &&
                        validator.areComboBoxesAndDatesValid(genero, ministro, fechaNacimiento, fechaConfirmacion);

                if (allFieldsFilled) {
                    boolean guardarPersistencia = actualizarBautismoDesdeInterfaz();
                    if (guardarPersistencia) {
                        if (fechaNacimiento.getValue().isAfter(fechaConfirmacion.getValue())) {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Error en las fechas");
                            alert.setHeaderText(null);
                            alert.setContentText("La fecha de nacimiento no puede ser posterior a la fecha de confirmación.");
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
        botones.setTranslateY(20);
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
            ControlConfirmacion ctrlConfirmacion = new ControlConfirmacion();
            Confirmacion confirmacion = new Confirmacion();
            if (confirmacion != null) {
                confirmacion.setLibro(libroText.getText());
                confirmacion.setFolio(folioText.getText());
                confirmacion.setNumero(numeroText.getText());
                confirmacion.setNombres(nombre.getText());
                confirmacion.setApellidos(apellido.getText());
                confirmacion.setGenero( genero.getValue());
                confirmacion.setPadre(padre.getText());
                confirmacion.setPadrinos(padrino.getText());
                confirmacion.setLugarBautismo(lugarBautismo.getText());
                confirmacion.setMinistro(ministro.getValue());

                LocalDate selectedDate = fechaNacimiento.getValue();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = selectedDate.format(formatter);
                confirmacion.setFechaNacimiento(formattedDate);

                confirmacion.setLugarNacimiento(lugarNacimiento.getText());

                LocalDate selectedDate1 = fechaConfirmacion.getValue();
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate1 = selectedDate1.format(formatter1);
                confirmacion.setFechaConfirmacion(formattedDate1);

                confirmacion.setMadre(madre.getText());
                confirmacion.setMadrina(parroquiaBautismo.getText());
                confirmacion.setDaFe( daFe.getValue());
                confirmacion.setNotaMarginal(notaMarginal.getText());
                if (ctrlConfirmacion.agregarConfirmacion(confirmacion)) {
                    return true; // Guardado exitoso
                } else {
                    // Muestra un mensaje de advertencia si ya existe el confirmacion
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Bautismo duplicado");
                    alert.setHeaderText("El confirmacion ya existe");
                    alert.setContentText("Ya existe un confirmacion con el mismo libro, número y folio.");
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

