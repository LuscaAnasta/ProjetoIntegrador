/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.cliente;

import com.mycompany.projetointegrador.controller.cliente.ClienteEditarController;
import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioEditarController;
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



public class TelaClienteEditar extends JDialog{  
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbCliente;
    private JScrollPane sp;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar;
    private JLabel lblnome, lblEditar, lblCsenha, lbltelefone, lbllogin, lblcpf, lblusuAtual; 
    private JButton btnVoltar, btnConfirmar, btnRefrescar;
    private JTextField nome_usuario,telefone_usuario, login_usuario, cpf_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    
    public TelaClienteEditar(JFrame frame, int id){
        
        super(frame, "Editar", true);
        
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
        
        lblEditar = new JLabel("Editar Cliente", SwingConstants.CENTER);
        lblEditar.setBounds(150, 40, 200, 20);
        lblEditar.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlTela.add(lblEditar);
        
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

        btnConfirmar = new JButton("Editar Cliente");
        btnConfirmar.setBounds(150, 300, 200, 30);
        pnlTela.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                editarUsuario(id);
                        
                
            }
        });
        
        ClienteEditarController ler = new ClienteEditarController();
        Cliente inicio = new Cliente(id);
        preencherCampos(ler.lerCliente(inicio));
    }
    
    public void editarUsuario(int id){
        String nome = nome_usuario.getText();
        int telefone = Integer.parseInt(telefone_usuario.getText());
        String cpf = cpf_usuario.getText();
        
        ClienteEditarController editar = new ClienteEditarController();
        editar.editarCliente(new Cliente(id, nome, telefone, cpf));
        dispose();
    }
    
    public void preencherCampos(Cliente cliente){
        
            nome_usuario.setText("");
            telefone_usuario.setText("");
            cpf_usuario.setText("");
        
            nome_usuario.setText(cliente.getNome());
            telefone_usuario.setText(String.valueOf(cliente.getTelefone()));
            cpf_usuario.setText(cliente.getCpf());

        
    }
    
   
}
