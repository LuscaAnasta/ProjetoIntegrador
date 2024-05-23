package com.mycompany.projetointegrador.view.servico;


import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoCadastrarController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.model.ServicoModel;
import com.mycompany.projetointegrador.model.ServicoTabela;
import com.mycompany.projetointegrador.view.TelaInicial;
import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author lucas.amsantos4
 */
public class TelaServicoCadastro extends JFrame{
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbServico;
    private JScrollPane sp;
    private JLabel lblnome, lbldescricao, lblCsenha, lblvalor, lbllogin, lblemail; 
    private JButton btnVoltar, btnConfirmar;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar, btnRefrescar;
    private JTextField nome_servico, descricao_servico, valor_servico;
    
    public TelaServicoCadastro(){
        
        setResizable(false);
        setTitle("Painel Funcionario");
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
        
        btnTelaCadastro = new JButton("Cadastrar funcionario");
        btnTelaCadastro.setBounds(20, 10, 320, 40);
        pnlTela.add(btnTelaCadastro);
        
        btnTelaCadastro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServicoCadastro telaCadastro = new TelaServicoCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnTelaDeletar = new JButton("Deletar funcionario");
        btnTelaDeletar.setBounds(340, 10, 319, 40);
        pnlTela.add(btnTelaDeletar);
        
        btnTelaDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServicoDeletar telaDeletar = new TelaServicoDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
        
        btnTelaEditar = new JButton("Editar funcionario");
        btnTelaEditar.setBounds(659, 10, 320, 40);
        pnlTela.add(btnTelaEditar);
        
        btnTelaEditar.addActionListener(e -> {
            // Cria e mostra o ChecarEditar
            ChecarEditar dialog = new ChecarEditar(this);
        });
        
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setBounds(20, 250, 100, 30);
        pnlTela.add(btnRefrescar);
        
        btnRefrescar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaServicoCadastro novaTela = new TelaServicoCadastro();
                novaTela.setVisible(true);
                dispose();
            }
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
        
        btnConfirmar = new JButton("Cadastrar");
        btnConfirmar.setBounds(590, 60, 200, 20);
        pnlAtividade.add(btnConfirmar);
        
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
       
        controller.cadastrarServico(new ServicoModel(descricao, valor));
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados Invalidos");
        }
    }
    
   
}