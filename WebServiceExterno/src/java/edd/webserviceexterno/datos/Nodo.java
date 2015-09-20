package edd.webserviceexterno.datos;

/**
 *
 * @author Marvin
 */
public class Nodo {
    
    protected int key;
    protected String correo;
    protected String contraseña;
    protected String valorString;
    protected Object dato;
    protected Nodo izquierdo;
    protected Nodo derecho;
    
    /*Administrador*/
    public Nodo(Object valor, String mail, String password) {
        dato = valor;
        correo = mail;
        contraseña = password;
        izquierdo = derecho = null;
    }
    
    public Nodo(Nodo ramaI, Object valor, Nodo ramaD) {
        dato = valor;
        izquierdo = ramaI;
        derecho = ramaD;
    }
    
    public void valorNodoEnString(int x) {
        valorString = String.valueOf(x);
    }
    
    public void valorNodoEnInt(int x) {
        key = x;
    }
    
    public String valorNodoEnString() {
        return valorString;
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

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
    
}
