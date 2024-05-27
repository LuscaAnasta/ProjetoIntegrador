/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.cliente;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.ClienteTabela;
import com.mycompany.projetointegrador.model.FuncionarioTabela;
import com.mycompany.projetointegrador.model.Servico;
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
public class ClienteLerController {
    public static ClienteTabela lerClienteModel(){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
    
    try {
        PreparedStatement qLinhas = banco.con.prepareStatement("SELECT COUNT(id_cliente) AS total FROM tb_cliente");
        ResultSet linhas = qLinhas.executeQuery();
        linhas.next(); // Mova o cursor para a primeira linha
        int nLinhas = linhas.getInt(1); // Acesse a primeira coluna pela posição do índice
        
        PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_cliente");
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
        
        return new ClienteTabela(nomeColuna, dados);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.out.println("Algo deu Errado\n  "+ex);
            System.err.println(ex);
        }finally{
            banco.FecharConexao();
        }
        return null;
        
    }
    
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
    
    
}
