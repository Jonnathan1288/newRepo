/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "servicios")
public class servicios {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "potencia")
    public Double potencia(@WebParam(name = "base") double base, @WebParam(name = "exponente") double exponente) {
        //TODO write your implementation code here:
        double reslt = Math.pow(base, exponente);
        return reslt;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "par_impar")
    public String par_impar(@WebParam(name = "numero") int numero) {
        //TODO write your implementation code here:
        String respuesta = "";
        int valor = numero % 2;
        if (valor == 0) {
            respuesta = "Par";
        } else {
            respuesta = "Impar";
        }
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "diccionario")
    public String diccionario(@WebParam(name = "palabra") String palabra) {
        //TODO write your implementation code here:
        String palabares = "";
        try {
            String result = valorResultado(palabra);
            if (result.equals("null")) {
                palabares = "La palabra no esta en el diccionario.";
            } else {
                palabares = result;
            }
        } catch (java.lang.NullPointerException e) {
            palabares = "No puede ingresar campos vacios";
        }
//        if (palabra == null) {
//            palabares = "No puede ingresar campos vacios";
//        } else {
//            String result = valorResultado(palabra);
//            if (result.equals("null")) {
//                palabares = "La palabra no esta en el diccionario.";
//            } else {
//                palabares = result;
//            }
//        }

        return palabares;
    }

    public String valorResultado(String key) {
        String keyValue = null;
        boolean keyFind = false;
        HashMap<String, String> mapBits = new HashMap<String, String>();
        mapBits.put("Saludo", "Un saludo puede catalogarse como un respeto.");
        mapBits.put("IP", "protocolo de internet.");
        mapBits.put("Tcp", "Protocolo de transferencia comunicación");
        mapBits.put("INTERNET", "Red de redes.");
        mapBits.put("LAN", "Redes de area local.");
        mapBits.put("man", "Redes de area metropolitana.");
        mapBits.put("WAN", "Redes de area extensa.");
        mapBits.put("HARDWARE", "Partes fisicas, tangibles");
        mapBits.put("SOFTWARE", "Son las partes logicas, las partes intangibles.");
        mapBits.put("so", "Sistema operativo");

        for (HashMap.Entry<String, String> each : mapBits.entrySet()) {
            System.out.println("Recorrido del for key -> " + each.getKey());
//                System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());        
            if (each.getKey().equalsIgnoreCase(key.intern())) {
                System.out.println("En el servidor tenemos: " + each.getValue());
                keyValue = each.getValue();
                keyFind = true;
                break;
            }
        }

        if (keyFind == true) {
            System.out.println("Lo que tenemos en el server de value: " + keyValue);
            return key + ": " + keyValue;

        } else {
            return "null";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "suma")
    public Double suma(@WebParam(name = "Num1") double num1, @WebParam(name = "Num2") double num2) {
        //TODO write your implementation code here:
        double sumaV = num1 + num2;
        return sumaV;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "resta")
    public Double resta(@WebParam(name = "Num1") double num1, @WebParam(name = "Num2") double num2) {
        //TODO write your implementation code here:
        double restaR = num1 - num2;
        return restaR;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplicacion")
    public Double multiplicacion(@WebParam(name = "Num1") double num1, @WebParam(name = "Num2") double num2) {
        //TODO write your implementation code here:
        double multiplicacionR = num1 * num2;
        return multiplicacionR;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "divicion")
    public Integer divicion(@WebParam(name = "Num1") int num1, @WebParam(name = "Num2") int num2) {
        //TODO write your implementation code here:
        int divM = num1 / num2;
        return divM;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "area")
    public double area(@WebParam(name = "base") double base, @WebParam(name = "altura") double altura) {
        //TODO write your implementation code here:
        double area = base / altura;
        return area;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "factorial")
    public Integer factorial(@WebParam(name = "numero") int numero) {
        int fact = 1;
        for (int i = 1; i <= numero; i++) {
            fact = fact * i;
        }

        return fact;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "volumenCubo")
    public double volumenCubo(@WebParam(name = "lado1") double lado1, @WebParam(name = "lado2") double lado2, @WebParam(name = "lado3") double lado3) {
        //TODO write your implementation code here:
        double volumen = lado1 * lado2 * lado3;
        return volumen;
    }

    /**
     * Web service operation
     */
    ArrayList<User> listaUser = new ArrayList<>();

    @WebMethod(operationName = "signup")
    public Boolean signup(@WebParam(name = "user") String user, @WebParam(name = "password") String password, @WebParam(name = "monto") int monto) {

        boolean encuentro = false;
        for (int i = 0; i < listaUser.size(); i++) {
            if (user.equalsIgnoreCase(listaUser.get(i).getUser())) {
                encuentro = true;
            }
        }
        if (encuentro) {
            return false;
        } else {
            listaUser.add(new User(user, password, monto));
            return true;
        }

    }

    @WebMethod(operationName = "signin")
    public String signin(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {

        String us = null, pas = null;
        int val = 0;

        boolean encuentro = false;
        for (int i = 0; i < listaUser.size(); i++) {
            if (user.equals(listaUser.get(i).getUser()) && password.equals(listaUser.get(i).getPassword())) {
                us = listaUser.get(i).getUser();
                pas = listaUser.get(i).getPassword();
                val = (int) listaUser.get(i).getMonto();
               // miLista.add(new User(listaUser.get(i).getUser(), listaUser.get(i).getPassword(), listaUser.get(i).getMonto()));
                encuentro = true;
                break;
            }
        }
        if (encuentro) {
            return ""+us+"/"+pas+"/"+val;
        } else {
            return "User Don't exit..";
        }
    }
    
    @WebMethod(operationName = "update")
    public Integer update(@WebParam(name = "user") String user, @WebParam(name = "monto") int monto) {

        boolean encuentro = false;
        for (int i = 0; i < listaUser.size(); i++) {
            if (user.equals(listaUser.get(i).getUser())) {
                listaUser.get(i).setMonto(monto);
                encuentro = true;
                break;
            }
        }
        if (encuentro) {
            return monto;
        } else {
            return 0;
        }

    }


    public class User {

        private String user;
        private String password;
        private double monto;

        public User() {
        }

        public User(String user, String password, double monto) {
            this.user = user;
            this.password = password;
            this.monto = monto;
        }
        
        public User(double monto) {
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

}
