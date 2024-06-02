package com.mycompany.projetointegrador.view.reserva;


import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.reserva.ReservaCadastrarController;
import com.mycompany.projetointegrador.controller.reserva.ReservaLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.Funcionario;
import com.mycompany.projetointegrador.model.Reserva;
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
import javax.swing.JDialog;
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
    
    private JPanel pnlTela, pnlTabela;
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
        
        lblcliente=new JLabel("Cliente");
        lblcliente.setBounds(30, 90, 200, 20);
        pnlTela.add(lblcliente);
        
        cboxCliente = new BoxCliente();
        cboxCliente.setBounds(30, 120, 200, 20);
        pnlTela.add(cboxCliente);
        
        lbldescricao=new JLabel("Serviço");
        lbldescricao.setBounds(30, 150, 200, 10); 
        pnlTela.add(lbldescricao);
        
        cboxServico = new BoxServico();
        cboxServico.setBounds(30, 180, 200, 20);
        pnlTela.add(cboxServico);
        
        lblfuncionario=new JLabel("Funcionario");
        lblfuncionario.setBounds(30, 210, 200, 10);
        pnlTela.add(lblfuncionario);
        
        cboxFuncionario = new BoxFuncionario();
        cboxFuncionario.setBounds(30, 240, 200, 20);
        pnlTela.add(cboxFuncionario);
        
        lbldia=new JLabel("Dia da reserva");
        lbldia.setBounds(270, 90, 200, 10); 
        pnlTela.add(lbldia);
        
        cboxDia = new BoxDiaSemana();
        cboxDia.setBounds(270, 120, 200, 20);
        pnlTela.add(cboxDia);
        
        
        lblhorario=new JLabel("Horario da reserva");
        lblhorario.setBounds(270, 150, 200, 10); 
        pnlTela.add(lblhorario);
        
        cboxHorario = new BoxHorario();
        cboxHorario.setBounds(270, 180, 200, 20);
        pnlTela.add(cboxHorario);
        
        btnConfirmar = new JButton("Reservar horario");
        btnConfirmar.setBounds(150, 300, 200, 30);
        pnlTela.add(btnConfirmar);
        
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
                dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Dados Invalidos");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecione todos os campos");
        }
    }
    
   
}