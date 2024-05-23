/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.cliente;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.ClienteModel;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class ClienteEditarController {
    public boolean checarExistencia(ClienteModel cliente){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_cliente WHERE id_cliente = ? ");
            lerDados.setInt(1, cliente.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.isBeforeFirst()){
                banco.FecharConexao(); 
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }finally{ banco.FecharConexao(); }
        JOptionPane.showMessageDialog(null, "Cliente Não Existe");
        return false;
    }
    
    public ClienteModel lerCliente(ClienteModel cliente){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_cliente WHERE id_cliente = ? ");
            lerDados.setInt(1, cliente.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.next()){
                
                System.out.println("1");
                String nome = banco.resultset.getString("nome_cliente");
                int telefone = banco.resultset.getInt("tel_cliente");
                String cpf = banco.resultset.getString("cpf_cliente");
                
                return new ClienteModel(nome, telefone, cpf);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado ");
        }finally{ banco.FecharConexao(); }
        
        return null;
    }
    
    public void editarCliente(ClienteModel cliente){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement atualizarDados = banco.con.prepareStatement("UPDATE tb_cliente SET nome_cliente = ?,"
                    + "tel_cliente = ?, cpf_cliente = ? "
                    + "WHERE id_cliente = ?");
            atualizarDados.setInt(4, cliente.getId());
            atualizarDados.setString(1, cliente.getNome());
            atualizarDados.setInt(2, cliente.getTelefone());
            atualizarDados.setString(3, cliente.getCpf());
            atualizarDados.execute();
            atualizarDados.close();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado, editar");
        }finally{ banco.FecharConexao(); }
        
    }
}
