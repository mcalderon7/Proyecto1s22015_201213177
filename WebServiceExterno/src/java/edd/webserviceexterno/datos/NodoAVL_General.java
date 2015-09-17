package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class NodoAVL_General extends Nodo_General {
    
    int fe;
    
    public NodoAVL_General(Object valor, String nombre, String clave, String contraseña) {
        super(valor, nombre, clave, contraseña);
        fe = 0;
    }
    
    public NodoAVL_General(Object valor, NodoAVL_General ramaI, NodoAVL_General ramaD) {
        super(ramaI, valor, ramaD);
        fe = 0;
    }
    
}
