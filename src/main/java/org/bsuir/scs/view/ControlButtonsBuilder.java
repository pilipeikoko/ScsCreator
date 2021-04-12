package org.bsuir.scs.view;

import org.bsuir.scs.view.border.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class ControlButtonsBuilder {
    private final JPanel panel;
    private final JButton checkButton;
    private final JButton saveButton;

    public ControlButtonsBuilder() {

        panel = new JPanel();
        //todo color
        panel.setBackground(Color.white);

        checkButton = new JButton("Check");

        saveButton = new JButton("Save");

        saveButton.setForeground(Color.BLACK);
        saveButton.setBackground(Color.WHITE);
        checkButton.setForeground(Color.BLACK);
        checkButton.setBackground(Color.WHITE);

        checkButton.setBorder(new RoundedBorder(5));
        saveButton.setBorder(new RoundedBorder(5));

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(10, 80, 1500)
                .addComponent(checkButton)
                .addComponent(saveButton)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(checkButton)
                .addComponent(saveButton)
        );
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
