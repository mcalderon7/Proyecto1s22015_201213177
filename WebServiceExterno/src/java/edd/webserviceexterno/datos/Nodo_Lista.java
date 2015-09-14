package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Nodo_Lista {
    
    int clave;
    String id_bus;
    Nodo_Lista anterior;
    Nodo_Lista siguiente;
    
    public Nodo_Lista(int clave_entrada, String id_entrada) {
        clave = clave_entrada;
        id_bus = id_entrada;
        anterior = siguiente = null;
    }
    
}
