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


public class FuncionarioLoginController {
    public boolean logar(Funcionario funcionario){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_funcionario "
                    + "WHERE login_funcionario = ? AND senha_funcionario = ?");
            lerDados.setString(1, funcionario.getLogin());
            lerDados.setString(2, funcionario.getSenha());
            banco.resultset = lerDados.executeQuery();
            if(banco.resultset.isBeforeFirst()){
                banco.FecharConexao(); 
                return true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }finally{ banco.FecharConexao(); }
        JOptionPane.showMessageDialog(null, "Login invalido");
        return false;
    }
}
