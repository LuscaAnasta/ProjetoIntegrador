/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.reserva;

import com.mycompany.projetointegrador.controller.funcionario.*;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.ReservaTabela;
import com.mycompany.projetointegrador.model.ServicoTabela;
import com.mycompany.projetointegrador.view.funcionario.TelaFuncionarioCadastro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.amsantos4
 */
public class ReservaLerController {
    
    public ReservaTabela lerReservaModel(){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
    
    try {
        PreparedStatement qLinhas = banco.con.prepareStatement("SELECT COUNT(id_reserva) AS total FROM tb_reserva");
        ResultSet linhas = qLinhas.executeQuery();
        linhas.next(); // Mova o cursor para a primeira linha
        int nLinhas = linhas.getInt(1); // Acesse a primeira coluna pela posição do índice
        
        PreparedStatement lerDados = banco.con.prepareStatement("select tb_reserva.id_reserva, tb_cliente.nome_cliente, tb_cliente.cpf_cliente,"
                + " tb_reserva.id_funcionario, tb_funcionario.nome_funcionario, tb_servico.descricao_servico,tb_servico.valor_servico, tb_reserva.horario_reserva , tb_reserva.dia_semana from tb_reserva "
                +"inner join tb_cliente on tb_reserva.id_cliente = tb_cliente.id_cliente " 
                +"inner join tb_funcionario on tb_reserva.id_funcionario = tb_funcionario.id_funcionario " 
                +"inner join tb_servico on tb_reserva.id_servico = tb_servico.id_servico");
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
        
        return new ReservaTabela(nomeColuna, dados);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Algo deu Errado.");
            System.out.println("Algo deu Errado\n  "+ex);
            System.err.println(ex);
        }finally{
            banco.FecharConexao();
        }
        return null;
        
    }
    
    
}
