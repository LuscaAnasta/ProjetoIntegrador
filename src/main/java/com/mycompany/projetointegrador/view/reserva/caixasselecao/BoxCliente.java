/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva.caixasselecao;

import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.Servico;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class BoxCliente extends JComboBox<String>{
    public BoxCliente(){
        setBounds(300, 20, 200, 20);
        
        ClienteLerController ler = new ClienteLerController();
        ArrayList<Cliente> clientes = ler.lerDadosCliente();
        addItem("Selecione");
        for (Cliente cliente : clientes) {
            addItem(cliente.getCpf());
        }
        
    }
}
