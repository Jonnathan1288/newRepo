/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import controller.ControlForm;
import model.ModelUser;
import view.FormAcces;
import view.FormDepRet;
import view.FormRecord;

/**
 *
 * @author DELL
 */
public class running {
    public static void main(String[] args) {
        System.out.println("Paso 1");
        FormAcces viewFormAcces = new FormAcces();
        System.out.println("Paso 2");
        FormRecord viewRecord = new FormRecord();
        System.out.println("Paso 3");
        FormDepRet viewDepRet = new FormDepRet();
        System.out.println("Paso 4");
        ModelUser modelUser = new ModelUser();
        ControlForm controller = new ControlForm(viewFormAcces, viewRecord, viewDepRet, modelUser);
    }
}
