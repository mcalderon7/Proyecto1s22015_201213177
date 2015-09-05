package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Arbol {
    
    protected Nodo raiz;
    
    public Arbol() {
        raiz = null;
    }
    
    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public Nodo raizArbol() {
        return raiz;
    }
    
    boolean esVacio() {
        return raiz == null;
    }
    
    public static Nodo nuevoArbol(Nodo ramaI, Object dato, Nodo ramaD) {
        return new Nodo(ramaI, dato, ramaD);
    }
    
}
