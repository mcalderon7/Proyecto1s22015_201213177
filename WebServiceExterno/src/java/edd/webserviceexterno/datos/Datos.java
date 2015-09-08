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
    
    ArbolAVL_Admin test = new ArbolAVL_Admin();
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
        test.insertar(elemento, valor);
        numNodos = ArbolAVL_Admin.imprimir(test.raizArbol());
        flag++;
        
        if(flag == 4) {
            try {
                String contenido = ArbolAVL_Admin.graficar(test.raizArbol());
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                System.out.println(contenido);
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
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