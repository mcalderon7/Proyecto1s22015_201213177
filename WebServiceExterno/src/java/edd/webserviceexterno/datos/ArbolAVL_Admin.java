package edd.webserviceexterno.datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Marvin
 */
public class ArbolAVL_Admin {
    
    static String codigoGraph = "";
    static int idNodo = 0;
    NodoAVL_Admin raiz;
    
    public ArbolAVL_Admin() {
        raiz = null;
        codigoGraph += "digraph grafica{\n";
        codigoGraph += "rankdir=TB;\n";
        codigoGraph += "node [shape = record, style=filled, fillcolor=seashell2];\n";
    }
    
    public NodoAVL_Admin raizArbol() {
        return raiz;
    }
    
    /*Método de rotación Izquierda Izquierda*/
    private NodoAVL_Admin rotacionII(NodoAVL_Admin n, NodoAVL_Admin n1) {
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
    
    private NodoAVL_Admin rotacionDD(NodoAVL_Admin n, NodoAVL_Admin n1) {
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
    
    private NodoAVL_Admin rotacionID(NodoAVL_Admin n, NodoAVL_Admin n1) {
        NodoAVL_Admin n2;
        
        n2 = (NodoAVL_Admin) n1.subArbolDerecho();
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
    
    private NodoAVL_Admin rotacionDI(NodoAVL_Admin n, NodoAVL_Admin n1) {
        NodoAVL_Admin n2;
        
        n2 = (NodoAVL_Admin)n1.subArbolIzquierdo();
        
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
    
    private NodoAVL_Admin insertarAVL(NodoAVL_Admin raiz, Comparador dt, Logical h, int x) {
        NodoAVL_Admin n1;
        
        if(raiz == null) {
            raiz = new NodoAVL_Admin(dt);
            raiz.valorNodoEnString(x);
            h.setLogical(true);
        }else if(dt.menorQue(raiz.valorNodo())) {
            NodoAVL_Admin izq;
            izq = insertarAVL((NodoAVL_Admin) raiz.subArbolIzquierdo(), dt, h, x);
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
                        n1 = (NodoAVL_Admin) raiz.subArbolIzquierdo();
                        if(n1.fe == -1) {
                            raiz = rotacionII(raiz, n1);
                        }else {
                            raiz = rotacionID(raiz, n1);
                        }
                        h.setLogical(false);
                }
            }
        }else if(dt.mayorQue(raiz.valorNodo())) {
            NodoAVL_Admin dr;
            dr = insertarAVL((NodoAVL_Admin) raiz.subArbolDerecho(), dt, h, x);
            raiz.ramaDerecha(dr);
            
            /*Regreso por los nodos del camino de busqueda*/
            if(h.booleanValue()) {
                switch(raiz.fe) {
                    case 1:
                        n1 = (NodoAVL_Admin) raiz.subArbolDerecho();
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
    
    public void insertar(Object valor, int x) {
        Comparador dato;
        Logical h = new Logical(false);
        dato = (Comparador) valor;
        raiz = insertarAVL(raiz, dato, h, x);
    }
    
    static int altura(NodoAVL_Admin r) {
        if(r != null) {
            return mayor(altura((NodoAVL_Admin)r.subArbolIzquierdo()), altura((NodoAVL_Admin)r.subArbolDerecho())) + 1;
        }else {
            return 0;
        }
    }
    
    static int mayor(int x, int y) {
        return (x > y ? x : y);
    }
    
    static int imprimir(NodoAVL_Admin r) {
        if(r != null) {
            int cuantosIzquierda, cuantosDerecha;
            cuantosIzquierda = imprimir((NodoAVL_Admin)r.subArbolIzquierdo());
            System.out.print(r.valorNodoEnString() + "\n");
            cuantosDerecha = imprimir((NodoAVL_Admin)r.subArbolDerecho());
            System.out.println("**************************************************************");
            System.out.println("Cuantos a la derecha ->" + cuantosDerecha);
            System.out.println("Cuantos a la izquierda ->" + cuantosIzquierda);
            System.out.println("**************************************************************");
            return cuantosIzquierda + cuantosDerecha + 1;
        }else {
            return 0;
        }
    }
    
    static String graficar(NodoAVL_Admin r) {
        
        NodoAVL_Admin aux = r;
        
        if(r != null) {
            codigoGraph += "nodo" + idNodo + " [ label ="+ graficar((NodoAVL_Admin)aux.subArbolIzquierdo()) +"];\n";
            codigoGraph += "nodo" + idNodo + " [ label ="+ graficar((NodoAVL_Admin)aux.subArbolDerecho()) +"];\n";
        }
        
        return aux.valorNodoEnString();
        
    }
    
    static void crearArchivoGraphviz(String contenido) throws IOException {
        
        /*Termino de escribir el contenido del archivo de graphviz*/
        codigoGraph += "\n}";
        
        File file = new File("diagrama.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(contenido);
        }
        System.out.println("Done writting Graphviz file.");
    }
    
}
