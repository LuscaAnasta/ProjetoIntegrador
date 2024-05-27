/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.funcionario;

import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class FuncionarioCadastrarController {
    public static void cadastrarFuncionario(Funcionario funcionarioModel){
        Conexao bancodds = new Conexao();
        bancodds.AbrirConexao();

        try{
            System.out.println("1");
            PreparedStatement verificarLogin = bancodds.con.prepareStatement("SELECT * FROM tb_funcionario WHERE login_funcionario = ?");
            verificarLogin.setString(1, funcionarioModel.getLogin());
            ResultSet resultado = verificarLogin.executeQuery();
            System.out.println("2");

                System.out.println("3");
                if(resultado.next()){
                    JOptionPane.showMessageDialog(null,"Login ja esta Cadastrado.");
                }else{
                    PreparedStatement inserir = bancodds.con.prepareStatement("INSERT INTO tb_funcionario(nome_funcionario,"
                            + " login_funcionario, senha_funcionario, tel_funcionario, email_funcionario)VALUES(?, ?, ?, ?, ?)");
                    inserir.setString(1, funcionarioModel.getNome());
                    inserir.setString(2, funcionarioModel.getLogin());
                    inserir.setString(3, funcionarioModel.getSenha());
                    inserir.setInt(4, funcionarioModel.getTelefone());
                    inserir.setString(5, funcionarioModel.getEmail());
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
