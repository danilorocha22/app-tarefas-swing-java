package com.danilorocha.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {

    private String buttonType;
    private JLabel jLabelButton;

    public ButtonColumnCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        jLabelButton = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        jLabelButton.setHorizontalAlignment(CENTER);
        jLabelButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/" + this.buttonType
                + ".png"))));
        return jLabelButton;
    }

}
