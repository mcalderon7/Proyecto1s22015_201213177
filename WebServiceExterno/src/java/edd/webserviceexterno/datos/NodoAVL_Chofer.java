package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class NodoAVL_Chofer extends Nodo_Chofer{
    
    int fe;
    
    public NodoAVL_Chofer(Object valor, String nombre, String apellido, String clave, String contraseña) {
        super(valor, nombre, apellido, clave, contraseña);
        fe = 0;
    }
    
    public NodoAVL_Chofer(Object valor, NodoAVL_Chofer ramaI, NodoAVL_Chofer ramaD) {
        super(ramaI, valor, ramaD);
        fe = 0;
    }
    
}
