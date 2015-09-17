package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Nodo_General {
    
    protected String nombre;
    protected String clave;
    protected String contraseña;
    protected String valorString;
    protected Object dato;
    protected Nodo_General izquierdo;
    protected Nodo_General derecho;
    
    public Nodo_General(Object valor, String name, String id, String password) {
        dato = valor;
        nombre = name;
        clave = id;
        contraseña = password;
        izquierdo = derecho = null;
    }
    
    public Nodo_General(Nodo_General ramaI, Object valor, Nodo_General ramaD) {
        dato = valor;
        izquierdo = ramaI;
        derecho = ramaD;
    }
    
    public void valorNodoEnString(int x) {
        valorString = String.valueOf(x);
    }
    
    public String valorNodoEnString() {
        return valorString;
    }
    
    public Object valorNodo() {
        return dato;
    }
    
    public Nodo_General subArbolIzquierdo() {
        return izquierdo;
    }
    
    public Nodo_General subArbolDerecho() {
        return derecho;
    }
    
    public void nuevoValor(Object x) {
        dato = x;
    }
    
    public void ramaIzquierda(Nodo_General n) {
        izquierdo = n;
    }
    
    public void ramaDerecha(Nodo_General n) {
        derecho = n;
    }

    public String getClave() {
        return clave;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

}
