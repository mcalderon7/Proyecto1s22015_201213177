package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class NodoAVL_Admin extends Nodo{
    
    int fe;
    
    public NodoAVL_Admin(Object valor, String correo, String contraseña) {
        super(valor, correo, contraseña);
        fe = 0;
    }
    
    public NodoAVL_Admin(Object valor, NodoAVL_Admin ramaI, NodoAVL_Admin ramaD) {
        super(ramaI, valor, ramaD);
        fe = 0;
    }
    
}
