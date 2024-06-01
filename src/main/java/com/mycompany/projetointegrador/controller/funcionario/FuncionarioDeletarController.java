/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.controller.funcionario;
import com.mycompany.projetointegrador.Conexao;
import com.mycompany.projetointegrador.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
/**
 *
 * @author lucas.amsantos4
 */
public class FuncionarioDeletarController {
    public boolean checarExistencia(Funcionario funcionario){
        
        Conexao banco = new Conexao();
        banco.AbrirConexao();
            try {
            PreparedStatement lerDados = banco.con.prepareStatement("SELECT * FROM tb_funcionario WHERE id_funcionario = ?");
            lerDados.setInt(1, funcionario.getId());
            banco.resultset = lerDados.executeQuery();
            if (banco.resultset.next()) { // Usando resultset.next() para verificar se há resultados
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario Não existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage()); // Mensagem de erro mais específica
            System.out.println(ex);
        } finally {
            banco.FecharConexao(); // Fechando a conexão apenas no finally
        }
        
        return false;
    }
    public void deletarFuncionario(Funcionario funcionario){
        Conexao banco = new Conexao();
        banco.AbrirConexao();
        
        try{
            
                if(checarExistencia(funcionario)){
                    PreparedStatement ps=banco.con.prepareStatement("DELETE FROM tb_funcionario WHERE id_funcionario=? AND senha_funcionario = ?");
                    ps.setInt(1, funcionario.getId());
                    ps.setString(2, funcionario.getSenha());
                    ps.execute();
                    ps.close();
                    JOptionPane.showMessageDialog(null, "Usuario Deletado");
                }
        }catch(SQLIntegrityConstraintViolationException ew){
            JOptionPane.showMessageDialog(null, "Funcionario possui reserva");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Algo deu errado");
            System.out.println(ex);
        }
        banco.FecharConexao();
    }
}
