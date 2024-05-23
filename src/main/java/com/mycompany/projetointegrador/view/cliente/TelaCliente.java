/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.cliente;

import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.model.ClienteTabela;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
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

/**
 *
 * @author lucas.amsantos4
 */
public class TelaCliente extends JFrame{
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
        setBounds(500, 200, 1000, 700);
        setLocationRelativeTo(null);
        
        telaCliente = new JPanel();
        telaCliente.setBackground(Color.WHITE);
        setContentPane(telaCliente);
        telaCliente.setLayout(null);
        
        panelAtividadeAtual = new JPanel();
        panelAtividadeAtual.setBackground(Color.yellow);
        panelAtividadeAtual.setBounds(20, 300, 960, 280);
        telaCliente.add(panelAtividadeAtual);
        
        panelTabela = new JPanel(new BorderLayout());
        panelTabela.setBackground(Color.red);
        panelTabela.setBounds(20,50, 960, 200);
        telaCliente.add(panelTabela);
        
        String[][] data = {};
        String[] columnNames = {};
        
        
        
        ClienteTabela tabela = ClienteLerController.lerClienteModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        
        tbCliente = new JTable(data, columnNames);
        tbCliente.setFillsViewportHeight(true);
        tbCliente.setBounds(100,400, 800, 50);
        tbCliente.setRowHeight(30);
        int n = tbCliente.getColumnCount()-1;
        
        
        sp = new JScrollPane(tbCliente);
        
        panelTabela.add(sp, BorderLayout.CENTER);
       
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 600, 100, 50);
        telaCliente.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Cadastrar cliente");
        btnCadastrar.setBounds(20, 10, 320, 40);
        telaCliente.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaClienteCadastro telaCadastro = new TelaClienteCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnDeletar = new JButton("Deletar cliente");
        btnDeletar.setBounds(340, 10, 319, 40);
        telaCliente.add(btnDeletar);
        
        btnDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaClienteDeletar telaDeletar = new TelaClienteDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
        
        btnEditar = new JButton("Editar cliente");
        btnEditar.setBounds(659, 10, 320, 40);
        telaCliente.add(btnEditar);
        
        btnEditar.addActionListener(e -> {
            // Cria e mostra o ChecarEditar
            ChecarEditar dialog = new ChecarEditar(this);
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(20, 250, 100, 30);
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
