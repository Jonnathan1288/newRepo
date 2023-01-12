/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import sv.Servicios;
import sv.Servicios_Service;

/**
 *
 * @author DELL
 */
public class ModelUser extends User {

    Servicios_Service servicio = new Servicios_Service();
    Servicios cliente = servicio.getServiciosPort();
    
    public String SingIn(){
        String userResponse = cliente.signin(getUser(), getPassword());
        return userResponse;
    }
    
    public Boolean SingUp(){
        boolean successful = cliente.signup(getUser(), getPassword(), (int) getMonto());
        return successful;
    }
    
    public int update(String user, int bank_balance){
        int update_successful = cliente.update(user, bank_balance);
        return update_successful;
    }

}
