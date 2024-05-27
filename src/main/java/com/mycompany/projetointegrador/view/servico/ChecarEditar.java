/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.servico;

import com.mycompany.projetointegrador.controller.cliente.ClienteEditarController;
import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioEditarController;
import com.mycompany.projetointegrador.controller.servico.ServicoEditarController;
import com.mycompany.projetointegrador.model.Servico;
import com.mycompany.projetointegrador.view.TelaInicial;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author lucas
 */
public class ChecarEditar extends JDialog{
    public ChecarEditar(JFrame frame){
        super(frame, "Checar e Editar", true);
        
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize( 300, 120);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        
        
        
        // Cria o JLabel
        JLabel label = new JLabel("Digite o Id que deseja Editar:");
        
        // Cria o JTextField
        JTextField textField = new JTextField(20); // 20 colunas de largura
        
        // Cria o JButton
        JButton button = new JButton("Verificar");
        JButton cancelar = new JButton("Cancelar");
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                
                try{
                    int id = Integer.parseInt(textField.getText());
                    ServicoEditarController verificar = new ServicoEditarController();
                    if(verificar.checarExistencia(new Servico(id))){
                        TelaServicoEditar telaEditar = new TelaServicoEditar(id);
                        telaEditar.setVisible(true);
                        frame.dispose();
                        dispose();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Valor Invalido");
                }
                
        
            }
        });
        cancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
               
                dispose();
        
            }
        });
        
        // Adiciona os componentes ao JDialog
        add(label);
        add(textField);
        add(button);
        add(cancelar);

        // Define o comportamento de fechamento do JDialog
        
        
        // Torna o JDialog visível
        setVisible(true);
        

    }
   

    
}
