/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.funcionario;

import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class FuncionarioEditarController {
    public boolean checarExistencia(FuncionarioModel funcionario){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM funcionario WHERE id_funcionario = '"
                +funcionario.getId()+"'");
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
    public FuncionarioModel lerFuncionario(int id_funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT FROM tb_funcionario WHERE id_funcionario = '"
                    +id_funcionario+"'");
            banco.resultset = lerDados.executeQuery();
            banco.resultset.next();
            String nome = banco.resultset.getString("nome_funcionario");
            String login = banco.resultset.getString("login_funcionario");
            String senha = banco.resultset.getString("senha_funcionario)");
            int telefone = banco.resultset.getInt("tel_funcionario");
            String email = banco.resultset.getString("email_funcionario");
            
            return new FuncionarioModel(nome, login, senha, telefone, email);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado");
        }finally{ banco.FecharConexao(); }
        
        return null;
    }
    public void editarFuncionario(FuncionarioModel funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement atualizarDados = banco.con.prepareStatement("UPDATE tb_funcionario SET nome_funcionario=?, login_funcionario=?,"
                    + "senha_funcionario=?,tel_funcionario=?, email_funcionario=? "
                    + "WHERE id_funcionario = '"+funcionario.getId()+"'");
            atualizarDados.setString(1, funcionario.getNome());
            atualizarDados.setString(2, funcionario.getLogin());
            atualizarDados.setString(3, funcionario.getSenha());
            atualizarDados.setInt(4, funcionario.getTelefone());
            atualizarDados.setString(5, funcionario.getEmail());
            atualizarDados.execute();
            atualizarDados.close();
            JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado");
        }finally{ banco.FecharConexao(); }
        
    }
}
