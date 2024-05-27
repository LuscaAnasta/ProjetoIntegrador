/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.servico;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.model.Servico;
import com.mycompany.projetointegrador.model.ServicoTabela;
import com.mycompany.projetointegrador.view.funcionario.TelaFuncionarioCadastro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class ServicoLerController {

   
    public ServicoTabela lerServicoModel(){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
    
    try {
        PreparedStatement qLinhas = banco.con.prepareStatement("SELECT COUNT(id_servico) AS total FROM tb_servico");
        ResultSet linhas = qLinhas.executeQuery();
        linhas.next(); // Mova o cursor para a primeira linha
        int nLinhas = linhas.getInt(1); // Acesse a primeira coluna pela posição do índice
        
        PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_servico");
        ResultSet resultado = lerDados.executeQuery();
        ResultSetMetaData remd = resultado.getMetaData();
        
        int colunaN = remd.getColumnCount();
        String[] nomeColuna = new String[colunaN];
        for(int c = 0; c < colunaN; c++) {
                nomeColuna[c] = remd.getColumnName(c + 1);
        }
        
        String[][] dados = new String[nLinhas][colunaN];
        int i = 0;
        while(resultado.next()) {
            for(int j = 0; j < colunaN; j++) {
               
                    dados[i][j] = resultado.getString(j + 1);
                
            }
            i++;
        }
        
        return new ServicoTabela(nomeColuna, dados);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.out.println("Algo deu Errado\n  "+ex);
            System.err.println(ex);
        }finally{
            banco.FecharConexao();
        }
        return null;
        
    }
    
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
}
