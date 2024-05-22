/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.funcionario;

import com.mycompany.projetointegrador.controller.funcionario.FuncionarioEditarController;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lucas
 */
public class TelaFuncionarioEditar extends JFrame{  
    
    private JPanel telaFuncionarioEditar;
    private JButton btnVoltar, btnConfirmar;
    
    public TelaFuncionarioEditar(){
        setResizable(false);
        setTitle("Painel Funcionario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 600);
        setLocationRelativeTo(null);
        
        telaFuncionarioEditar = new JPanel();
        telaFuncionarioEditar.setBackground(Color.WHITE);
        setContentPane(telaFuncionarioEditar);
        telaFuncionarioEditar.setLayout(null);
        
        btnConfirmar = new JButton("Cadastrar");
        btnConfirmar.setBounds(320, 210, 200, 30);
        telaFuncionarioEditar.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){      
                FuncionarioModel model = new FuncionarioModel(2, "LucasMudados","LucasLG123","senha123",99999999,"emails@elams.com");
                FuncionarioEditarController editar = new FuncionarioEditarController();
                editar.editarFuncionario(model);
                editar.lerFuncionario(2);
                System.out.println(editar.lerFuncionario(2).getLogin());
            }
        });
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(50, 500, 100, 50);
        telaFuncionarioEditar.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaFuncionario telaFuncionario = new TelaFuncionario();
                telaFuncionario.setVisible(true);
                dispose();
        
            }
        });
    }
}
