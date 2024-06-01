/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.funcionario;

import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.Funcionario;
import com.mycompany.projetointegrador.model.Funcionario;
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
public class FuncionarioLerController {
    
    public ArrayList<Funcionario> lerNomeFuncionario(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT id_funcionario, nome_funcionario FROM tb_funcionario");
            banco.resultset = lerDados.executeQuery();
            
            while(banco.resultset.next()){
                funcionarios.add(new Funcionario(banco.resultset.getInt("id_funcionario"), banco.resultset.getString("nome_funcionario")));
            }
            return funcionarios;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.err.println(ex);
        }finally{
            banco.FecharConexao();
        }
        return null;
    }
    
    public int lerIdFuncionario(String nome){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT id_funcionario FROM tb_funcionario WHERE nome_funcionario = ?");
            lerDados.setString(1, nome);
            banco.resultset = lerDados.executeQuery();
            
            if(banco.resultset.next()){
                int id =  banco.resultset.getInt("id_funcionario");
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
    
    public ArrayList<Funcionario> lerFuncionario() throws SQLException{
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try{
           PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_funcionario"); 
           ResultSet resultado = lerDados.executeQuery();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario(
                        resultado.getInt("id_funcionario"),
                        resultado.getString("nome_funcionario"), 
                        resultado.getString("login_funcionario"), 
                        resultado.getString("senha_funcionario"),
                        resultado.getInt("tel_funcionario"),
                        resultado.getString("email_funcionario")
                );
                
                funcionarios.add(funcionario);
            }
           banco.FecharConexao();
           return funcionarios;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.out.println(ex);
        }finally{
            banco.FecharConexao();
        }
        
        return null;
    }
    
}
