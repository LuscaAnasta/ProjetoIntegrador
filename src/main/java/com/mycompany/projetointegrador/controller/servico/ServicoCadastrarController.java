/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.servico;

import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ServicoCadastrarController {
    public void cadastrarServico(Servico servico){
        Conexao bancodds = new Conexao();
        bancodds.AbrirConexao();

        try{
            System.out.println("1");
            PreparedStatement verificarLogin = bancodds.con.prepareStatement("SELECT * FROM tb_servico WHERE descricao_servico = ?");
            verificarLogin.setString(1, servico.getDescricao());
            ResultSet resultado = verificarLogin.executeQuery();
            System.out.println("2");

                System.out.println("3");
                if(resultado.next()){
                    JOptionPane.showMessageDialog(null,"Serviço ja esta Cadastrado.");
                }else{
                    PreparedStatement inserir = bancodds.con.prepareStatement("INSERT INTO tb_servico(descricao_servico ,"
                            + "valor_servico )VALUES(?, ?)");
                    inserir.setString(1, servico.getDescricao());
                    inserir.setFloat(2, servico.getValor());
                    inserir.execute();
                    inserir.close();
                    JOptionPane.showMessageDialog(null,"Serviço Cadastrado com Sucesso!");
                    System.out.println("Serviço Cadastrado");   
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
