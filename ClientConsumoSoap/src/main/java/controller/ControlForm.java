/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import model.ModelUser;
import model.User;
import view.FormAcces;
import view.FormDepRet;
import view.FormRecord;

/**
 *
 * @author DELL
 */
public class ControlForm {

    private FormAcces viewFormAcces;
    private FormRecord viewRecord;
    private FormDepRet viewDepRet;
    private ModelUser modelUser;

    public ControlForm(FormAcces viewFormAcces, FormRecord viewRecord, FormDepRet viewDepRet, ModelUser modelUser) {
        this.viewFormAcces = viewFormAcces;
        this.viewRecord = viewRecord;
        this.viewDepRet = viewDepRet;
        this.modelUser = modelUser;
        locationViews();
        eventView();
        view();
        messageViewFalse();
    }

    private void locationViews() {
        this.viewDepRet.setLocationRelativeTo(null);
        this.viewFormAcces.setLocationRelativeTo(null);
        this.viewRecord.setLocationRelativeTo(null);
    }

    private void messageViewFalse() {
        viewFormAcces.getLblErrorMessage().setVisible(false);

        //View false
        viewRecord.getLblMessageSuccessful().setVisible(false);

        //View false depocito e ingreso
        viewDepRet.getLblMessageSuccessful().setVisible(false);
    }

    //View of sign in
    private void view() {
        viewFormAcces.setVisible(true);

        // viewFormAcces.setSize(1, 1);
        controlBtns();
    }

    private void controlBtns() {
        viewFormAcces.getBtnSingIn().addActionListener(l -> SingIn());
        viewFormAcces.getBtnSingUp().addActionListener(l -> SingUp());

        //
        viewRecord.getBtnCreateR().addActionListener(l -> creteUser());

        //
        viewDepRet.getBtnConfirmOperation().addActionListener(l -> IngresoRetiro());

        //
        viewRecord.getBtnCanceRl().addActionListener(l -> btnCancelar());

        //
        viewDepRet.getBtnCancelOperation().addActionListener(l -> logOut());
    }

    private void btnCancelar() {
        viewRecord.dispose();
        viewFormAcces.setVisible(true);
    }

    private void logOut() {
        int i = JOptionPane.showConfirmDialog(viewDepRet, "¿Seguro en salir?", "LogOut", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (i == 0) {
            viewDepRet.dispose();
            viewFormAcces.setVisible(true);
        }

    }

    private void SingIn() {

        ModelUser modUs = new ModelUser();
        modUs.setUser(viewFormAcces.getTxtUserFormA().getText());
        modUs.setPassword(viewFormAcces.getTxtPasswordA().getText());

        String userHere = modUs.SingIn();
        if (userHere.equals("User Don't exit..")) {
            viewFormAcces.getLblErrorMessage().setForeground(Color.red);
            viewFormAcces.getLblErrorMessage().setText("User don't exit");
            viewFormAcces.getLblErrorMessage().setVisible(true);
        } else {
            viewFormAcces.getTxtPasswordA().setText("");
            viewDepRet.setVisible(true);

            viewFormAcces.setVisible(false);
            viewFormAcces.dispose();

            String[] userDetails = userHere.split("/");
            String userResponse = userDetails[0];
            String passwordResponse = userDetails[1];
            int bank_BalanceResponse = Integer.parseInt(userDetails[2]);

            viewDepRet.getLblNameUser().setText(userResponse);
            viewDepRet.getLblSaldoUser().setText("" + bank_BalanceResponse);
        }

    }

    private void SingUp() {
        viewFormAcces.setVisible(false);
        viewRecord.setVisible(true);
    }

    private void creteUser() {

        String password = viewRecord.getTxtPasswordR().getText();
        String repeat_password = viewRecord.getTxtRepeatPasswordR().getText();

        if (viewRecord.getTxtUserR().getText().trim().isEmpty() || viewRecord.getTxtPasswordR().getText().trim().isEmpty()
                || viewRecord.getTxtRepeatPasswordR().getText().trim().isEmpty() || viewRecord.getTxtSaldo().getText().equals("")) {
            JOptionPane.showMessageDialog(viewRecord, "Empty fields", "Empty", JOptionPane.WARNING_MESSAGE);
        } else {

            if (password.equals(repeat_password)) {
                ModelUser modUser = new ModelUser();
                modUser.setUser(viewRecord.getTxtUserR().getText());
                modUser.setPassword(viewRecord.getTxtPasswordR().getText());
                modUser.setMonto(Integer.parseInt(viewRecord.getTxtSaldo().getText()));
                if (modUser.SingUp()) {
                    viewRecord.getLblMessageSuccessful().setText("Creación satisfactoria..");
                    viewRecord.getLblMessageSuccessful().setForeground(Color.blue);
                    viewRecord.getLblMessageSuccessful().setVisible(true);
                } else {
                    viewRecord.getLblMessageSuccessful().setText("Error the user exit..");
                    viewRecord.getLblMessageSuccessful().setForeground(Color.red);
                    viewRecord.getLblMessageSuccessful().setVisible(true);
                    JOptionPane.showMessageDialog(viewRecord, "Error the user exit");
                }

            } else {
                JOptionPane.showMessageDialog(viewRecord, "The password it don´t same");

            }
        }
    }

    private void IngresoRetiro() {
        String user = viewDepRet.getLblNameUser().getText();
        int bank_balance = Integer.parseInt(viewDepRet.getLblSaldoUser().getText());

        //logica con radio btnGroup
        System.out.println("Hasta aaqui esttoy llegando");
        if (viewDepRet.getGroupViewDepReg().isSelected(null)) {

            JOptionPane.showMessageDialog(viewDepRet, "Seleccione una operación.");
        } else {
            if (viewDepRet.getBtnGroupDep().isSelected()) {

                String resta = viewDepRet.getTxtValorResta().getText();

                if (resta.trim().equals("")) {
                    JOptionPane.showMessageDialog(viewDepRet, "Valor vacio", "Empty", JOptionPane.WARNING_MESSAGE);
                } else {

                    int more_bank_balance = Integer.parseInt(viewDepRet.getTxtValorResta().getText());

                    int new_bank_balance = bank_balance + more_bank_balance;

                    int result_final = modelUser.update(user, new_bank_balance);

                    if (result_final != 0) {
                        viewDepRet.getLblMessageSuccessful().setText("Depocito realizado con exito");
                        viewDepRet.getLblMessageSuccessful().setForeground(Color.blue);

                        viewDepRet.getLblMessageSuccessful().setVisible(true);
                        viewDepRet.getLblSaldoUser().setText("" + result_final);
                    } else {
                        JOptionPane.showMessageDialog(viewDepRet, "Eroor al depocitar");
                    }
                }

            }
            if (viewDepRet.getBtnGroupRet().isSelected()) {

                int putOff_bank_balance = Integer.parseInt(viewDepRet.getTxtValorResta().getText());

                if (putOff_bank_balance > bank_balance) {
                    viewDepRet.getLblMessageSuccessful().setForeground(Color.yellow);
                    viewDepRet.getLblMessageSuccessful().setText("Infringe cantidad actual");
                    viewDepRet.getLblMessageSuccessful().setVisible(true);

                    JOptionPane.showMessageDialog(viewDepRet, "Infringe cantidad actual..");
                } else {

                    int new_bank_balance = bank_balance - putOff_bank_balance;

                    int result_finalR = modelUser.update(user, new_bank_balance);

                    if (result_finalR != 0) {
                        viewDepRet.getLblMessageSuccessful().setForeground(Color.blue);
                        viewDepRet.getLblMessageSuccessful().setText("Retiro con exito..");
                        viewDepRet.getLblMessageSuccessful().setVisible(true);
                        viewDepRet.getLblSaldoUser().setText("" + result_finalR);
                    } else {
                        viewDepRet.getLblMessageSuccessful().setForeground(Color.red);
                        viewDepRet.getLblMessageSuccessful().setText("Error al retirar.");
                        viewDepRet.getLblMessageSuccessful().setVisible(true);
                        JOptionPane.showMessageDialog(viewDepRet, "Eroor al retirar");
                    }

                }
            }
        }

    }

    private void eventView() {
        KeyListener key = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c < '0' || c > '9') {
                    e.consume();
                }
                if (Character.isLetter(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(viewDepRet.getTxtValorResta(), "Just number");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        viewDepRet.getTxtValorResta().addKeyListener(key);
        viewRecord.getTxtSaldo().addKeyListener(key);
    }
}
