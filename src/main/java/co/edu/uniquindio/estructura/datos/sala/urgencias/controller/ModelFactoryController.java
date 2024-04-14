package co.edu.uniquindio.estructura.datos.sala.urgencias.controller;

import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Diagnostico;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Urgencias;
import co.edu.uniquindio.estructura.datos.sala.urgencias.utils.UrgenciasUtils;

import java.util.List;

public class ModelFactoryController {

    Urgencias urgencias;


    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {
        if(urgencias == null){
            cargarDatosBase();
        }
    }

    public Urgencias getUrgencias() {
        return urgencias;
    }

    public boolean inicioSesion(String usuario, String password) {
        return getUrgencias().inicioSesion(usuario, password);
    }

    public List<Diagnostico> obtenerDiagnosticos() {
        return  urgencias.getDiagnosticos();
    }

    private void cargarDatosBase() {
        urgencias = UrgenciasUtils.inicializarDatos();
    }
}
