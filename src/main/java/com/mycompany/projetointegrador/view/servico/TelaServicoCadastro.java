package com.mycompany.projetointegrador.view.servico;


import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoCadastrarController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.Servico;
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


public class TelaServicoCadastro extends JFrame{
    
    private JPanel pnlTela;
    private JTable tbServico;
    private JLabel lblCadastrar, lbldescricao, lblvalor; 
    private JButton btnVoltar, btnConfirmar;
    private JButton btnRefrescar;
    private JTextField descricao_servico, valor_servico;
    
    public TelaServicoCadastro(){
        
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
        
        lblCadastrar = new JLabel("Cadastrar Serviço", SwingConstants.CENTER);
        lblCadastrar.setBounds(150, 40, 200, 20);
        lblCadastrar.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlTela.add(lblCadastrar);
        
        lbldescricao = new JLabel("Descrição Serviço");
        lbldescricao.setBounds(150, 90, 200, 20);
        pnlTela.add(lbldescricao);

        descricao_servico = new JTextField();
        descricao_servico.setBounds(150, 120, 200, 20);
        pnlTela.add(descricao_servico);
        descricao_servico.setColumns(10);

        lblvalor = new JLabel("Valor Serviço");
        lblvalor.setBounds(150, 150, 200, 20);
        pnlTela.add(lblvalor);

        valor_servico = new JTextField();
        valor_servico.setBounds(150, 180, 200, 20);
        pnlTela.add(valor_servico);
        valor_servico.setColumns(10);

        btnConfirmar = new JButton("Cadastrar Serviço");
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
            ServicoCadastrarController controller = new ServicoCadastrarController();
            String descricao = descricao_servico.getText();
            float valor = Float.parseFloat(valor_servico.getText());
       
            controller.cadastrarServico(new Servico(descricao, valor));
            dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados Invalidos");
        }
    }
    
   
}