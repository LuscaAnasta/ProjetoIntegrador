/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.funcionario;

import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;

import com.mycompany.projetointegrador.view.TelaInicial;
import com.mycompany.projetointegrador.view.cliente.TabelaCliente;
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


public class TelaFuncionario extends JFrame{
    private JPanel telaFuncionario;
    private JPanel panelTabela, panelAtividadeAtual;
    private JButton btnVoltar;
    private JButton btnCadastrar, btnDeletar, btnEditar, btnRefrescar;
    private JTable tbFuncionario;
    private JScrollPane sp;
    
    

    public TelaFuncionario(){
       
        setResizable(false);
        setTitle("Painel Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 500);
        setLocationRelativeTo(null);
        
        telaFuncionario = new JPanel();
        telaFuncionario.setBackground(Color.WHITE);
        setContentPane(telaFuncionario);
        telaFuncionario.setLayout(null);
        
        panelTabela = new JPanel(new BorderLayout());
        panelTabela.setBackground(Color.red);
        panelTabela.setBounds(20,50, 960, 330);
        telaFuncionario.add(panelTabela);
        
        TabelaFuncionario tabela= new TabelaFuncionario();
        tbFuncionario = new JTable(tabela);
        
        tbFuncionario.getColumn(" ").setCellRenderer(new ButtonRenderer());
        tbFuncionario.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox(), tbFuncionario, telaFuncionario, this));
        tbFuncionario.getColumn("  ").setCellRenderer(new ButtonRenderer());
        tbFuncionario.getColumn("  ").setCellEditor(new ButtonEditor(new JCheckBox(), tbFuncionario, telaFuncionario, this));
        
        sp = new JScrollPane(tbFuncionario);
        
        panelTabela.add(sp, BorderLayout.CENTER);
       
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 400, 80, 30);
        telaFuncionario.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Cadastrar funcionario");
        btnCadastrar.setBounds(729, 20, 250, 30);
        telaFuncionario.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaFuncionarioCadastro telaCadastro = new TelaFuncionarioCadastro();
                telaCadastro.setVisible(true);
                
            }
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(859, 380, 120, 30);
        telaFuncionario.add(btnRefrescar);
        
        btnRefrescar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaFuncionario novaTela = new TelaFuncionario();
                novaTela.setVisible(true);
                dispose();
            }
        });
    }
}
