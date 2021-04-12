package org.bsuir.scs.view;

import org.bsuir.scs.image.ImageCreator;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HelperView {
    public HelperView()  {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        JDialog dialog = new JDialog();
        dialog.setTitle("Helper");

        JPanel panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        Font boldFont = new Font("TimesRoman", Font.BOLD, 16);
        Font simpleFont = new Font("TimesRoman", Font.PLAIN, 12);


        JLabel howToUseLabel = new JLabel("How to use it?\n");
        JLabel dontUseLabel = new JLabel("Don't use it\n\n");
        JLabel constantsExplanation = new JLabel("To add constants and its html links, you have to pass it in brackets");
        JLabel exampleText = new JLabel("Example:");
        JLabel example = new JLabel("formal system - (concept_system system) that ....");

        Image image = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/cattie.png"))).getImage();

        JLabel picLabel = new JLabel(new ImageIcon(ImageCreator.toBufferedImage(image)));


        howToUseLabel.setFont(boldFont);
        dontUseLabel.setFont(simpleFont);
        constantsExplanation.setFont(simpleFont);
        example.setFont(simpleFont);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(howToUseLabel)
                .addComponent(dontUseLabel)
                .addComponent(constantsExplanation)
                .addComponent(exampleText)
                .addComponent(example)
                .addComponent(picLabel)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(howToUseLabel)
                .addComponent(dontUseLabel)
                .addGap(30)
                .addComponent(constantsExplanation)
                .addComponent(exampleText)
                .addComponent(example)
                .addComponent(picLabel)
        );
        panel.add(howToUseLabel);
        panel.add(dontUseLabel);
        panel.add(picLabel);

        dialog.add(panel);

        dialog.pack();
        dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
        dialog.setVisible(true);
        dialog.setResizable(false);
    }

}
