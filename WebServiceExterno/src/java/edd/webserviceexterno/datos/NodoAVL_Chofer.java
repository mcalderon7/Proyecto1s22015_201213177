package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class NodoAVL_Chofer extends Nodo{
    
    int fe;
    
    public NodoAVL_Chofer(Object valor) {
        super(valor);
        fe = 0;
    }
    
    public NodoAVL_Chofer(Object valor, NodoAVL_Chofer ramaI, NodoAVL_Chofer ramaD) {
        super(ramaI, valor, ramaD);
        fe = 0;
    }
    
}
