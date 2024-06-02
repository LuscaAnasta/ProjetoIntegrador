/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.view.reserva;

import com.mycompany.projetointegrador.view.cliente.*;
import com.mycompany.projetointegrador.controller.cliente.ClienteDeletarController;
import com.mycompany.projetointegrador.controller.reserva.ReservaDeletarController;
import com.mycompany.projetointegrador.model.Cliente;
import com.mycompany.projetointegrador.model.Reserva;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class ButtonRenderer extends JButton implements TableCellRenderer{
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private int row;
    private JPanel telaAtual;
    private JFrame tela;
    private JTable table;
    private int idColumnIndex;

    public ButtonEditor(JCheckBox checkBox, JTable table, JPanel painel, JFrame tela) {
        super(checkBox);
        this.table = table;
        this.idColumnIndex = idColumnIndex;
        this.tela = tela;
        this.telaAtual = painel;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            
            Object idValue = table.getValueAt(row, 0);
            Object nomeValue = table.getValueAt(row, 1);
            String columnName = table.getColumnName(table.getSelectedColumn());
            if (columnName.equals(" ")) {
                
                TelaReservaEditar telaEd = new TelaReservaEditar(tela, Integer.parseInt(idValue.toString()));
                telaEd.setVisible(true);
                
                
            } else if (columnName.equals("  ")) {
                // Ação ao clicar no botão Deletar
                JOptionPane del;
                int deletar = JOptionPane.showConfirmDialog(telaAtual,"Deletar "+nomeValue+"?","Deletar", 
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                
                if(deletar == JOptionPane.YES_OPTION){
                    
                    ReservaDeletarController delete = new ReservaDeletarController();
                    delete.deletarServico(new Reserva(Integer.parseInt(idValue.toString())));
                }
            }
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
