package mvc.modelo.dominio;

import java.util.Date;

public class Vuelo {
    //numero de vuelo
    Integer cantidadDeAsientos;
    Aeropuerto aeropuertoDeSalida;
    Aeropuerto aeropuertoDeLlegada;
    Date dateSalida; //fecha y hora de salida
    Date dateLlegada; //fecha y hora de llegada
    String tiempo; //tiempo de vuelo
}
