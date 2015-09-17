package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Nodo_Chofer {
    
    protected String nombre;
    protected String apellido;
    protected String clave;
    protected String contraseña;
    protected String valorString;
    protected Object dato;
    protected Nodo_Chofer izquierdo;
    protected Nodo_Chofer derecho;
    
    public Nodo_Chofer(Object valor, String name, String lastName, String id, String password) {
        dato = valor;
        nombre = name;
        apellido = lastName;
        clave = id;
        contraseña = password;
        izquierdo = derecho = null;
    }
    
    public Nodo_Chofer(Nodo_Chofer ramaI, Object valor, Nodo_Chofer ramaD) {
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
    
    public Nodo_Chofer subArbolIzquierdo() {
        return izquierdo;
    }
    
    public Nodo_Chofer subArbolDerecho() {
        return derecho;
    }
    
    public void nuevoValor(Object x) {
        dato = x;
    }
    
    public void ramaIzquierda(Nodo_Chofer n) {
        izquierdo = n;
    }
    
    public void ramaDerecha(Nodo_Chofer n) {
        derecho = n;
    }

    public String getClave() {
        return clave;
    }

    public String getContraseña() {
        return contraseña;
    }

}
