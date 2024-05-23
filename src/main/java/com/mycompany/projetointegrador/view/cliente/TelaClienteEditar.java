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
import com.mycompany.projetointegrador.model.ClienteModel;
import com.mycompany.projetointegrador.model.ClienteTabela;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.view.TelaInicial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



/**
 *
 * @author lucas
 */
public class TelaClienteEditar extends JFrame{  
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbCliente;
    private JScrollPane sp;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar;
    private JLabel lblnome, lblsenha, lblCsenha, lbltelefone, lbllogin, lblcpf, lblusuAtual; 
    private JButton btnVoltar, btnConfirmar, btnRefrescar;
    private JTextField nome_usuario,telefone_usuario, login_usuario, cpf_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    
    public TelaClienteEditar(int id){
        setResizable(false);
        setTitle("Painel Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 700);
        setLocationRelativeTo(null);
        
        pnlTela = new JPanel();
        pnlTela.setBackground(Color.WHITE);
        setContentPane(pnlTela);
        pnlTela.setLayout(null);
        
        pnlAtividade = new JPanel();
        pnlAtividade.setBackground(Color.yellow);
        pnlAtividade.setBounds(20, 300, 960, 280);
        pnlAtividade.setLayout(null);
        pnlTela.add(pnlAtividade);
        
        pnlTabela = new JPanel(new BorderLayout());
        pnlTabela.setBackground(Color.red);
        pnlTabela.setBounds(20,50, 960, 200);
        pnlTela.add(pnlTabela);
        
        
        String[][] data = {};
        String[] columnNames = {};
        
        ClienteTabela tabela = ClienteLerController.lerClienteModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        lblusuAtual =new JLabel(String.format("Editando cliente id: %d", id));
        lblusuAtual.setBounds(400, 290, 200, 10); 
        pnlTela.add(lblusuAtual);
        
        tbCliente = new JTable(data, columnNames);
        tbCliente.setFillsViewportHeight(true);
        tbCliente.setBounds(100,400, 800, 50);
        tbCliente.setRowHeight(30);
        int n = tbCliente.getColumnCount()-1;
        
        sp = new JScrollPane(tbCliente);
        
        pnlTabela.add(sp, BorderLayout.CENTER);
       
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 600, 100, 50);
        pnlTela.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnTelaCadastro = new JButton("Cadastrar cliente");
        btnTelaCadastro.setBounds(20, 10, 320, 40);
        pnlTela.add(btnTelaCadastro);
        
        btnTelaCadastro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaClienteCadastro telaCadastro = new TelaClienteCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnTelaDeletar = new JButton("Deletar cliente");
        btnTelaDeletar.setBounds(340, 10, 319, 40);
        pnlTela.add(btnTelaDeletar);
        
        btnTelaDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaClienteDeletar telaDeletar = new TelaClienteDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
        
        btnTelaEditar = new JButton("Editar cliente");
        btnTelaEditar.setBounds(659, 10, 320, 40);
        pnlTela.add(btnTelaEditar);
        
        btnTelaEditar.addActionListener(e -> {
            // Cria e mostra o ChecarEditar
            ChecarEditar dialog = new ChecarEditar(this);
        });
        
        lblnome=new JLabel("Nome Cliente");
        lblnome.setBounds(10, 50, 200, 10); 
        pnlAtividade.add(lblnome);
        
        nome_usuario = new JTextField();
        nome_usuario.setBounds(10, 60, 200, 20);
        pnlAtividade.add(nome_usuario);
        nome_usuario.setColumns(10);
        
        lblcpf=new JLabel("Cpf Cliente");
        lblcpf.setBounds(300, 50, 200, 10); 
        pnlAtividade.add(lblcpf);
        
        cpf_usuario = new JTextField();
        cpf_usuario.setBounds(300, 60, 200, 20);
        pnlAtividade.add(cpf_usuario);
        cpf_usuario.setColumns(10);
        
        lbltelefone=new JLabel("Telefone Cliente");
        lbltelefone.setBounds(590, 50, 200, 10); 
        pnlAtividade.add(lbltelefone);
        
        telefone_usuario = new JTextField();
        telefone_usuario.setBounds(590, 60, 200, 20);
        pnlAtividade.add(telefone_usuario);
        telefone_usuario.setColumns(10);
        
        btnConfirmar = new JButton("Editar Usuario");
        btnConfirmar.setBounds(300, 120, 200, 30);
        pnlAtividade.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                editarUsuario(id);
                        
                
            }
        });
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(50, 500, 100, 50);
        pnlTela.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaCliente telaFuncionario = new TelaCliente();
                telaFuncionario.setVisible(true);
                dispose();
        
            }
        });
        ClienteEditarController ler = new ClienteEditarController();
        ClienteModel inicio = new ClienteModel(id);
        preencherCampos(ler.lerCliente(inicio));
    }
    
    public void editarUsuario(int id){
        String nome = nome_usuario.getText();
        int telefone = Integer.parseInt(telefone_usuario.getText());
        String cpf = cpf_usuario.getText();
        
        ClienteEditarController editar = new ClienteEditarController();
        editar.editarCliente(new ClienteModel(id, nome, telefone, cpf));
        TelaCliente telaFuncionario = new TelaCliente();
        telaFuncionario.setVisible(true);
        dispose();
    }
    
    public void preencherCampos(ClienteModel cliente){
        
            nome_usuario.setText("");
            telefone_usuario.setText("");
            cpf_usuario.setText("");
        
            nome_usuario.setText(cliente.getNome());
            telefone_usuario.setText(String.valueOf(cliente.getTelefone()));
            cpf_usuario.setText(cliente.getCpf());

        
    }
    
   
}
