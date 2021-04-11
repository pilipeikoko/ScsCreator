package org.bsuir.scs.view;

import org.bsuir.scs.controller.MainFrameController;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private final JFrame frame;
    private final TypeChooserBuilder typeChooserBuilder;
    private final TypeCardsBuilder typeCardsBuilder;
    private final ControlButtonsBuilder controlButtonsBuilder;

    public MainFrame() {
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }
        frame = new JFrame();
        //todo color
        frame.setBackground(Color.white);
        typeChooserBuilder = new TypeChooserBuilder();
        typeCardsBuilder = new TypeCardsBuilder();
        controlButtonsBuilder = new ControlButtonsBuilder();
        setFrame();
        new MainFrameController(typeChooserBuilder.getButtonGroup(), typeChooserBuilder.getRadioButtons(),
                typeCardsBuilder.getConceptTextFields(), typeCardsBuilder.getNrelTextFields(),
                typeCardsBuilder.getRrelTextFields(), typeCardsBuilder.getNrelCheckBoxes(), typeCardsBuilder.getRrelCheckBoxes(),
                typeCardsBuilder.getCards(),controlButtonsBuilder.getCheckButton(),controlButtonsBuilder.getSaveButton());
    }

    private void setFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(typeChooserBuilder.getPanel(),BorderLayout.WEST);
        frame.add(typeCardsBuilder.getCards(),BorderLayout.CENTER);
        frame.add(controlButtonsBuilder.getPanel(),BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}