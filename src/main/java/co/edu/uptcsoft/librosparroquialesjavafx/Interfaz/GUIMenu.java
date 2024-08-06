package co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.InputStream;

public class GUIMenu extends Application {

    public void start(Stage stage) {

        // Cargar el banner
        ImageView logo;
        InputStream inputStream = getClass().getResourceAsStream("/Imagenes/BannerMenu.jpg");
        Image image = new Image(inputStream);
        logo = new ImageView(image);
        logo.setFitWidth(1400);
        logo.setFitHeight(550);
        logo.setPreserveRatio(true);

        // Boton bautismo
        Image imgBautismo = new Image(getClass().getResourceAsStream("/Imagenes/ImgBautismoMenu.jpg"));
        ImageView imageViewBautismo = new ImageView(imgBautismo);
        imageViewBautismo.setFitWidth(200);
        imageViewBautismo.setFitHeight(200);
        Button btnBautismo = new Button();
        btnBautismo.setGraphic(imageViewBautismo);
        btnBautismo.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");

        Label bautismo = new Label("Bautismo");
        bautismo.setFont(new Font("Arial", 25));
        bautismo.setTranslateY(-30);
        bautismo.setStyle("-fx-background-color: white");
        bautismo.setMaxWidth(220);
        bautismo.setAlignment(Pos.CENTER);

        // Crear un menú contextual
        ContextMenu menuBautismo = new ContextMenu();
        MenuItem agregarBautismo = new MenuItem("Agregar Partida");
        agregarBautismo.setStyle("-fx-font-size: 18pt;");
        MenuItem buscarBautismo = new MenuItem("Buscar partida");
        buscarBautismo.setStyle("-fx-font-size: 18pt;");
        menuBautismo.getItems().addAll(agregarBautismo, buscarBautismo);

        // Asignar la acción de mostrar el menú contextual al botón
        btnBautismo.setOnAction(e -> menuBautismo.show(btnBautismo, Side.BOTTOM, 0, 0));

        agregarBautismo.setOnAction(e ->{
            GUIAgregarBautismo guiBautismoAgregar = new GUIAgregarBautismo();
            guiBautismoAgregar.start(stage);
        });

        buscarBautismo.setOnAction(e ->{
            GUIBautismoBuscar guiBuscarBautismo = new GUIBautismoBuscar();
            try {
                guiBuscarBautismo.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox vBoxBautismo = new VBox();
        vBoxBautismo.getChildren().addAll(btnBautismo,bautismo);
        vBoxBautismo.setAlignment(Pos.CENTER);


        //Boton confirmacion
        Image imgConfirmacion = new Image(getClass().getResourceAsStream("/Imagenes/ImgConfirMenu.jpg"));
        ImageView imageViewConfirmacion = new ImageView(imgConfirmacion);
        imageViewConfirmacion.setFitWidth(200);
        imageViewConfirmacion.setFitHeight(200);
        Button btnConfirmacion = new Button();
        btnConfirmacion.setGraphic(imageViewConfirmacion);
        btnConfirmacion.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");
        btnConfirmacion.setTranslateY(-3);

        Label confirmacion = new Label("Confirmación");
        confirmacion.setFont(new Font("Arial", 25));
        confirmacion.setTranslateY(-30);
        confirmacion.setStyle("-fx-background-color: white");
        confirmacion.setMaxWidth(220);
        confirmacion.setAlignment(Pos.CENTER);

        ContextMenu menuConfirmacion = new ContextMenu();
        MenuItem agregarConfirmacion = new MenuItem("Agregar Partida");
        agregarConfirmacion.setStyle("-fx-font-size: 18pt;");
        MenuItem buscarConfirmacion = new MenuItem("Buscar partida");
        buscarConfirmacion.setStyle("-fx-font-size: 18pt;");
        menuConfirmacion.getItems().addAll(agregarConfirmacion, buscarConfirmacion);

        // Asignar la acción de mostrar el menú contextual al botón
        btnConfirmacion.setOnAction(e -> menuConfirmacion.show(btnConfirmacion, Side.BOTTOM, 0, 0));
        agregarConfirmacion.setOnAction(e ->{
            GUIConfirmacionAgregar guiConfirmacionAgregar = new GUIConfirmacionAgregar();
            try {
                guiConfirmacionAgregar.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        buscarConfirmacion.setOnAction(e ->{
            GUIConfirmacionBuscar guiConfirmacionBuscar = new GUIConfirmacionBuscar();
            try {
                guiConfirmacionBuscar.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox vBoxConfirmacion = new VBox();
        vBoxConfirmacion.getChildren().addAll(btnConfirmacion,confirmacion);
        vBoxConfirmacion.setAlignment(Pos.CENTER);

        //boton matrimonio
        Image imgMatrimonio = new Image(getClass().getResourceAsStream("/Imagenes/ImgMatriMenu.jpg"));
        ImageView imageViewMatrimonio = new ImageView(imgMatrimonio);
        imageViewMatrimonio.setFitWidth(200);
        imageViewMatrimonio.setFitHeight(200);
        Button btnMatrimonio = new Button();
        btnMatrimonio.setGraphic(imageViewMatrimonio);
        btnMatrimonio.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");
        Label matrimonio = new Label("Matrimonio");
        matrimonio.setFont(new Font("Arial", 25));
        matrimonio.setTranslateY(-30);
        matrimonio.setStyle("-fx-background-color: white");
        matrimonio.setMaxWidth(220);
        matrimonio.setAlignment(Pos.CENTER);

        ContextMenu menuMatrimonio = new ContextMenu();
        MenuItem agregarMatrimonio = new MenuItem("Agregar Partida");
        agregarMatrimonio.setStyle("-fx-font-size: 18pt;");
        MenuItem buscarMatrimonio = new MenuItem("Buscar partida");
        buscarMatrimonio.setStyle("-fx-font-size: 18pt;");
        menuMatrimonio.getItems().addAll(agregarMatrimonio, buscarMatrimonio);

        // Asignar la acción de mostrar el menú contextual al botón
        btnMatrimonio.setOnAction(e -> menuMatrimonio.show(btnMatrimonio, Side.BOTTOM, 0, 0));

        agregarMatrimonio.setOnAction(e ->{
            GUIMatrimonioAgregar guiMatrimonioAgregar = new GUIMatrimonioAgregar();
            try {
                guiMatrimonioAgregar.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        buscarMatrimonio.setOnAction(e ->{
            GUIMatrimonioBuscar guiMatrimonioBuscar = new GUIMatrimonioBuscar();
            try {
                guiMatrimonioBuscar.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Manejar eventos de los elementos del menú
        agregarMatrimonio.setOnAction(e -> System.out.println("Crear una reunión para más tarde seleccionado"));
        buscarMatrimonio.setOnAction(e -> System.out.println("Iniciar una reunión ahora seleccionado"));

        VBox vBoxMatrimonio = new VBox();
        vBoxMatrimonio.getChildren().addAll(btnMatrimonio,matrimonio);
        vBoxMatrimonio.setAlignment(Pos.CENTER);

        //Boton defuncion
        Image imgDefuncion = new Image(getClass().getResourceAsStream("/Imagenes/ImgDefuncionMenu.jpg"));
        ImageView imageViewDefuncion = new ImageView(imgDefuncion);
        imageViewDefuncion.setFitWidth(200);
        imageViewDefuncion.setFitHeight(200);
        Button btnDefuncion = new Button();
        btnDefuncion.setGraphic(imageViewDefuncion);
        btnDefuncion.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");

        Label defuncion = new Label("Defunción");
        defuncion.setFont(new Font("Arial", 25));
        defuncion.setTranslateY(-30);
        defuncion.setStyle("-fx-background-color: white");
        defuncion.setMaxWidth(220);
        defuncion.setAlignment(Pos.CENTER);

        // Crear un menú contextual
        ContextMenu menuDefuncion = new ContextMenu();
        MenuItem agregarDefuncion = new MenuItem("Agregar Partida");
        agregarDefuncion.setStyle("-fx-font-size: 18pt;");
        MenuItem buscarDefuncion = new MenuItem("Buscar partida");
        buscarDefuncion.setStyle("-fx-font-size: 18pt;");
        menuDefuncion.getItems().addAll(agregarDefuncion, buscarDefuncion);

        // Asignar la acción de mostrar el menú contextual al botón
        btnDefuncion.setOnAction(e -> menuDefuncion.show(btnDefuncion, Side.BOTTOM, 0, 0));
        agregarDefuncion.setOnAction(e ->{
            GUIDefuncion guiDefuncionAgregar = new GUIDefuncion();
            try {
                guiDefuncionAgregar.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        buscarDefuncion.setOnAction(e ->{
            GUIDefuncion guiDefuncionBuscar = new GUIDefuncion();
            try {
                guiDefuncionBuscar.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Manejar eventos de los elementos del menú
        agregarDefuncion.setOnAction(e -> System.out.println("Crear una reunión para más tarde seleccionado"));
        buscarDefuncion.setOnAction(e -> System.out.println("Iniciar una reunión ahora seleccionado"));

        VBox vBoxDefuncion = new VBox();
        vBoxDefuncion.getChildren().addAll(btnDefuncion,defuncion);
        vBoxDefuncion.setAlignment(Pos.CENTER);

        //Boton sacerdotes
        Image imgSacerdotes = new Image(getClass().getResourceAsStream("/Imagenes/ImgSacerdotesMenu.jpg"));
        ImageView imageViewSacerdotes = new ImageView(imgSacerdotes);
        imageViewSacerdotes.setFitWidth(200);
        imageViewSacerdotes.setFitHeight(200);
        Button btnSacerdotes = new Button();
        btnSacerdotes.setGraphic(imageViewSacerdotes);
        btnSacerdotes.setStyle("-fx-background-color: transparent; -fx-border-color: transparent transparent #000000 transparent; -fx-border-width: 0 0 1px 0;");

        Label sacerdotes = new Label("Sacerdotes");
        sacerdotes.setFont(new Font("Arial", 25));
        sacerdotes.setTranslateY(-30);
        sacerdotes.setStyle("-fx-background-color: white");
        sacerdotes.setMaxWidth(220);
        sacerdotes.setAlignment(Pos.CENTER);

        // Crear un menú contextual
        ContextMenu menuSacerdotes = new ContextMenu();
        MenuItem agregarSacerdotes = new MenuItem("Agregar un Sacerdotes");
        agregarSacerdotes.setStyle("-fx-font-size: 18pt;");
        MenuItem buscarSacerdotes = new MenuItem("Lista de Sacerdotes");
        buscarSacerdotes.setStyle("-fx-font-size: 18pt;");
        menuSacerdotes.getItems().addAll(agregarSacerdotes, buscarSacerdotes);

        // Asignar la acción de mostrar el menú contextual al botón
        btnSacerdotes.setOnAction(e -> menuSacerdotes.show(btnSacerdotes, Side.BOTTOM, 0, 0));

        // Manejar eventos de los elementos del menú
        agregarSacerdotes.setOnAction(e -> System.out.println("Crear una reunión para más tarde seleccionado"));
        buscarSacerdotes.setOnAction(e -> System.out.println("Iniciar una reunión ahora seleccionado"));

        VBox vBoxSacerdotes = new VBox();
        vBoxSacerdotes.getChildren().addAll(btnSacerdotes,sacerdotes);
        vBoxSacerdotes.setAlignment(Pos.CENTER);


        //botones del menu
        HBox hBoxButton = new HBox(30);
        hBoxButton.getChildren().addAll(vBoxBautismo,vBoxConfirmacion,vBoxMatrimonio,vBoxDefuncion, vBoxSacerdotes);
        hBoxButton.setStyle("-fx-background-color: white");
        hBoxButton.setAlignment(Pos.CENTER);

        // Layout principal
        VBox vBox = new VBox(logo, hBoxButton);
        vBox.setAlignment(Pos.CENTER); // Centrar el VBox


        Scene scene = new Scene(vBox, 1400, 700);

        stage.setTitle("Administrador De Libros Parroquiales");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}