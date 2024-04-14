package co.edu.uniquindio.estructura.datos.sala.urgencias.viewController;

import co.edu.uniquindio.estructura.datos.sala.urgencias.MainUrgencias;
import co.edu.uniquindio.estructura.datos.sala.urgencias.controller.ModelFactoryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    MainUrgencias urgencias = new MainUrgencias();
    ModelFactoryController modelFactoryController = new ModelFactoryController();

    @FXML
    private Button btnCancelarLogin;

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField txfContrasenia;

    @FXML
    private TextField txfNombreUsuario;

    @FXML
    void siguienteVentana(ActionEvent event) {
        inicioSesion();
    }

    private void inicioSesion(){
        String usuario = txfNombreUsuario.getText();
        String password = txfContrasenia.getText();
        if(modelFactoryController.inicioSesion(usuario, password)){
            cerrarVentana(btnIngresar);
            urgencias.cargarVentanaRegistroPacientes();
        }else {
            mostrarMensaje("Notificación de Inicio de Sesión", "Usuario o contraseña incorrecto", "No se pudo iniciar sesión", Alert.AlertType.ERROR);
        }

    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
