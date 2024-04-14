module co.edu.uniquindio.estructura.datos.sala.urgencias {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.estructura.datos.sala.urgencias to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias;
    opens co.edu.uniquindio.estructura.datos.sala.urgencias.viewController to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias.viewController;
    opens co.edu.uniquindio.estructura.datos.sala.urgencias.models to javafx.fxml;
    exports co.edu.uniquindio.estructura.datos.sala.urgencias.models;
}