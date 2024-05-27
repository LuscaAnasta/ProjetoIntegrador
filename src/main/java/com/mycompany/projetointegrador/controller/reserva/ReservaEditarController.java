/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.reserva;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import com.mycompany.projetointegrador.model.Reserva;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class ReservaEditarController {
    public boolean checarExistencia(Reserva reserva){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_reserva WHERE id_reserva = ? ");
            lerDados.setInt(1, reserva.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.isBeforeFirst()){
                banco.FecharConexao(); 
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }finally{ banco.FecharConexao(); }
        JOptionPane.showMessageDialog(null, "Reserva Não Existe");
        return false;
    }
    
    public Reserva lerReserva(Reserva reserva){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement lerDados = banco.con.prepareStatement("select tb_cliente.nome_cliente, "
                    + "tb_funcionario.nome_funcionario, tb_servico.descricao_servico, "
                    + " tb_reserva.horario_reserva , tb_reserva.dia_semana from tb_reserva " +
                "inner join tb_cliente on tb_reserva.id_cliente = tb_cliente.id_cliente " +
                "inner join tb_funcionario on tb_reserva.id_funcionario = tb_funcionario.id_funcionario " +
                "inner join tb_servico on tb_reserva.id_servico = tb_servico.id_servico"
                    + " WHERE tb_reserva.id_reserva = ?");
            lerDados.setInt(1, reserva.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.next()){
                
                String cliente = banco.resultset.getString("nome_cliente");
                String funcionario = banco.resultset.getString("nome_funcionario");
                String servico = banco.resultset.getString("descricao_servico");
                String dia = banco.resultset.getString("dia_semana");
                String horario = banco.resultset.getString("horario_reserva");
                banco.FecharConexao();
                return new Reserva(cliente, funcionario, servico, horario, dia);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado ");
            System.out.println(ex);
        }finally{ banco.FecharConexao(); }
        
        return null;
    }
    
    public void editarReserva(Reserva reserva){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        System.out.println(reserva.getId_cliente());
        try{
            
            PreparedStatement atualizarDados = banco.con.prepareStatement("UPDATE tb_reserva SET id_funcionario = ?, id_servico = ?,"
                    + "horario_reserva = ?,dia_semana = ? "
                    + "WHERE id_reserva = ?");
            atualizarDados.setInt(5, reserva.getId());
            atualizarDados.setInt(1, reserva.getId_funcionario());
            atualizarDados.setInt(2, reserva.getId_servico());
            atualizarDados.setString(3, reserva.getHorario());
            atualizarDados.setString(4, reserva.getDia());
            atualizarDados.execute();
            atualizarDados.close();
            JOptionPane.showMessageDialog(null, "Reserva alterado com sucesso");
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Algo deu errado, editar");
        }finally{ banco.FecharConexao(); }
        
    }
}
