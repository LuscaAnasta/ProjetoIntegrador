package com.mycompany.projetointegrador.view.reserva;


import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.reserva.ReservaCadastrarController;
import com.mycompany.projetointegrador.controller.reserva.ReservaLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.Funcionario;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import com.mycompany.projetointegrador.model.Reserva;
import com.mycompany.projetointegrador.model.ReservaTabela;
import com.mycompany.projetointegrador.view.TelaInicial;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxCliente;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxDiaSemana;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxFuncionario;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxHorario;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxServico;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class TelaReservaCadastro extends JFrame{
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbReserva;
    private JScrollPane sp;
    private JLabel lblfuncionario, lblcliente, lbldescricao, lbltelefone, lbldia, lblhorario;
    private JComboBox<String> cboxCliente, cboxFuncionario, cboxServico, cboxDia, cboxHorario;
    private JButton btnVoltar, btnConfirmar;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar, btnRefrescar;
    private JTextField nome_usuario,telefone_usuario, login_usuario, email_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    
    public TelaReservaCadastro(){
        
        setResizable(false);
        setTitle("Painel Reserva");
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
        
        ReservaLerController ler = new ReservaLerController();
        ReservaTabela tabela = ler.lerReservaModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        
        tbReserva = new JTable(data, columnNames);
        tbReserva.setFillsViewportHeight(true);
        tbReserva.setBounds(100,400, 800, 50);
        tbReserva.setRowHeight(30);
        int n = tbReserva.getColumnCount()-1;
        
        sp = new JScrollPane(tbReserva);
        
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
        
        btnTelaCadastro = new JButton("Cadastrar reserva");
        btnTelaCadastro.setBounds(20, 10, 320, 40);
        pnlTela.add(btnTelaCadastro);
        
        btnTelaCadastro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReservaCadastro telaCadastro = new TelaReservaCadastro();
                telaCadastro.setVisible(true);
                dispose();
                
            }
        });
        
        btnTelaDeletar = new JButton("Deletar reserva");
        btnTelaDeletar.setBounds(340, 10, 319, 40);
        pnlTela.add(btnTelaDeletar);
        
        btnTelaDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                TelaReservaDeletar telaDeletar = new TelaReservaDeletar();
                telaDeletar.setVisible(true);
                dispose();
            }
        });
        
        btnTelaEditar = new JButton("Editar reserva");
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
                
                TelaReserva novaTela = new TelaReserva();
                novaTela.setVisible(true);
                dispose();
            }
        });
        
        lblfuncionario=new JLabel("Funcionario");
        lblfuncionario.setBounds(10, 10, 200, 10); 
        pnlAtividade.add(lblfuncionario);
        
        cboxFuncionario = new BoxFuncionario();
        pnlAtividade.add(cboxFuncionario);
        
        
        lbldia=new JLabel("Dia da reserva");
        lbldia.setBounds(10, 50, 200, 10); 
        pnlAtividade.add(lbldia);
        
        cboxDia = new BoxDiaSemana();
        pnlAtividade.add(cboxDia);
        
        
        lblcliente=new JLabel("Cliente");
        lblcliente.setBounds(300, 10, 200, 10); 
        pnlAtividade.add(lblcliente);
        
        cboxCliente = new BoxCliente();
        pnlAtividade.add(cboxCliente);
        
        
        lbldescricao=new JLabel("Serviço");
        lbldescricao.setBounds(590, 10, 200, 10); 
        pnlAtividade.add(lbldescricao);
        
        cboxServico = new BoxServico();
        pnlAtividade.add(cboxServico);
        
        
        lblhorario=new JLabel("Horario da reserva");
        lblhorario.setBounds(300, 50, 200, 10); 
        pnlAtividade.add(lblhorario);
        
        cboxHorario = new BoxHorario();
        pnlAtividade.add(cboxHorario);
        
        btnConfirmar = new JButton("Reservar horario");
        btnConfirmar.setBounds(300, 120, 200, 30);
        pnlAtividade.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                cadastrar();
                        
                
            }
        });
        
        
        
        
    }
    public void cadastrar(){
        if(cboxFuncionario.getSelectedIndex() != 0){
            try{
                ReservaCadastrarController controller = new ReservaCadastrarController();
                FuncionarioLerController lerFuncionario = new FuncionarioLerController();
                ServicoLerController lerServico = new ServicoLerController();
                ClienteLerController lerCliente = new ClienteLerController();
                
                String funcionario = String.valueOf(cboxFuncionario.getSelectedItem());
                String cliente = String.valueOf(cboxCliente.getSelectedItem());
                String servico = String.valueOf(cboxServico.getSelectedItem());
                String dia = String.valueOf(cboxDia.getSelectedItem());
                String horario = String.valueOf(cboxHorario.getSelectedItem());
                
                
                controller.cadastrarReserva(new Reserva(lerCliente.lerIdCliente(cliente),
                        lerFuncionario.lerIdFuncionario(funcionario), lerServico.lerIdServico(servico), horario, dia));

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Dados Invalidos");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecione todos os campos");
        }
    }
    
   
}