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
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class ServicoEditarController {
    public boolean checarExistencia(ServicoModel servico){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_servico WHERE id_servico = ? ");
            lerDados.setInt(1, servico.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.isBeforeFirst()){
                banco.FecharConexao(); 
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }finally{ banco.FecharConexao(); }
        JOptionPane.showMessageDialog(null, "Servico Não Existe");
        return false;
    }
    
    public ServicoModel lerServico(ServicoModel servico){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_servico WHERE id_servico = ? ");
            lerDados.setInt(1, servico.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.next()){
                
                
                String descricao = banco.resultset.getString("descricao_servico");
                float valor = banco.resultset.getFloat("valor_servico");
                
                
                return new ServicoModel(descricao, valor);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado ");
        }finally{ banco.FecharConexao(); }
        
        return null;
    }
    
    public void editarServico(ServicoModel servico){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement atualizarDados = banco.con.prepareStatement("UPDATE tb_servico SET descricao_servico = ?, valor_servico = ? "
                    + "WHERE id_servico = ?");
            atualizarDados.setInt(3, servico.getId());
            atualizarDados.setString(1, servico.getDescricao());
            atualizarDados.setFloat(2, servico.getValor());
            
            atualizarDados.execute();
            atualizarDados.close();
            JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado");
        }finally{ banco.FecharConexao(); }
        
    }
}
