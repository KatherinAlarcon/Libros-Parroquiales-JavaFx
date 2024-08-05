package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import co.edu.uptcsoft.librosparroquialesjavafx.Control.ControlConfirmacion;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Confirmacion;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Optional;

public class GUIConfirmacionBuscar extends Application {

    Label textLibrosEcle;
    Label textMenu;
    Button textInicio;
    Button btnBautismo;
    Button btnConfirmacion;
    Button btnMatrimonio;
    Button btnDefuncion;
    Button btnSacerdote;
    Button btnSalir;
    Region flexibleRegion;

    private TextField nombreField;
    private TextField apellidoField;
    private TableView<Confirmacion> tableView;
    private ControlConfirmacion controlConfirmacion;

    @Override
    public void start(Stage stage) {
        // Inicialización de ControlConfirmacion
        controlConfirmacion = new ControlConfirmacion();

        // Configuración del menú lateral
        VBox menuLateral = new VBox(20);
        menuLateral.setStyle("-fx-background-color: #2e3c85");
        menuLateral.setPrefWidth(220);
        menuLateral.setAlignment(Pos.BASELINE_LEFT);
        menuLateral.setPadding(new Insets(20, 10, 20, 10));

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
        btnSalir.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("¿Estás seguro de que desea salir?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    GUILogin login = new GUILogin();
                    login.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
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

        // Panel de búsqueda
        GridPane searchPanel = new GridPane();
        searchPanel.setPadding(new Insets(20));
        searchPanel.setHgap(10);
        searchPanel.setVgap(10);

        Label searchLabel = new Label("Buscar/Confirmacion");
        searchLabel.setStyle("-fx-font-size: 24px;");

        Label nameLabel = new Label("Nombre:");
        nombreField = new TextField();

        Label surnameLabel = new Label("Apellido:");
        apellidoField = new TextField();

        Button searchButton = new Button("Buscar");
        searchButton.setOnAction(e -> buscarConfirmacion(nombreField.getText(), apellidoField.getText()));

        HBox searchBox = new HBox(10, nameLabel, nombreField, surnameLabel, apellidoField, searchButton);
        searchBox.setPadding(new Insets(10));

        // Configuración del TableView y sus columnas
        tableView = new TableView<>();
        TableColumn<Confirmacion, String> libroColumn = new TableColumn<>("Libro");
        libroColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLibro()));

        TableColumn<Confirmacion, String> numeroColumn = new TableColumn<>("Número");
        numeroColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumero()));

        TableColumn<Confirmacion, String> folioColumn = new TableColumn<>("Folio");
        folioColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFolio()));

        TableColumn<Confirmacion, String> nombreColumn = new TableColumn<>("Nombre");
        nombreColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombres()));

        TableColumn<Confirmacion, String> apellidoColumn = new TableColumn<>("Apellido");
        apellidoColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getApellidos()));

        tableView.getColumns().addAll(libroColumn, numeroColumn, folioColumn, nombreColumn, apellidoColumn);

        VBox vbox = new VBox(10, searchBox, tableView);
        vbox.setPadding(new Insets(10));

        // Configuración de la escena y el stage
        Scene scene = new Scene(new BorderPane(vbox, null, null, null, menuLateral), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void buscarConfirmacion(String nombre, String apellido) {
        ObservableList<Confirmacion> resultados = FXCollections.observableArrayList();
        for (Confirmacion confirmacion : controlConfirmacion.getListaConfirmacion()) {
            if (confirmacion.getNombres().equalsIgnoreCase(nombre) && confirmacion.getApellidos().equalsIgnoreCase(apellido)) {
                resultados.add(confirmacion);
            }
        }
        tableView.setItems(resultados);
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
}
