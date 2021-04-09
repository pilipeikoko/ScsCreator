package org.bsuir.scs.creator;

import org.bsuir.scs.params.DefaultParameters;

public class ConceptCreator extends CustomCreator {

    public ConceptCreator(String systemIdentifier, String definition, String statement, String russianIdentifier, String englishIdentifier) {
        this.definition = definition;
        this.statement = statement;
        this.systemIdentifier = systemIdentifier;
        this.russianIdentifier = russianIdentifier;
        this.englishIdentifier = englishIdentifier;
    }

    @Override
    public void create() {
        //todo add constants parser
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(systemIdentifier).append(" <- ").append(DefaultParameters.CONCEPT_NODE_TYPE).append(";;\n\n");
        stringBuilder.append(systemIdentifier).append(" => ").append(DefaultParameters.MAIN_IDTF).append(":\n");
        stringBuilder.append("[").append(russianIdentifier).append("] ").append(DefaultParameters.RUSSIAN_LANGUAGE).append(";\n");
        stringBuilder.append("[").append(englishIdentifier).append("] ").append(DefaultParameters.ENGLISH_LANGUAGE).append(";;\n\n");

        stringBuilder.append(systemIdentifier).append(" <- ").append(DefaultParameters.KEY_SC_ELEMENT).append(": ...\n");
        stringBuilder.append("(*\n");
        stringBuilder.append("<- " + DefaultParameters.DEFINITION + ";;\n");
        stringBuilder.append("=> " + DefaultParameters.MAIN_IDTF + ":\n");
        stringBuilder.append("\t[Опр. (").append(russianIdentifier).append(")] ").append(DefaultParameters.RUSSIAN_LANGUAGE).append(";;\n");;
        stringBuilder.append("=> " + DefaultParameters.USING_CONSTANTS + ":\n");
        stringBuilder.append("\t{\n");
        //todo add constants
        stringBuilder.append("\t};;\n");
        stringBuilder.append("<=" + DefaultParameters.TEXT_TRANSLATION + ": ...\n");
        stringBuilder.append("\t(*\n");
        stringBuilder.append("\t\t-> " + DefaultParameters.EXAMPLE +":\n");
        stringBuilder.append("\t\t[" + this.definition + "]" + DefaultParameters.HTML_FLAG + ";;\n");
        stringBuilder.append("\t*);;\n");
        stringBuilder.append("*);;\n\n");

        stringBuilder.append(systemIdentifier).append(" <- ").append(DefaultParameters.KEY_SC_ELEMENT).append(": ...\n");
        stringBuilder.append("(*\n");
        stringBuilder.append("<- " + DefaultParameters.STATEMENT + ";;\n");
        stringBuilder.append("=> " + DefaultParameters.MAIN_IDTF + ":\n");
        stringBuilder.append("\t[Утв. (" + russianIdentifier + ")] "+DefaultParameters.RUSSIAN_LANGUAGE + ";;\n");;
        stringBuilder.append("=> " + DefaultParameters.USING_CONSTANTS + ":\n");
        stringBuilder.append("\t{\n");
        //todo add constants
        stringBuilder.append("\t};;\n");
        stringBuilder.append("<=" + DefaultParameters.TEXT_TRANSLATION + ": ...\n");
        stringBuilder.append("\t(*\n");
        stringBuilder.append("\t\t-> " + DefaultParameters.EXAMPLE +":\n");
        stringBuilder.append("\t\t[" + this.statement + "]" + DefaultParameters.HTML_FLAG + ";;\n");
        stringBuilder.append("\t*);;\n");
        stringBuilder.append("*);;\n");

        result = stringBuilder.toString();

    }
}
