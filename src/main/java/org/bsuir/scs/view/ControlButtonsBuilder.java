package org.bsuir.scs.view;

import javax.swing.*;

public class ControlButtonsBuilder {
    private final JPanel panel;
    private final JButton checkButton;
    private final JButton saveButton;

    public ControlButtonsBuilder(){
        panel = new JPanel();
        checkButton = new JButton("Check");
        saveButton = new JButton("Save");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(10,80,1500)
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
