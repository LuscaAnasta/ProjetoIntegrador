/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva.caixasselecao;

import javax.swing.JComboBox;


public class BoxDiaSemana extends JComboBox<String>{
    private String[] diasemana = {"Segunda", "Terça","Quarta","Quinta","Sexta","Sabado"};
    public BoxDiaSemana(){
        setBounds(10, 60, 200, 20);
        addItem("Selecione");
        for (String dia : diasemana) {
            addItem(dia);
        }
    }
}
