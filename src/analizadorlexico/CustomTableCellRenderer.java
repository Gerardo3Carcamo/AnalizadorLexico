/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtener el valor de isCorrect de la tabla
        Boolean isCorrect = (Boolean) table.getModel().getValueAt(row, 1);

        if (isCorrect != null) {
            cellComponent.setFont(new Font("Firacode", Font.PLAIN, 16));
            if (isCorrect) {
                cellComponent.setBackground(Color.GREEN);
                cellComponent.setForeground(Color.BLACK);
            } else {
                cellComponent.setBackground(Color.RED);
                cellComponent.setForeground(Color.WHITE);
            }
        } else {
            cellComponent.setBackground(Color.WHITE);
            cellComponent.setForeground(Color.BLACK);
        }

        // Mantener el color de selección
        if (isSelected) {
            cellComponent.setBackground(Color.BLUE);
            cellComponent.setForeground(Color.WHITE);
        }

        return cellComponent;
    }
}
