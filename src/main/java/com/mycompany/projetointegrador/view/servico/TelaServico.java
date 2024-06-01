/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.servico;

import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.ServicoTabela;
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
        setBounds(500, 200, 1000, 700);
        setLocationRelativeTo(null);
        
        telaServico = new JPanel();
        telaServico.setBackground(Color.WHITE);
        setContentPane(telaServico);
        telaServico.setLayout(null);
        
        panelAtividadeAtual = new JPanel();
        panelAtividadeAtual.setBackground(Color.LIGHT_GRAY);
        panelAtividadeAtual.setBounds(20, 300, 960, 280);
        telaServico.add(panelAtividadeAtual);
        
        panelTabela = new JPanel(new BorderLayout());
        panelTabela.setBackground(Color.red);
        panelTabela.setBounds(20,50, 960, 200);
        telaServico.add(panelTabela);
        
        String[][] data = {};
        String[] columnNames = {};
        
        
        ServicoLerController ler = new ServicoLerController();
        ServicoTabela tabela = ler.lerServicoModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        
        tbServico = new JTable(data, columnNames);
        tbServico.setFillsViewportHeight(true);
        tbServico.setBounds(100,400, 800, 50);
        tbServico.setRowHeight(30);
        int n = tbServico.getColumnCount()-1;
        
        
        sp = new JScrollPane(tbServico);
        
        panelTabela.add(sp, BorderLayout.CENTER);
       
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 600, 100, 50);
        telaServico.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Cadastrar serviço");
        btnCadastrar.setBounds(20, 10, 320, 40);
        telaServico.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServicoCadastro telaCadastro = new TelaServicoCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnDeletar = new JButton("Deletar serviço");
        btnDeletar.setBounds(340, 10, 319, 40);
        telaServico.add(btnDeletar);
        
        btnDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServicoDeletar telaDeletar = new TelaServicoDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
        
        btnEditar = new JButton("Editar serviço");
        btnEditar.setBounds(659, 10, 320, 40);
        telaServico.add(btnEditar);
        
        btnEditar.addActionListener(e -> {
            // Cria e mostra o ChecarEditar
            ChecarEditar dialog = new ChecarEditar(this);
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(20, 250, 120, 30);
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
