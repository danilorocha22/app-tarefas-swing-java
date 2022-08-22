package com.danilorocha.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Objects;

public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {

    private String buttonType;

    public ButtonColumnCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        JLabel jLabelButton;
        jLabelButton = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        jLabelButton.setHorizontalAlignment(CENTER);
        jLabelButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/" + getButtonType()
                + ".png"))));
        return jLabelButton;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
}
