package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class NodoAVL_Clave extends Nodo_Clave{
    
    int fe;
    
    public NodoAVL_Clave(Object valor, String nombre, String clave, String contraseña) {
        super(valor, nombre, clave, contraseña);
        fe = 0;
    }
    
    public NodoAVL_Clave(Object valor, NodoAVL_Clave ramaI, NodoAVL_Clave ramaD) {
        super(ramaI, valor, ramaD);
        fe = 0;
    }
    
}
