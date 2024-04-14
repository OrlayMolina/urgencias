package co.edu.uniquindio.estructura.datos.sala.urgencias;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainUrgencias extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainUrgencias.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        String rutaRelativa = "/co/edu/uniquindio/estructura/datos/sala/urgencias/img/logo.JPG";
        Image iconImage = new Image(Objects.requireNonNull(getClass().getResource(rutaRelativa)).toExternalForm());
        stage.getIcons().add(iconImage);
        stage.setTitle("Ingresa con tus datos de usuario");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void cargarVentanaRegistroPacientes() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainUrgencias.class.getResource("registro-pacientes-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            String rutaRelativa = "/co/edu/uniquindio/estructura/datos/sala/urgencias/img/logo.JPG";
            Image iconImage = new Image(Objects.requireNonNull(getClass().getResource(rutaRelativa)).toExternalForm());
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Registro de Pacientes a Sala de Urgencias");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}