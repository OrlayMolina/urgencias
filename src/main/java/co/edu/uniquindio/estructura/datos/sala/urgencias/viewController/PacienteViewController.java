package co.edu.uniquindio.estructura.datos.sala.urgencias.viewController;

import co.edu.uniquindio.estructura.datos.sala.urgencias.MainUrgencias;
import co.edu.uniquindio.estructura.datos.sala.urgencias.controller.ModelFactoryController;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Genero;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Opcion;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Diagnostico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class PacienteViewController {

    MainUrgencias urgencias;
    ModelFactoryController controller;
    ObservableList<Genero> listaGeneros = FXCollections.observableArrayList();
    ObservableList<Opcion> listaOpciones = FXCollections.observableArrayList();
    ObservableList<Diagnostico> listaDiagnosticos = FXCollections.observableArrayList();
    String foto;

    @FXML
    private ImageView ImgFoto;

    @FXML
    private Button btnEditarDatos;

    @FXML
    private Button btnElegirFoto;

    @FXML
    private Button btnIngresarPaciente;

    @FXML
    private Button btnSalirSistema;

    @FXML
    private ComboBox<Diagnostico> cmbDX;

    @FXML
    private ComboBox<Opcion> cmbDiscapacidad;

    @FXML
    private ComboBox<Opcion> cmbEmbarazo;

    @FXML
    private ComboBox<Genero> cmbGenero;

    @FXML
    private TableColumn<?, ?> colApellidoAmarillo;

    @FXML
    private TableColumn<?, ?> colApellidosNaranja;

    @FXML
    private TableColumn<?, ?> colApellidosRojo;

    @FXML
    private TableColumn<?, ?> colDXAmarillo;

    @FXML
    private TableColumn<?, ?> colDXNaranja;

    @FXML
    private TableColumn<?, ?> colDXRojo;

    @FXML
    private TableColumn<?, ?> colDiscapacidadAmarillo;

    @FXML
    private TableColumn<?, ?> colDiscapacidadNaranja;

    @FXML
    private TableColumn<?, ?> colDiscapacidadRojo;

    @FXML
    private TableColumn<?, ?> colDocumentoAmarillo;

    @FXML
    private TableColumn<?, ?> colDocumentoNaranja;

    @FXML
    private TableColumn<?, ?> colDocumentoRojo;

    @FXML
    private TableColumn<?, ?> colEdadAmarillo;

    @FXML
    private TableColumn<?, ?> colEdadNaranja;

    @FXML
    private TableColumn<?, ?> colEdadRojo;

    @FXML
    private TableColumn<?, ?> colEmbarazoAmarrillo;

    @FXML
    private TableColumn<?, ?> colEmbarazoNaranja;

    @FXML
    private TableColumn<?, ?> colEmbarazoRojo;

    @FXML
    private TableColumn<?, ?> colGeneroAmarillo;

    @FXML
    private TableColumn<?, ?> colGeneroNaranja;

    @FXML
    private TableColumn<?, ?> colGeneroRojo;

    @FXML
    private TableColumn<?, ?> colNombresAmarillo;

    @FXML
    private TableColumn<?, ?> colNombresNaranja;

    @FXML
    private TableColumn<?, ?> colNombresRojo;

    @FXML
    private TableView<?> tblPrioridadAmarillo;

    @FXML
    private TableView<?> tblPrioridadNaranja;

    @FXML
    private TableView<?> tblPrioridadRojo;

    @FXML
    private TextField txfApellidos;

    @FXML
    private TextField txfDocumento;

    @FXML
    private TextField txfEdad;

    @FXML
    private TextField txfFrecuenciaCardiaca;

    @FXML
    private TextField txfFrecuenciaRespiratoria;

    @FXML
    private TextField txfNombres;

    @FXML
    private TextField txfTemperatura;

    @FXML
    private TextField txfTensionArterial;

    @FXML
    void volverLogin(ActionEvent event) {
        cerrarPrograma();
    }

    @FXML
    void seleccionarImagen(ActionEvent event) {
        seleccionarImagen();
    }

    @FXML
    void initialize() {
        urgencias = new MainUrgencias();
        controller = new ModelFactoryController();
        initView();
    }

    private void initView() {
        mostrarGenero();
        mostrarOpciones();
        getListaDiagnosticos();
        mostrarDiagnosticos();
    }

    private void seleccionarImagen(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Abrir Archivo");
        File file = chooser.showOpenDialog(new Stage());

        if (file != null) { // Verificar si se seleccionó un archivo
            String rutaOrigen = file.getPath();
            String rutaDestino = "src/main/resources/co/edu/uniquindio/estructura/datos/sala/urgencias/img/" + file.getName();

            try (InputStream inputStream = new FileInputStream(rutaOrigen);
                 OutputStream outputStream = new FileOutputStream(rutaDestino)) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }

                mostrarImagen(rutaDestino);
                foto = rutaDestino;
                System.out.println("Archivo copiado con éxito!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    private void mostrarImagen(String rutaImagen) {
        try {
            File file = new File(rutaImagen);
            if (file.exists()) {
                Image image = new Image(file.toURI().toString());

                ImgFoto.setImage(image);
            } else {
                System.out.println("La imagen no existe en la ruta especificada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarGenero(){
        listaGeneros.add(Genero.FEMENINO);
        listaGeneros.add(Genero.MASCULINO);
        cmbGenero.setItems(listaGeneros);
    }

    public void mostrarOpciones(){
        listaOpciones.add(Opcion.NO);
        listaOpciones.add(Opcion.SI);
        cmbDiscapacidad.setItems(listaOpciones);
        cmbEmbarazo.setItems(listaOpciones);
    }

    public void mostrarDiagnosticos(){
        cmbDX.setItems(listaDiagnosticos);
    }

    public ObservableList<Diagnostico> getListaDiagnosticos() {
        listaDiagnosticos.addAll(controller.obtenerDiagnosticos());
        return listaDiagnosticos;
    }

    private void cerrarPrograma(){
        cerrarVentana(btnSalirSistema);
        urgencias.cargarPantallaLogin();
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
