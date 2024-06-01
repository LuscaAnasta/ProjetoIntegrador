package com.mycompany.projetointegrador.view.funcionario;


import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.model.Funcionario;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
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
public class TelaFuncionarioCadastro extends JFrame{
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbFuncionario;
    private JScrollPane sp;
    private JLabel lblnome, lblsenha, lblCsenha, lbltelefone, lbllogin, lblemail; 
    private JButton btnVoltar, btnConfirmar;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar, btnRefrescar;
    private JTextField nome_usuario,telefone_usuario, login_usuario, email_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    
    public TelaFuncionarioCadastro(){
        
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
        
        FuncionarioLerController lerTb = new FuncionarioLerController();
        FuncionarioTabela tabela = lerTb.lerFuncionarioModel();
        
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
        tbFuncionario.setRowHeight(30);
        int n = tbFuncionario.getColumnCount()-1;
        
        sp = new JScrollPane(tbFuncionario);
        
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
                
                TelaFuncionarioCadastro telaCadastro = new TelaFuncionarioCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnTelaDeletar = new JButton("Deletar funcionario");
        btnTelaDeletar.setBounds(340, 10, 319, 40);
        pnlTela.add(btnTelaDeletar);
        
        btnTelaDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaFuncionarioDeletar telaDeletar = new TelaFuncionarioDeletar();
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
        btnRefrescar.setBounds(20, 250, 120, 30);
        pnlTela.add(btnRefrescar);
        
        btnRefrescar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaFuncionarioCadastro novaTela = new TelaFuncionarioCadastro();
                novaTela.setVisible(true);
                dispose();
            }
        });
        
        lblnome=new JLabel("Nome Usuario");
        lblnome.setBounds(10, 10, 200, 10); 
        pnlAtividade.add(lblnome);
        
        nome_usuario = new JTextField();
        nome_usuario.setBounds(10, 20, 200, 20);
        pnlAtividade.add(nome_usuario);
        nome_usuario.setColumns(10);
        
        lbllogin=new JLabel("Login Usuario");
        lbllogin.setBounds(10, 50, 200, 10); 
        pnlAtividade.add(lbllogin);
        
        login_usuario = new JTextField();
        login_usuario.setBounds(10, 60, 200, 20);
        pnlAtividade.add(login_usuario);
        login_usuario.setColumns(10);
        
        lblsenha=new JLabel("Nova Senha");
        lblsenha.setBounds(300, 10, 200, 10); 
        pnlAtividade.add(lblsenha);
        
        senha_usuario = new JPasswordField();
        senha_usuario.setBounds(300, 20, 200, 20);
        pnlAtividade.add(senha_usuario);
        senha_usuario.setColumns(10);
        
        lblCsenha=new JLabel("Confirmar Senha");
        lblCsenha.setBounds(590, 10, 200, 10); 
        pnlAtividade.add(lblCsenha);
        
        confsenha_usuario = new JPasswordField();
        confsenha_usuario.setBounds(590, 20, 200, 20); 
        pnlAtividade.add(confsenha_usuario);
        confsenha_usuario.setColumns(10);
        
        lblemail=new JLabel("E-mail Usuario");
        lblemail.setBounds(300, 50, 200, 10); 
        pnlAtividade.add(lblemail);
        
        email_usuario = new JTextField();
        email_usuario.setBounds(300, 60, 200, 20);
        pnlAtividade.add(email_usuario);
        email_usuario.setColumns(10);
        
        lbltelefone=new JLabel("Telefone Usuario");
        lbltelefone.setBounds(590, 50, 200, 10); 
        pnlAtividade.add(lbltelefone);
        
        telefone_usuario = new JTextField();
        telefone_usuario.setBounds(590, 60, 200, 20);
        pnlAtividade.add(telefone_usuario);
        telefone_usuario.setColumns(10);
        
        btnConfirmar = new JButton("Cadastrar");
        btnConfirmar.setBounds(300, 120, 200, 30);
        pnlAtividade.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                cadastrar();
                        
                
            }
        });
        
        
        
        
    }
    public void cadastrar(){
        try{
        FuncionarioCadastrarController controller = new FuncionarioCadastrarController();
        String nome = nome_usuario.getText();
        String login = login_usuario.getText();
        boolean cond = senha_usuario.getText().equals(confsenha_usuario.getText());
        String senha = senha_usuario.getText();
        int telefone = Integer.parseInt(telefone_usuario.getText());
        String email = email_usuario.getText();
       
        controller.cadastrarFuncionario(new Funcionario(nome, login, senha, telefone, email));
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados Invalidos");
        }
    }
    
   
}