package edd.webserviceexterno.datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Marvin
 */
public class ArbolAVL_General {
    
    static Boolean flag = false;
    static Stack<String> pila;
    static String codigoGraph = "";
    static String enlaceGraph = "";
    static int idNodo = 0;
    NodoAVL_General raiz;
    
    public ArbolAVL_General() {
        raiz = null;
        codigoGraph += "digraph G{" + System.getProperty("line.separator");
        codigoGraph += "rankdir=TB;" + System.getProperty("line.separator");
        codigoGraph += "node [shape = record, style=filled, fillcolor=seashell2];" + System.getProperty("line.separator");
        pila = new Stack();
    }
    
    public NodoAVL_General raizArbol() {
        return raiz;
    }
    
    /*Método de rotación Izquierda Izquierda*/
    private NodoAVL_General rotacionII(NodoAVL_General n, NodoAVL_General n1) {
        n.ramaIzquierda(n1.subArbolDerecho());
        n1.ramaDerecha(n);
        
        /*Actualización de los factores de equilibrio*/
        if(n1.fe == -1) {
            n.fe = 0;
            n1.fe = 0;
        }else {
            n.fe = -1;
            n1.fe = 1;
        }
        
        return n1;
    }
    
    private NodoAVL_General rotacionDD(NodoAVL_General n, NodoAVL_General n1) {
        n.ramaDerecha(n1.subArbolIzquierdo());
        n1.ramaIzquierda(n);
        
        /*Actualización de los factores de equilibrio*/
        if(n1.fe == +1) {
            n.fe = 0;
            n1.fe = 0;
        }else {
            n.fe = +1;
            n1.fe = -1;
        }
        
        return n1;
    }
    
    private NodoAVL_General rotacionID(NodoAVL_General n, NodoAVL_General n1) {
        NodoAVL_General n2;
        
        n2 = (NodoAVL_General) n1.subArbolDerecho();
        n.ramaIzquierda(n2.subArbolDerecho());
        n2.ramaDerecha(n);
        n1.ramaDerecha(n2.subArbolIzquierdo());
        n2.ramaIzquierda(n1);
        
        /*Actualización de los factores de equilibrio*/
        if(n2.fe == +1) {
            n1.fe = -1;
        }else {
            n1.fe = 0;
        }
        
        if(n2.fe == -1) {
            n.fe = 1;
        }else {
            n.fe = 0;
        }
        
        n2.fe = 0;
        
        return n2;
    }
    
    private NodoAVL_General rotacionDI(NodoAVL_General n, NodoAVL_General n1) {
        NodoAVL_General n2;
        
        n2 = (NodoAVL_General)n1.subArbolIzquierdo();
        
        n.ramaDerecha(n2.subArbolIzquierdo());
        n2.ramaIzquierda(n);
        n1.ramaIzquierda(n2.subArbolDerecho());
        n2.ramaDerecha(n1);
        
        /*Actualización de los factores de equilibrio*/
        if(n2.fe == +1) {
            n.fe = -1;
        }else {
            n.fe = 0;
        }
        
        if(n.fe == -1) {
            n1.fe = 1;
        }else {
            n1.fe = 0;
        }
        
        n2.fe = 0;
        
        return n2;
    }
    
    private NodoAVL_General insertarAVL(NodoAVL_General raiz, Comparador dt, Logical h, int x, String nombre, String clave, String contraseña) {
        NodoAVL_General n1;
        
        if(raiz == null) {
            raiz = new NodoAVL_General(dt, nombre, clave, contraseña);
            raiz.valorNodoEnString(x);
            h.setLogical(true);
        }else if(dt.menorQue(raiz.valorNodo())) {
            NodoAVL_General izq;
            izq = insertarAVL((NodoAVL_General) raiz.subArbolIzquierdo(), dt, h, x, nombre, clave, contraseña);
            raiz.ramaIzquierda(izq);
            
            /*Regreso por los nodos del camino de busqueda*/
            if(h.booleanValue()) {
                switch (raiz.fe) {
                    case 1:
                        raiz.fe = 0;
                        h.setLogical(false);
                        break;
                    case 0:
                        raiz.fe = -1;
                        break;
                    case -1:
                        n1 = (NodoAVL_General) raiz.subArbolIzquierdo();
                        if(n1.fe == -1) {
                            raiz = rotacionII(raiz, n1);
                        }else {
                            raiz = rotacionID(raiz, n1);
                        }
                        h.setLogical(false);
                }
            }
        }else if(dt.mayorQue(raiz.valorNodo())) {
            NodoAVL_General dr;
            dr = insertarAVL((NodoAVL_General) raiz.subArbolDerecho(), dt, h, x, nombre, clave, contraseña);
            raiz.ramaDerecha(dr);
            
            /*Regreso por los nodos del camino de busqueda*/
            if(h.booleanValue()) {
                switch(raiz.fe) {
                    case 1:
                        n1 = (NodoAVL_General) raiz.subArbolDerecho();
                        if(n1.fe == +1) {
                            raiz = rotacionDD(raiz, n1);
                        }else {
                            raiz = rotacionDI(raiz, n1);
                        }
                        h.setLogical(false);
                        break;
                    case 0:
                        raiz.fe = +1;
                        break;
                    case -1:
                        raiz.fe = 0;
                        h.setLogical(false);
                }
            }
            
        }else {
            System.out.println("Clave repetida");
        }
        
        return raiz;
    }
    
    public void insertar(Object valor, int x, String nombre, String clave, String contraseña) {
        Comparador dato;
        Logical h = new Logical(false);
        dato = (Comparador) valor;
        raiz = insertarAVL(raiz, dato, h, x, nombre, clave, contraseña);
    }
    
    static int altura(NodoAVL_General r) {
        if(r != null) {
            return mayor(altura((NodoAVL_General)r.subArbolIzquierdo()), altura((NodoAVL_General)r.subArbolDerecho())) + 1;
        }else {
            return 0;
        }
    }
    
    static int mayor(int x, int y) {
        return (x > y ? x : y);
    }
    
    public void eliminar(Object valor)  {
        Comparador dato;
        dato = (Comparador) valor;
        Logical flag = new Logical(false);
        raiz = borrarAVL(raiz, dato, flag);
    }
    
    private NodoAVL_General borrarAVL(NodoAVL_General r, Comparador clave, Logical cambiaAltura)  {
        if(r == null) {
            System.out.println("Nodo no encontrado");
        }else if(clave.menorQue(r.valorNodo())) {
            NodoAVL_General izquierda;
            izquierda = borrarAVL((NodoAVL_General)r.subArbolIzquierdo(), clave, cambiaAltura);
            r.ramaIzquierda(izquierda);
            if(cambiaAltura.booleanValue()) {
                r = equilibrar1(r, cambiaAltura);
            }
        }else if(clave.mayorQue(r.valorNodo())) {
            NodoAVL_General dr;
            dr = borrarAVL((NodoAVL_General)r.subArbolDerecho(), clave, cambiaAltura);
            r.ramaDerecha(dr);
            if(cambiaAltura.booleanValue()) {
                r = equilibrar2(r, cambiaAltura);
            }
        /*Si no se encuentra el nodo*/    
        }else {
            NodoAVL_General q;
            q = r;  //Nodo que se va a quitar del arbol
            if(q.subArbolIzquierdo() == null) {
                r = (NodoAVL_General) q.subArbolDerecho();
                cambiaAltura.setLogical(true);
            }else if(q.subArbolDerecho() == null) {
                r = (NodoAVL_General) q.subArbolIzquierdo();
                cambiaAltura.setLogical(true);
            /*Tiene rama izquierda y derecha*/
            }else {
                NodoAVL_General izquierda;
                izquierda = reemplazar(r, (NodoAVL_General)r.subArbolIzquierdo(), cambiaAltura);
                r.ramaIzquierda(izquierda);
                if(cambiaAltura.booleanValue()) {
                    r = equilibrar1(r, cambiaAltura);
                }
            }
            q = null;
        }
        return r;
    }
    
    private NodoAVL_General reemplazar(NodoAVL_General n, NodoAVL_General act, Logical cambiaAltura) {
        if(act.subArbolDerecho() != null) {
            NodoAVL_General d;
            d = reemplazar(n, (NodoAVL_General)act.subArbolDerecho(), cambiaAltura);
            act.ramaDerecha(d);
            if(cambiaAltura.booleanValue())
                act = equilibrar2(act, cambiaAltura);
        }else {
            n.nuevoValor(act.valorNodo());
            n = act;
            act = (NodoAVL_General)act.subArbolIzquierdo();
            n = null;
            cambiaAltura.setLogical(true);
        }
        return act;
    }
    
    private NodoAVL_General equilibrar1(NodoAVL_General n, Logical cambiaAltura) {
        NodoAVL_General n1;
        
        switch(n.fe) {
            case -1:
                n.fe = 0;
                break;
            case 0:
                n.fe = 1;
                cambiaAltura.setLogical(false);
                break;
            case +1:
                n1 = (NodoAVL_General)n.subArbolDerecho();
                if(n1.fe >= 0) {
                    if(n1.fe == 0)
                        cambiaAltura.setLogical(false);
                    n = rotacionDD(n, n1);
                }else
                    n = rotacionDI(n, n1);
                break;
        }
        return n;
    }
    
    private NodoAVL_General equilibrar2(NodoAVL_General n, Logical cambiaAltura) {
        NodoAVL_General n1;
        
        switch(n.fe) {
            case -1:
                n1 = (NodoAVL_General)n.subArbolIzquierdo();
                if(n1.fe <= 0) {
                    if(n1.fe == 0)
                        cambiaAltura.setLogical(false);
                    n = rotacionII(n, n1);
                }else
                    n = rotacionID(n, n1);
                break;
            case 0:
                n.fe = -1;
                cambiaAltura.setLogical(false);
                break;
            case +1:
                n.fe = 0;
                break;
        }
        return n;
    }
    
    static int imprimir(NodoAVL_General r) {
        if(r != null) {
            int cuantosIzquierda, cuantosDerecha;
            cuantosIzquierda = imprimir((NodoAVL_General)r.subArbolIzquierdo());
            System.out.print(r.valorNodoEnString() + "\n");
            cuantosDerecha = imprimir((NodoAVL_General)r.subArbolDerecho());
            System.out.println("**************************************************************");
            System.out.println("Cuantos a la izquierda ->" + cuantosIzquierda);
            System.out.println("Cuantos a la derecha ->" + cuantosDerecha);
            System.out.println("**************************************************************");
            return cuantosIzquierda + cuantosDerecha + 1;
        }else {
            return 0;
        }
    }
    
    static String graficar(NodoAVL_General r) {
        
        if(r != null) {
            codigoGraph += "nodo" + idNodo + " [ label = "+ r.valorNodoEnString() +" ];" + System.getProperty("line.separator");
            pila.push("nodo"+idNodo);
            idNodo++;
            
            if((NodoAVL_General)r.subArbolIzquierdo() != null) {
                String aux = pila.pop();
                enlaceGraph += aux + " -> nodo" + idNodo + System.getProperty("line.separator");
                graficar((NodoAVL_General)r.subArbolIzquierdo());
                pila.push(aux);
            }
            if((NodoAVL_General)r.subArbolDerecho() != null) {
                String aux = pila.pop();
                enlaceGraph += aux + " -> nodo" + idNodo + System.getProperty("line.separator");
                graficar((NodoAVL_General)r.subArbolDerecho());
            }
            return codigoGraph + enlaceGraph;
        }else {
            return codigoGraph + enlaceGraph;
        }
    }
    
    static void crearArchivoGraphviz(String contenido) throws IOException {
        
        /*Termino de escribir el contenido del archivo de graphviz*/
        contenido += "}";
        
        File file = new File("C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_general.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(contenido);
        }
        System.out.println("Done writting Graphviz file.");
        
        try {
            String dotPath = "C:\\Archivos de programa\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_general.txt";
            String fileOutputPath = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_general.jpg";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
            
            System.out.println("Done making Graphviz image.");
            
        } catch(IOException ex) {
        
        } finally {   
        
        }
        
    }
    
}
