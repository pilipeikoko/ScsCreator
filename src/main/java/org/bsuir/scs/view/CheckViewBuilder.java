package org.bsuir.scs.view;

import org.bsuir.scs.controller.CheckViewController;
import org.bsuir.scs.entity.ScsEntity;
import org.bsuir.scs.view.border.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class CheckViewBuilder {
    private final JTextArea label;
    private final JButton copyButton;
    private final JButton okButton;
    private final ScsEntity creator;
    private final JLabel copiedToClipboardLabel;

    {
        label = new JTextArea();
        copiedToClipboardLabel = new JLabel("Copied to the clipboard");
        copyButton = new JButton("Copy");
        okButton = new JButton("Ok");
    }

    public CheckViewBuilder(ScsEntity creator){
        this.creator = creator;
        setLabelInfo();
        setButtons();
        setFrame();
    }

    private void setButtons() {
        okButton.setForeground(Color.BLACK);
        okButton.setBackground(Color.WHITE);
        copyButton.setForeground(Color.BLACK);
        copyButton.setBackground(Color.WHITE);

        okButton.setBorder(new RoundedBorder(5));
        copyButton.setBorder(new RoundedBorder(5));
    }

    private void setFrame() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Do you like what you see buddy?");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        JPanel panel = new JPanel();

        //todo color
        panel.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane(panel);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        panel.add(label);
        panel.add(copyButton);
        panel.add(okButton);
        panel.add(copiedToClipboardLabel);

        copiedToClipboardLabel.setVisible(false);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(label)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(copyButton)
                        .addGap(10,20,20)
                        .addComponent(okButton)
                        .addGap(10,50,100)
                        .addComponent(copiedToClipboardLabel)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(label)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(copyButton)
                        .addComponent(okButton)
                        .addComponent(copiedToClipboardLabel)
                )
        );

        dialog.add(scrollPane);
        dialog.pack();

        dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);
        dialog.setVisible(true);

        new CheckViewController(creator, label,okButton,copyButton,copiedToClipboardLabel);

    }

    private void setLabelInfo() {

        label.setText(creator.getCustomCreator().getResult());
    }


}
