/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva;

import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
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
public class TelaReserva extends JFrame{
    private JPanel telaFuncionario;
    private JPanel panelTabela, panelAtividadeAtual;
    private JButton btnVoltar;
    private JButton btnCadastrar, btnDeletar, btnEditar, btnRefrescar;
    private JTable tbFuncionario;
    private JScrollPane sp;
    
    

    public TelaReserva(){
       
        setResizable(false);
        setTitle("Painel Funcionario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 700);
        setLocationRelativeTo(null);
        
        telaFuncionario = new JPanel();
        telaFuncionario.setBackground(Color.WHITE);
        setContentPane(telaFuncionario);
        telaFuncionario.setLayout(null);
        
        panelAtividadeAtual = new JPanel();
        panelAtividadeAtual.setBackground(Color.yellow);
        panelAtividadeAtual.setBounds(20, 300, 960, 280);
        telaFuncionario.add(panelAtividadeAtual);
        
        panelTabela = new JPanel(new BorderLayout());
        panelTabela.setBackground(Color.red);
        panelTabela.setBounds(20,50, 960, 200);
        telaFuncionario.add(panelTabela);
        
        String[][] data = {};
        String[] columnNames = {};
        
        
        
        FuncionarioTabela tabela = FuncionarioLerController.lerFuncionarioModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        
        tbFuncionario = new JTable(data, columnNames);
        tbFuncionario.setFillsViewportHeight(true);
        tbFuncionario.setBounds(100,400, 800, 50);
        tbFuncionario.setRowHeight(30);
        int n = tbFuncionario.getColumnCount()-1;
        
        
        sp = new JScrollPane(tbFuncionario);
        
        panelTabela.add(sp, BorderLayout.CENTER);
       
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 600, 100, 50);
        telaFuncionario.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Cadastrar funcionario");
        btnCadastrar.setBounds(20, 10, 320, 40);
        telaFuncionario.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReservaCadastro telaCadastro = new TelaReservaCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnDeletar = new JButton("Deletar funcionario");
        btnDeletar.setBounds(340, 10, 319, 40);
        telaFuncionario.add(btnDeletar);
        
        btnDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReservaDeletar telaDeletar = new TelaReservaDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
        
        btnEditar = new JButton("Editar funcionario");
        btnEditar.setBounds(659, 10, 320, 40);
        telaFuncionario.add(btnEditar);
        
        btnEditar.addActionListener(e -> {
            // Cria e mostra o ChecarEditar
            ChecarEditar dialog = new ChecarEditar(this);
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(20, 250, 100, 30);
        telaFuncionario.add(btnRefrescar);
        
        btnRefrescar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReserva novaTela = new TelaReserva();
                novaTela.setVisible(true);
                dispose();
            }
        });
    }
}
