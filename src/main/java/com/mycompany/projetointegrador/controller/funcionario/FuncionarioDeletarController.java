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
    public boolean checarExistencia(FuncionarioModel funcionario){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_funcionario WHERE id_funcionario = ? ");
            lerDados.setInt(1, funcionario.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.isBeforeFirst()){
                banco.FecharConexao(); 
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }finally{ banco.FecharConexao(); }
        JOptionPane.showMessageDialog(null, "Usuario Não Existe");
        return false;
    }
    public void deletarFuncionario(FuncionarioModel funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            banco.stmt= banco.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            banco.resultset = banco.stmt.executeQuery("SELECT * FROM tb_funcionario WHERE id_funcionario = '" + funcionario.getId()
                    + "' AND senha_funcionario = '"+funcionario.getSenha()+"'");
            PreparedStatement ps=banco.con.prepareStatement("DELETE FROM tb_funcionario WHERE id_funcionario=?");
            
            
                if(banco.resultset.isBeforeFirst()){
                    ps.setInt(1, funcionario.getId());
                    ps.execute();
                    ps.close();
                    JOptionPane.showMessageDialog(null, "Usuario Deletado");
                }else{
                    JOptionPane.showMessageDialog(null, "Dados Invalidos");
                }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado");
            System.out.println(ex);
        }
        banco.FecharConexao();
    }
}
