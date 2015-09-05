package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Nodo {
    
    protected Object dato;
    protected Nodo izquierdo;
    protected Nodo derecho;
    
    public Nodo(Object valor) {
        dato = valor;
        izquierdo = derecho = null;
    }
    
    public Nodo(Nodo ramaI, Object valor, Nodo ramaD) {
        dato = valor;
        izquierdo = ramaI;
        derecho = ramaD;
    }
    
    public Object valorNodo() {
        return dato;
    }
    
    public Nodo subArbolIzquierdo() {
        return izquierdo;
    }
    
    public Nodo subArbolDerecho() {
        return derecho;
    }
    
    public void nuevoValor(Object x) {
        dato = x;
    }
    
    public void ramaIzquierda(Nodo n) {
        izquierdo = n;
    }
    
    public void ramaDerecha(Nodo n) {
        derecho = n;
    }
    
}
