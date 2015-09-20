/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.webserviceexterno.datos;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Marvin
 */
@WebService(serviceName = "Datos")
public class Datos {
    
    ArbolAVL_Admin admin = new ArbolAVL_Admin();
    ArbolAVL_Chofer chofer = new ArbolAVL_Chofer();
    ArbolAVL_General estacion_general = new ArbolAVL_General();
    ArbolAVL_Clave estacion_clave = new ArbolAVL_Clave();
    Lista_Buses bus = new Lista_Buses();
    Lista_Ruta ruta = new Lista_Ruta();
    
    /**
     * Web service operation
     * @param correo
     * @param password
     * @return 
     */
    @WebMethod(operationName = "CrearAdministrador")
    public String CrearAdministrador(@WebParam(name = "correo") String correo, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        int numNodos = 0;
        int valor = (correo.hashCode() > 0) ? correo.hashCode() : correo.hashCode() * -1;
        String salida = "Podriamos decir que usted esta creando el administrador con correo "+ correo +" y con la contraseña: " + password;
        
        Numero elemento = new Numero(valor);
        admin.insertar(elemento, valor, correo, password);
        numNodos = ArbolAVL_Admin.imprimir(admin.raizArbol());
        
        return salida;
    }

    /**
     * Web service operation
     * @param id_estacion_clave
     * @param nombre
     * @param password
     * @return 
     */
    @WebMethod(operationName = "CrearEstacionClave")
    public String CrearEstacionClave(@WebParam(name = "id_estacion_clave") int id_estacion_clave, @WebParam(name = "nombre") String nombre, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        int numNodos = 0;
        String salida = "Podriamos decir que usted esta creando la estacion clave con id: "+ id_estacion_clave +" y con el nombre: " + nombre + " y con contraseña: " + password;
        
        Numero elemento = new Numero(id_estacion_clave);
        estacion_clave.insertar(elemento, id_estacion_clave, nombre, String.valueOf(id_estacion_clave), password);
        numNodos = ArbolAVL_Clave.imprimir(estacion_clave.raizArbol());
        
        return salida;
    }

    /**
     * Web service operation
     * @param id_estacion_general
     * @param nombre
     * @param password
     * @return
     */
    @WebMethod(operationName = "CrearEstacionGeneral")
    public String CrearEstacionGeneral(@WebParam(name = "id_estacion_general") int id_estacion_general, @WebParam(name = "nombre") String nombre, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        int numNodos = 0;
        String salida = "Podriamos decir que usted esta creando la estacion general con id: "+ id_estacion_general +" y con el nombre: " + nombre + " y con contraseña: " + password;
        
        Numero elemento = new Numero(id_estacion_general);
        estacion_general.insertar(elemento, id_estacion_general, nombre, String.valueOf(id_estacion_general), password);
        numNodos = ArbolAVL_General.imprimir(estacion_general.raizArbol());
        
        return salida;
    }

    /**
     * Web service operation
     * @param nombre
     * @param apellido
     * @param clave
     * @param password
     * @return
     */
    @WebMethod(operationName = "CrearChofer")
    public String CrearChofer(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "clave") int clave, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        int numNodos = 0;
        String salida = "Podriamos decir que usted esta creando el chofer con id: "+ clave +" y con el nombre: " + nombre + " y con contraseña: " + password;
        
        Numero elemento = new Numero(clave);
        chofer.insertar(elemento, clave, nombre, apellido, String.valueOf(clave), password);
        numNodos = ArbolAVL_Chofer.imprimir(chofer.raizArbol());
        
        return salida;
    }

    /**
     * Web service operation
     * @param id_bus
     * @return
     */
    @WebMethod(operationName = "CrearBus")
    public String CrearBus(@WebParam(name = "id_bus") String id_bus) {
        //TODO write your implementation code here:
        int valor = (id_bus.hashCode() > 0) ? id_bus.hashCode() : id_bus.hashCode() * -1;
        String salida = "Podriamos decir que usted esta creando el bus con id: " + id_bus;
        bus.insertar(valor, id_bus);
        bus.ordenamientoBurbuja(bus);
        System.out.println("Cantidad de nodos de los buses: " + bus.getCantidadNodos());
        return salida;
    }

    /**
     * Web service operation
     * @param nombre
     * @param estaciones
     * @return
     */
    @WebMethod(operationName = "CrearRuta")
    public String CrearRuta(@WebParam(name = "nombre") String nombre, @WebParam(name = "estaciones") String estaciones) {
        //TODO write your implementation code here:
        int valor = (nombre.hashCode() > 0) ? nombre.hashCode() : nombre.hashCode() * -1;
        String salida = "Podriamos decir que usted esta creando la ruta con id: " + nombre;
        ruta.insertar(valor, nombre, estaciones);
        ruta.ordenamientoBurbuja(ruta);
        System.out.println("Cantidad de nodos de las rutas: " + ruta.getCantidadNodos());
        return salida;
    }

    /**
     * Web service operation
     * @param correo
     * @param password
     * @return
     */
    @WebMethod(operationName = "verificarAdministrador")
    public boolean verificarAdministrador(@WebParam(name = "correo") String correo, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        int valor = (correo.hashCode() > 0) ? correo.hashCode() : correo.hashCode() * -1;
        /*Llamamos al método que verifica si existe el nodo con esa información*/
        boolean bandera = admin.existe(admin.raiz, valor, password);
        
        return bandera;
    }

    /**
     * Web service operation
     * @param key
     * @param password
     * @return
     */
    @WebMethod(operationName = "verificarEstacionClave")
    public boolean verificarEstacionClave(@WebParam(name = "key") int key, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        /*Llamamos al método que verifica si existe el nodo con esa información*/
        boolean bandera = estacion_clave.existe(estacion_clave.raiz, key, password);
        
        return bandera;
    }

    /**
     * Web service operation
     * @param key
     * @param password
     * @return
     */
    @WebMethod(operationName = "verificarEstacionGeneral")
    public boolean verificarEstacionGeneral(@WebParam(name = "key") int key, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        /*Llamamos al método que verifica si existe el nodo con esa información*/
        boolean bandera = estacion_general.existe(estacion_general.raiz, key, password);
        
        return bandera;
    }

    /**
     * Web service operation
     * @param key
     * @param password
     * @return
     */
    @WebMethod(operationName = "verificarChofer")
    public boolean verificarChofer(@WebParam(name = "key") int key, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        /*Llamamos al método que verifica si existe el nodo con esa información*/
        boolean bandera = chofer.existe(chofer.raiz, key, password);
        
        return bandera;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reporteAdministrador")
    public void reporteAdministrador() {
        //TODO write your implementation code here:
        try {
            String contenido = ArbolAVL_Admin.graficar(admin.raizArbol());
            ArbolAVL_Admin.crearArchivoGraphviz(contenido);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reporteChofer")
    public void reporteChofer() {
        //TODO write your implementation code here:
        try {
            String contenido = ArbolAVL_Chofer.graficar(chofer.raizArbol());
            ArbolAVL_Chofer.crearArchivoGraphviz(contenido);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reporteEstacionClave")
    public void reporteEstacionClave() {
        //TODO write your implementation code here:
        try {
            String contenido = ArbolAVL_Clave.graficar(estacion_clave.raizArbol());
            ArbolAVL_Clave.crearArchivoGraphviz(contenido);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reporteEstacionGeneral")
    public void reporteEstacionGeneral() {
        //TODO write your implementation code here:
        try {
            String contenido = ArbolAVL_General.graficar(estacion_general.raizArbol());
            ArbolAVL_General.crearArchivoGraphviz(contenido);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reporteRuta")
    public void reporteRuta() {
        //TODO write your implementation code here:
        try {
            String contenido = Lista_Ruta.graficar();
            Lista_Ruta.crearArchivoGraphviz(contenido);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reporteBus")
    public void reporteBus() {
        //TODO write your implementation code here:
        try {
            String contenido = Lista_Buses.graficar();
            Lista_Buses.crearArchivoGraphviz(contenido);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     * @param tipo
     * @return
     */
    @WebMethod(operationName = "imageToByteArray")
    public byte[] imageToByteArray(@WebParam(name = "tipo") String tipo) {
        //TODO write your implementation code here:
        byte[] bytes = null;
        String path = "";
        
        if("admin".equals(tipo)) {
            path = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_admin.jpg";
        }else if("chofer".equals(tipo)) {
            path = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_chofer.jpg";
        }else if("estacion_clave".equals(tipo)) {
            path = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_estacion_clave.jpg";
        }else if("estacion_general".equals(tipo)) {
            path = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\diagrama_general.jpg";
        }else if("bus".equals(tipo)) {
            path = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\lista_buses.jpg";
        }else if("ruta".equals(tipo)) {
            path = "C:\\Documents and Settings\\Marvin Calderon\\Escritorio\\lista_ruta.jpg";
        }
        
        File file = new File(path);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            //create FileInputStream which obtains input bytes from a file in a file system
            //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            try {
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    //Writes to this byte array output stream
                    bos.write(buf, 0, readNum); 
                    System.out.println("read " + readNum + " bytes,");
                }
                
                System.out.println("Read process has finish.");
                bytes = bos.toByteArray();
                
            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return bytes;
    }

    /**
     * Web service operation
     * @param tipo
     * @return 
     */
    @WebMethod(operationName = "verificacion")
    public boolean verificacion(@WebParam(name = "tipo") String tipo) {
        //TODO write your implementation code here:
        boolean flag = false;
        
        if("admin".equals(tipo)) {
            flag = admin.bandera_creacion;
        }else if("chofer".equals(tipo)) {
            flag = chofer.bandera_creacion;
        }else if("estacion_clave".equals(tipo)) {
            flag = estacion_clave.bandera_creacion;
        }else if("estacion_general".equals(tipo)) {
            flag = estacion_general.bandera_creacion;
        }
        
        return flag;
        
    }

    /**
     * Web service operation
     * @param identificador
     * @return 
     */
    @WebMethod(operationName = "verifyBus")
    public boolean verifyBus(@WebParam(name = "identificador") int identificador) {
        //TODO write your implementation code here:
        boolean flag = bus.existe(identificador);
        
        return flag;
    }

    /**
     * Web service operation
     * @param identificador
     * @return 
     */
    @WebMethod(operationName = "verifyRuta")
    public boolean verifyRuta(@WebParam(name = "identificador") int identificador) {
        //TODO write your implementation code here:
        boolean flag = ruta.existe(identificador);
        
        return flag;
    }

    /**
     * Web service operation
     * @param array
     */
    @WebMethod(operationName = "byteArrayToFile")
    @Oneway
    public void byteArrayToFile(@WebParam(name = "array") byte[] array) {
        
        
        
    }
}