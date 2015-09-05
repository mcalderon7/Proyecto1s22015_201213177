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

    /**
     * Web service operation
     * @param correo
     * @param password
     * @return 
     */
    @WebMethod(operationName = "CrearAdministrador")
    public String CrearAdministrador(@WebParam(name = "correo") String correo, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        int valor = (correo.hashCode() > 0) ? correo.hashCode() : correo.hashCode() * -1;
        String salida = "Podriamos decir que usted esta creando el administrador con correo "+ correo +" y con la contraseña: " + password;
        
        ArbolAVL_Admin test = new ArbolAVL_Admin();
        Numero elemento = new Numero(valor);
        test.insertar(elemento);
        
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
        return null;
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
        return null;
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
        return null;
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