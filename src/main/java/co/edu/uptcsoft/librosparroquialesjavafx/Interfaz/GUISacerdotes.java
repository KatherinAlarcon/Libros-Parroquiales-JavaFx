package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import co.edu.uptcsoft.librosparroquialesjavafx.Modelo.Sacerdotes;
import co.edu.uptcsoft.librosparroquialesjavafx.Persistencia.SacerdotesPersistencia;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.util.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GUISacerdotes extends Application {
    private static TableView<Object[]> table;
    private static ObservableList<Object[]> data;

    @Override
    public void start(Stage stage) {
        VBox menuLateral = createMenuLateral(stage);
        VBox rightPanel = createRightPanel(stage);

        HBox root = new HBox(menuLateral, rightPanel);
        HBox.setHgrow(rightPanel, Priority.ALWAYS);

        Scene scene = new Scene(root, 1400, 700);
        stage.setScene(scene);
        stage.show();
        actualizarTabla();
    }

    private VBox createMenuLateral(Stage stage) {
        VBox menuLateral = new VBox(20);
        menuLateral.setStyle("-fx-background-color: #2e3c85");
        menuLateral.setPrefWidth(220);
        menuLateral.setAlignment(Pos.BASELINE_LEFT);
        menuLateral.setPadding(new Insets(20, 10, 20, 10));

        Label textLibrosEcle = new Label("Libros Eclesiasticos");
        textLibrosEcle.setTextFill(Color.WHITE);
        textLibrosEcle.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        Label textMenu = new Label("Menu");
        textMenu.setTextFill(Color.WHITE);
        textMenu.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textMenu.setAlignment(Pos.TOP_CENTER);

        Button textInicio = createMenuButton("Inicio", "/Imagenes/hogar.png", stage, GUIMenu.class);
        Button btnBautismo = createMenuButton("Bautismo", "/Imagenes/Sol.png", stage, GUIBautismo.class);
        Button btnConfirmacion = createMenuButton("Confirmación", "/Imagenes/paloma.png", stage, GUIConfirmacion.class);
        Button btnMatrimonio = createMenuButton("Matrimonio", "/Imagenes/Anillo.png", stage, GUIMatrimonio.class);
        Button btnDefuncion = createMenuButton("Defunción", "/Imagenes/ataud.png", stage, GUIDefuncion.class);
        Button btnSacerdote = createMenuButton("Sacerdotes", "/Imagenes/Cruz.png", stage, GUIAgregarSacerdotes.class);

        Region flexibleRegion = new Region();
        VBox.setVgrow(flexibleRegion, Priority.ALWAYS);
        Button btnSalir = createMenuButton("Salir", "/Imagenes/cerrar-sesion.png", stage, GUILogin.class);
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

        Label titulo = new Label("Sacerdotes");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        table = createTable();
        HBox botones = createButtons();

        rightPanel.getChildren().addAll(titulo, table, botones);
        VBox.setVgrow(table, Priority.ALWAYS);

        return rightPanel;
    }

    private TableView<Object[]> createTable() {
        TableView<Object[]> table = new TableView<>();
        data = FXCollections.observableArrayList();

        TableColumn<Object[], String> numeroColumn = new TableColumn<>("Numero");
        numeroColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[0]));

        TableColumn<Object[], String> nombreColumn = new TableColumn<>("Nombres");
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[1]));

        TableColumn<Object[], String> apellidoColumn = new TableColumn<>("Apellidos");
        apellidoColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[2]));

        TableColumn<Object[], String> ordenColumn = new TableColumn<>("Orden Sacerdotal");
        ordenColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue()[3]));

        table.getColumns().addAll(numeroColumn, nombreColumn, apellidoColumn, ordenColumn);
        table.setItems(data);

        // Estilo de la tabla
        table.setStyle("-fx-background-color: White ; -fx-font-size: 14px; -fx-border-color: #e0e0e0 ; -fx-border-width: 2px;");
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Estilo de los encabezados
        for (TableColumn<Object[], ?> column : table.getColumns()) {
            column.setStyle("-fx-background-color: #5563A2; -fx-text-fill: white; -fx-font-weight: bold; -fx-alignment: CENTER;");
            column.setPrefWidth(200);
        }

        // Estilo de las celdas
        table.setRowFactory(tv -> {
            TableRow<Object[]> row = new TableRow<>();
            row.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 2 0;");
            return row;
        });

        return table;
    }

    public static void actualizarTabla() {
        List<Sacerdotes> sacerdotesList = SacerdotesPersistencia.cargarSacerdotes();
        data.clear();
        for (Sacerdotes sacerdote : sacerdotesList) {
            data.add(new Object[]{sacerdote.getId(), sacerdote.getNombre(), sacerdote.getApellido(), sacerdote.getTitulo()});
        }
    }

    private HBox createButtons() {
        Button btnAgregar = new Button("Agregar");
        btnAgregar.setStyle("-fx-font-size: 16; -fx-background-color: #2e3c85; -fx-text-fill: white; -fx-border-radius: 5;");
        btnAgregar.setPrefWidth(150);
        btnAgregar.setCursor(Cursor.HAND);
        btnAgregar.setOnAction(e -> cambiarEscena((Stage) btnAgregar.getScene().getWindow(), GUIAgregarSacerdotes.class));

        Button btnEditar = new Button("Editar");
        btnEditar.setStyle("-fx-font-size: 16; -fx-background-color: #2e3c85; -fx-text-fill: white; -fx-border-radius: 5;");
        btnEditar.setPrefWidth(150);
        btnEditar.setCursor(Cursor.HAND);
        btnEditar.setOnAction(e -> cambiarEscena((Stage) btnEditar.getScene().getWindow(), GUIEditarSacerdotes.class));

        HBox botones = new HBox(20, btnAgregar, btnEditar);
        botones.setAlignment(Pos.CENTER);

        return botones;
    }

    private void agregarSacerdote() {
        // Lógica para agregar un sacerdote
    }

    private void cambiarEscenaConDatos(Stage currentStage, Class<? extends Application> targetClass, Sacerdotes sacerdote) {
        try {
            GUIEditarSacerdotes targetApp = (GUIEditarSacerdotes) targetClass.getDeclaredConstructor().newInstance();
            targetApp.setSacerdote(sacerdote);
            Stage newStage = new Stage();
            targetApp.start(newStage);
            currentStage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editarSacerdote() {
        Object[] selectedRow = table.getSelectionModel().getSelectedItem();
        if (selectedRow != null) {
            String numero = (String) selectedRow[0];
            // Lógica para editar sacerdote basado en el número
        } else {
            mostrarAlerta("Selección inválida", "Por favor, seleccione un sacerdote de la tabla.");
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
