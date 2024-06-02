/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.servico;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Servico;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ServicoEditarController {
    public static boolean checarExistencia(Servico servico){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_servico WHERE descricao_servico = ? AND valor_servico = ?");
            lerDados.setString(1, servico.getDescricao());
            lerDados.setFloat(2, servico.getValor());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.next()){
                banco.FecharConexao(); 
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }finally{ banco.FecharConexao(); }
        return true;
    }
    
    public Servico lerServico(Servico servico){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_servico WHERE id_servico = ? ");
            lerDados.setInt(1, servico.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.next()){
                
                
                String descricao = banco.resultset.getString("descricao_servico");
                float valor = banco.resultset.getFloat("valor_servico");
                
                
                return new Servico(descricao, valor);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado ");
        }finally{ banco.FecharConexao(); }
        
        return null;
    }
    
    public void editarServico(Servico servico){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            if(checarExistencia(servico)){
            PreparedStatement atualizarDados = banco.con.prepareStatement("UPDATE tb_servico SET descricao_servico = ?, valor_servico = ? "
                    + "WHERE id_servico = ?");
            atualizarDados.setInt(3, servico.getId());
            atualizarDados.setString(1, servico.getDescricao());
            atualizarDados.setFloat(2, servico.getValor());
            
            atualizarDados.execute();
            atualizarDados.close();
            JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Serviço ja esta Cadastrado.");
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado");
        }finally{ banco.FecharConexao(); }
        
    }
}
