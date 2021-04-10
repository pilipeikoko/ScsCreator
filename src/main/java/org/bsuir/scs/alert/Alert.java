package org.bsuir.scs.alert;

import javax.swing.*;

public class Alert {
    public static void incorrectInfoAlert(String reason) {
        JOptionPane.showMessageDialog(null, reason);
    }
}
