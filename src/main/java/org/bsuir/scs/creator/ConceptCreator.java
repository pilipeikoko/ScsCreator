package org.bsuir.scs.creator;

import org.bsuir.scs.util.DefaultParameters;
import org.bsuir.scs.parser.ConstantsParser;

public class ConceptCreator extends CustomCreator {

    public ConceptCreator(String systemIdentifier, String definition, String statement, String russianIdentifier, String englishIdentifier) {
        init(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier);
    }

    @Override
    public void create() {
        ConstantsParser constantsParser = new ConstantsParser();

        definitionConstants = constantsParser.getConstants(definition);
        statementsConstants = constantsParser.getConstants(statement);
        definition = constantsParser.replaceConstantsWithLinks(definition);
        statement = constantsParser.replaceConstantsWithLinks(statement);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(createHeader());
        stringBuilder.append(createDefinition());
        stringBuilder.append(createStatement());

        result = stringBuilder.toString();

    }

    @Override
    protected String createHeader() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(systemIdentifier).append(" <- ").append(DefaultParameters.CONCEPT_NODE_TYPE).append(";;\n\n");
        stringBuilder.append(systemIdentifier).append(" => ").append(DefaultParameters.MAIN_IDTF).append(":\n");
        stringBuilder.append("[").append(russianIdentifier).append("] ").append(DefaultParameters.RUSSIAN_LANGUAGE).append(";\n");
        stringBuilder.append("[").append(englishIdentifier).append("] ").append(DefaultParameters.ENGLISH_LANGUAGE).append(";;\n\n");

        return stringBuilder.toString();
    }
}
