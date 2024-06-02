/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva;

import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioEditarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.reserva.ReservaCadastrarController;
import com.mycompany.projetointegrador.controller.reserva.ReservaEditarController;
import com.mycompany.projetointegrador.controller.reserva.ReservaLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoLerController;
import com.mycompany.projetointegrador.model.Reserva;
import com.mycompany.projetointegrador.view.TelaInicial;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxCliente;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxDiaSemana;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxFuncionario;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxHorario;
import com.mycompany.projetointegrador.view.reserva.caixasselecao.BoxServico;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;



public class TelaReservaEditar extends JDialog{  
    
    private JPanel pnlTela, pnlTabela;
    private JTable tbReserva;
    private JScrollPane sp;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar;
    private JLabel lblfuncionario, lblcliente, lbldescricao, lbltelefone, lbldia, lblhorario, lblEditar;
    private JComboBox<String> cboxCliente, cboxFuncionario, cboxServico, cboxDia, cboxHorario;
    private JButton btnVoltar, btnConfirmar, btnRefrescar;
    private JTextField nome_usuario,telefone_usuario, login_usuario, email_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    private String nome_cliente;
    
    public TelaReservaEditar(JFrame frame, int id){
        super(frame, "Editar", true);
        
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
        
        lblEditar = new JLabel("Editar Reserva", SwingConstants.CENTER);
        lblEditar.setBounds(150, 40, 200, 20);
        lblEditar.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlTela.add(lblEditar);
        
        lblfuncionario=new JLabel("Funcionario");
        lblfuncionario.setBounds(30, 90, 200, 20);
        pnlTela.add(lblfuncionario);
        
        cboxFuncionario = new BoxFuncionario();
        cboxFuncionario.setBounds(30, 120, 200, 20);
        pnlTela.add(cboxFuncionario);
        
        
        lbldia=new JLabel("Dia da reserva");
        lbldia.setBounds(30, 150, 200, 10);  
        pnlTela.add(lbldia);
        
        cboxDia = new BoxDiaSemana();
        cboxDia.setBounds(30, 180, 200, 20);
        pnlTela.add(cboxDia);
        
        lbldescricao=new JLabel("Serviço");
        lbldescricao.setBounds(270, 90, 200, 10); 
        pnlTela.add(lbldescricao);
        
        cboxServico = new BoxServico();
        cboxServico.setBounds(270, 120, 200, 20);
        pnlTela.add(cboxServico);
        
        
        lblhorario=new JLabel("Horario da reserva");
        lblhorario.setBounds(270, 150, 200, 10);  
        pnlTela.add(lblhorario);
        
        cboxHorario = new BoxHorario();
        cboxHorario.setBounds(270, 180, 200, 20);
        pnlTela.add(cboxHorario);
        
        btnConfirmar = new JButton("Editar Reserva");
        btnConfirmar.setBounds(150, 300, 200, 30);
        pnlTela.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                
                editarUsuario(id);
                        
                
            }
        });
        
        
        ReservaEditarController ler = new ReservaEditarController();
        Reserva inicio = new Reserva(id);
        nome_cliente = ler.lerReserva(inicio).getNome_cliente();
        preencherCampos(ler.lerReserva(inicio));
    }
    public void editarUsuario(int id){
        if(cboxFuncionario.getSelectedIndex() != 0){
            try{
                ReservaEditarController editar = new ReservaEditarController();
                FuncionarioLerController lerFuncionario = new FuncionarioLerController();
                ServicoLerController lerServico = new ServicoLerController();
                ClienteLerController lerCliente = new ClienteLerController();
                
                String funcionario = String.valueOf(cboxFuncionario.getSelectedItem());
                String servico = String.valueOf(cboxServico.getSelectedItem());
                String dia = String.valueOf(cboxDia.getSelectedItem());
                String horario = String.valueOf(cboxHorario.getSelectedItem());
                System.out.println("Funcionario "+lerFuncionario.lerIdFuncionario(funcionario));
                
                editar.editarReserva(new Reserva(id, 
                        lerCliente.lerIdCliente(nome_cliente),
                        lerFuncionario.lerIdFuncionario(funcionario), 
                        lerServico.lerIdServico(servico), 
                        horario,
                        dia
                ));
                
                 dispose();
        

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Dados Invalidos");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecione todos os campos");
        }
        
        
                   
        
    }
    public void preencherCampos(Reserva reserva){
        
            cboxFuncionario.setSelectedItem(reserva.getNome_funcionario());
            cboxServico.setSelectedItem(reserva.getDescricao_servico());
            cboxDia.setSelectedItem(reserva.getDia());
            cboxHorario.setSelectedItem(reserva.getHorario());
            

        
    }
    
   
}
