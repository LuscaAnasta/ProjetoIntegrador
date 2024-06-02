/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.servico;
import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

public class ServicoDeletarController {
    public void deletarServico(Servico servico){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
            try{
                banco.stmt= banco.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                PreparedStatement ps=banco.con.prepareStatement("DELETE FROM tb_servico WHERE id_servico = ?");

                        ps.setInt(1, servico.getId());
                        ps.execute();
                        ps.close();
                        JOptionPane.showMessageDialog(null, "Serviço Deletado");

            }catch(SQLIntegrityConstraintViolationException ei){
                JOptionPane.showMessageDialog(null, "Serviço esta sendo utilizado.\nEdite ou delete reserva");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Algo deu errado");
                System.out.println(ex);
            }
        
        banco.FecharConexao();
    }
}
