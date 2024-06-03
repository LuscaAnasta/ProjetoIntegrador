/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.cliente;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClienteEditarController {
    
    private static boolean checarExistencia(Cliente cliente){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_cliente WHERE cpf_cliente = ?");
            lerDados.setString(1, cliente.getCpf());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.isBeforeFirst()){
                banco.FecharConexao(); 
                return false;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }finally{ banco.FecharConexao(); }
        return true;
    }
 
    public Cliente lerCliente(Cliente cliente){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_cliente WHERE id_cliente = ? ");
            lerDados.setInt(1, cliente.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.next()){
                
                System.out.println("1 editasr");
                String nome = banco.resultset.getString("nome_cliente");
                int telefone = banco.resultset.getInt("tel_cliente");
                String cpf = banco.resultset.getString("cpf_cliente");
                
                return new Cliente(nome, telefone, cpf);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado ");
        }finally{ banco.FecharConexao(); }
        
        return null;
    }
    
    public void editarCliente(Cliente cliente){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            if(checarExistencia(cliente)){
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
            }else{
                JOptionPane.showMessageDialog(null,"CPF ja esta Cadastrado.");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado, editar");
        }finally{ banco.FecharConexao(); }
        
    }
}
