package com.mycompany.projetointegrador.view.cliente;


import com.mycompany.projetointegrador.controller.cliente.ClienteCadastrarController;
import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.model.Cliente;
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
import javax.swing.SwingConstants;

/**
 *
 * @author lucas.amsantos4
 */
public class TelaClienteCadastro extends JFrame{
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbCliente;
    private JScrollPane sp;
    private JLabel lblnome, lbltelefone, lblcpf, lblCadastrar; 
    private JButton btnVoltar, btnConfirmar;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar, btnRefrescar;
    private JTextField nome_usuario,telefone_usuario, cpf_usuario;
    
    
    public TelaClienteCadastro(){
        
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
        
        lblCadastrar = new JLabel("Cadastrar Cliente", SwingConstants.CENTER);
        lblCadastrar.setBounds(150, 40, 200, 20);
        lblCadastrar.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlTela.add(lblCadastrar);
        
        lblnome = new JLabel("Nome Cliente");
        lblnome.setBounds(150, 90, 200, 20);
        pnlTela.add(lblnome);

        nome_usuario = new JTextField();
        nome_usuario.setBounds(150, 120, 200, 20);
        pnlTela.add(nome_usuario);
        nome_usuario.setColumns(10);

        lblcpf = new JLabel("Cpf Cliente");
        lblcpf.setBounds(150, 150, 200, 20);
        pnlTela.add(lblcpf);

        cpf_usuario = new JTextField();
        cpf_usuario.setBounds(150, 180, 200, 20);
        pnlTela.add(cpf_usuario);
        cpf_usuario.setColumns(10);

        lbltelefone = new JLabel("Telefone Cliente");
        lbltelefone.setBounds(150, 210, 200, 20);
        pnlTela.add(lbltelefone);

        telefone_usuario = new JTextField();
        telefone_usuario.setBounds(150, 240, 200, 20);
        pnlTela.add(telefone_usuario);
        telefone_usuario.setColumns(10);

        btnConfirmar = new JButton("Cadastrar Cliente");
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
            ClienteCadastrarController controller = new ClienteCadastrarController();
            String nome = nome_usuario.getText();
            int telefone = Integer.parseInt(telefone_usuario.getText());
            String cpf = cpf_usuario.getText();
            controller.cadastrarCliente(new Cliente(nome, telefone, cpf));
            dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados Invalidos");
        }
    }
    
   
}