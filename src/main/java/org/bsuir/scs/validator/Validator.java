package org.bsuir.scs.validator;

import org.bsuir.scs.exception.customException;

public class Validator {
    public static void validateConcept(String systemIdentifier,String russianIdentifier,String englishIdentifier,
                                          String definition,String statement) throws customException {
        if (systemIdentifier.isEmpty() || russianIdentifier.isEmpty() || englishIdentifier.isEmpty() ||
                definition.isEmpty() || statement.isEmpty()) {
            throw new customException("Fill all needed fields");
        }
    }

    public static void validateRelation(String systemIdentifier,String russianIdentifier,String englishIdentifier,
                                           String definition,String statement,String arity, String firstDomain,
                                           String secondDomain) throws customException {
        if (systemIdentifier.isEmpty() || russianIdentifier.isEmpty() || englishIdentifier.isEmpty() ||
                definition.isEmpty() || statement.isEmpty() || arity.isEmpty() || firstDomain.isEmpty()
                || secondDomain.isEmpty()) {
            throw new customException("Fill all needed fields");
        }
        try{
            Integer.parseInt(arity);
        } catch (NumberFormatException exception){
            throw new customException("Arity is a numeric value");
        }

    }
}
