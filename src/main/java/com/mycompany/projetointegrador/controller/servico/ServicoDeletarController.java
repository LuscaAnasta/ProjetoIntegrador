/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.servico;
import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import com.mycompany.projetointegrador.model.ServicoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author lucas.amsantos4
 */
public class ServicoDeletarController {
    public static boolean checarExistencia(int id){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_servico WHERE id_servico = ? ");
            lerDados.setInt(1, id);
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.isBeforeFirst()){
                banco.FecharConexao(); 
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }finally{ banco.FecharConexao(); }
        JOptionPane.showMessageDialog(null, "Serviço não existe");
        return false;
    }
    public void deletarServico(ServicoModel servico){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        if(checarExistencia(servico.getId())){
            try{
                banco.stmt= banco.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                PreparedStatement ps=banco.con.prepareStatement("DELETE FROM tb_servico WHERE id_servico = ?");

                        ps.setInt(1, servico.getId());
                        ps.execute();
                        ps.close();
                        JOptionPane.showMessageDialog(null, "Serviço Deletado");


            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Algo deu errado");
                System.out.println(ex);
            }
        }
        banco.FecharConexao();
    }
}
