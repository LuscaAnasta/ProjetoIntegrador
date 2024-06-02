/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva.caixasselecao;

import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.Funcionario;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class BoxFuncionario extends JComboBox<String>{
    public BoxFuncionario(){
        setBounds(10, 20, 200, 20);
        
        FuncionarioLerController ler = new FuncionarioLerController();
        ArrayList<Funcionario> funcionarios = ler.lerNomeFuncionario();
        addItem("Selecione");
        for (Funcionario funcionario : funcionarios) {
            addItem(funcionario.getSenha());
        }
        
    }
}
