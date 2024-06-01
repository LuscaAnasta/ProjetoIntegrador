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
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.model.Reserva;
import com.mycompany.projetointegrador.model.ReservaTabela;
import com.mycompany.projetointegrador.view.TelaInicial;
import com.mycompany.projetointegrador.view.caixasselecao.BoxCliente;
import com.mycompany.projetointegrador.view.caixasselecao.BoxDiaSemana;
import com.mycompany.projetointegrador.view.caixasselecao.BoxFuncionario;
import com.mycompany.projetointegrador.view.caixasselecao.BoxHorario;
import com.mycompany.projetointegrador.view.caixasselecao.BoxServico;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author lucas
 */
public class TelaReservaEditar extends JFrame{  
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbReserva;
    private JScrollPane sp;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar;
    private JLabel lblfuncionario, lblcliente, lbldescricao, lbltelefone, lbldia, lblhorario, lblusuAtual;
    private JComboBox<String> cboxCliente, cboxFuncionario, cboxServico, cboxDia, cboxHorario;
    private JButton btnVoltar, btnConfirmar, btnRefrescar;
    private JTextField nome_usuario,telefone_usuario, login_usuario, email_usuario;
    private JPasswordField  senha_usuario, confsenha_usuario;
    private String nome_cliente;
    
    public TelaReservaEditar(int id){
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
        
        ReservaLerController lerTb = new ReservaLerController();
        ReservaTabela tabela = lerTb.lerReservaModel();
        if(tabela != null){
            tabela.getDados();
            data = tabela.getDados();
            columnNames = tabela.getNomeColunas();
        }else{
             JOptionPane.showMessageDialog(null,"Modelo null.");
        }
        
        lblusuAtual =new JLabel(String.format("Editando reserva id: %d", id));
        lblusuAtual.setBounds(400, 290, 200, 10); 
        pnlTela.add(lblusuAtual);
        
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
        
        lbldescricao=new JLabel("Serviço");
        lbldescricao.setBounds(300, 10, 200, 10); 
        pnlAtividade.add(lbldescricao);
        
        cboxServico = new BoxServico();
        cboxServico.setBounds(300, 20, 200, 20);
        pnlAtividade.add(cboxServico);
        
        
        lblhorario=new JLabel("Horario da reserva");
        lblhorario.setBounds(300, 50, 200, 10); 
        pnlAtividade.add(lblhorario);
        
        cboxHorario = new BoxHorario();
        pnlAtividade.add(cboxHorario);
        
        btnConfirmar = new JButton("Editar Usuario");
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
                TelaReserva telaReserva = new TelaReserva();
                telaReserva.setVisible(true);
                dispose();
        
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
                
                 TelaReserva telaFuncionario = new TelaReserva();
                 telaFuncionario.setVisible(true);
                 dispose();
        

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Dados Invalidos");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecione todos os campos");
        }
        
        
            FuncionarioEditarController editar = new FuncionarioEditarController();
           // editar.editarReserva(new FuncionarioModel(id, nome, login, senha, telefone, email));
            TelaReserva telaFuncionario = new TelaReserva();
            telaFuncionario.setVisible(true);
            dispose();
        
    }
    public void preencherCampos(Reserva reserva){
        
            cboxFuncionario.setSelectedItem(reserva.getNome_funcionario());
            cboxServico.setSelectedItem(reserva.getDescricao_servico());
            cboxDia.setSelectedItem(reserva.getDia());
            cboxHorario.setSelectedItem(reserva.getHorario());
            

        
    }
    
   
}
