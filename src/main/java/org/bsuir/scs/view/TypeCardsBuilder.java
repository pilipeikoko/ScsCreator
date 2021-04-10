package org.bsuir.scs.view;

import com.tagmycode.plugin.gui.TextPrompt;
import org.bsuir.scs.params.DefaultParameters;

import javax.swing.*;
import java.awt.*;

public class TypeCardsBuilder {
    private static final int CONCEPT_AMOUNT_OF_TEXT_FIELDS = 5;
    private static final int RELATION_AMOUNT_OF_TEXT_FIELDS = 8;
    private static final int RELATION_AMOUNT_OF_CHECK_BOXES = 3;

    private final JTextField[] conceptTextFields;
    private final JTextField[] nrelTextFields;
    private final JTextField[] rrelTextFields;
    private final JCheckBox[] nrelCheckBoxes;
    private final JCheckBox[] rrelCheckBoxes;


    private final JPanel cards;

    public TypeCardsBuilder() {
        conceptTextFields = new JTextField[CONCEPT_AMOUNT_OF_TEXT_FIELDS];
        nrelTextFields = new JTextField[RELATION_AMOUNT_OF_TEXT_FIELDS];
        rrelTextFields = new JTextField[RELATION_AMOUNT_OF_TEXT_FIELDS];
        nrelCheckBoxes = new JCheckBox[RELATION_AMOUNT_OF_CHECK_BOXES];
        rrelCheckBoxes = new JCheckBox[RELATION_AMOUNT_OF_CHECK_BOXES];

        cards = new JPanel(new CardLayout());

        createElements();

        JPanel conceptPanel = createConceptPanel();
        JPanel nrelPanel = createNrelPanel();
        JPanel rrelPanel = createRrelPanel();

        cards.add(conceptPanel, DefaultParameters.TYPES[0]);
        cards.add(nrelPanel, DefaultParameters.TYPES[1]);
        cards.add(rrelPanel, DefaultParameters.TYPES[2]);
    }

    private JPanel createRrelPanel() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        panel.add(rrelTextFields[0]);
        panel.add(rrelTextFields[1]);
        panel.add(rrelTextFields[2]);
        panel.add(rrelTextFields[3]);
        panel.add(rrelTextFields[4]);
        panel.add(rrelTextFields[5]);
        panel.add(rrelTextFields[6]);
        panel.add(rrelTextFields[7]);
        panel.add(rrelCheckBoxes[0]);
        panel.add(rrelCheckBoxes[1]);
        panel.add(rrelCheckBoxes[2]);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(rrelTextFields[0])
                        .addComponent(rrelTextFields[1])
                        .addComponent(rrelTextFields[2])
                        .addComponent(rrelTextFields[3])
                        .addComponent(rrelTextFields[4])
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(rrelCheckBoxes[0])
                        .addComponent(rrelCheckBoxes[1])
                        .addComponent(rrelCheckBoxes[2])
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(rrelTextFields[0])
                        .addComponent(rrelTextFields[1])
                        .addComponent(rrelTextFields[2])
                        .addComponent(rrelTextFields[3])
                        .addComponent(rrelTextFields[4])
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(rrelCheckBoxes[0])
                        .addComponent(rrelCheckBoxes[1])
                        .addComponent(rrelCheckBoxes[2])
                )
        );
        return panel;
    }

    private JPanel createNrelPanel() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        panel.add(nrelTextFields[0]);
        panel.add(nrelTextFields[1]);
        panel.add(nrelTextFields[2]);
        panel.add(nrelTextFields[3]);
        panel.add(nrelTextFields[4]);
        panel.add(nrelTextFields[5]);
        panel.add(nrelTextFields[6]);
        panel.add(nrelTextFields[7]);
        panel.add(nrelCheckBoxes[0]);
        panel.add(nrelCheckBoxes[1]);
        panel.add(nrelCheckBoxes[2]);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(nrelTextFields[0])
                        .addComponent(nrelTextFields[1])
                        .addComponent(nrelTextFields[2])
                        .addComponent(nrelTextFields[3])
                        .addComponent(nrelTextFields[4])
                        .addComponent(nrelTextFields[5])
                        .addComponent(nrelTextFields[6])
                        .addComponent(nrelTextFields[7])
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(nrelCheckBoxes[0])
                        .addComponent(nrelCheckBoxes[1])
                        .addComponent(nrelCheckBoxes[2])
                )
        );
        layout.setVerticalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(nrelTextFields[0])
                        .addComponent(nrelTextFields[1])
                        .addComponent(nrelTextFields[2])
                        .addComponent(nrelTextFields[3])
                        .addComponent(nrelTextFields[4])
                        .addComponent(nrelTextFields[5])
                        .addComponent(nrelTextFields[6])
                        .addComponent(nrelTextFields[7])
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(nrelCheckBoxes[0])
                        .addComponent(nrelCheckBoxes[1])
                        .addComponent(nrelCheckBoxes[2])
                )
        );

        return panel;

    }

    private void createElements() {
        createConceptElements();
        createNrelElements();
        createRrelElements();
    }

    private void createRrelElements() {
        Font font = new Font("TimesRoman", Font.ITALIC, 12);


        JTextField systemIdentifierField = new JTextField();
        TextPrompt systemIdentifierPrompt = new TextPrompt("System identifier*", systemIdentifierField);
        systemIdentifierPrompt.setFont(font);

        JTextField mainRussianIdentifierField = new JTextField();
        TextPrompt mainRussianIdentifierPrompt = new TextPrompt("Main russian identifier*", mainRussianIdentifierField);
        mainRussianIdentifierPrompt.setFont(font);

        JTextField mainEnglishIdentifierField = new JTextField();
        TextPrompt mainEnglishIdentifierPrompt = new TextPrompt("Main english identifier*", mainEnglishIdentifierField);
        mainEnglishIdentifierPrompt.setFont(font);

        JTextField definitionField = new JTextField();
        TextPrompt definitionFieldPrompt = new TextPrompt("Definition*", definitionField);
        definitionFieldPrompt.setFont(font);

        JTextField statementField = new JTextField();
        TextPrompt statementFieldPrompt = new TextPrompt("Statement*", statementField);
        statementFieldPrompt.setFont(font);

        JTextField arityField = new JTextField();
        TextPrompt arityFieldPrompt = new TextPrompt("Arity", arityField);
        arityFieldPrompt.setFont(font);

        JTextField firstDomainField = new JTextField();
        TextPrompt firstDomainFieldPrompt = new TextPrompt("First domain", firstDomainField);
        firstDomainFieldPrompt.setFont(font);

        JTextField secondDomainField = new JTextField();
        TextPrompt secondDomainFieldPrompt = new TextPrompt("First domain", secondDomainField);
        secondDomainFieldPrompt.setFont(font);

        JCheckBox symmetricalCheckBox = new JCheckBox("symmetrical");
        JCheckBox transitiveCheckBox = new JCheckBox("transitive");
        JCheckBox reflexiveCheckBox = new JCheckBox("reflexive");

        rrelTextFields[0] = systemIdentifierField;
        rrelTextFields[1] = mainRussianIdentifierField;
        rrelTextFields[2] = mainEnglishIdentifierField;
        rrelTextFields[3] = definitionField;
        rrelTextFields[4] = statementField;
        rrelTextFields[5] = arityField;
        rrelTextFields[6] = firstDomainField;
        rrelTextFields[7] = secondDomainField;

        rrelCheckBoxes[0] = symmetricalCheckBox;
        rrelCheckBoxes[1] = transitiveCheckBox;
        rrelCheckBoxes[2] = reflexiveCheckBox;
    }

    private void createNrelElements() {
        Font font = new Font("TimesRoman", Font.ITALIC, 12);


        JTextField systemIdentifierField = new JTextField();
        TextPrompt systemIdentifierPrompt = new TextPrompt("System identifier*", systemIdentifierField);
        systemIdentifierPrompt.setFont(font);

        JTextField mainRussianIdentifierField = new JTextField();
        TextPrompt mainRussianIdentifierPrompt = new TextPrompt("Main russian identifier*", mainRussianIdentifierField);
        mainRussianIdentifierPrompt.setFont(font);

        JTextField mainEnglishIdentifierField = new JTextField();
        TextPrompt mainEnglishIdentifierPrompt = new TextPrompt("Main english identifier*", mainEnglishIdentifierField);
        mainEnglishIdentifierPrompt.setFont(font);

        JTextField definitionField = new JTextField();
        TextPrompt definitionFieldPrompt = new TextPrompt("Definition*", definitionField);
        definitionFieldPrompt.setFont(font);

        JTextField statementField = new JTextField();
        TextPrompt statementFieldPrompt = new TextPrompt("Statement*", statementField);
        statementFieldPrompt.setFont(font);

        JTextField arityField = new JTextField();
        TextPrompt arityFieldPrompt = new TextPrompt("Arity", arityField);
        arityFieldPrompt.setFont(font);

        JTextField firstDomainField = new JTextField();
        TextPrompt firstDomainFieldPrompt = new TextPrompt("First domain", firstDomainField);
        firstDomainFieldPrompt.setFont(font);

        JTextField secondDomainField = new JTextField();
        TextPrompt secondDomainFieldPrompt = new TextPrompt("First domain", secondDomainField);
        secondDomainFieldPrompt.setFont(font);

        JCheckBox symmetricalCheckBox = new JCheckBox("symmetrical");
        JCheckBox transitiveCheckBox = new JCheckBox("transitive");
        JCheckBox reflexiveCheckBox = new JCheckBox("reflexive");

        nrelTextFields[0] = systemIdentifierField;
        nrelTextFields[1] = mainRussianIdentifierField;
        nrelTextFields[2] = mainEnglishIdentifierField;
        nrelTextFields[3] = definitionField;
        nrelTextFields[4] = statementField;
        nrelTextFields[5] = arityField;
        nrelTextFields[6] = firstDomainField;
        nrelTextFields[7] = secondDomainField;

        nrelCheckBoxes[0] = symmetricalCheckBox;
        nrelCheckBoxes[1] = transitiveCheckBox;
        nrelCheckBoxes[2] = reflexiveCheckBox;
    }

    private void createConceptElements() {
        Font font = new Font("TimesRoman", Font.ITALIC, 12);


        JTextField systemIdentifierField = new JTextField();
        TextPrompt systemIdentifierPrompt = new TextPrompt("System identifier*", systemIdentifierField);
        systemIdentifierPrompt.setFont(font);

        JTextField mainRussianIdentifierField = new JTextField();
        TextPrompt mainRussianIdentifierPrompt = new TextPrompt("Main russian identifier*", mainRussianIdentifierField);
        mainRussianIdentifierPrompt.setFont(font);

        JTextField mainEnglishIdentifierField = new JTextField();
        TextPrompt mainEnglishIdentifierPrompt = new TextPrompt("Main english identifier*", mainEnglishIdentifierField);
        mainEnglishIdentifierPrompt.setFont(font);

        JTextField definitionField = new JTextField();
        TextPrompt definitionFieldPrompt = new TextPrompt("Definition*", definitionField);
        definitionFieldPrompt.setFont(font);

        JTextField statementField = new JTextField();
        TextPrompt statementFieldPrompt = new TextPrompt("Statement*", statementField);
        statementFieldPrompt.setFont(font);

        conceptTextFields[0] = systemIdentifierField;
        conceptTextFields[1] = mainRussianIdentifierField;
        conceptTextFields[2] = mainEnglishIdentifierField;
        conceptTextFields[3] = definitionField;
        conceptTextFields[4] = statementField;
    }


    private JPanel createConceptPanel() {

        JPanel panel = new JPanel();
        //todo remove
        panel.setPreferredSize(new Dimension(400, 150));
        GroupLayout layout = new GroupLayout(panel);
//        layout.setAutoCreateGaps(true);
//        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        panel.add(conceptTextFields[0]);
        panel.add(conceptTextFields[1]);
        panel.add(conceptTextFields[2]);
        panel.add(conceptTextFields[3]);
        panel.add(conceptTextFields[4]);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(conceptTextFields[0])
                .addComponent(conceptTextFields[1])
                .addComponent(conceptTextFields[2])
                .addComponent(conceptTextFields[3])
                .addComponent(conceptTextFields[4])
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(conceptTextFields[0])
                .addComponent(conceptTextFields[1])
                .addComponent(conceptTextFields[2])
                .addComponent(conceptTextFields[3])
                .addComponent(conceptTextFields[4])
        );

        return panel;
    }

    /**
     * <br>[0] system identifier</br>
     * <br>[1] main russian identifier</br>
     * <br>[2] main english identifier </br>
     * <br>[3] definition</br>
     * <br>[4] statement </br>
     * <br>[5] arity </br>
     * <br>[6] first domain </br>
     * <br>[7] second domain </br>
     */
    public JTextField[] getNrelTextFields() {
        return nrelTextFields;
    }
    /**
     * <br>[0] system identifier</br>
     * <br>[1] main russian identifier</br>
     * <br>[2] main english identifier </br>
     * <br>[3] definition</br>
     * <br>[4] statement </br>
     * <br>[5] arity </br>
     * <br>[6] first domain </br>
     * <br>[7] second domain </br>
     */
    public JTextField[] getRrelTextFields() {
        return rrelTextFields;
    }

    /**
     * <br>[0] system identifier</br>
     * <br>[1] main russian identifier</br>
     * <br>[2] main english identifier </br>
     * <br>[3] definition</br>
     * <br>[4] statement </br>
     */
    public JTextField[] getConceptTextFields() {
        return conceptTextFields;
    }

    /**
     * <br>[0] symmetrical</br>
     * <br>[1] transitive</br>
     * <br>[2] reflexive</br>
     */
    public JCheckBox[] getNrelCheckBoxes() {
        return nrelCheckBoxes;
    }

    /**
     * <br>[0] symmetrical</br>
     * <br>[1] transitive</br>
     * <br>[2] reflexive</br>
     */
    public JCheckBox[] getRrelCheckBoxes() {
        return rrelCheckBoxes;
    }

    public JPanel getCards() {
        return cards;
    }
}
