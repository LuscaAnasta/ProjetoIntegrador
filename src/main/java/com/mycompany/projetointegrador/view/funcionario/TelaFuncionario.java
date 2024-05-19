/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.funcionario;

import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.view.TelaInicial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author lucas.amsantos4
 */
public class TelaFuncionario extends JFrame{
    private JPanel telaFuncionario, pTabela;
    private JButton btnVoltar;
    private JButton btnCadastrar, btnDeletar, btnEditar;
    private JTable tbFuncionario;
    private JScrollPane sp;

    public TelaFuncionario(){
        
        setResizable(false);
        setTitle("Painel Funcionario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1000, 600);
        setLocationRelativeTo(null);
        
        telaFuncionario = new JPanel();
        telaFuncionario.setBackground(Color.WHITE);
        setContentPane(telaFuncionario);
        telaFuncionario.setLayout(null);
        
        pTabela = new JPanel(new BorderLayout());
        pTabela.setBackground(Color.yellow);
        pTabela.setBounds(100,50, 800, 400);
        
        telaFuncionario.add(pTabela);
        String[][] data = {};
        String[] columnNames = {};
        
        
        
        FuncionarioTabela tabela = FuncionarioLerController.lerFuncionariosModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        
        tbFuncionario = new JTable(data, columnNames);
        tbFuncionario.setFillsViewportHeight(true);
        tbFuncionario.setBounds(100,400, 800, 50);
        sp = new JScrollPane(tbFuncionario);
        
        pTabela.add(sp, BorderLayout.CENTER);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(50, 500, 100, 50);
        telaFuncionario.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x) {
                TelaInicial telai = new TelaInicial();
                telai.setVisible(true);
                dispose();
        
            }
        });
        
        btnCadastrar = new JButton("Cadastrar novo funcionario");
        btnCadastrar.setBounds(650, 10, 250, 40);
        telaFuncionario.add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                TelaFuncionarioCadastro telaCadastro = new TelaFuncionarioCadastro();
                telaCadastro.setVisible(true);
                dispose();
            }
        });
        
        btnDeletar = new JButton("Deletar funcionario");
        btnDeletar.setBounds(400, 10, 250, 40);
        telaFuncionario.add(btnDeletar);
        
        btnDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                TelaFuncionarioDeletar telaDeletar = new TelaFuncionarioDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
    }
   
    
    
}
