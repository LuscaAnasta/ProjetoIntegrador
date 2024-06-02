/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.cliente;
import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

public class ClienteDeletarController {
    
    public void deletarCliente(Cliente cliente){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            PreparedStatement ps=banco.con.prepareStatement("DELETE FROM tb_cliente WHERE id_cliente=?");
            ps.setInt(1, cliente.getId());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cliente Deletado");
        
        }catch(SQLIntegrityConstraintViolationException ei){
            JOptionPane.showMessageDialog(null, "Cliente tem reserva marcada.\nEdite ou delete reserva");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado");
            System.out.println(ex);
        }
        banco.FecharConexao();
    }
}
