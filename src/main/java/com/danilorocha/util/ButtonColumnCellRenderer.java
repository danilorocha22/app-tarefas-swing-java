package com.danilorocha.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Objects;

public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {

    private final String buttonType;

    public ButtonColumnCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        JLabel jLabelButton = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        jLabelButton.setHorizontalAlignment(CENTER);
        jLabelButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/" + this.buttonType
                + ".png"))));
        return jLabelButton;
    }

}
