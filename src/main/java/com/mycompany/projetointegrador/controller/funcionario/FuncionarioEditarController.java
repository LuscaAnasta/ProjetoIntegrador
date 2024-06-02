/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.funcionario;

import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class FuncionarioEditarController {
    public static boolean checarExistencia(Funcionario funcionario){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_funcionario WHERE login_funcionario = ? ");
            lerDados.setString(1, funcionario.getLogin());
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
    
    public Funcionario lerFuncionario(Funcionario funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_funcionario WHERE id_funcionario = ? ");
            lerDados.setInt(1, funcionario.getId());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.next()){
                
                System.out.println("1");
                String nome = banco.resultset.getString("nome_funcionario");
                String login = banco.resultset.getString("login_funcionario");
                String senha = banco.resultset.getString("senha_funcionario");
                int telefone = banco.resultset.getInt("tel_funcionario");
                String email = banco.resultset.getString("email_funcionario");
                
                return new Funcionario(nome, login, senha, telefone, email);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado ");
        }finally{ banco.FecharConexao(); }
        
        return null;
    }
    
    public void editarFuncionario(Funcionario funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            if(checarExistencia(funcionario)){
                PreparedStatement atualizarDados = banco.con.prepareStatement("UPDATE tb_funcionario SET nome_funcionario=?, login_funcionario=?,"
                        + "senha_funcionario=?,tel_funcionario=?, email_funcionario=? "
                        + "WHERE id_funcionario = ?");
                atualizarDados.setInt(6, funcionario.getId());
                atualizarDados.setString(1, funcionario.getNome());
                atualizarDados.setString(2, funcionario.getLogin());
                atualizarDados.setString(3, funcionario.getSenha());
                atualizarDados.setInt(4, funcionario.getTelefone());
                atualizarDados.setString(5, funcionario.getEmail());
                atualizarDados.execute();
                atualizarDados.close();
                
                JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Login ja esta Cadastrado.");
            }
                
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado, editar");
        }finally{ banco.FecharConexao(); }
        
    }
}
