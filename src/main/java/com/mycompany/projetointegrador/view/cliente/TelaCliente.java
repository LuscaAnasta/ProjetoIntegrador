/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.cliente;

import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.view.TelaInicial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.Icon;
import javax.swing.JCheckBox;

/**
 *
 * @author lucas.amsantos4
 */
public class TelaCliente extends JFrame {
    private JPanel telaCliente;
    private JPanel panelTabela, panelAtividadeAtual;
    private JButton btnVoltar;
    private JButton btnCadastrar, btnDeletar, btnEditar, btnRefrescar;
    private JTable tbCliente;
    private JScrollPane sp;
    
    

    public TelaCliente(){
       
        setResizable(false);
        setTitle("Painel Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 500);
        setLocationRelativeTo(null);
        
        telaCliente = new JPanel();
        telaCliente.setBackground(Color.WHITE);
        setContentPane(telaCliente);
        telaCliente.setLayout(null);
        
        panelTabela = new JPanel(new BorderLayout());
        panelTabela.setBackground(Color.red);
        panelTabela.setBounds(20,50, 960, 330);
        telaCliente.add(panelTabela);
        
        TabelaCliente tabelaCliente = new TabelaCliente();
        tbCliente = new JTable(tabelaCliente);
        
        tbCliente.getColumn(" ").setCellRenderer(new ButtonRenderer());
        tbCliente.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox(), tbCliente, telaCliente, this));
        tbCliente.getColumn("  ").setCellRenderer(new ButtonRenderer());
        tbCliente.getColumn("  ").setCellEditor(new ButtonEditor(new JCheckBox(), tbCliente, telaCliente, this));
        
        sp = new JScrollPane(tbCliente);
        
        panelTabela.add(sp, BorderLayout.CENTER);
       
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 400, 80, 30);
        telaCliente.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Cadastrar cliente");
        btnCadastrar.setBounds(729, 20, 250, 30);
        telaCliente.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaClienteCadastro telaCadastro = new TelaClienteCadastro();
                telaCadastro.setVisible(true);
                
                
            }
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(859, 380, 120, 30);
        telaCliente.add(btnRefrescar);
        
        btnRefrescar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaCliente novaTela = new TelaCliente();
                novaTela.setVisible(true);
                dispose();
            }
        });
    }
}
