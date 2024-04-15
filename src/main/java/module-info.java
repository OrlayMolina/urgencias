module co.edu.uniquindio.estructura.datos.sala.urgencias {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens co.edu.uniquindio.estructura.datos.sala.urgencias to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias;
    opens co.edu.uniquindio.estructura.datos.sala.urgencias.viewController to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias.viewController;
    opens co.edu.uniquindio.estructura.datos.sala.urgencias.models to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias.models;
    opens co.edu.uniquindio.estructura.datos.sala.urgencias.enumms to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias.enumms;
    opens co.edu.uniquindio.estructura.datos.sala.urgencias.utils to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias.utils;
    opens co.edu.uniquindio.estructura.datos.sala.urgencias.controller to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias.controller;
}