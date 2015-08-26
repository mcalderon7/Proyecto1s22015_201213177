/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Marvin
 */
@WebService(serviceName = "EstructurasWebService")
public class EstructurasWebService {

    /**
     * Web service operation
     * @param correo
     * @param contraseña
     * @return 
     */
    @WebMethod(operationName = "CrearAdministrador")
    public String CrearAdministrador(@WebParam(name = "correo") String correo, @WebParam(name = "contrase\u00f1a") String contraseña) {
        //TODO write your implementation code here:
        
        String output = "El administrador creado tiene el correo: " + correo + " y la contraseña: " + contraseña;
        
        return output;
    }

    /**
     * Web service operation
     * @param id
     * @param nombre
     * @param contraseña
     * @return
     */
    @WebMethod(operationName = "CrearEstacionClave")
    public String CrearEstacionClave(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "contrase\u00f1a") String contraseña) {
        //TODO write your implementation code here:
        String output = "La estacion clave tiene el id: " + id + ", el nombre: " + nombre  + " y la contraseña " + contraseña;
        
        return output;
    }

    /**
     * Web service operation
     * @param id
     * @param nombre
     * @param contraseña
     * @return
     */
    @WebMethod(operationName = "CrearEstacionGeneral")
    public String CrearEstacionGeneral(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "contrase\u00f1a") String contraseña) {
        //TODO write your implementation code here:
        String output = "La estacion general tiene el id: " + id + ", el nombre: " + nombre  + " y la contraseña " + contraseña;
        
        return output;
    }

    /**
     * Web service operation
     * @param nombre
     * @param apellido
     * @param clave
     * @param contraseña
     * @return
     */
    @WebMethod(operationName = "CrearChofer")
    public String CrearChofer(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "clave") String clave, @WebParam(name = "contrase\u00f1a") String contraseña) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * @param id
     */
    @WebMethod(operationName = "CrearBus")
    public String CrearBus(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        return null;
    }
}
