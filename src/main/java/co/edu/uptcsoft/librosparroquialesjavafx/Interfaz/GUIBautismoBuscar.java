package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import co.edu.uptcsoft.librosparroquialesjavafx.Control.ControlConfirmacion;
import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Confirmacion;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class GUIBautismoBuscar extends Application {
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

    private TextField nombreField;
    private TextField apellidoField;
    private TableView<Object[]> table;
    private ObservableList<Object[]> data;
    private ControlConfirmacion controlConfirmacion;
    ArrayList<Confirmacion> listaConfirmacion;

    @Override
    public void start(Stage stage) {
        controlConfirmacion = new ControlConfirmacion();
        listaConfirmacion = controlConfirmacion.getListaConfirmacion();

        VBox menuLateral = createMenuLateral(stage);
        VBox rightPanel = createRightPanel(stage);

        HBox root = new HBox(menuLateral, rightPanel);
        HBox.setHgrow(rightPanel, Priority.ALWAYS);

        Scene scene = new Scene(root, 1400, 700);
        stage.setScene(scene);
        stage.show();

        cargarTodosLosDatos();
    }

    private VBox createMenuLateral(Stage stage) {
        VBox menuLateral = new VBox(20);
        menuLateral.setStyle("-fx-background-color: #2e3c85");
        menuLateral.setPrefWidth(220);
        menuLateral.setAlignment(Pos.BASELINE_LEFT);
        menuLateral.setPadding(new Insets(20, 10, 20, 10));

        textLibrosEcle = new Label("Libros Eclesiasticos");
        textLibrosEcle.setTextFill(Color.WHITE);
        textLibrosEcle.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        textMenu = new Label("Menu");
        textMenu.setTextFill(Color.WHITE);
        textMenu.setFont(Font.font("Arial", FontWeight.BOLD, 20));
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
        btnSalir.setOnAction(actionEvent -> handleSalir(stage));

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

        return menuLateral;
    }

    private VBox createRightPanel(Stage stage) {
        VBox rightPanel = new VBox(20);
        rightPanel.setPadding(new Insets(20));

        GridPane searchPanel = createSearchPanel();
        table = createTable();

        rightPanel.getChildren().addAll(searchPanel, table);
        VBox.setVgrow(table, Priority.ALWAYS);

        return rightPanel;
    }

    private GridPane createSearchPanel() {
        GridPane searchPanel = new GridPane();
        searchPanel.setPadding(new Insets(20));
        searchPanel.setHgap(10);
        searchPanel.setVgap(10);

        Label searchLabel = new Label("Buscar/Confirmacion");
        searchLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        nombreLabel = new Label("Nombre:");
        nombreLabel.setFont(Font.font("Arial", 16));
        nombreField = new TextField();
        nombreField.setStyle("-fx-font-size: 16; -fx-background-color: #f0f0f0; -fx-border-radius: 5; -fx-border-color: #2e3c85;");
        nombreField.setPrefWidth(300);

        apellidoLabel = new Label("Apellido:");
        apellidoLabel.setFont(Font.font("Arial", 16));
        apellidoField = new TextField();
        apellidoField.setStyle("-fx-font-size: 16; -fx-background-color: #f0f0f0; -fx-border-radius: 5; -fx-border-color: #2e3c85;");
        apellidoField.setPrefWidth(300);

        Button btnBuscar = new Button("Buscar");
        btnBuscar.setStyle("-fx-font-size: 16; -fx-background-color: #2e3c85; -fx-text-fill: white; -fx-border-radius: 5;");
        btnBuscar.setPrefWidth(150);
        btnBuscar.setCursor(Cursor.HAND);
        btnBuscar.setOnAction(e -> buscar());

        HBox busqueda = new HBox(20, nombreLabel, nombreField, apellidoLabel, apellidoField, btnBuscar);
        busqueda.setAlignment(Pos.CENTER_LEFT);

        searchPanel.add(searchLabel, 0, 0);
        searchPanel.add(busqueda, 0, 1);

        return searchPanel;
    }

    private TableView<Object[]> createTable() {
        TableView<Object[]> table = new TableView<>();
        data = FXCollections.observableArrayList();


        TableColumn<Object[], String> folioColumn = new TableColumn<>("Numero");
        folioColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[0]));

        TableColumn<Object[], String> nombreColumn = new TableColumn<>("Nombres y Apellidos");
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[1]));

        TableColumn<Object[], String> libroColumn = new TableColumn<>("Libro");
        libroColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[2]));

        table.getColumns().addAll(folioColumn, nombreColumn, libroColumn);
        table.setItems(data);

        // Estilo de la tabla
        table.setStyle("-fx-background-color: white;-fx-font-size: 14px; -fx-border-color: #2e3c85; -fx-border-width: 2px;");
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Estilo de los encabezados
        for (TableColumn<Object[], ?> column : table.getColumns()) {
            column.setStyle("-fx-background-color: #2e3c85; -fx-text-fill: white; -fx-font-weight: bold; -fx-alignment: CENTER;");
            column.setPrefWidth(200);
        }

        // Estilo de las celdas
        table.setRowFactory(tv -> {
            TableRow<Object[]> row = new TableRow<>();
            row.setStyle("-fx-background-color: white ;-fx-border-color: #010101; -fx-border-width: 0 0 1 0;");
            return row;
        });
        Stage stage = new Stage();
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Doble clic
                Object[] selectedRow = table.getSelectionModel().getSelectedItem();
                if (selectedRow != null) {
                    String numero = (String) selectedRow[0];
                    abrirEdicionConfirmacion(stage, numero);
                }
            }
        });
        return table;
    }

    private void buscar() {
        String nombre = nombreField.getText().trim().toLowerCase();
        String apellido = apellidoField.getText().trim().toLowerCase();

        data.clear();

        for (Confirmacion confirmacion : listaConfirmacion) {
            boolean nombreCoincide = nombre.isEmpty() || confirmacion.getNombres().toLowerCase().contains(nombre);
            boolean apellidoCoincide = apellido.isEmpty() || confirmacion.getApellidos().toLowerCase().contains(apellido);

            if (nombreCoincide && apellidoCoincide) {
                data.add(new Object[]{
                        confirmacion.getNumero(),
                        confirmacion.getNombres() + " " + confirmacion.getApellidos(),
                        confirmacion.getLibro()
                });
            }
        }

        if (data.isEmpty()) {
            mostrarAlerta("No se encontraron resultados", "No se encontró ningún resultado.");
        }
    }

    private void cargarTodosLosDatos() {
        data.clear();
        for (Confirmacion confirmacion : listaConfirmacion) {
            data.add(new Object[]{
                    confirmacion.getNumero(),
                    confirmacion.getNombres() + " " + confirmacion.getApellidos(),
                    confirmacion.getLibro()
            });
        }
    }

    private void abrirEdicionConfirmacion(Stage currentStage, String numero ) {
        try {
            // Crear una nueva instancia de GUIConfirmacionEditar
            GUIConfirmacion editor = new GUIConfirmacion();
            editor.initData(numero); // Pasar los datos al constructor o a un método de inicialización

            // Mostrar la nueva ventana
            Stage newStage = new Stage();
            editor.start(newStage);
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void handleSalir(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Estás seguro de que desea salir?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            cambiarEscena(stage, GUILogin.class);
        }
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}