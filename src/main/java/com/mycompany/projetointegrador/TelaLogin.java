/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador;

import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLoginController;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import com.mycompany.projetointegrador.view.TelaInicial;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author lucas
 */
public class TelaLogin extends JFrame{
    private JPanel telaLogin;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JLabel lbllogin, lblsenha;
    private JButton btnLogar;
    public TelaLogin(){
        setResizable(false);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 600, 600);
        setLocationRelativeTo(null);
        
        telaLogin = new JPanel();
        telaLogin.setBackground(Color.WHITE);
        setContentPane(telaLogin);
        telaLogin.setLayout(null);
        
        lbllogin=new JLabel("Login");
        lbllogin.setBounds(200, 70, 200, 10); 
        telaLogin.add(lbllogin);
        
        txtLogin = new JTextField();
        txtLogin.setBounds(200, 90, 200, 20);
        telaLogin.add(txtLogin);
        txtLogin.setColumns(10);
        
        lblsenha=new JLabel("Nova Senha");
        lblsenha.setBounds(200, 120, 200, 10); 
        telaLogin.add(lblsenha);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(200, 140, 200, 20);
        telaLogin.add(txtSenha);
        txtSenha.setColumns(10);
        
        btnLogar = new JButton("Logar");
        btnLogar.setBounds(200, 400, 200, 30);
        telaLogin.add(btnLogar);
        
        btnLogar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
               logar(verificar());
                        
                
            }
        });
    }
    
    public boolean verificar(){
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        
        FuncionarioLoginController logar = new FuncionarioLoginController();
        return logar.logar(new FuncionarioModel(login, senha));
        
        
    }
    public void logar(boolean usuarioExiste){
        if(usuarioExiste){
            TelaInicial telaInicio = new TelaInicial();
            telaInicio.setVisible(true);
            dispose();
        }
    }
    
}
