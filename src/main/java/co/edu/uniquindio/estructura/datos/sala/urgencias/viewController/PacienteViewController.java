package co.edu.uniquindio.estructura.datos.sala.urgencias.viewController;

import co.edu.uniquindio.estructura.datos.sala.urgencias.MainUrgencias;
import co.edu.uniquindio.estructura.datos.sala.urgencias.controller.ModelFactoryController;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Genero;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Opcion;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Diagnostico;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Paciente;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Urgencias;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PacienteViewController {

    MainUrgencias urgenciasVentanas;
    Urgencias urgencias;
    ModelFactoryController controller;
    ObservableList<Genero> listaGeneros = FXCollections.observableArrayList();
    ObservableList<Opcion> listaOpciones = FXCollections.observableArrayList();
    ObservableList<Diagnostico> listaDiagnosticos = FXCollections.observableArrayList();

    ObservableList<Paciente> listaBajaPrioridad = FXCollections.observableArrayList();
    ObservableList<Paciente> listaPrioridadModerada = FXCollections.observableArrayList();
    ObservableList<Paciente> listaAltaPrioridad = FXCollections.observableArrayList();
    private Thread hiloActual;
    Paciente pacienteSeleccionado;
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
    private Button btnMasOpciones;

    @FXML
    private ComboBox<Diagnostico> cmbDX;

    @FXML
    private ComboBox<Opcion> cmbDiscapacidad;

    @FXML
    private ComboBox<Opcion> cmbEmbarazo;

    @FXML
    private ComboBox<Genero> cmbGenero;

    @FXML
    private TableColumn<Paciente, String> colApellidoAmarillo;

    @FXML
    private TableColumn<Paciente, String> colApellidosNaranja;

    @FXML
    private TableColumn<Paciente, String> colApellidosRojo;

    @FXML
    private TableColumn<Paciente, String> colDXAmarillo;

    @FXML
    private TableColumn<Paciente, String> colDXNaranja;

    @FXML
    private TableColumn<Paciente, String> colDXRojo;

    @FXML
    private TableColumn<Paciente, String> colDiscapacidadAmarillo;

    @FXML
    private TableColumn<Paciente, String> colDiscapacidadNaranja;

    @FXML
    private TableColumn<Paciente, String> colDiscapacidadRojo;

    @FXML
    private TableColumn<Paciente, String> colDocumentoAmarillo;

    @FXML
    private TableColumn<Paciente, String> colDocumentoNaranja;

    @FXML
    private TableColumn<Paciente, String> colDocumentoRojo;

    @FXML
    private TableColumn<Paciente, Integer> colEdadAmarillo;

    @FXML
    private TableColumn<Paciente, Integer> colEdadNaranja;

    @FXML
    private TableColumn<Paciente, Integer> colEdadRojo;

    @FXML
    private TableColumn<Paciente, String> colEmbarazoAmarrillo;

    @FXML
    private TableColumn<Paciente, String> colEmbarazoNaranja;

    @FXML
    private TableColumn<Paciente, String> colEmbarazoRojo;

    @FXML
    private TableColumn<Paciente, String> colGeneroAmarillo;

    @FXML
    private TableColumn<Paciente, String> colGeneroNaranja;

    @FXML
    private TableColumn<Paciente, String> colGeneroRojo;

    @FXML
    private TableColumn<Paciente, String> colNombresAmarillo;

    @FXML
    private TableColumn<Paciente, String> colNombresNaranja;

    @FXML
    private TableColumn<Paciente, String> colNombresRojo;

    @FXML
    private TableView<Paciente> tblPrioridadAmarillo;

    @FXML
    private TableView<Paciente> tblPrioridadNaranja;

    @FXML
    private TableView<Paciente> tblPrioridadRojo;

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
    private Label txfTiempoRestante;

    @FXML
    void opcionesAvanzadas(ActionEvent event) {
        cancelarBusqueda();
    }

    @FXML
    void volverLogin(ActionEvent event) {
        cerrarPrograma();
    }

    @FXML
    void editarDatos(ActionEvent event) {
        actualizarPaciente();
    }

    @FXML
    void seleccionarImagen(ActionEvent event) {
        seleccionarImagen();
    }

    @FXML
    void crearPacienteEnSala(ActionEvent event) {
        crearPaciente();
    }

    @FXML
    void initialize() {
        urgenciasVentanas = new MainUrgencias();
        urgencias = new Urgencias();
        controller = new ModelFactoryController();
        initView();
    }

    private void initView() {
        initDataBindingAmarillo();
        initDataBindingNaranja();
        initDataBindingRojo();
        obtenerPacientesBajaPrioridad();
        obtenerPacientesPrioridadModerada();
        obtenerPacientesAltaPrioridad();
        mostrarGenero();
        mostrarOpciones();
        getListaDiagnosticos();
        mostrarDiagnosticos();
        tblPrioridadAmarillo.getItems().clear();
        tblPrioridadAmarillo.setItems(listaBajaPrioridad);
        tblPrioridadNaranja.getItems().clear();
        tblPrioridadNaranja.setItems(listaPrioridadModerada);
        tblPrioridadRojo.getItems().clear();
        tblPrioridadRojo.setItems(listaAltaPrioridad);
        listenerSelectionAmarillo();
        listenerSelectionNaranja();
        listenerSelectionRojo();
    }

    private void initDataBindingAmarillo() {
        colDocumentoAmarillo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
        colNombresAmarillo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombres()));
        colApellidoAmarillo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        colGeneroAmarillo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero().toString()));
        colDiscapacidadAmarillo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiscapacidad().toString()));
        colEmbarazoAmarrillo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmbarazada().toString()));
        colDXAmarillo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiagnostico().toString()));

    }

    private void listenerSelectionAmarillo() {
        tblPrioridadAmarillo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            pacienteSeleccionado = newSelection;
            mostrarInformacionPaciente(pacienteSeleccionado);
        });
    }

    private void initDataBindingNaranja() {
        colDocumentoNaranja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
        colNombresNaranja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombres()));
        colApellidosNaranja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        colGeneroNaranja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero().toString()));
        colDiscapacidadNaranja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiscapacidad().toString()));
        colEmbarazoNaranja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmbarazada().toString()));
        colDXNaranja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiagnostico().toString()));

    }

    private void listenerSelectionNaranja() {
        tblPrioridadNaranja.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            pacienteSeleccionado = newSelection;
            mostrarInformacionPaciente(pacienteSeleccionado);
        });
    }

    private void initDataBindingRojo() {
        colDocumentoRojo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
        colNombresRojo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombres()));
        colApellidosRojo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        colGeneroRojo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero().toString()));
        colDiscapacidadRojo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiscapacidad().toString()));
        colEmbarazoRojo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmbarazada().toString()));
        colDXRojo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiagnostico().toString()));

    }

    private void listenerSelectionRojo() {
        tblPrioridadRojo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            pacienteSeleccionado = newSelection;
            mostrarInformacionPaciente(pacienteSeleccionado);
        });
    }

    private void mostrarInformacionPaciente(Paciente pacienteSeleccionado) {
        if(pacienteSeleccionado != null){
            txfDocumento.setText(pacienteSeleccionado.getDocumento());
            txfNombres.setText(pacienteSeleccionado.getNombres());
            txfApellidos.setText(pacienteSeleccionado.getApellidos());
            txfEdad.setText(String.valueOf(pacienteSeleccionado.getEdad()));
            cmbGenero.setValue(pacienteSeleccionado.getGenero());
            cmbDiscapacidad.setValue(pacienteSeleccionado.getDiscapacidad());
            cmbEmbarazo.setValue(pacienteSeleccionado.getEmbarazada());
            txfTemperatura.setText(pacienteSeleccionado.getTemperatura());
            txfTensionArterial.setText(pacienteSeleccionado.getTensionArterial());
            txfFrecuenciaRespiratoria.setText(pacienteSeleccionado.getFrecuenciaRespiratoria());
            txfFrecuenciaCardiaca.setText(pacienteSeleccionado.getFrecuenciaCardiaca());
            cmbDX.setValue(pacienteSeleccionado.getDiagnostico());

            String rutaImagen = pacienteSeleccionado.getFoto();
            if (rutaImagen != null && !rutaImagen.isEmpty()) {
                File file = new File(rutaImagen);
                if (file.exists()) {
                    Image image = new Image(file.toURI().toString());
                    ImgFoto.setImage(image);
                } else {
                    System.out.println("La imagen no existe en la ruta especificada.");
                }
            } else {
                System.out.println("La ruta de la imagen está vacía o es nula.");
            }

            actualizarTiempoRestante(pacienteSeleccionado.getHoraLlegada(), pacienteSeleccionado);
        }

    }

    public void cancelarBusqueda(){
        limpiarCamposPacientes();
        tblPrioridadAmarillo.getSelectionModel().clearSelection();
        tblPrioridadNaranja.getSelectionModel().clearSelection();
        tblPrioridadRojo.getSelectionModel().clearSelection();

        if (hiloActual != null && hiloActual.isAlive()) {
            hiloActual.interrupt(); // Detener el hilo de conteo regresivo si está en ejecución
        }

        txfTiempoRestante.setText("00:00:00");
        limpiarCamposPacientes();
        listenerSelectionAmarillo();
        listenerSelectionNaranja();
        listenerSelectionRojo();
    }

    private void crearPaciente() {
        Paciente paciente = construirPaciente();
        if(datosValidos(paciente)){
            if(controller.agregarPaciente(paciente)){
                if(paciente.determinarPrioridad() == 1){
                    listaBajaPrioridad.add(paciente);
                }else if(paciente.determinarPrioridad() == 2){
                    listaPrioridadModerada.add(paciente);
                }else if(paciente.determinarPrioridad() == 3) {
                    listaAltaPrioridad.add(paciente);
                }
                limpiarCamposPacientes();
                registrarAcciones("Paciente creado",1, "Paciente creado por el usuario "+urgencias.getUsuarioLogueado());
                mostrarMensaje("Notificación paciente", "Paciente creado", "El Paciente creado correctamente", Alert.AlertType.INFORMATION);
            }else{
                registrarAcciones("No fue posible crear al paciente",1, "Paciente no fue creado, intento realizado por "+urgencias.getUsuarioLogueado());
                mostrarMensaje("Notificación paciente", "Paciente no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación paciente", "Paciente no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void actualizarPaciente(){
        Paciente paciente = construirPaciente();
        if(datosValidos(paciente)){
            if(controller.actualizarPaciente(paciente)){
                registrarAcciones("Paciente actualizado",1, "Paciente actualizado por el usuario"+urgencias.getUsuarioLogueado() );
                mostrarMensaje("Notificación paciente", "Paciente actualizado", "El Paciente actualizado correctamente", Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje("Notificación paciente", "Paciente no actualizado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación paciente", "Paciente no actualizado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private boolean datosValidos(Paciente paciente) {
        String mensaje = "";
        if(paciente.getNombres() == null || paciente.getNombres().equals(""))
            mensaje += "El nombre del Paciente es invalido \n" ;
        if(paciente.getApellidos() == null || paciente.getApellidos() .equals(""))
            mensaje += "El apellido del Paciente es invalido \n" ;
        if(paciente.getDocumento() == null || paciente.getDocumento() .equals(""))
            mensaje += "El documento del Paciente es invalido \n" ;
        if(paciente.getEdad() == 0)
            mensaje += "La edad del Paciente es invalido \n" ;
        if(paciente.getGenero() == null)
            mensaje += "El genero del Paciente es invalido \n" ;
        if(paciente.getDiscapacidad() == null)
            mensaje += "La discapacidad del Paciente es invalido \n" ;
        if(paciente.getEmbarazada() == null)
            mensaje += "El embarazo del Paciente es invalido \n" ;
        if(paciente.getTemperatura() == null || paciente.getTemperatura() .equals(""))
            mensaje += "La temperatura es invalido \n" ;
        if(paciente.getTensionArterial() == null || paciente.getTensionArterial() .equals(""))
            mensaje += "La tensión arterial es invalido \n" ;
        if(paciente.getFrecuenciaCardiaca() == null || paciente.getFrecuenciaCardiaca().equals(""))
            mensaje += "La frecuencia cárdiaca es invalida \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación producto", "Producto no creado", mensaje, Alert.AlertType.ERROR);
            return false;
        }
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

    private void actualizarTiempoRestante(String horaLlegada, Paciente pacienteSeleccionado) {
        if (hiloActual != null && hiloActual.isAlive()) {
            hiloActual.interrupt(); // Detener el hilo actual si está en ejecución
        }

        LocalDateTime horaInicio = LocalDateTime.parse(horaLlegada); // Convertir la hora de llegada a LocalDateTime

        Thread nuevoHilo = new Thread(() -> {
            boolean tiempoCumplido = false;

            while (!tiempoCumplido) {
                LocalDateTime horaActual = LocalDateTime.now(); // Obtener la fecha y hora actual

                long segundosRestantes;
                int prioridad = pacienteSeleccionado.determinarPrioridad();

                switch (prioridad) {
                    case 1:
                        segundosRestantes = 4 * 3600; // 4 horas en segundos
                        break;
                    case 2:
                        segundosRestantes = 30 * 60; // 30 minutos en segundos
                        break;
                    case 3:
                    default:
                        segundosRestantes = 0; // Atender inmediatamente
                        break;
                }

                long segundosTranscurridos = ChronoUnit.SECONDS.between(horaInicio, horaActual);
                segundosRestantes -= segundosTranscurridos;

                if (segundosRestantes <= 0) {
                    tiempoCumplido = true;
                    Platform.runLater(() -> txfTiempoRestante.setText("ATENDER!!"));
                } else {
                    long horas = segundosRestantes / 3600;
                    long minutos = (segundosRestantes % 3600) / 60;
                    long segundos = segundosRestantes % 60;

                    String textoTiempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
                    Platform.runLater(() -> txfTiempoRestante.setText(textoTiempo));
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Manejar la interrupción del hilo
                    return;
                }
            }
        });

        hiloActual = nuevoHilo; // Asignar el nuevo hilo como hilo actual
        nuevoHilo.start(); // Iniciar el hilo para el nuevo anuncio
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

    private Paciente construirPaciente() {

        return new Paciente(
                txfNombres.getText(),
                txfApellidos.getText(),
                txfDocumento.getText(),
                foto,
                Integer.parseInt(txfEdad.getText()),
                String.valueOf(LocalDateTime.now()),
                cmbGenero.getValue(),
                cmbDiscapacidad.getValue(),
                cmbEmbarazo.getValue(),
                txfTemperatura.getText(),
                txfTensionArterial.getText(),
                txfFrecuenciaRespiratoria.getText(),
                txfFrecuenciaCardiaca.getText(),
                cmbDX.getValue()
        );
    }

    private void limpiarCamposPacientes() {
        txfNombres.setText("");
        txfApellidos.setText("");
        txfDocumento.setText("");
        ImgFoto.setImage(null);
        txfEdad.setText("");
        cmbGenero.setValue(null);
        cmbDiscapacidad.setValue(null);
        cmbEmbarazo.setValue(null);
        txfTemperatura.setText("");
        txfTensionArterial.setText("");
        txfFrecuenciaRespiratoria.setText("");
        txfFrecuenciaCardiaca.setText("");
        cmbDX.setValue(null);

    }

    public ObservableList<Diagnostico> getListaDiagnosticos() {
        listaDiagnosticos.addAll(controller.obtenerDiagnosticos());
        return listaDiagnosticos;
    }

    private void obtenerPacientesBajaPrioridad() {
        listaBajaPrioridad.addAll(controller.obtenerPacientesBajaPrioridad());
    }

    private void obtenerPacientesPrioridadModerada() {
        listaPrioridadModerada.addAll(controller.obtenerPacientesPrioridadModerada());
    }

    private void obtenerPacientesAltaPrioridad() {
        listaAltaPrioridad.addAll(controller.obtenerPacientesAltaPrioridad());
    }

    private void registrarAcciones(String mensaje, int nivel, String accion) {
        controller.registrarAccionesSistema(mensaje, nivel, accion);
    }

    private void cerrarPrograma(){
        cerrarVentana(btnSalirSistema);
        urgenciasVentanas.cargarPantallaLogin();
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
