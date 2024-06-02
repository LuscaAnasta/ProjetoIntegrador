package com.mycompany.projetointegrador.view.funcionario;


import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.model.Funcionario;
import com.mycompany.projetointegrador.view.TelaInicial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class TelaFuncionarioCadastro extends JFrame{
    
    private JPanel pnlTela, pnlTabela;
    private JTable tbFuncionario;
    private JScrollPane sp;
    private JLabel lblnome, lblsenha, lblCsenha, lbltelefone, lbllogin, lblemail; 
    private JButton btnVoltar, btnConfirmar;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar, btnRefrescar;
    private JTextField nome_usuario,telefone_usuario, login_usuario, email_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    
    public TelaFuncionarioCadastro(){
        
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize( 500, 500);
        setLocationRelativeTo(null);
        
        pnlTela = new JPanel();
        pnlTela.setBackground(Color.WHITE);
        setContentPane(pnlTela);
        pnlTela.setLayout(null);
        
        btnVoltar = new JButton("Cancelar");
        btnVoltar.setBounds(20, 420, 100, 30);
        pnlTela.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                
                dispose();
        
            }
        });
        
        lblnome=new JLabel("Nome Funcionario");
        lblnome.setBounds(30, 90, 200, 20);
        pnlTela.add(lblnome);
        
        nome_usuario = new JTextField();
        nome_usuario.setBounds(30, 120, 200, 20);
        pnlTela.add(nome_usuario);
        nome_usuario.setColumns(10);
        
        lbllogin=new JLabel("Login Funcionario");
        lbllogin.setBounds(30, 150, 200, 10); 
        pnlTela.add(lbllogin);
        
        login_usuario = new JTextField();
        login_usuario.setBounds(30, 180, 200, 20);
        pnlTela.add(login_usuario);
        login_usuario.setColumns(10);
        
        lblsenha=new JLabel("Nova Senha");
        lblsenha.setBounds(30, 210, 200, 10); 
        pnlTela.add(lblsenha);
        
        senha_usuario = new JPasswordField();
        senha_usuario.setBounds(30, 240, 200, 20);
        pnlTela.add(senha_usuario);
        senha_usuario.setColumns(10);
        
        lblCsenha=new JLabel("Confirmar Senha");
        lblCsenha.setBounds(270, 210, 200, 10); 
        pnlTela.add(lblCsenha);
        
        confsenha_usuario = new JPasswordField();
        confsenha_usuario.setBounds(270, 240, 200, 20); 
        pnlTela.add(confsenha_usuario);
        confsenha_usuario.setColumns(10);
        
        lblemail=new JLabel("E-mail Funcionario");
        lblemail.setBounds(270, 90, 200, 10); 
        pnlTela.add(lblemail);
        
        email_usuario = new JTextField();
        email_usuario.setBounds(270, 120, 200, 20);
        pnlTela.add(email_usuario);
        email_usuario.setColumns(10);
        
        lbltelefone=new JLabel("Telefone Funcionario");
        lbltelefone.setBounds(270, 150, 200, 10); 
        pnlTela.add(lbltelefone);
        
        telefone_usuario = new JTextField();
        telefone_usuario.setBounds(270, 180, 200, 20);
        pnlTela.add(telefone_usuario);
        telefone_usuario.setColumns(10);
        
        btnConfirmar = new JButton("Cadastrar Funcionario");
        btnConfirmar.setBounds(150, 300, 200, 30);
        pnlTela.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                cadastrar();
                        
                
            }
        });
        
        
        
        
    }
    public void cadastrar(){
        try{
            FuncionarioCadastrarController controller = new FuncionarioCadastrarController();
            String nome = nome_usuario.getText();
            String login = login_usuario.getText();
            boolean cond = senha_usuario.getText().equals(confsenha_usuario.getText());
            String senha = senha_usuario.getText();
            int telefone = Integer.parseInt(telefone_usuario.getText());
            String email = email_usuario.getText();

            controller.cadastrarFuncionario(new Funcionario(nome, login, senha, telefone, email));
            dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados Invalidos");
        }
    }
    
   
}