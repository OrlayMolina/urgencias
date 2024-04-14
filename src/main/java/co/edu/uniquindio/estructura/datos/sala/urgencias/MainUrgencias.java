package co.edu.uniquindio.estructura.datos.sala.urgencias;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}