/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.funcionario;


import com.mycompany.projetointegrador.controller.funcionario.FuncionarioLerController;
import com.mycompany.projetointegrador.model.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelaFuncionario extends AbstractTableModel{
    private final List<Object[]> data;
    private final String[] columnNames = {"ID", "Nome","Login","Senha", "Telefone", "Email", " ", "  "};

    public TabelaFuncionario() {
        data = new ArrayList<>();
        try {
            
            FuncionarioLerController ler = new FuncionarioLerController();
            ArrayList<Funcionario> funcionarios = ler.lerFuncionario();
            
            for (Funcionario funcionario : funcionarios) {
                data.add(new Object[]{
                    funcionario.getId(),
                    funcionario.getNome(), 
                    funcionario.getLogin(),
                    funcionario.getSenha(),
                    funcionario.getTelefone(), 
                    funcionario.getEmail(),
                    "Editar", "Deletar"});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex >= data.size()) {
            return null; // ou algum valor padrão apropriado
        }
        Object[] rowData = data.get(rowIndex);
        if (columnIndex < 0 || columnIndex >= rowData.length) {
            return null; // ou algum valor padrão apropriado
        }
        return rowData[columnIndex];
    }
     public int getRowCount() {
        return data.size();
    }
   public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 6; // Somente as colunas dos botões são editáveis
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data.get(rowIndex)[columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Object getRowData(int rowIndex) {
        return data.get(rowIndex);
    }
    
    
}
