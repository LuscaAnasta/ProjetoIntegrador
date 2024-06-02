/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.cliente;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClienteCadastrarController {
    
    
    public void cadastrarCliente(Cliente cliente){
        Conexao bancodds = new Conexao();
        bancodds.AbrirConexao();

        try{
            System.out.println("1");
            PreparedStatement verificarLogin = bancodds.con.prepareStatement("SELECT * FROM tb_cliente WHERE cpf_cliente = ?");
            verificarLogin.setString(1, cliente.getCpf());
            ResultSet resultado = verificarLogin.executeQuery();
            System.out.println("2");

                System.out.println("3");
                if(resultado.next()){
                    JOptionPane.showMessageDialog(null,"Cliente ja esta Cadastrado.");
                }else{
                    PreparedStatement inserir = bancodds.con.prepareStatement("INSERT INTO tb_cliente(nome_cliente,"
                            + "tel_cliente, cpf_cliente)VALUES(?, ?, ?)");
                    inserir.setString(1, cliente.getNome());
                    inserir.setInt(2, cliente.getTelefone());
                    inserir.setString(3, cliente.getCpf());
                    inserir.execute();
                    inserir.close();
                    JOptionPane.showMessageDialog(null,"Cliente Cadastrado com Sucesso!");
                    System.out.println("Cliente Cadastrado");   
                }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.out.println("Algo deu Errado\n  "+ex);
            System.err.println(ex);
        }finally{
            bancodds.FecharConexao();
            System.out.println("saida");
        }
    }
}
