package org.bsuir.scs.view;

import org.bsuir.scs.controller.LinkMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class AboutView {


    public AboutView(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        JDialog dialog = new JDialog();
        dialog.setTitle("About");

        JPanel panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        Font boldFont = new Font("TimesRoman", Font.BOLD, 16);
        Font simpleFont = new Font("TimesRoman", Font.PLAIN, 12);

        JLabel source = new JLabel("source-govno-code:\n");
        JLabel link = new JLabel("https://github.com/pilipeikoko/ScsCreator");
        new LinkMouseListener(link);

        source.setFont(boldFont);
        link.setFont(simpleFont);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(source)
                .addComponent(link)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(source)
                .addComponent(link)
        );
        panel.add(source);
        panel.add(link);

        dialog.add(panel);

        dialog.pack();
        dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);
        dialog.setVisible(true);

    }
}
