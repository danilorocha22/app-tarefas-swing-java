package com.danilorocha.util;

import com.danilorocha.entities.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDate;

public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        JLabel jLabel;
        //Pega o componente padrão na classe pai
        jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        jLabel.setHorizontalAlignment(CENTER);

        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        Task task = taskTableModel.getTasks().get(row);

        if (task.getDeadline().isAfter(LocalDate.now())) {
            jLabel.setBackground(Color.GREEN);
        } else {
            jLabel.setBackground(Color.RED);
        }
        return jLabel;
    }

}
