/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva;

import com.mycompany.projetointegrador.view.funcionario.*;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioCadastrarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioDeletarController;
import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.controller.reserva.ReservaDeletarController;
import com.mycompany.projetointegrador.controller.reserva.ReservaLerController;
import com.mycompany.projetointegrador.controller.servico.ServicoDeletarController;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.model.Reserva;
import com.mycompany.projetointegrador.model.ReservaTabela;
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
public class TelaReservaDeletar extends JFrame{
    
    private JPanel pnlTela, pnlAtividade, pnlTabela;
    private JTable tbReserva;
    private JScrollPane sp;
    private JLabel lblidreserva, lblid, lblsenha;
    private JTextField telefone_usuario, id_reserva, senha_usuario;
    private JButton btnTelaCadastro, btnTelaDeletar, btnTelaEditar, btnRefrescar;
    private JButton btnVoltar, btnConfirmar;
    
    public TelaReservaDeletar(){
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
        
        lblidreserva=new JLabel("Id reserva");
        lblidreserva.setBounds(10, 50, 200, 10); 
        pnlAtividade.add(lblidreserva);
        
        id_reserva = new JTextField();
        id_reserva.setBounds(10, 60, 200, 20);
        pnlAtividade.add(id_reserva);
        id_reserva.setColumns(10);
        
        btnConfirmar = new JButton("Deletar");
        btnConfirmar.setBounds(590, 60, 200, 20);
        pnlAtividade.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent x){
                  deletarUsuario();      
                
            }
        });
    }
    
    public void deletarUsuario(){
        try{
            ReservaDeletarController deletar = new ReservaDeletarController();
            int id = Integer.parseInt(id_reserva.getText());
            
            deletar.deletarServico( new Reserva(id));
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Dados invalidos");
        }
    }
}
