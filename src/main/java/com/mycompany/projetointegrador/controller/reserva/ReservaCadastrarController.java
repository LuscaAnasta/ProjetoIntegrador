/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.reserva;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ReservaCadastrarController {
    public static void cadastrarReserva(Reserva reserva){
        Conexao bancodds = new Conexao();
        bancodds.AbrirConexao();

        try{
            System.out.println("1");
            PreparedStatement verificarLogin = bancodds.con.prepareStatement("SELECT * FROM tb_reserva "
                    + "WHERE horario_reserva = ? AND dia_semana = ? AND id_funcionario = ?");
            verificarLogin.setString(1, reserva.getHorario());
            verificarLogin.setString(2, reserva.getDia());
            verificarLogin.setInt(3, reserva.getId_funcionario());
            ResultSet resultado = verificarLogin.executeQuery();
            System.out.println("2");

                System.out.println("3");
                if(resultado.next()){
                    JOptionPane.showMessageDialog(null,"Horario ja reservado.");
                }else{
                    PreparedStatement inserir = bancodds.con.prepareStatement("INSERT INTO tb_reserva(id_cliente,"
                            + " id_funcionario, id_servico, dia_semana, horario_reserva)VALUES(?, ?, ?, ?, ?)");
                    inserir.setInt(1, reserva.getId_cliente());
                    inserir.setInt(2, reserva.getId_funcionario());
                    inserir.setInt(3, reserva.getId_servico());
                    inserir.setString(4, reserva.getDia());
                    inserir.setString(5, reserva.getHorario());
                    inserir.execute();
                    inserir.close();
                    JOptionPane.showMessageDialog(null,"Horario reservado com Sucesso!");
                    System.out.println("Cadastrado");   
                }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Dados Invalidos.");
            System.out.println("Algo deu Errado\n  "+ex);
            System.err.println(ex);
        }finally{
            bancodds.FecharConexao();
            System.out.println("saida");
        }
    }
}
