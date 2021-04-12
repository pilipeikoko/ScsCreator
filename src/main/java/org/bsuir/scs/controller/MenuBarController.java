package org.bsuir.scs.controller;

import org.bsuir.scs.view.AboutView;
import org.bsuir.scs.view.HelperView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuBarController {
    private final MenuItem[] menuItems;

    public MenuBarController(MenuItem[] menuBarItems) {
        this.menuItems = menuBarItems;
        addHelperItemsAction();
        addAboutItemAction();
    }

    private void addHelperItemsAction() {
        menuItems[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HelperView();
            }
        });
    }

    private void addAboutItemAction() {
        menuItems[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutView();
            }
        });
    }
}
