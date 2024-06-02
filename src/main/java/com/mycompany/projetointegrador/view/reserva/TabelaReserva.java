/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva;

import com.mycompany.projetointegrador.view.cliente.*;
import com.mycompany.projetointegrador.controller.cliente.ClienteLerController;
import com.mycompany.projetointegrador.controller.reserva.ReservaLerController;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.Reserva;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TabelaReserva extends AbstractTableModel{
    private final List<Object[]> data;
    private final String[] columnNames = {"ID", "Nome Cliente", "CPF Cliente", "Dia","Horario","Serviço","Valor","Funcionario", " ", "  "};

    public TabelaReserva() {
        data = new ArrayList<>();
        try {
            
            ReservaLerController ler = new ReservaLerController();
            ArrayList<Reserva> reservas = ler.lerCliente();
            
            for (Reserva reserva : reservas) {
                data.add(new Object[]{reserva.getId(),reserva.getNome_cliente(), reserva.getCpf_cliente(), reserva.getDia()
                        , reserva.getHorario(), reserva.getDescricao_servico(), reserva.getValor_servico(), reserva.getNome_funcionario()
                        , "Editar", "Deletar"});
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
        return columnIndex >= 8; // Somente as colunas dos botões são editáveis
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
