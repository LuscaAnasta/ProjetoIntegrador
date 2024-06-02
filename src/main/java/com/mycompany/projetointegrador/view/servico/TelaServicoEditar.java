/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.servico;

import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioEditarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoEditarController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.Servico;
import com.mycompany.projetointegrador.view.TelaInicial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class TelaServicoEditar extends JDialog{  
    
    private JPanel pnlTela;
    private JButton btnTelaCadastro, btnTelaEditar;
    private JLabel lblnome, lblvalor, lblCsenha, lbltelefone, lbllogin, lblemail, lblEditar; 
    private JButton btnVoltar, btnConfirmar, btnRefrescar;
    private JTextField descricao_servico,valor_servico, login_usuario, email_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    
    public TelaServicoEditar(JFrame frame, int id){
        super(frame, "Editar", true);
        
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize( 500, 500);
        setLocationRelativeTo(null);
        
        pnlTela = new JPanel();
        pnlTela.setBackground(Color.WHITE);
        setContentPane(pnlTela);
        pnlTela.setLayout(null);
        
        btnVoltar = new JButton("Cancelar");
        btnVoltar.setBounds(20, 420, 100, 30);
        pnlTela.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                dispose();
        
            }
        });
        
        lblEditar = new JLabel("Editar Servico", SwingConstants.CENTER);
        lblEditar.setBounds(150, 40, 200, 20);
        lblEditar.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlTela.add(lblEditar);
        
        lblnome = new JLabel("Descrição Serviço");
        lblnome.setBounds(150, 90, 200, 20);
        pnlTela.add(lblnome);

        descricao_servico = new JTextField();
        descricao_servico.setBounds(150, 120, 200, 20);
        pnlTela.add(descricao_servico);
        descricao_servico.setColumns(10);

        lblvalor = new JLabel("Valor Serviço");
        lblvalor.setBounds(150, 150, 200, 20);
        pnlTela.add(lblvalor);

        valor_servico = new JTextField();
        valor_servico.setBounds(150, 180, 200, 20);
        pnlTela.add(valor_servico);
        valor_servico.setColumns(10);

        btnConfirmar = new JButton("Editar Serviço");
        btnConfirmar.setBounds(150, 300, 200, 30);
        pnlTela.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                editarUsuario(id);
                        
                
            }
        });
        
        ServicoEditarController ler = new ServicoEditarController();
        Servico inicio = new Servico(id);
        preencherCampos(ler.lerServico(inicio));
    }
    public void editarUsuario(int id){
        try{
            String descricao = descricao_servico.getText();
            float valor = Float.parseFloat(valor_servico.getText());
            ServicoEditarController editar = new ServicoEditarController();
            editar.editarServico(new Servico(id, descricao, valor));
            dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados incorretos");
        }  
    }
    public void preencherCampos(Servico servico){
        
            descricao_servico.setText("");
            valor_servico.setText("");
            
        
            descricao_servico.setText(servico.getDescricao());
            valor_servico.setText(String.valueOf(servico.getValor()));
            
        
    }
    
   
}
