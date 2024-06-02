/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva;

import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.reserva.ReservaLerController;
import com.mycompany.projetointegrador.view.TelaInicial;
import com.mycompany.projetointegrador.view.cliente.TabelaCliente;
import com.mycompany.projetointegrador.view.cliente.TelaCliente;
import com.mycompany.projetointegrador.view.cliente.TelaClienteCadastro;
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
        setBounds(500, 200, 1000, 500);
        setLocationRelativeTo(null);
        
        telaReserva = new JPanel();
        telaReserva.setBackground(Color.WHITE);
        setContentPane(telaReserva);
        telaReserva.setLayout(null);
        
        panelTabela = new JPanel(new BorderLayout());
        panelTabela.setBackground(Color.red);
        panelTabela.setBounds(20,50, 960, 330);
        telaReserva.add(panelTabela);
        
        TabelaReserva tabelaReserva = new TabelaReserva();
        tbReserva = new JTable(tabelaReserva);
        
        tbReserva.getColumn(" ").setCellRenderer(new ButtonRenderer());
        tbReserva.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox(), tbReserva, telaReserva, this));
        tbReserva.getColumn("  ").setCellRenderer(new ButtonRenderer());
        tbReserva.getColumn("  ").setCellEditor(new ButtonEditor(new JCheckBox(), tbReserva, telaReserva, this));
        
        sp = new JScrollPane(tbReserva);
        
        panelTabela.add(sp, BorderLayout.CENTER);
       
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 400, 80, 30);
        telaReserva.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Agendar Horario");
        btnCadastrar.setBounds(729, 20, 250, 30);
        telaReserva.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReservaCadastro telaCadastro = new TelaReservaCadastro();
                telaCadastro.setVisible(true);
                
                
            }
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(859, 380, 120, 30);
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
