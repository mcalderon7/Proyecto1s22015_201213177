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
public class ArbolAVL_Admin {
    
    static Boolean flag = false;
    static Stack<String> pila;
    static String codigoGraph = "";
    static String enlaceGraph = "";
    static int idNodo = 0;
    NodoAVL_Admin raiz;
    
    public ArbolAVL_Admin() {
        raiz = null;
        codigoGraph += "digraph G{" + System.getProperty("line.separator");
        codigoGraph += "rankdir=TB;" + System.getProperty("line.separator");
        codigoGraph += "node [shape = record, style=filled, fillcolor=seashell2];" + System.getProperty("line.separator");
        pila = new Stack();
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
    
    private NodoAVL_Admin insertarAVL(NodoAVL_Admin raiz, Comparador dt, Logical h, int x, String correo, String contraseña) {
        NodoAVL_Admin n1;
        
        if(raiz == null) {
            raiz = new NodoAVL_Admin(dt, correo, contraseña);
            raiz.valorNodoEnString(x);
            h.setLogical(true);
        }else if(dt.menorQue(raiz.valorNodo())) {
            NodoAVL_Admin izq;
            izq = insertarAVL((NodoAVL_Admin) raiz.subArbolIzquierdo(), dt, h, x, correo, contraseña);
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
            dr = insertarAVL((NodoAVL_Admin) raiz.subArbolDerecho(), dt, h, x, correo, contraseña);
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
    
    public void insertar(Object valor, int x, String correo, String contraseña) {
        Comparador dato;
        Logical h = new Logical(false);
        dato = (Comparador) valor;
        raiz = insertarAVL(raiz, dato, h, x, correo, contraseña);
    }
    
    static int altura(NodoAVL_Admin r) {
        if(r != null) {
            return mayor(altura((NodoAVL_Admin)r.subArbolIzquierdo()), altura((NodoAVL_Admin)r.subArbolDerecho())) + 1;
        }else {
            return 0;
        }
    }
    
    public boolean existe(NodoAVL_Admin nodo, String correo, String password) {
        
        if(nodo != null) {
            
            if(nodo.correo.equals(correo) && nodo.contraseña.equals(password)) {
                System.out.println("SE ENCONTRO EL NODO!");
                return true;
            }else {
                if((NodoAVL_Admin)nodo.subArbolIzquierdo() != null) {
                    existe((NodoAVL_Admin)nodo.subArbolIzquierdo(), correo, password);
                }
                if((NodoAVL_Admin)nodo.subArbolDerecho() != null) {
                    existe((NodoAVL_Admin)nodo.subArbolDerecho(), correo, password);
                }
            }
        }
        System.out.println("NO SE ENCONTRO EL NODO!");
        return false;
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
    
    private NodoAVL_Admin borrarAVL(NodoAVL_Admin r, Comparador clave, Logical cambiaAltura)  {
        if(r == null) {
            System.out.println("Nodo no encontrado");
        }else if(clave.menorQue(r.valorNodo())) {
            NodoAVL_Admin izquierda;
            izquierda = borrarAVL((NodoAVL_Admin)r.subArbolIzquierdo(), clave, cambiaAltura);
            r.ramaIzquierda(izquierda);
            if(cambiaAltura.booleanValue()) {
                r = equilibrar1(r, cambiaAltura);
            }
        }else if(clave.mayorQue(r.valorNodo())) {
            NodoAVL_Admin dr;
            dr = borrarAVL((NodoAVL_Admin)r.subArbolDerecho(), clave, cambiaAltura);
            r.ramaDerecha(dr);
            if(cambiaAltura.booleanValue()) {
                r = equilibrar2(r, cambiaAltura);
            }
        /*Si no se encuentra el nodo*/    
        }else {
            NodoAVL_Admin q;
            q = r;  //Nodo que se va a quitar del arbol
            if(q.subArbolIzquierdo() == null) {
                r = (NodoAVL_Admin) q.subArbolDerecho();
                cambiaAltura.setLogical(true);
            }else if(q.subArbolDerecho() == null) {
                r = (NodoAVL_Admin) q.subArbolIzquierdo();
                cambiaAltura.setLogical(true);
            /*Tiene rama izquierda y derecha*/
            }else {
                NodoAVL_Admin izquierda;
                izquierda = reemplazar(r, (NodoAVL_Admin)r.subArbolIzquierdo(), cambiaAltura);
                r.ramaIzquierda(izquierda);
                if(cambiaAltura.booleanValue()) {
                    r = equilibrar1(r, cambiaAltura);
                }
            }
            q = null;
        }
        return r;
    }
    
    private NodoAVL_Admin reemplazar(NodoAVL_Admin n, NodoAVL_Admin act, Logical cambiaAltura) {
        if(act.subArbolDerecho() != null) {
            NodoAVL_Admin d;
            d = reemplazar(n, (NodoAVL_Admin)act.subArbolDerecho(), cambiaAltura);
            act.ramaDerecha(d);
            if(cambiaAltura.booleanValue())
                act = equilibrar2(act, cambiaAltura);
        }else {
            n.nuevoValor(act.valorNodo());
            n = act;
            act = (NodoAVL_Admin)act.subArbolIzquierdo();
            n = null;
            cambiaAltura.setLogical(true);
        }
        return act;
    }
    
    private NodoAVL_Admin equilibrar1(NodoAVL_Admin n, Logical cambiaAltura) {
        NodoAVL_Admin n1;
        
        switch(n.fe) {
            case -1:
                n.fe = 0;
                break;
            case 0:
                n.fe = 1;
                cambiaAltura.setLogical(false);
                break;
            case +1:
                n1 = (NodoAVL_Admin)n.subArbolDerecho();
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
    
    private NodoAVL_Admin equilibrar2(NodoAVL_Admin n, Logical cambiaAltura) {
        NodoAVL_Admin n1;
        
        switch(n.fe) {
            case -1:
                n1 = (NodoAVL_Admin)n.subArbolIzquierdo();
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
    
    static int imprimir(NodoAVL_Admin r) {
        if(r != null) {
            int cuantosIzquierda, cuantosDerecha;
            cuantosIzquierda = imprimir((NodoAVL_Admin)r.subArbolIzquierdo());
            System.out.print(r.valorNodoEnString() + "\n");
            cuantosDerecha = imprimir((NodoAVL_Admin)r.subArbolDerecho());
            System.out.println("**************************************************************");
            System.out.println("Cuantos a la izquierda ->" + cuantosIzquierda);
            System.out.println("Cuantos a la derecha ->" + cuantosDerecha);
            System.out.println("**************************************************************");
            return cuantosIzquierda + cuantosDerecha + 1;
        }else {
            return 0;
        }
    }
    
    static String graficar(NodoAVL_Admin r) {
        
        if(r != null) {
            codigoGraph += "nodo" + idNodo + " [ label = "+ r.valorNodoEnString() +" ];" + System.getProperty("line.separator");
            pila.push("nodo"+idNodo);
            idNodo++;
            
            if((NodoAVL_Admin)r.subArbolIzquierdo() != null) {
                String aux = pila.pop();
                enlaceGraph += aux + " -> nodo" + idNodo + System.getProperty("line.separator");
                graficar((NodoAVL_Admin)r.subArbolIzquierdo());
                pila.push(aux);
            }
            if((NodoAVL_Admin)r.subArbolDerecho() != null) {
                String aux = pila.pop();
                enlaceGraph += aux + " -> nodo" + idNodo + System.getProperty("line.separator");
                graficar((NodoAVL_Admin)r.subArbolDerecho());
            }
            return codigoGraph + enlaceGraph;
        }else {
            return codigoGraph + enlaceGraph;
        }
    }
    
    static void crearArchivoGraphviz(String contenido) throws IOException {
        
        /*Termino de escribir el contenido del archivo de graphviz*/
        contenido += "}";
        
        File file = new File("C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_admin.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(contenido);
        }
        System.out.println("Done writting Graphviz file.");
        
        try {
            String dotPath = "C:\\Archivos de programa\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_admin.txt";
            String fileOutputPath = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_admin.jpg";
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
