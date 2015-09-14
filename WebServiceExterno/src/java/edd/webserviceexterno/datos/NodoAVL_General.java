package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class NodoAVL_General extends Nodo{
    
    int fe;
    
    public NodoAVL_General(Object valor) {
        super(valor);
        fe = 0;
    }
    
    public NodoAVL_General(Object valor, NodoAVL_General ramaI, NodoAVL_General ramaD) {
        super(ramaI, valor, ramaD);
        fe = 0;
    }
    
}
