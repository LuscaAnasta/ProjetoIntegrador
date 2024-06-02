/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.funcionario;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

public class FuncionarioDeletarController {
      public void deletarFuncionario(Funcionario funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            PreparedStatement ps=banco.con.prepareStatement("DELETE FROM tb_funcionario WHERE id_funcionario = ?");
            ps.setInt(1, funcionario.getId());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Funcionario Deletado");
         
        }catch(SQLIntegrityConstraintViolationException ei){
            JOptionPane.showMessageDialog(null, "Funcionario tem reserva marcada.\nEdite ou delete reserva");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado");
            System.out.println(ex);
        }
        banco.FecharConexao();
    }
}
