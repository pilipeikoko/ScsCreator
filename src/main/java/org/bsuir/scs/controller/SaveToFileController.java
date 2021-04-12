package org.bsuir.scs.controller;
import org.bsuir.scs.alert.Alert;
import org.bsuir.scs.entity.ScsEntity;
import org.bsuir.scs.view.TypeCardsBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SaveToFileController {
    private final JFileChooser fileChooser;
    private final ScsEntity creator;
    /**
     * @see TypeCardsBuilder#getConceptTextFields()
     */
    private final JTextField[] conceptTextFields;
    /**
     * @see TypeCardsBuilder#getNrelTextFields()
     */
    private final JTextField[] nrelTextFields;
    /**
     * @see TypeCardsBuilder#getRrelTextFields()
     */
    private final JTextField[] rrelTextFields;
    public SaveToFileController(JFileChooser fileChooser, ScsEntity creator, JTextField[] conceptTextFields, JTextField[] nrelTextFields, JTextField[] rrelTextFields) {
        this.fileChooser = fileChooser;
        this.creator = creator;
        this.conceptTextFields = conceptTextFields;
        this.nrelTextFields = nrelTextFields;
        this.rrelTextFields = rrelTextFields;
        addActionListener();
        fileChooser.showOpenDialog(null);
    }

    private void addActionListener() {
        fileChooser.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getActionCommand().equals("ApproveSelection")) {
                    try {
                       creator.createFile(fileChooser.getSelectedFile());
                       clearTextFields();
                    } catch (IOException exception) {
                        Alert.incorrectInfoAlert("Couldn't save to file");
                    }
                }
            }
        });
    }

    private void clearTextFields() {
        for (JTextField conceptTextField : conceptTextFields) {
            conceptTextField.setText("");
        }
        for (JTextField nrelTextField : nrelTextFields) {
            nrelTextField.setText("");
        }
        for (JTextField rrelTextField : rrelTextFields) {
            rrelTextField.setText("");
        }
    }
}

