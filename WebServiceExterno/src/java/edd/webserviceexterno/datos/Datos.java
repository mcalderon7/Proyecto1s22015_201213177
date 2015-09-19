/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.webserviceexterno.datos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

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
        String salida = "Podriamos decir que usted esta creando el administrador con id: "+ id_estacion_clave +" y con el nombre: " + nombre + " y con contraseña: " + password;
        
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
        String salida = "Podriamos decir que usted esta creando el administrador con id: "+ id_estacion_general +" y con el nombre: " + nombre + " y con contraseña: " + password;
        
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
        String salida = "Podriamos decir que usted esta creando el administrador con id: "+ clave +" y con el nombre: " + nombre + " y con contraseña: " + password;
        
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
        String salida = "Podriamos decir que usted esta creando el administrador con id: " + id_bus;
        bus.insertar(valor, id_bus);
        
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
        String salida = "Podriamos decir que usted esta creando el administrador con id: " + nombre;
        ruta.insertar(valor, nombre, estaciones);
        
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
        
        /*Llamamos al método que verifica si existe el nodo con esa información*/
        boolean bandera = admin.existe(admin.raiz, correo, password);
        
        return bandera;
    }

    /**
     * Web service operation
     * @param nombre
     * @param password
     * @return
     */
    @WebMethod(operationName = "verificarEstacionClave")
    public boolean verificarEstacionClave(@WebParam(name = "nombre") String nombre, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        /*Llamamos al método que verifica si existe el nodo con esa información*/
        boolean bandera = estacion_clave.existe(estacion_clave.raiz, nombre, password);
        
        return bandera;
    }

    /**
     * Web service operation
     * @param nombre
     * @param password
     * @return
     */
    @WebMethod(operationName = "verificarEstacionGeneral")
    public boolean verificarEstacionGeneral(@WebParam(name = "nombre") String nombre, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        /*Llamamos al método que verifica si existe el nodo con esa información*/
        boolean bandera = estacion_general.existe(estacion_general.raiz, nombre, password);
        
        return bandera;
    }

    /**
     * Web service operation
     * @param nombre
     * @param apellido
     * @param password
     * @return
     */
    @WebMethod(operationName = "verificarChofer")
    public boolean verificarChofer(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        /*Llamamos al método que verifica si existe el nodo con esa información*/
        boolean bandera = chofer.existe(chofer.raiz, nombre, apellido, password);
        
        return bandera;
    }


}