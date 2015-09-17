package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Nodo_Clave {
    
    protected String nombre;
    protected String clave;
    protected String contraseña;
    protected String valorString;
    protected Object dato;
    protected Nodo_Clave izquierdo;
    protected Nodo_Clave derecho;
    
    public Nodo_Clave(Object valor, String name, String id, String password) {
        dato = valor;
        nombre = name;
        clave = id;
        contraseña = password;
        izquierdo = derecho = null;
    }
    
    public Nodo_Clave(Nodo_Clave ramaI, Object valor, Nodo_Clave ramaD) {
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
    
    public Nodo_Clave subArbolIzquierdo() {
        return izquierdo;
    }
    
    public Nodo_Clave subArbolDerecho() {
        return derecho;
    }
    
    public void nuevoValor(Object x) {
        dato = x;
    }
    
    public void ramaIzquierda(Nodo_Clave n) {
        izquierdo = n;
    }
    
    public void ramaDerecha(Nodo_Clave n) {
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
