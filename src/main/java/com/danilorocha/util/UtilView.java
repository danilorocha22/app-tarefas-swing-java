/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danilorocha.util;

import javax.swing.*;

/**
 *
 * @author danilo
 */
public class UtilView {
    
    public static boolean checkInputs(JRootPane rootPane, String name, 
            String description) {
        
        if (name.isBlank()) {
            messageDialog(rootPane,"Informe o nome do projeto");
            return false;
        } else if (description.isBlank()) {
            messageDialog(rootPane, "Informe a descrição");
            return false;
        }
        return true;
        
    }//checkInputs
    
    public static boolean checkInputs(JRootPane rootPane, String name, 
            String description, String deadline) {
        
        if (name.isBlank()) {
            messageDialog(rootPane,"Informe o nome da tarefa");
            return false;
        } else if (description.isBlank()) {
            messageDialog(rootPane, "Informe a descrição");
            return false;
        } else if (deadline.isBlank()) {
            messageDialog(rootPane, "Informe o prazo");
            return false;
        } 
        return true;
        
    }//checkInputs
    
    public static void messageDialog(JRootPane rootPane, String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }//message
    
}
