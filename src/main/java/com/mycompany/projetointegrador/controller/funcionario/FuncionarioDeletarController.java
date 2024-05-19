/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.funcionario;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author lucas.amsantos4
 */
public class FuncionarioDeletarController {
    public void deletarFuncionario(FuncionarioModel funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            banco.stmt= banco.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            banco.resultset = banco.stmt.executeQuery("SELECT * FROM funcionario WHERE id_funcionario = '" + funcionario.getId()
                    + "' AND senha_funcionario = '"+funcionario.getSenha()+"'");
            PreparedStatement ps=banco.con.prepareStatement("DELETE FROM funcionario WHERE id_funcionario=?");
            
            
                if(banco.resultset.isBeforeFirst()){
                    ps.setInt(1, funcionario.getId());
                    ps.execute();
                    ps.close();
                    JOptionPane.showMessageDialog(null, "Usuario Deletado");
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario Não Existe");
                }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error");
            System.out.println(ex);
        }
        banco.FecharConexao();
    }
}
