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
public class ArbolAVL_Clave {
    
    boolean bandera_creacion;
    static Boolean flag = false;
    static Stack<String> pila;
    static String codigoGraph = "";
    static String enlaceGraph = "";
    static int idNodo = 0;
    NodoAVL_Clave raiz;
    
    public ArbolAVL_Clave() {
        raiz = null;
        codigoGraph += "digraph G{" + System.getProperty("line.separator");
        codigoGraph += "rankdir=TB;" + System.getProperty("line.separator");
        codigoGraph += "node [shape = record, style=filled, fillcolor=seashell2];" + System.getProperty("line.separator");
        pila = new Stack();
    }
    
    public NodoAVL_Clave raizArbol() {
        return raiz;
    }
    
    /*Método de rotación Izquierda Izquierda*/
    private NodoAVL_Clave rotacionII(NodoAVL_Clave n, NodoAVL_Clave n1) {
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
    
    private NodoAVL_Clave rotacionDD(NodoAVL_Clave n, NodoAVL_Clave n1) {
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
    
    private NodoAVL_Clave rotacionID(NodoAVL_Clave n, NodoAVL_Clave n1) {
        NodoAVL_Clave n2;
        
        n2 = (NodoAVL_Clave) n1.subArbolDerecho();
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
    
    private NodoAVL_Clave rotacionDI(NodoAVL_Clave n, NodoAVL_Clave n1) {
        NodoAVL_Clave n2;
        
        n2 = (NodoAVL_Clave)n1.subArbolIzquierdo();
        
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
    
    private NodoAVL_Clave insertarAVL(NodoAVL_Clave raiz, Comparador dt, Logical h, int x, String nombre, String clave, String contraseña) {
        bandera_creacion = false;
        NodoAVL_Clave n1;
        
        if(raiz == null) {
            raiz = new NodoAVL_Clave(dt, nombre, clave, contraseña);
            raiz.valorNodoEnString(x);
            h.setLogical(true);
        }else if(dt.menorQue(raiz.valorNodo())) {
            NodoAVL_Clave izq;
            izq = insertarAVL((NodoAVL_Clave) raiz.subArbolIzquierdo(), dt, h, x, nombre, clave, contraseña);
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
                        n1 = (NodoAVL_Clave) raiz.subArbolIzquierdo();
                        if(n1.fe == -1) {
                            raiz = rotacionII(raiz, n1);
                        }else {
                            raiz = rotacionID(raiz, n1);
                        }
                        h.setLogical(false);
                }
            }
        }else if(dt.mayorQue(raiz.valorNodo())) {
            NodoAVL_Clave dr;
            dr = insertarAVL((NodoAVL_Clave) raiz.subArbolDerecho(), dt, h, x, nombre, clave, contraseña);
            raiz.ramaDerecha(dr);
            
            /*Regreso por los nodos del camino de busqueda*/
            if(h.booleanValue()) {
                switch(raiz.fe) {
                    case 1:
                        n1 = (NodoAVL_Clave) raiz.subArbolDerecho();
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
            bandera_creacion = true;
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
    
    static int altura(NodoAVL_Clave r) {
        if(r != null) {
            return mayor(altura((NodoAVL_Clave)r.subArbolIzquierdo()), altura((NodoAVL_Clave)r.subArbolDerecho())) + 1;
        }else {
            return 0;
        }
    }
    
    public boolean existe(NodoAVL_Clave nodo, String nombre, String password) {
        
        if(nodo != null) {
            
            if(nodo.nombre.equals(nombre) && nodo.contraseña.equals(password)) {
                System.out.println("SE ENCONTRO EL NODO!");
                return true;
            }else {
                if((NodoAVL_Clave)nodo.subArbolIzquierdo() != null) {
                    existe((NodoAVL_Clave)nodo.subArbolIzquierdo(), nombre, password);
                }
                if((NodoAVL_Clave)nodo.subArbolDerecho() != null) {
                    existe((NodoAVL_Clave)nodo.subArbolDerecho(), nombre, password);
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
    
    private NodoAVL_Clave borrarAVL(NodoAVL_Clave r, Comparador clave, Logical cambiaAltura)  {
        if(r == null) {
            System.out.println("Nodo no encontrado");
        }else if(clave.menorQue(r.valorNodo())) {
            NodoAVL_Clave izquierda;
            izquierda = borrarAVL((NodoAVL_Clave)r.subArbolIzquierdo(), clave, cambiaAltura);
            r.ramaIzquierda(izquierda);
            if(cambiaAltura.booleanValue()) {
                r = equilibrar1(r, cambiaAltura);
            }
        }else if(clave.mayorQue(r.valorNodo())) {
            NodoAVL_Clave dr;
            dr = borrarAVL((NodoAVL_Clave)r.subArbolDerecho(), clave, cambiaAltura);
            r.ramaDerecha(dr);
            if(cambiaAltura.booleanValue()) {
                r = equilibrar2(r, cambiaAltura);
            }
        /*Si no se encuentra el nodo*/    
        }else {
            NodoAVL_Clave q;
            q = r;  //Nodo que se va a quitar del arbol
            if(q.subArbolIzquierdo() == null) {
                r = (NodoAVL_Clave) q.subArbolDerecho();
                cambiaAltura.setLogical(true);
            }else if(q.subArbolDerecho() == null) {
                r = (NodoAVL_Clave) q.subArbolIzquierdo();
                cambiaAltura.setLogical(true);
            /*Tiene rama izquierda y derecha*/
            }else {
                NodoAVL_Clave izquierda;
                izquierda = reemplazar(r, (NodoAVL_Clave)r.subArbolIzquierdo(), cambiaAltura);
                r.ramaIzquierda(izquierda);
                if(cambiaAltura.booleanValue()) {
                    r = equilibrar1(r, cambiaAltura);
                }
            }
            q = null;
        }
        return r;
    }
    
    private NodoAVL_Clave reemplazar(NodoAVL_Clave n, NodoAVL_Clave act, Logical cambiaAltura) {
        if(act.subArbolDerecho() != null) {
            NodoAVL_Clave d;
            d = reemplazar(n, (NodoAVL_Clave)act.subArbolDerecho(), cambiaAltura);
            act.ramaDerecha(d);
            if(cambiaAltura.booleanValue())
                act = equilibrar2(act, cambiaAltura);
        }else {
            n.nuevoValor(act.valorNodo());
            n = act;
            act = (NodoAVL_Clave)act.subArbolIzquierdo();
            n = null;
            cambiaAltura.setLogical(true);
        }
        return act;
    }
    
    private NodoAVL_Clave equilibrar1(NodoAVL_Clave n, Logical cambiaAltura) {
        NodoAVL_Clave n1;
        
        switch(n.fe) {
            case -1:
                n.fe = 0;
                break;
            case 0:
                n.fe = 1;
                cambiaAltura.setLogical(false);
                break;
            case +1:
                n1 = (NodoAVL_Clave)n.subArbolDerecho();
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
    
    private NodoAVL_Clave equilibrar2(NodoAVL_Clave n, Logical cambiaAltura) {
        NodoAVL_Clave n1;
        
        switch(n.fe) {
            case -1:
                n1 = (NodoAVL_Clave)n.subArbolIzquierdo();
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
    
    static int imprimir(NodoAVL_Clave r) {
        if(r != null) {
            int cuantosIzquierda, cuantosDerecha;
            cuantosIzquierda = imprimir((NodoAVL_Clave)r.subArbolIzquierdo());
            System.out.print(r.valorNodoEnString() + "\n");
            cuantosDerecha = imprimir((NodoAVL_Clave)r.subArbolDerecho());
            System.out.println("**************************************************************");
            System.out.println("Cuantos a la izquierda ->" + cuantosIzquierda);
            System.out.println("Cuantos a la derecha ->" + cuantosDerecha);
            System.out.println("**************************************************************");
            return cuantosIzquierda + cuantosDerecha + 1;
        }else {
            return 0;
        }
    }
    
    static String graficar(NodoAVL_Clave r) {
        
        if(r != null) {
            codigoGraph += "nodo" + idNodo + " [ label = "+ r.valorNodoEnString() +" ];" + System.getProperty("line.separator");
            pila.push("nodo"+idNodo);
            idNodo++;
            
            if((NodoAVL_Clave)r.subArbolIzquierdo() != null) {
                String aux = pila.pop();
                enlaceGraph += aux + " -> nodo" + idNodo + System.getProperty("line.separator");
                graficar((NodoAVL_Clave)r.subArbolIzquierdo());
                pila.push(aux);
            }
            if((NodoAVL_Clave)r.subArbolDerecho() != null) {
                String aux = pila.pop();
                enlaceGraph += aux + " -> nodo" + idNodo + System.getProperty("line.separator");
                graficar((NodoAVL_Clave)r.subArbolDerecho());
            }
            
            return codigoGraph + enlaceGraph;
        }else {
            
            return codigoGraph + enlaceGraph;
        }
    }
    
    static void crearArchivoGraphviz(String contenido) throws IOException {
        
        idNodo = 0;
        codigoGraph = "";
        codigoGraph += "digraph G{" + System.getProperty("line.separator");
        codigoGraph += "rankdir=TB;" + System.getProperty("line.separator");
        codigoGraph += "node [shape = record, style=filled, fillcolor=seashell2];" + System.getProperty("line.separator");
        enlaceGraph = "";
        
        /*Termino de escribir el contenido del archivo de graphviz*/
        contenido += "}";
        
        File file = new File("C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_estacion_clave.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
        fw.write(contenido);
        fw.close();
        System.out.println("Done writting Graphviz file.");
        
        try {
            String dotPath = "C:\\Archivos de programa\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_estacion_clave.txt";
            String fileOutputPath = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_estacion_clave.jpg";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            
            File file_y = new File(fileOutputPath);
            if(file_y.exists() && !file_y.isDirectory()) {
                file_y.delete();
                System.out.println(file_y.getName() + " is deleted!");
            }
            
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
            
            System.out.println("Done making Graphviz [Estaciones Clave] image.");
            
            File file_x = new File(fileOutputPath);
            while (!file_x.exists()) {
                try { 
                    Thread.sleep(100);
                } catch (InterruptedException ie) { 
                    /* safe to ignore */
                }
            }
            
        } catch(IOException ex) {
        
        } finally {   
        
        }
        
    }
    
}
