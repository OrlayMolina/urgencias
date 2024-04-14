package co.edu.uniquindio.estructura.datos.sala.urgencias.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PacienteViewController {

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
    private ComboBox<?> cmbDX;

    @FXML
    private ComboBox<?> cmbDiscapacidad;

    @FXML
    private ComboBox<?> cmbEmbarazo;

    @FXML
    private ComboBox<?> cmbGenero;

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

}
