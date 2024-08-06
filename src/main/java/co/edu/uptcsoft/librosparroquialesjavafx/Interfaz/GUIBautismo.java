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

import java.util.Optional;

public class GUIBautismo extends Application {
    private Label libroText;
    private Label folioText;
    private Label numeroText;
    private Label nombre;
    private Label apellido;
    private Label padre;
    private Label abueloPaternoText;
    private Label abueloMaternoText;
    private Label padrino;
    private Label lugarNacimiento;
    private Label madre;
    private Label abuelaPaterna;
    private Label abuelaMaterna;
    private Label madrina;
    private ComboBox<String> genero;
    private ComboBox<String> ministro;
    private ComboBox<String> daFe;
    private DatePicker fechaNacimiento;
    private DatePicker fechaBautismo;
    private TextArea notaMarginal;
    private Button btnEditar;
    private Button btnEliminar;
    private Button btnImprimir;
    private Button btnRegresar;
    private ControlBautismo bautismo;
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
        titulo = new Label("Bautismo");
        titulo.setFont(new Font("Arial", 30));

        //libro
        libroText = new Label("*Libro:");
        libroText.setPrefWidth(250);
        libroText.setPrefHeight(35);
        libroText.setStyle("-fx-background-color: #2e3c85; -fx-border-color: transparent;-fx-text-fill: #ffffff;-fx-font-size: 15;-fx-background-radius: 5");

        //folio
        folioText = new Label("*Folio:");
        folioText.setPrefHeight(35);
        folioText.setPrefWidth(250);
        folioText.setStyle("-fx-background-color: #2e3c85; -fx-border-color: transparent;-fx-text-fill: white;-fx-font-size: 15;-fx-background-radius: 5");

        //numero
        numeroText = new Label("*Numero:");
        numeroText.setPrefWidth(250);
        numeroText.setPrefHeight(35);
        numeroText.setStyle("-fx-background-color: #2e3c85; -fx-border-color: transparent;-fx-text-fill: white;-fx-font-size: 15;-fx-background-radius: 5");


        HBox hBoxLibro = new HBox(120);
        hBoxLibro.getChildren().addAll(libroText, folioText, numeroText);
        hBoxLibro.setAlignment(Pos.CENTER);
        hBoxLibro.setTranslateX(50);
        //primera Columna
        nombre = new Label("*Nombres");
        nombre.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        nombre.setPrefWidth(540);
        nombre.setPrefHeight(35);

        apellido = new Label("*Apellidos");
        apellido.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        apellido.setPrefWidth(540);
        apellido.setPrefHeight(35);

        genero = new ComboBox<>();
        genero.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        genero.getItems().addAll("Femenino", "Masculino");
        genero.setValue("*Genero");
        genero.setPrefWidth(540);
        genero.setDisable(true);

        padre = new Label("Nombre del padre");
        padre.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        padre.setPrefWidth(540);
        padre.setPrefHeight(35);


        abueloPaternoText = new Label();
        abueloPaternoText.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        abueloPaternoText.setPrefWidth(540);
        abueloPaternoText.setPrefHeight(35);



        abueloMaternoText = new Label();
        abueloMaternoText.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        abueloMaternoText.setPrefWidth(540);
        abueloMaternoText.setPrefHeight(35);


        padrino = new Label("Padrino");
        padrino.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        padrino.setPrefWidth(540);
        padrino.setPrefHeight(35);


        ministro = new ComboBox<>();
        ministro.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        ministro.getItems().addAll("ministro 1", "ministo 2");
        ministro.setValue("*Ministro");
        ministro.setPrefWidth(540);
        ministro.setDisable(true);

        VBox columna1 = new VBox(15);
        columna1.getChildren().addAll(nombre, apellido, genero, padre, abueloPaternoText, abueloMaternoText, padrino, ministro);
        columna1.setPrefWidth(540);
        columna1.setAlignment(Pos.TOP_LEFT);


        //columna 2
        fechaNacimiento = new DatePicker();
        fechaNacimiento.setPromptText("*Fecha de Nacimiento");
        fechaNacimiento.setStyle("-fx-text-fill: #7c7878;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaNacimiento.setPrefWidth(520);
        fechaNacimiento.setDisable(true);

        lugarNacimiento = new Label("Lugar de Nacimiento");
        lugarNacimiento.setStyle("-fx-text-fill: #9a9898;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        lugarNacimiento.setPrefWidth(520);
        lugarNacimiento.setPrefHeight(35);

        fechaBautismo = new DatePicker();
        fechaBautismo.setPromptText("*Fecha de confirmacion");
        fechaBautismo.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        fechaBautismo.setPrefWidth(520);
        fechaBautismo.setDisable(true);

        madre = new Label("Nombre de la Madre");
        madre.setStyle("-fx-text-fill: #9a9898;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        madre.setPrefWidth(520);
        madre.setPrefHeight(35);

        abuelaPaterna = new Label();
        abuelaPaterna.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        abuelaPaterna.setPrefWidth(540);
        abuelaPaterna.setPrefHeight(35);


        abuelaMaterna = new Label();
        abuelaMaterna.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        abuelaMaterna.setPrefWidth(540);
        abuelaMaterna.setPrefHeight(35);



        madrina = new Label();
        madrina.setStyle("-fx-text-fill: #9a9898;-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        madrina.setPrefWidth(540);
        madrina.setPrefHeight(35);


        daFe = new ComboBox<>();
        daFe.setStyle("-fx-font-size: 15;-fx-background-color: transparent;-fx-border-radius:10;-fx-border-color: #2e3c85;");
        daFe.getItems().addAll("1", "2", "3");
        daFe.setValue("*Da fe");
        daFe.setPrefWidth(520);
        daFe.setDisable(true);

        VBox columna2 = new VBox(15);
        columna2.getChildren().addAll(fechaNacimiento, lugarNacimiento, fechaBautismo, madre, abuelaPaterna, abuelaMaterna, madrina, daFe);
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
                try {
                    GUIBautismoEditar guiBautismoEditar = new GUIBautismoEditar();
                    guiBautismoEditar.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
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
            String libro = libroText.getText();
            String numero = numeroText.getText();
            bautismo= new ControlBautismo();
            int index = bautismo.buscarBautismo(libro,numero);
            if (index >= 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmar Eliminación");
                alert.setHeaderText(null);
                alert.setContentText("¿Estás seguro de que deseas eliminar este registro?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    bautismo.eliminarBautismo( libro, numero);
                    limpiarCampos();

                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Éxito");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Registro eliminado con éxito.");
                    successAlert.showAndWait();

                    try {
                        GUIBautismoBuscar bautismoBuscar = new GUIBautismoBuscar();
                        bautismoBuscar.start(stage);
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
                try {
                    GUIMenu menu = new GUIMenu();
                    menu.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
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
        botones.getChildren().addAll(btnEditar, btnEliminar,btnImprimir, btnRegresar);
        botones.setAlignment(Pos.CENTER);
        botones.setPrefWidth(1000);
        VBox.setMargin(botones, new Insets(20, 0, 0, 0));

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
    private void limpiarCampos(){

    }
    }





