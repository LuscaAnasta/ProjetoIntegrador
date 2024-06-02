/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.servico;


import com.mycompany.projetointegrador.view.TelaInicial;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import javax.swing.JCheckBox;

/**
 *
 * @author lucas.amsantos4
 */
public class TelaServico extends JFrame{
    private JPanel telaServico;
    private JPanel panelTabela, panelAtividadeAtual;
    private JButton btnVoltar;
    private JButton btnCadastrar, btnDeletar, btnEditar, btnRefrescar;
    private JTable tbServico;
    private JScrollPane sp;
    
    

    public TelaServico(){
       
        setResizable(false);
        setTitle("Painel Serviço");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 500);
        setLocationRelativeTo(null);
        
        telaServico = new JPanel();
        telaServico.setBackground(Color.WHITE);
        setContentPane(telaServico);
        telaServico.setLayout(null);
        
        panelTabela = new JPanel(new BorderLayout());
        panelTabela.setBackground(Color.red);
        panelTabela.setBounds(20,50, 960, 330);
        telaServico.add(panelTabela);
  
        TabelaServico tabelaServico = new TabelaServico();
        tbServico = new JTable(tabelaServico);
        
        tbServico.getColumn(" ").setCellRenderer(new ButtonRenderer());
        tbServico.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox(), tbServico, telaServico, this));
        tbServico.getColumn("  ").setCellRenderer(new ButtonRenderer());
        tbServico.getColumn("  ").setCellEditor(new ButtonEditor(new JCheckBox(), tbServico, telaServico, this));
       
        sp = new JScrollPane(tbServico);
        
        panelTabela.add(sp, BorderLayout.CENTER);
       
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 400, 80, 30);
        telaServico.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Cadastrar Servico");
        btnCadastrar.setBounds(729, 20, 250, 30);
        telaServico.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServicoCadastro telaCadastro = new TelaServicoCadastro();
                telaCadastro.setVisible(true);
                
                
            }
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(859, 380, 120, 30);
        telaServico.add(btnRefrescar);
        
        btnRefrescar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServico novaTela = new TelaServico();
                novaTela.setVisible(true);
                dispose();
            }
        });
    }
}
