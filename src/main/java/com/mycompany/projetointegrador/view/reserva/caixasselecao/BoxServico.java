/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva.caixasselecao;

import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.Servico;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxServico extends JComboBox<String>{
    public BoxServico(){
        setBounds(590, 20, 200, 20);
        
        ServicoLerController lerControl = new ServicoLerController();
        ArrayList<Servico> servicos = lerControl.lerDadosServico();
        addItem("Selecione");
        for (Servico servico : servicos) {
            addItem(servico.getDescricao());
        }
        
    }
    
}
