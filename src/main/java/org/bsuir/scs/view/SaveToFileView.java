package org.bsuir.scs.view;

import org.bsuir.scs.controller.SaveToFileController;
import org.bsuir.scs.entity.ScsCreator;

import javax.swing.*;
import java.io.File;

public class SaveToFileView {
    public SaveToFileView(ScsCreator scsCreator,JTextField[] conceptTextFields,JTextField[] nrelTextFields,JTextField[] rrelTextFields) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save to");
        fileChooser.setApproveButtonText("Save");
        fileChooser.setSelectedFile(new File(scsCreator.getCustomCreator().getSystemIdentifier()+".scs"));
        new SaveToFileController(fileChooser,scsCreator,conceptTextFields,nrelTextFields,rrelTextFields);
    }
}
