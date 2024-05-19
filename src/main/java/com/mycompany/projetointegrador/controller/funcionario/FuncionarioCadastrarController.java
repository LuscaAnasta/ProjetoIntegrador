/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.funcionario;

import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.FuncionarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class FuncionarioCadastrarController {
    public static void cadastrarFuncionario(FuncionarioModel funcionarioModel){
        Conexao bancodds = new Conexao();
        bancodds.AbrirConexao();

        try{
            System.out.println("1");
            PreparedStatement verificarCpf = bancodds.con.prepareStatement("SELECT * FROM funcionario WHERE cpf_funcionario = ?");
            verificarCpf.setInt(1, funcionarioModel.getCpf());
            ResultSet resultado = verificarCpf.executeQuery();
            System.out.println("2");

                System.out.println("3");
                if(resultado.next()){
                    JOptionPane.showMessageDialog(null,"CPF ja esta Cadastrado.");
                }else{
                    PreparedStatement inserir = bancodds.con.prepareStatement("INSERT INTO funcionario(nome_funcionario, senha_funcionario, tel_funcionario, email_funcionario, cpf_funcionario)VALUES(?, ?, ?, ?, ?)");
                    inserir.setString(1, funcionarioModel.getNome());
                    inserir.setString(2, funcionarioModel.getSenha());
                    inserir.setInt(3, funcionarioModel.getTelefone());
                    inserir.setString(4, funcionarioModel.getEmail());
                    inserir.setInt(5, funcionarioModel.getCpf());
                    inserir.execute();
                    inserir.close();
                    JOptionPane.showMessageDialog(null,"Usuario Cadastrado com Sucesso!");
                    System.out.println("Usuario Cadastrado");   
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
