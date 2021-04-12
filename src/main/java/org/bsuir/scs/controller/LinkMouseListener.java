package org.bsuir.scs.controller;

import org.bsuir.scs.alert.Alert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LinkMouseListener {
    private static String DEFAULT_TEXT;

    public LinkMouseListener(JLabel link) {
        DEFAULT_TEXT = link.getText();
        addLinkMouseListener(link);
    }

    private void addLinkMouseListener(JLabel link) {
        link.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    Desktop.getDesktop().browse(new URI(DEFAULT_TEXT));

                } catch (IOException | URISyntaxException e1) {
                    Alert.incorrectInfoAlert("Couldn't open link");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                link.setText("<html><a href=''>" + link.getText() + "</a></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                link.setText(DEFAULT_TEXT);
            }
        });
    }
}
