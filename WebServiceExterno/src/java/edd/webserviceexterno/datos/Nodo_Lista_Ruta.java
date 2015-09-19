package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Nodo_Lista_Ruta {
    
    int clave;
    String ruta;
    String estaciones;
    Nodo_Lista_Ruta anterior;
    Nodo_Lista_Ruta siguiente;
    
    public Nodo_Lista_Ruta(int clave_entrada, String nombre_ruta, String entrada_estaciones) {
        clave = clave_entrada;
        ruta = nombre_ruta;
        estaciones = entrada_estaciones;
        anterior = siguiente = null;
    }
    
}
