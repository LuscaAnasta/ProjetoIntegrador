/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva.caixasselecao;

import javax.swing.JComboBox;


public class BoxHorario extends JComboBox<String>{
    private String[] horarios =  {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"};
    public BoxHorario(){
        setBounds(300, 60, 200, 20);
        addItem("Selecione");
        for (String hora : horarios) {
            addItem(hora);
        }
    }
}
