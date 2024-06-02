/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view;


import com.mycompany.projetointegrador.RoundedBorder;
import com.mycompany.projetointegrador.TelaLogin;
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
        setTitle("Tela Inicial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 600, 450);
        setLocationRelativeTo(null);
        
        telaInicial = new JPanel();
        telaInicial.setBackground(Color.WHITE);
        setContentPane(telaInicial);
        telaInicial.setLayout(null);
        
        btnCliente = new JButton("Clientes");
        btnCliente.setBounds(75, 100, 200, 100);
        btnCliente.setBorder(new RoundedBorder(10));
        telaInicial.add(btnCliente);
        
        btnFuncionario = new JButton("Funcionarios");
        btnFuncionario.setBounds(325, 100, 200, 100);
        btnFuncionario.setBorder(new RoundedBorder(10));
        telaInicial.add(btnFuncionario);
        
        btnServico = new JButton("Serviços");
        btnServico.setBounds(75, 250, 200, 100);
        btnServico.setBorder(new RoundedBorder(10));
        telaInicial.add(btnServico);
        
        btnReserva = new JButton("Reservas");
        btnReserva.setBounds(325, 250, 200, 100);
        btnReserva.setBorder(new RoundedBorder(10));
        telaInicial.add(btnReserva);
        
        
        
        btnSair = new JButton("Logout");
        btnSair.setBounds(50, 25, 100, 50);
        btnSair.setBorder(new RoundedBorder(10));
        telaInicial.add(btnSair);
        
        btnDesligar = new JButton("Encerrar");
        btnDesligar.setBounds(450, 25, 100, 50);
        btnDesligar.setBorder(new RoundedBorder(10));
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
        
        btnSair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                TelaLogin tela = new TelaLogin();
                tela.setVisible(true);
                dispose();
            }
        });
        
        
    }
}
