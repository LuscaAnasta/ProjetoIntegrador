/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view;


import com.mycompany.projetointegrador.view.servico.TelaServico;
import com.mycompany.projetointegrador.view.reserva.TelaReserva;
import com.mycompany.projetointegrador.view.cliente.TelaCliente;
import com.mycompany.projetointegrador.view.funcionario.TelaFuncionario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lucas.amsantos4
 */
public class TelaInicial extends JFrame{
    private JPanel telaInicial;
    private JButton btnCliente;
    private JButton btnServico;
    private JButton btnFuncionario;
    private JButton btnReserva;
    private JButton btnSair;
    private JButton btnDesligar;
    
    public TelaInicial(){
    
        setResizable(false);
        setTitle("Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 600);
        setLocationRelativeTo(null);
        
        telaInicial = new JPanel();
        telaInicial.setBackground(Color.WHITE);
        setContentPane(telaInicial);
        telaInicial.setLayout(null);
        
        btnCliente = new JButton("Clientes");
        btnCliente.setBounds(500, 100, 300, 50);
        telaInicial.add(btnCliente);
        
        btnFuncionario = new JButton("Funcionarios");
        btnFuncionario.setBounds(500, 200, 300, 50);
        telaInicial.add(btnFuncionario);
        
        btnReserva = new JButton("Reservas");
        btnReserva.setBounds(500, 300, 300, 50);
        telaInicial.add(btnReserva);
        
        btnServico = new JButton("Serviços");
        btnServico.setBounds(500, 400, 300, 50);
        telaInicial.add(btnServico);
        
        btnSair = new JButton("Sair");
        btnSair.setBounds(50, 500, 100, 50);
        telaInicial.add(btnSair);
        
        btnDesligar = new JButton("Desligar");
        btnDesligar.setBounds(50, 50, 100, 50);
        telaInicial.add(btnDesligar);
        
        btnCliente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaCliente telac = new TelaCliente();
                telac.setVisible(true);
                dispose();
            }
        } );
        
        btnFuncionario.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaFuncionario telaf = new TelaFuncionario();
                telaf.setVisible(true);
                dispose();
            }
        } );
        
        btnReserva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaReserva telar = new TelaReserva();
                telar.setVisible(true);
                dispose();
            }
        } );
        
        btnServico.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaServico telas = new TelaServico();
                telas.setVisible(true);
                dispose();
            }
        } );
        
        btnDesligar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
            System.exit(0);
            }
        });
        
        
    }
}
