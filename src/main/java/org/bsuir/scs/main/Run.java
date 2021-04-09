package org.bsuir.scs.main;

import org.bsuir.scs.creator.ConceptCreator;
import org.bsuir.scs.entity.ScsCreator;

public class Run {
    public static void main(String[] args) {
        ConceptCreator conceptCreator = new ConceptCreator("concept_system","система дяд дя ", "продам гараж ","система", "system");
        ScsCreator scsCreator = new ScsCreator(conceptCreator);
        scsCreator.createFile();
    }
}
