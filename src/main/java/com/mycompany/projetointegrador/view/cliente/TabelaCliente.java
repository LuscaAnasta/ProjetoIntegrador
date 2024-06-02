/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.cliente;

import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelaCliente extends AbstractTableModel{
    private final List<Object[]> data;
    private final String[] columnNames = {"ID", "Nome", "Telefone", "CPF", " ", "  "};

    public TabelaCliente() {
        data = new ArrayList<>();
        try {
            
            ClienteLerController ler = new ClienteLerController();
            ArrayList<Cliente> clientes = ler.lerCliente();
            
            for (Cliente cliente : clientes) {
                data.add(new Object[]{cliente.getId(),cliente.getNome(), cliente.getTelefone(), cliente.getCpf(), "Editar", "Deletar"});
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
        return columnIndex >= 4; // Somente as colunas dos botões são editáveis
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
