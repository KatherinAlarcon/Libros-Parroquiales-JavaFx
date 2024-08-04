module co.edu.uptcsoft.librosparroquialesjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;

    opens co.edu.uptcsoft.librosparroquialesjavafx.Interfaz to javafx.fxml;
    exports co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;
    opens co.edu.uptcsoft.librosparroquialesjavafx.Modelo to javafx.fxml, com.google.gson;
    opens co.edu.uptcsoft.librosparroquialesjavafx.Control to javafx.fxml, com.google.gson;
    opens co.edu.uptcsoft.librosparroquialesjavafx.Persistencia to javafx.fxml, com.google.gson;
}
