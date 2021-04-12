package org.bsuir.scs.view;

import org.bsuir.scs.controller.MenuBarController;

import java.awt.*;

public class MenuBarBuilder {

    public static final int AMOUNT_OF_MENU_BAR_ITEMS = 2;

    private MenuBar menuBar;
    private final MenuItem[] menuBarItems;

    public MenuBarBuilder() {
        menuBarItems = new MenuItem[AMOUNT_OF_MENU_BAR_ITEMS];
        makeMenuBar();
        new MenuBarController(menuBarItems);
    }

    private void makeMenuBar() {
        MenuItem helperItem = new MenuItem("Helper");
        MenuItem aboutItem = new MenuItem("About");

        addMenuBarItems(helperItem, aboutItem);

        Menu fileMenu = new Menu("Help");

        fileMenu.add(helperItem);
        fileMenu.add(aboutItem);

        menuBar = new MenuBar();
        menuBar.add(fileMenu);
    }

    private void addMenuBarItems(MenuItem helperItem, MenuItem aboutItem) {
        menuBarItems[0] = helperItem;
        menuBarItems[1] = aboutItem;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}