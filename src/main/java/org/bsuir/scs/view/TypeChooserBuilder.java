package org.bsuir.scs.view;

import org.bsuir.scs.util.DefaultParameters;
import org.bsuir.scs.view.border.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class TypeChooserBuilder {
    private static final int AMOUNT_OF_RADIO_BUTTONS = 3;

    private final JPanel panel;
    private final ButtonGroup buttonGroup;

    private final JRadioButton[] radioButtons;
    private final JButton clearButton;

    public TypeChooserBuilder() {
        radioButtons = new JRadioButton[AMOUNT_OF_RADIO_BUTTONS];
        panel = new JPanel();
        buttonGroup = new ButtonGroup();
        //todo color
        panel.setBackground(Color.white);

        clearButton = new JButton("clear");
        clearButton.setForeground(Color.BLACK);
        clearButton.setBackground(Color.WHITE);
        clearButton.setBorder(new RoundedBorder(5));


        JRadioButton conceptButton = new JRadioButton("concept");
        JRadioButton nrelButton = new JRadioButton("nrel");
        JRadioButton rrelButton = new JRadioButton("rrel");

        //todo color
        conceptButton.setBackground(Color.white);
        nrelButton.setBackground(Color.white);
        rrelButton.setBackground(Color.white);

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
        panel.add(clearButton);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(conceptButton)
                .addComponent(nrelButton)
                .addComponent(rrelButton)
                .addComponent(clearButton)
        );

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(conceptButton)
                .addComponent(nrelButton)
                .addComponent(rrelButton)
                .addComponent(clearButton)
        );
    }


    public JPanel getPanel() {
        return panel;
    }

    public JButton getClearButton() {
        return clearButton;
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
