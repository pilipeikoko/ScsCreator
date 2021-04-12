package org.bsuir.scs.controller;

import org.bsuir.scs.entity.ScsEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

public class CheckViewController {
    private final ScsEntity creator;
    private final JTextArea label;
    private final JButton okButton;
    private final JButton copyButton;
    private final JLabel copiedLabel;

    public CheckViewController(ScsEntity creator, JTextArea label, JButton okButton, JButton copyButton, JLabel copiedLabel) {
        this.creator = creator;
        this.label= label;
        this.okButton = okButton;
        this.copyButton = copyButton;
        this.copiedLabel = copiedLabel;
        setOkButtonAction();
        setCopyButtonAction();
    }

    private void setCopyButtonAction() {
        copyButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copiedLabel.setVisible(true);
                Toolkit.getDefaultToolkit()
                        .getSystemClipboard()
                        .setContents(
                                new StringSelection(label.getText()),
                                null
                        );
            }
        });
    }

    private void setOkButtonAction() {
        okButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor(okButton).dispose();
            }
        });
    }
}
