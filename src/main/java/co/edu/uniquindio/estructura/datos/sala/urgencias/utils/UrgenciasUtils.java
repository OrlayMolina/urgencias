package co.edu.uniquindio.estructura.datos.sala.urgencias.utils;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Riesgo;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Diagnostico;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Enfermera;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Urgencias;

public class UrgenciasUtils {

    public static Urgencias inicializarDatos(){
        Urgencias urgencias = new Urgencias();
        Enfermera enfermera = new Enfermera();
        enfermera.setNombres("Claudia");
        enfermera.setApellidos("Chitiva");
        enfermera.setCedula("4578695");
        enfermera.setNombreUsuario("Claudia123");
        enfermera.setContrasenia("123");
        urgencias.getEnfermerasLista().add(enfermera);

        Diagnostico diagnostico1 = new Diagnostico();
        diagnostico1.setNombreDX("CEFALEA");
        diagnostico1.setRiesgo(Riesgo.BAJO);
        urgencias.getDiagnosticos().add(diagnostico1);

        Diagnostico diagnostico2 = new Diagnostico();
        diagnostico2.setNombreDX("AMPUTACION TRAUMATICA");
        diagnostico2.setRiesgo(Riesgo.ALTO);
        urgencias.getDiagnosticos().add(diagnostico2);

        Diagnostico diagnostico3 = new Diagnostico();
        diagnostico3.setNombreDX("DOLOR ABDOMINAL");
        diagnostico3.setRiesgo(Riesgo.MODERADO);
        urgencias.getDiagnosticos().add(diagnostico3);

        Diagnostico diagnostico4 = new Diagnostico();
        diagnostico4.setNombreDX("PARO CARDIORESPIRATOTIO");
        diagnostico4.setRiesgo(Riesgo.ALTO);
        urgencias.getDiagnosticos().add(diagnostico4);

        Diagnostico diagnostico5 = new Diagnostico();
        diagnostico5.setNombreDX("DIARREA");
        diagnostico5.setRiesgo(Riesgo.BAJO);
        urgencias.getDiagnosticos().add(diagnostico5);

        return urgencias;
    }
}
