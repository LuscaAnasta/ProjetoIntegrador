/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.servico;

import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioDeletarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoDeletarController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.Servico;
import com.mycompany.projetointegrador.model.ServicoTabela;
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
public class TelaServicoDeletar extends JFrame{
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbServico;
    private JScrollPane sp;
    private JLabel lblidservico, lblsenha;
    private JTextField id_servico;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar, btnRefrescar;
    private JButton btnVoltar, btnConfirmar;
    
    public TelaServicoDeletar(){
        setResizable(false);
        setTitle("Painel Serviço");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 700);
        setLocationRelativeTo(null);
        
        pnlTela = new JPanel();
        pnlTela.setBackground(Color.WHITE);
        setContentPane(pnlTela);
        pnlTela.setLayout(null);
        
        pnlAtividade = new JPanel();
        pnlAtividade.setBackground(Color.LIGHT_GRAY);
        pnlAtividade.setBounds(20, 300, 960, 280);
        pnlAtividade.setLayout(null);
        pnlTela.add(pnlAtividade);
        
        pnlTabela = new JPanel(new BorderLayout());
        pnlTabela.setBackground(Color.red);
        pnlTabela.setBounds(20,50, 960, 200);
        pnlTela.add(pnlTabela);
        
        
        String[][] data = {};
        String[] columnNames = {};
        
        ServicoLerController ler = new ServicoLerController();
        ServicoTabela tabela = ler.lerServicoModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        
        tbServico = new JTable(data, columnNames);
        tbServico.setFillsViewportHeight(true);
        tbServico.setBounds(100,400, 800, 50);
        tbServico.setRowHeight(30);
        int n = tbServico.getColumnCount()-1;
        
        sp = new JScrollPane(tbServico);
        
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
        
        btnTelaCadastro = new JButton("Cadastrar serviço");
        btnTelaCadastro.setBounds(20, 10, 320, 40);
        pnlTela.add(btnTelaCadastro);
        
        btnTelaCadastro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServicoCadastro telaCadastro = new TelaServicoCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnTelaDeletar = new JButton("Deletar serviço");
        btnTelaDeletar.setBounds(340, 10, 319, 40);
        pnlTela.add(btnTelaDeletar);
        
        btnTelaDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServicoDeletar telaDeletar = new TelaServicoDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
        
        btnTelaEditar = new JButton("Editar serviço");
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
                
                TelaServicoDeletar novaTela = new TelaServicoDeletar();
                novaTela.setVisible(true);
                dispose();
            }
        });
        
        lblidservico=new JLabel("Id serviço");
        lblidservico.setBounds(10, 50, 200, 10); 
        pnlAtividade.add(lblidservico);
        
        id_servico = new JTextField();
        id_servico.setBounds(10, 60, 200, 20);
        pnlAtividade.add(id_servico);
        id_servico.setColumns(10);
        
        btnConfirmar = new JButton("Deletar");
        btnConfirmar.setBounds(300, 60, 200, 20);
        pnlAtividade.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                  deletarServico();      
                
            }
        });
    }
    
    public void deletarServico(){
        try{
            ServicoDeletarController deletar = new ServicoDeletarController();
            int id = Integer.parseInt(id_servico.getText());
            
            deletar.deletarServico( new Servico(id));
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados invalidos");
        }
    }
}
