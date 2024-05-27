/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva;

import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.reserva.ReservaLerController;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.model.ReservaTabela;
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
    private JPanel telaReserva;
    private JPanel panelTabela, panelAtividadeAtual;
    private JButton btnVoltar;
    private JButton btnCadastrar, btnDeletar, btnEditar, btnRefrescar;
    private JTable tbReserva;
    private JScrollPane sp;
    
    

    public TelaReserva(){
       
        setResizable(false);
        setTitle("Painel Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 700);
        setLocationRelativeTo(null);
        
        telaReserva = new JPanel();
        telaReserva.setBackground(Color.WHITE);
        setContentPane(telaReserva);
        telaReserva.setLayout(null);
        
        panelAtividadeAtual = new JPanel();
        panelAtividadeAtual.setBackground(Color.yellow);
        panelAtividadeAtual.setBounds(20, 300, 960, 280);
        telaReserva.add(panelAtividadeAtual);
        
        panelTabela = new JPanel(new BorderLayout());
        panelTabela.setBackground(Color.red);
        panelTabela.setBounds(20,50, 960, 200);
        telaReserva.add(panelTabela);
        
        String[][] data = {};
        String[] columnNames = {};
        
        
        ReservaLerController ler = new ReservaLerController();
        ReservaTabela tabela = ler.lerReservaModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        
        tbReserva = new JTable(data, columnNames);
        tbReserva.setFillsViewportHeight(true);
        tbReserva.setBounds(100,400, 800, 50);
        tbReserva.setRowHeight(30);
        int n = tbReserva.getColumnCount()-1;
        
        
        sp = new JScrollPane(tbReserva);
        
        panelTabela.add(sp, BorderLayout.CENTER);
       
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 600, 100, 50);
        telaReserva.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Cadastrar reserva");
        btnCadastrar.setBounds(20, 10, 320, 40);
        telaReserva.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReservaCadastro telaCadastro = new TelaReservaCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnDeletar = new JButton("Deletar reserva");
        btnDeletar.setBounds(340, 10, 319, 40);
        telaReserva.add(btnDeletar);
        
        btnDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReservaDeletar telaDeletar = new TelaReservaDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
        
        btnEditar = new JButton("Editar reserva");
        btnEditar.setBounds(659, 10, 320, 40);
        telaReserva.add(btnEditar);
        
        btnEditar.addActionListener(e -> {
            // Cria e mostra o ChecarEditar
            ChecarEditar dialog = new ChecarEditar(this);
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(20, 250, 120, 30);
        telaReserva.add(btnRefrescar);
        
        btnRefrescar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReserva novaTela = new TelaReserva();
                novaTela.setVisible(true);
                dispose();
            }
        });
    }
}
