package edd.webserviceexterno.datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Marvin
 */
public class Lista_Buses {
    
    int idNodo = 0;
    String codigoGraph = "";
    String enlaceGraph = "";
    private Nodo_Lista cabeza;
    
    public Lista_Buses() {
        cabeza = null;
        codigoGraph += "digraph G{" + System.getProperty("line.separator");
        codigoGraph += "rankdir=TB;" + System.getProperty("line.separator");
        codigoGraph += "node [shape = record, style=filled, fillcolor=seashell2];" + System.getProperty("line.separator");
    }
    
    public Lista_Buses insertar(int clave, String id_bus) {
        
        Nodo_Lista nuevo = new Nodo_Lista(clave, id_bus);
        nuevo.siguiente = cabeza;
        
        if(cabeza != null)
            cabeza.anterior = nuevo;
        cabeza = nuevo;
        
        return this;
        
    }
    
    public int getCantidadNodos() {
        int cantidad = 0;
        Nodo_Lista aux = cabeza;
        
        while(aux != null) {
            aux = aux.siguiente;
            cantidad++;
        }
        return cantidad;
    }
    
    public boolean existe(int clave) {
        Nodo_Lista aux = cabeza;
        
        while(aux != null) {
            if(aux.clave == clave)
                return true;
            aux = aux.siguiente;
        }
        return false;
    }
    
    public void eliminar(int entrada) {
        
        Nodo_Lista actual;
        boolean encontrado = false;
        actual = cabeza;
        
        /*Ciclo de búsqueda*/
        while((actual != null) && (!encontrado)) {
            encontrado = (actual.clave == entrada);
            if(!encontrado)
                actual = actual.siguiente;
        }
        
        /*Enlace de nodo anterior con el siguiente*/
        if(actual != null) {
            
            /*Distingue entre nodo cabeza o resto de la lista*/
            if(actual == cabeza) {
                cabeza = actual.siguiente;
                if(actual.siguiente != null)
                    actual.siguiente.anterior = null;
            /*Si no es el último nodo*/
            }else if(actual.siguiente != null) {
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
            /*Si es el último nodo*/
            }else
                actual.anterior.siguiente = null;
            actual = null;
        }
        
    }
    
    public void ordenamientoBurbuja(Lista_Buses lista) {
        
        if(lista.getCantidadNodos() > 1) {
            
            Nodo_Lista aux1 = cabeza;
            Nodo_Lista aux2 = cabeza.siguiente;
            
            while(aux2 != null) {
                if(aux2.clave < aux1.clave) {
                    int aux = aux1.clave;
                    aux1.clave = aux2.clave;
                    aux2.clave = aux;
                }
                aux2 = aux2.siguiente;
                aux1 = aux1.siguiente;
            }
            
        }
        
    }
    
    public String graficar() {
        Nodo_Lista aux = cabeza;
        
        while(aux != null) {
            codigoGraph += "nodo" + idNodo + " [ label = \"Id Bus: "+ aux.id_bus +"\" ];" + System.getProperty("line.separator");
            enlaceGraph += "nodo" + idNodo + " -> nodo" + (idNodo + 1) + System.getProperty("line.separator");
            aux = aux.siguiente;
        }
        
        return codigoGraph + enlaceGraph;
    }
    
    public void crearArchivoGraphviz(String contenido) throws IOException {
        
        /*Termino de escribir el contenido del archivo de graphviz*/
        contenido += "}";
        
        File file = new File("C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\lista_buses.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(contenido);
        }
        System.out.println("Done writting Graphviz [lista_buses] file.");
        
        try {
            String dotPath = "C:\\Archivos de programa\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\lista_buses.txt";
            String fileOutputPath = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\lista_buses.jpg";
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
            
            System.out.println("Done making Graphviz [lista_buses] image.");
            
        } catch(IOException ex) {
        
        } finally {   
        
        }
        
    }
    
}