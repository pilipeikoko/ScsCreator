package org.bsuir.scs.controller;

import org.bsuir.scs.alert.Alert;
import org.bsuir.scs.creator.ConceptCreator;
import org.bsuir.scs.creator.NrelCreator;
import org.bsuir.scs.creator.RrelCreator;
import org.bsuir.scs.entity.ScsEntity;
import org.bsuir.scs.exception.customException;
import org.bsuir.scs.params.DefaultParameters;
import org.bsuir.scs.validator.Validator;
import org.bsuir.scs.view.CheckViewBuilder;
import org.bsuir.scs.view.SaveToFileView;
import org.bsuir.scs.view.TypeCardsBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController {
    private final JRadioButton[] radioButtons;
    private final ButtonGroup buttonGroup;

    /**
     * @see TypeCardsBuilder#getConceptTextFields()
     */
    private final JTextField[] conceptTextFields;
    /**
     * @see TypeCardsBuilder#getNrelTextFields()
     */
    private final JTextField[] nrelTextFields;
    /**
     * @see TypeCardsBuilder#getRrelTextFields()
     */
    private final JTextField[] rrelTextFields;
    /**
     * @see TypeCardsBuilder#getNrelCheckBoxes()
     */
    private final JCheckBox[] nrelCheckBoxes;
    /**
     * @see TypeCardsBuilder#getRrelCheckBoxes()
     */
    private final JCheckBox[] rrelCheckBoxes;
    private final JButton checkBottom;
    private final JButton saveButton;

    private final JPanel cards;

    public MainFrameController(ButtonGroup buttonGroup, JRadioButton[] radioButtons, JTextField[] conceptTextFields,
                               JTextField[] nrelTextFields, JTextField[] rrelTextFields, JCheckBox[] nrelCheckBoxes,
                               JCheckBox[] rrelCheckBoxes, JPanel cards, JButton checkBottom, JButton saveButton) {
        this.buttonGroup = buttonGroup;
        this.radioButtons = radioButtons;
        this.conceptTextFields = conceptTextFields;
        this.nrelTextFields = nrelTextFields;
        this.rrelTextFields = rrelTextFields;
        this.nrelCheckBoxes = nrelCheckBoxes;
        this.rrelCheckBoxes = rrelCheckBoxes;
        this.cards = cards;
        this.checkBottom = checkBottom;
        this.saveButton = saveButton;
        addRadioButtonListener();
        addCheckButtonListener();
        addSaveButtonListener();
    }

    private void addSaveButtonListener() {
        saveButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createSaveView();
                } catch (org.bsuir.scs.exception.customException | NumberFormatException customException) {
                    Alert.incorrectInfoAlert(customException.getMessage());
                }
            }
        });
    }

    private void createSaveView() throws customException {
        String action = buttonGroup.getSelection().getActionCommand();
        if (action.equals(DefaultParameters.TYPES[0])) {
            String systemIdentifier = conceptTextFields[0].getText();
            String russianIdentifier = conceptTextFields[1].getText();
            String englishIdentifier = conceptTextFields[2].getText();
            String definition = conceptTextFields[3].getText();
            String statement = conceptTextFields[4].getText();

            Validator.validateConcept(systemIdentifier,russianIdentifier,englishIdentifier,definition,statement);

            ConceptCreator creator = new ConceptCreator(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier);
            new SaveToFileView(new ScsEntity(creator), conceptTextFields, nrelTextFields, rrelTextFields);
        } else if (action.equals(DefaultParameters.TYPES[1])) {
            String systemIdentifier = nrelTextFields[0].getText();
            String russianIdentifier = nrelTextFields[1].getText();
            String englishIdentifier = nrelTextFields[2].getText();
            String definition = nrelTextFields[3].getText();
            String statement = nrelTextFields[4].getText();
            String arity = nrelTextFields[5].getText();
            String firstDomain = nrelTextFields[6].getText();
            String secondDomain = nrelTextFields[7].getText();
            boolean isSymmetric = nrelCheckBoxes[0].isSelected();
            boolean isTransitive = nrelCheckBoxes[1].isSelected();
            boolean isReflexive = nrelCheckBoxes[2].isSelected();

            Validator.validateRelation(systemIdentifier,russianIdentifier,englishIdentifier,definition,statement,arity,firstDomain,secondDomain);

            int numericArity = Integer.parseInt(arity);

            NrelCreator nrelCreator = new NrelCreator(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier, numericArity, firstDomain, secondDomain, isSymmetric, isReflexive, isTransitive);
            new SaveToFileView(new ScsEntity(nrelCreator), conceptTextFields, nrelTextFields, rrelTextFields);
        } else if (action.equals(DefaultParameters.TYPES[2])) {

            String systemIdentifier = rrelTextFields[0].getText();
            String russianIdentifier = rrelTextFields[1].getText();
            String englishIdentifier = rrelTextFields[2].getText();
            String definition = rrelTextFields[3].getText();
            String statement = rrelTextFields[4].getText();
            String arity = nrelTextFields[5].getText();
            String firstDomain = rrelTextFields[6].getText();
            String secondDomain = rrelTextFields[7].getText();
            boolean isSymmetric = rrelCheckBoxes[0].isSelected();
            boolean isTransitive = rrelCheckBoxes[1].isSelected();
            boolean isReflexive = rrelCheckBoxes[2].isSelected();

            Validator.validateRelation(systemIdentifier,russianIdentifier,englishIdentifier,definition,statement,arity,firstDomain,secondDomain);

            int numericArity = Integer.parseInt(arity);

            RrelCreator rrelCreator = new RrelCreator(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier, numericArity, firstDomain, secondDomain, isSymmetric, isReflexive, isTransitive);
            new SaveToFileView(new ScsEntity(rrelCreator), conceptTextFields, nrelTextFields, rrelTextFields);
        }
    }

    private void addCheckButtonListener() {
        checkBottom.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    createCheckView();
                } catch (org.bsuir.scs.exception.customException customException) {
                    Alert.incorrectInfoAlert(customException.getMessage());
                }

            }
        });
    }

    private void createCheckView() throws customException {
        String action = buttonGroup.getSelection().getActionCommand();

        if (action.equals(DefaultParameters.TYPES[0])) {
            String systemIdentifier = conceptTextFields[0].getText();
            String russianIdentifier = conceptTextFields[1].getText();
            String englishIdentifier = conceptTextFields[2].getText();
            String definition = conceptTextFields[3].getText();
            String statement = conceptTextFields[4].getText();

            Validator.validateConcept(systemIdentifier,russianIdentifier,englishIdentifier,definition,statement);

            ConceptCreator creator = new ConceptCreator(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier);
            creator.create();
            new CheckViewBuilder(new ScsEntity(creator));
        } else if (action.equals(DefaultParameters.TYPES[1])) {

            String systemIdentifier = nrelTextFields[0].getText();
            String russianIdentifier = nrelTextFields[1].getText();
            String englishIdentifier = nrelTextFields[2].getText();
            String definition = nrelTextFields[3].getText();
            String statement = nrelTextFields[4].getText();
            String arity = nrelTextFields[5].getText();
            String firstDomain = nrelTextFields[6].getText();
            String secondDomain = nrelTextFields[7].getText();
            boolean isSymmetric = nrelCheckBoxes[0].isSelected();
            boolean isTransitive = nrelCheckBoxes[1].isSelected();
            boolean isReflexive = nrelCheckBoxes[2].isSelected();

            Validator.validateRelation(systemIdentifier,russianIdentifier,englishIdentifier,definition,statement,arity,firstDomain,secondDomain);

            int numericArity = Integer.parseInt(arity);

            NrelCreator nrelCreator = new NrelCreator(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier, numericArity, firstDomain, secondDomain, isSymmetric, isReflexive, isTransitive);
            nrelCreator.create();
            new CheckViewBuilder(new ScsEntity(nrelCreator));

        } else if (action.equals(DefaultParameters.TYPES[2])) {

            String systemIdentifier = rrelTextFields[0].getText();
            String russianIdentifier = rrelTextFields[1].getText();
            String englishIdentifier = rrelTextFields[2].getText();
            String definition = rrelTextFields[3].getText();
            String statement = rrelTextFields[4].getText();
            String arity = rrelTextFields[5].getText();
            String firstDomain = rrelTextFields[6].getText();
            String secondDomain = rrelTextFields[7].getText();
            boolean isSymmetric = rrelCheckBoxes[0].isSelected();
            boolean isTransitive = rrelCheckBoxes[1].isSelected();
            boolean isReflexive = rrelCheckBoxes[2].isSelected();

            Validator.validateRelation(systemIdentifier,russianIdentifier,englishIdentifier,definition,statement,arity,firstDomain,secondDomain);

            int numericArity = Integer.parseInt(arity);

            RrelCreator rrelCreator = new RrelCreator(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier, numericArity, firstDomain, secondDomain, isSymmetric, isReflexive, isTransitive);
            rrelCreator.create();
            new CheckViewBuilder(new ScsEntity(rrelCreator));
        }
    }

    private void addRadioButtonListener() {
        ActionListener buttonGroupListener = new ButtonGroupListener(buttonGroup, cards);

        radioButtons[0].addActionListener(buttonGroupListener);
        radioButtons[1].addActionListener(buttonGroupListener);
        radioButtons[2].addActionListener(buttonGroupListener);
    }
}
