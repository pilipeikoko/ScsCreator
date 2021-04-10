package org.bsuir.scs.view;

import org.bsuir.scs.controller.ButtonGroupListener;
import org.bsuir.scs.params.DefaultParameters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypeChooserBuilder {
    private static final int AMOUNT_OF_RADIO_BUTTONS = 3;

    private final JPanel panel;
    private final ButtonGroup buttonGroup;

    private final JRadioButton[] radioButtons;

    public TypeChooserBuilder(){
        radioButtons = new JRadioButton[AMOUNT_OF_RADIO_BUTTONS];
        panel = new JPanel();
        buttonGroup = new ButtonGroup();

        JRadioButton conceptButton = new JRadioButton("concept");
        JRadioButton nrelButton = new JRadioButton("nrel");
        JRadioButton rrelButton = new JRadioButton("rrel");

        radioButtons[0] = conceptButton;
        radioButtons[1] = nrelButton;
        radioButtons[2] = rrelButton;

        conceptButton.setActionCommand(DefaultParameters.TYPES[0]);
        nrelButton.setActionCommand(DefaultParameters.TYPES[1]);
        rrelButton.setActionCommand(DefaultParameters.TYPES[2]);


        buttonGroup.add(conceptButton);
        buttonGroup.add(nrelButton);
        buttonGroup.add(rrelButton);
        buttonGroup.getElements().nextElement().setSelected(true);

        panel.add(conceptButton);
        panel.add(nrelButton);
        panel.add(rrelButton);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(conceptButton)
                .addComponent(nrelButton)
                .addComponent(rrelButton));

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(conceptButton)
                .addComponent(nrelButton)
                .addComponent(rrelButton));
    }


    public JPanel getPanel() {
        return panel;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    /**
     * <br>[0] concept button</br>
     * <br>[1] nrel button</br>
     * <br>[2] rrel button</br>
     */
    public JRadioButton[] getRadioButtons() {
        return radioButtons;
    }
}
