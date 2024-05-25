/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.servico;

import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioEditarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoEditarController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.model.ServicoModel;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



/**
 *
 * @author lucas
 */
public class TelaServicoEditar extends JFrame{  
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbServico;
    private JScrollPane sp;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar;
    private JLabel lbldescricao, lblvalor, lblCsenha, lbltelefone, lbllogin, lblemail, lblusuAtual; 
    private JButton btnVoltar, btnConfirmar, btnRefrescar;
    private JTextField descricao_servico,valor_servico, login_usuario, email_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    
    public TelaServicoEditar(int id){
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
        
        ServicoTabela tabela = ServicoLerController.lerServicoModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        lblusuAtual =new JLabel(String.format("Editando serviço id: %d", id));
        lblusuAtual.setBounds(400, 290, 200, 10); 
        pnlTela.add(lblusuAtual);
        
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
        
        lbldescricao = new JLabel("Serviço");
        lbldescricao.setBounds(10, 50, 200, 10); 
        pnlAtividade.add(lbldescricao);
        
        descricao_servico = new JTextField();
        descricao_servico.setBounds(10, 60, 200, 20);
        pnlAtividade.add(descricao_servico);
        descricao_servico.setColumns(10);
        
        lblvalor=new JLabel("Valor Serviço");
        lblvalor.setBounds(300, 50, 200, 10); 
        pnlAtividade.add(lblvalor);
        
        valor_servico = new JTextField();
        valor_servico.setBounds(300, 60, 200, 20);
        pnlAtividade.add(valor_servico);
        valor_servico.setColumns(10);
        
        btnConfirmar = new JButton("Editar serviço");
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
                TelaServico telaFuncionario = new TelaServico();
                telaFuncionario.setVisible(true);
                dispose();
        
            }
        });
        
        ServicoEditarController ler = new ServicoEditarController();
        ServicoModel inicio = new ServicoModel(id);
        preencherCampos(ler.lerServico(inicio));
    }
    public void editarUsuario(int id){
        try{
            String descricao = descricao_servico.getText();
            float valor = Float.parseFloat(valor_servico.getText());
            ServicoEditarController editar = new ServicoEditarController();
            editar.editarServico(new ServicoModel(id, descricao, valor));
            TelaServico telaFuncionario = new TelaServico();
            telaFuncionario.setVisible(true);
            dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados incorretos");
        }  
    }
    public void preencherCampos(ServicoModel servico){
        
            descricao_servico.setText("");
            valor_servico.setText("");
            
        
            descricao_servico.setText(servico.getDescricao());
            valor_servico.setText(String.valueOf(servico.getValor()));
            
        
    }
    
   
}
