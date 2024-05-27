/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.cliente;

import com.mycompany.projetointegrador.controller.cliente.ClienteDeletarController;
import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioDeletarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.ClienteTabela;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author lucas.amsantos4
 */
public class TelaClienteDeletar extends JFrame{
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbCliente;
    private JScrollPane sp;
    private JLabel lbltelefone, lblid, lblcpf;
    private JTextField telefone_usuario, id_usuario, cpf_usuario;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar, btnRefrescar;
    private JButton btnVoltar, btnConfirmar;
    
    public TelaClienteDeletar(){
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
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(20, 250, 120, 30);
        pnlTela.add(btnRefrescar);
        
        btnRefrescar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaClienteDeletar novaTela = new TelaClienteDeletar();
                novaTela.setVisible(true);
                dispose();
            }
        });
        
        lblid=new JLabel("Id Usuario");
        lblid.setBounds(10, 50, 200, 10); 
        pnlAtividade.add(lblid);
        
        id_usuario = new JTextField();
        id_usuario.setBounds(10, 60, 200, 20);
        pnlAtividade.add(id_usuario);
        id_usuario.setColumns(10);
        
        lblcpf=new JLabel("Cpf Usuario");
        lblcpf.setBounds(300, 50, 200, 10); 
        pnlAtividade.add(lblcpf);
        
        cpf_usuario = new JTextField();
        cpf_usuario.setBounds(300, 60, 200, 20);
        pnlAtividade.add(cpf_usuario);
        cpf_usuario.setColumns(10);
        
        btnConfirmar = new JButton("Deletar");
        btnConfirmar.setBounds(590, 60, 200, 20);
        pnlAtividade.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                  deletarUsuario();      
                
            }
        });
    }
    
    public void deletarUsuario(){
        try{
            ClienteDeletarController deletar = new ClienteDeletarController();
            int id = Integer.parseInt(id_usuario.getText());
            String cpf = cpf_usuario.getText();
            if(deletar.checarExistencia(new Cliente(id))){
            deletar.deletarCliente(new Cliente(id, cpf));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados invalidos");
        }
    }
}
