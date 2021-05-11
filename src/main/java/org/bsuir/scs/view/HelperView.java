package org.bsuir.scs.view;

import org.bsuir.scs.image.ImageCreator;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HelperView {
    public HelperView()  {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        JDialog dialog = new JDialog();

        Image icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/icon.png"))).getImage();
        dialog.setIconImage(icon);

        dialog.setTitle("Helper");

        JPanel panel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(panel);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        Font boldFont = new Font("TimesRoman", Font.BOLD, 16);
        Font simpleFont = new Font("TimesRoman", Font.PLAIN, 12);


        JLabel howToUseLabel = new JLabel("How to use it?\n");
        JLabel dontUseLabel = new JLabel("Don't use it\n");
        JLabel constantsExplanation = new JLabel("To add constants and its html links, you have to pass it in square brackets");
        JLabel exampleText = new JLabel("Example:");

        Image exampleImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/example.png"))).getImage();
        JLabel exampleLabel = new JLabel(new ImageIcon(ImageCreator.resize(ImageCreator.toBufferedImage(exampleImage),600,150)));

        Image image = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/cattie.png"))).getImage();

        JLabel picLabel = new JLabel(new ImageIcon(ImageCreator.toBufferedImage(image)));


        howToUseLabel.setFont(boldFont);
        dontUseLabel.setFont(simpleFont);
        constantsExplanation.setFont(simpleFont);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(howToUseLabel)
                .addComponent(dontUseLabel)
                .addComponent(constantsExplanation)
                .addComponent(exampleText)
                .addComponent(exampleLabel)
                .addComponent(picLabel)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(howToUseLabel)
                .addComponent(dontUseLabel)
                .addGap(20)
                .addComponent(constantsExplanation)
                .addComponent(exampleText)
                .addComponent(exampleLabel)
                .addComponent(picLabel)
        );
        panel.add(howToUseLabel);
        panel.add(dontUseLabel);
        panel.add(picLabel);

        dialog.add(scrollPane);

        dialog.pack();
        dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
        dialog.setVisible(true);
        dialog.setResizable(false);
    }

}
