/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.reserva;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.Reserva;
import com.mycompany.projetointegrador.view.funcionario.TelaFuncionarioCadastro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReservaLerController { 
        
    
    public ArrayList<Reserva> lerCliente() throws SQLException{
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        ArrayList<Reserva> reservas = new ArrayList<>();
        try{
           PreparedStatement lerDados = banco.con.prepareStatement(""
                + "select tb_reserva.id_reserva, tb_cliente.nome_cliente, tb_cliente.cpf_cliente, tb_reserva.dia_semana, "
                   + "tb_reserva.horario_reserva, tb_servico.descricao_servico, tb_servico.valor_servico, tb_funcionario.nome_funcionario from tb_reserva " 
                + "inner join tb_cliente on tb_reserva.id_cliente = tb_cliente.id_cliente " 
                +  "inner join tb_funcionario on tb_reserva.id_funcionario = tb_funcionario.id_funcionario " 
                +  "inner join tb_servico on tb_reserva.id_servico = tb_servico.id_servico"); 
           ResultSet resultado = lerDados.executeQuery();
            while (resultado.next()) {
                Reserva reserva = new Reserva(
                        resultado.getInt("id_reserva"),
                        resultado.getString("nome_cliente"),
                        resultado.getString("cpf_cliente"),
                        resultado.getString("nome_funcionario"), 
                        resultado.getString("descricao_servico"), 
                        resultado.getFloat("valor_servico"),
                        resultado.getString("horario_reserva"),
                        resultado.getString("dia_semana")
                );
                 reservas.add(reserva);
            }
           banco.FecharConexao();
           return reservas;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.out.println(ex);
        }finally{
            banco.FecharConexao();
        }
        
        return null;
    }
    
    
}
