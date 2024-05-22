package com.mycompany.projetointegrador.view.funcionario;


import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author lucas.amsantos4
 */
public class TelaFuncionarioCadastro extends JFrame{
    
    private JPanel telaFuncionarioCadastro;
    private JLabel lblnome, lblsenha, lblCsenha, lbltelefone, lblcpf, lblemail; 
    private JButton btnVoltar, btnConfirmar;
    private JTextField nome_usuario,telefone_usuario, login_usuario, email_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    
    public TelaFuncionarioCadastro(){
        
        setResizable(false);
        setTitle("Cadastrar Funcionario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 600);
        setLocationRelativeTo(null);
        
        telaFuncionarioCadastro = new JPanel();
        telaFuncionarioCadastro.setBackground(Color.WHITE);
        setContentPane(telaFuncionarioCadastro);
        telaFuncionarioCadastro.setLayout(null);
        
        lblnome=new JLabel("Nome Funcionario");
        lblnome.setBounds(100, 10, 200, 10); 
        telaFuncionarioCadastro.add(lblnome);
        
        nome_usuario = new JTextField();
        nome_usuario.setBounds(100, 20, 200, 20);
        telaFuncionarioCadastro.add(nome_usuario);
        nome_usuario.setColumns(10);
        
        lblsenha=new JLabel("Nova Senha");
        lblsenha.setBounds(100, 50, 200, 10); 
        telaFuncionarioCadastro.add(lblsenha);
        
        senha_usuario = new JPasswordField();
        senha_usuario.setBounds(100, 60, 200, 20);
        telaFuncionarioCadastro.add(senha_usuario);
        senha_usuario.setColumns(10);
        
        lblCsenha=new JLabel("Confirmar Senha");
        lblCsenha.setBounds(100, 90, 200, 10); 
        telaFuncionarioCadastro.add(lblCsenha);
        
        confsenha_usuario = new JPasswordField();
        confsenha_usuario.setBounds(100, 100, 200, 20);
        telaFuncionarioCadastro.add(confsenha_usuario);
        confsenha_usuario.setColumns(10);
        
        lblcpf=new JLabel("Cpf Funcionario");
        lblcpf.setBounds(100, 130, 200, 10); 
        telaFuncionarioCadastro.add(lblcpf);
        
        login_usuario = new JTextField();
        login_usuario.setBounds(100, 140, 200, 20);
        telaFuncionarioCadastro.add(login_usuario);
        login_usuario.setColumns(10);
        
        lblemail=new JLabel("E-mail Funcionario");
        lblemail.setBounds(100, 170, 200, 10); 
        telaFuncionarioCadastro.add(lblemail);
        
        email_usuario = new JTextField();
        email_usuario.setBounds(100, 180, 200, 20);
        telaFuncionarioCadastro.add(email_usuario);
        email_usuario.setColumns(10);
        
        lbltelefone=new JLabel("Telefone Funcionario");
        lbltelefone.setBounds(100, 210, 200, 10); 
        telaFuncionarioCadastro.add(lbltelefone);
        
        telefone_usuario = new JTextField();
        telefone_usuario.setBounds(100, 220, 200, 20);
        telaFuncionarioCadastro.add(telefone_usuario);
        telefone_usuario.setColumns(10);
        
        btnConfirmar = new JButton("Cadastrar");
        btnConfirmar.setBounds(320, 210, 200, 30);
        telaFuncionarioCadastro.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                cadastrar();
                        
                
            }
        });
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(50, 500, 100, 50);
        telaFuncionarioCadastro.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaFuncionario telaFuncionario = new TelaFuncionario();
                telaFuncionario.setVisible(true);
                dispose();
        
            }
        });
        
        
    }
    public void cadastrar(){
        FuncionarioCadastrarController controller = new FuncionarioCadastrarController();
        FuncionarioCadastrarController.cadastrarFuncionario(
                validarFuncionario(nome_usuario.getText().toString(), senha_usuario.getText().toString(), 
                        confsenha_usuario.getText().toString(), login_usuario.getText().toString(),
                        telefone_usuario.getText().toString(), email_usuario.getText().toString()));
    }
    public FuncionarioModel validarFuncionario(String nome, String senha, String conf_senha, String login, String telefone, String email){
        int tele = 0;
        boolean valido = true;
        if(nome.isBlank() && email.isBlank()){
            System.out.println("1");
            valido = false;
        }
        if(senha.isBlank() && !senha.equals(conf_senha) && senha.length()<8){
            System.out.println("2");
            valido = false;
        }
        if(login.isBlank() || login.length()>18){
            System.out.println("3");
            valido = false;
        }
        
        try{
        tele = Integer.parseInt(telefone);
        }catch(Exception ex){
            System.out.println("4");
            valido = false;
        }
        
        if(valido == false) {
            System.out.println("5");
            JOptionPane.showMessageDialog(null,"Dados Invalidos.");
            return null;
        }
        System.out.println("saida");
        return new FuncionarioModel(nome, login, senha, tele, email);
        
    }
   
}