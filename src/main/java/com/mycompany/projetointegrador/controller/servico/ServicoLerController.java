/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.servico;

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


public class ServicoLerController {
    
    public ArrayList<Servico> lerDadosServico(){
        ArrayList<Servico> servicos = new ArrayList<>();
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT id_servico, descricao_servico FROM tb_servico");
            banco.resultset = lerDados.executeQuery();
            
            while(banco.resultset.next()){
                servicos.add(new Servico(banco.resultset.getInt("id_servico"), banco.resultset.getString("descricao_servico")));
            }
            return servicos;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.err.println(ex);
        }finally{
            banco.FecharConexao();
        }
        return null;
    }
    
    public int lerIdServico(String desc){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT id_servico FROM tb_servico WHERE descricao_servico = ?");
            lerDados.setString(1, desc);
            banco.resultset = lerDados.executeQuery();
            
            if(banco.resultset.next()){
                int id = banco.resultset.getInt("id_servico");
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
    
    public ArrayList<Servico> lerServico() throws SQLException{
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        ArrayList<Servico> servicos = new ArrayList<>();
        try{
           PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_servico"); 
           ResultSet resultado = lerDados.executeQuery();
            while (resultado.next()) {
                Servico servico = new Servico(
                        resultado.getInt("id_servico"),
                        resultado.getString("descricao_servico"), 
                        resultado.getFloat("valor_servico")
                );
                System.out.println(servico.getValor());
                servicos.add(servico);
            }
           banco.FecharConexao();
           return servicos;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.out.println(ex);
        }finally{
            banco.FecharConexao();
        }
        
        return null;
    }
}
