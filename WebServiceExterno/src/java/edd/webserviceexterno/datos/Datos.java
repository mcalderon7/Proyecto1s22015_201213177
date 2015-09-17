/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.webserviceexterno.datos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    int flag = 0;
    
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
        flag++;
        
        if(flag == 6) {
            try {
                String contenido = ArbolAVL_Admin.graficar(admin.raizArbol());
                ArbolAVL_Admin.crearArchivoGraphviz(contenido);
            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
        flag++;
        
        if(flag == 6) {
            try {
                String contenido = ArbolAVL_Clave.graficar(estacion_clave.raizArbol());
                ArbolAVL_Clave.crearArchivoGraphviz(contenido);
            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
        flag++;
        
        if(flag == 6) {
            try {
                String contenido = ArbolAVL_General.graficar(estacion_general.raizArbol());
                ArbolAVL_General.crearArchivoGraphviz(contenido);
            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
        flag++;
        
        if(flag == 6) {
            try {
                String contenido = ArbolAVL_Chofer.graficar(chofer.raizArbol());
                ArbolAVL_Chofer.crearArchivoGraphviz(contenido);
            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return salida;
    }

    /**
     * Web service operation
     * @param id_bus
     * @return
     */
    @WebMethod(operationName = "CrearBus")
    public String CrearBus(@WebParam(name = "id_bus") int id_bus) {
        //TODO write your implementation code here:
        return null;
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
        return null;
    }

}