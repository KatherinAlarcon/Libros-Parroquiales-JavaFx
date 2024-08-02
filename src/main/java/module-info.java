module co.edu.uptcsoft.librosparroquialesjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uptcsoft.librosparroquialesjavafx.Interfaz to javafx.fxml;
    exports co.edu.uptcsoft.librosparroquialesjavafx.Interfaz;
}
