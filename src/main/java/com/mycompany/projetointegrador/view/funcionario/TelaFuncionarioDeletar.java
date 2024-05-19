/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.funcionario;

import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioDeletarController;
import com.mycompany.projetointegrador.model.FuncionarioModel;
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
public class TelaFuncionarioDeletar extends JFrame{
    
    private JPanel telaFuncionarioDeletar;
    private JButton btnVoltar, btnConfirmar;
    
    public TelaFuncionarioDeletar(){
        setResizable(false);
        setTitle("Cadastrar Funcionario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 600);
        setLocationRelativeTo(null);

        telaFuncionarioDeletar = new JPanel();
        telaFuncionarioDeletar.setBackground(Color.WHITE);
        setContentPane(telaFuncionarioDeletar);
        telaFuncionarioDeletar.setLayout(null);
        
        btnConfirmar = new JButton("Cadastrar");
        btnConfirmar.setBounds(320, 210, 200, 30);
        telaFuncionarioDeletar.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){      
                FuncionarioModel model = new FuncionarioModel("senha123", 5);
                FuncionarioDeletarController deletar = new FuncionarioDeletarController();
                deletar.deletarFuncionario(model);
            }
        });
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(50, 500, 100, 50);
        telaFuncionarioDeletar.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaFuncionario telaFuncionario = new TelaFuncionario();
                telaFuncionario.setVisible(true);
                dispose();
        
            }
        });
        
    }
}
