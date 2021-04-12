package org.bsuir.scs.view;

import org.bsuir.scs.controller.SaveToFileController;
import org.bsuir.scs.entity.ScsEntity;

import javax.swing.*;
import java.io.File;

public class SaveToFileView {
    public SaveToFileView(ScsEntity scsEntity, JTextField[] conceptTextFields, JTextField[] nrelTextFields, JTextField[] rrelTextFields) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save to");
        fileChooser.setApproveButtonText("Save");
        fileChooser.setSelectedFile(new File(scsEntity.getCustomCreator().getSystemIdentifier() + ".scs"));
        new SaveToFileController(fileChooser, scsEntity, conceptTextFields, nrelTextFields, rrelTextFields);
    }
}
