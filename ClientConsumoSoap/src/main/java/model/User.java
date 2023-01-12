/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class User {

    private String user;
    private String password;
    private double monto;

    public User(String user, String password, double monto) {
        this.user = user;
        this.password = password;
        this.monto = monto;
    }

    public User() {
    }

    public User(String password, double monto) {
        this.password = password;
        this.monto = monto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
