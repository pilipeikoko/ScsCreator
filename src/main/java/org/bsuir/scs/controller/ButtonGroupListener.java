package org.bsuir.scs.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGroupListener implements ActionListener {
    private final ButtonGroup buttonGroup;
    private final JPanel cards;

    public ButtonGroupListener(ButtonGroup buttonGroup,JPanel cards){
        this.buttonGroup = buttonGroup;
        this.cards = cards;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = buttonGroup.getSelection().getActionCommand();
        CardLayout layout = (CardLayout) (cards.getLayout());
        layout.show(cards, action);
    }

}
