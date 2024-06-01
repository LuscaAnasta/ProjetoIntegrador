/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.cliente;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.Servico;
import com.mycompany.projetointegrador.view.funcionario.TelaFuncionarioCadastro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class ClienteLerController {
   
    
    public ArrayList<Cliente> lerDadosCliente(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT id_cliente, cpf_cliente FROM tb_cliente");
            banco.resultset = lerDados.executeQuery();
            
            while(banco.resultset.next()){
                clientes.add(new Cliente(banco.resultset.getInt("id_cliente"), banco.resultset.getString("cpf_cliente")));
            }
            return clientes;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.err.println(ex);
        }finally{
            banco.FecharConexao();
        }
        return null;
    }
    
    public int lerIdCliente(String cpf){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT id_cliente FROM tb_cliente WHERE cpf_cliente = ?");
            lerDados.setString(1, cpf);
            banco.resultset = lerDados.executeQuery();
            
            if(banco.resultset.next()){
                int id = banco.resultset.getInt("id_cliente");
                return id;
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.err.println(ex);
        }finally{
            banco.FecharConexao();
        }
        return -1;
    }
    
    public ArrayList<Cliente> lerCliente() throws SQLException{
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{
           PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_cliente"); 
           ResultSet resultado = lerDados.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(
                        resultado.getInt("id_cliente"),
                        resultado.getString("nome_cliente"), 
                        resultado.getInt("tel_cliente"), 
                        resultado.getString("cpf_cliente")
                );
                
                clientes.add(cliente);
            }
           banco.FecharConexao();
           return clientes;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.out.println(ex);
        }finally{
            banco.FecharConexao();
        }
        
        return null;
    }
    
}
