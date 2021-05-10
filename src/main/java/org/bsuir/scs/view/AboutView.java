package org.bsuir.scs.view;

import org.bsuir.scs.controller.LinkMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Objects;

public class AboutView {


    public AboutView() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        JDialog dialog = new JDialog();

        Image image = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/icon.png"))).getImage();
        dialog.setIconImage(image);

        dialog.setTitle("About");

        JPanel panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        Font boldFont = new Font("TimesRoman", Font.BOLD, 16);
        Font simpleFont = new Font("TimesRoman", Font.PLAIN, 12);

        JLabel source = new JLabel("source-govno-code:\n");
        JLabel gitLink = new JLabel("https://github.com/pilipeikoko/ScsCreator");
        JLabel iconCreatorText = new JLabel("icon-artist:");
        JLabel iconCreatorLink = new JLabel("https://www.deviantart.com/makshilo");

        new LinkMouseListener(gitLink);
        new LinkMouseListener(iconCreatorLink);

        source.setFont(boldFont);
        gitLink.setFont(simpleFont);
        iconCreatorText.setFont(boldFont);
        iconCreatorLink.setFont(simpleFont);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(source)
                .addComponent(gitLink)
                .addComponent(iconCreatorText)
                .addComponent(iconCreatorLink)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(source)
                .addComponent(gitLink)
                .addComponent(iconCreatorText)
                .addComponent(iconCreatorLink)
        );


        dialog.add(panel);

        dialog.pack();
        dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
        dialog.setVisible(true);

    }
}
