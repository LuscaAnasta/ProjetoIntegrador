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
            if(banco.resultset.isBeforeFirst())return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro");
        }
        JOptionPane.showMessageDialog(null, "Usuario Não Existe");
        return false;
    }
    public FuncionarioModel lerFuncionario(FuncionarioModel funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM funcionario WHERE id_funcionario = '"
                    +funcionario.getId()+"'");
            banco.resultset = lerDados.executeQuery();
            
            
        }catch(Exception ex){
            
        }
        return funcionario;
    }
}
