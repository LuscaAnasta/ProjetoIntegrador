/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view;

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
public class TelaServico extends JFrame{
    
    private JPanel telaServico;
    private JButton btnVoltar;
    
    public TelaServico(){
        
        setResizable(false);
        setTitle("Painel Serviços");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 600);
        setLocationRelativeTo(null);
        
        telaServico = new JPanel();
        telaServico.setBackground(Color.WHITE);
        setContentPane(telaServico);
        telaServico.setLayout(null);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(50, 500, 100, 50);
        telaServico.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
    }
    
}
