package org.bsuir.scs.validator;

import org.bsuir.scs.exception.CustomException;

public class Validator {
    public static void validateConcept(String systemIdentifier, String russianIdentifier, String englishIdentifier,
                                       String definition, String statement) throws CustomException {
        if (systemIdentifier.isEmpty() || russianIdentifier.isEmpty() || englishIdentifier.isEmpty() ||
                definition.isEmpty() || statement.isEmpty()) {
            throw new CustomException("Fill all needed fields");
        }
    }

    public static void validateRelation(String systemIdentifier, String russianIdentifier, String englishIdentifier,
                                        String definition, String statement, String arity, String firstDomain,
                                        String secondDomain) throws CustomException {
        if (systemIdentifier.isEmpty() || russianIdentifier.isEmpty() || englishIdentifier.isEmpty() ||
                definition.isEmpty() || statement.isEmpty() || arity.isEmpty() || firstDomain.isEmpty()
                || secondDomain.isEmpty()) {
            throw new CustomException("Fill all needed fields");
        }
        try {
            Integer.parseInt(arity);
        } catch (NumberFormatException exception) {
            throw new CustomException("Arity is a numeric value");
        }

    }
}
