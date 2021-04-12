package org.bsuir.scs.creator;

import org.bsuir.scs.util.DefaultParameters;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomCreator {
    protected String result;
    protected String systemIdentifier;
    protected String definition;
    protected String statement;
    protected String russianIdentifier;
    protected String englishIdentifier;
    protected List<String> definitionConstants;
    protected List<String> statementsConstants;

    abstract public void create();

    public void init(String systemIdentifier, String definition, String statement, String russianIdentifier, String englishIdentifier) {
        this.definition = definition;
        this.statement = statement;
        this.systemIdentifier = systemIdentifier;
        this.russianIdentifier = russianIdentifier;
        this.englishIdentifier = englishIdentifier;
        definitionConstants = new ArrayList<>();
        statementsConstants = new ArrayList<>();
    }

    public String createDefinition() {
        String constants = constantsAtList(this.definitionConstants);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(systemIdentifier).append(" <- ").append(DefaultParameters.KEY_SC_ELEMENT).append(": ...\n");
        stringBuilder.append("(*\n");
        stringBuilder.append("<- " + DefaultParameters.DEFINITION + ";;\n");
        stringBuilder.append("=> " + DefaultParameters.MAIN_IDTF + ":\n");
        stringBuilder.append("\t[Опр. (").append(russianIdentifier).append(")] ").append(DefaultParameters.RUSSIAN_LANGUAGE).append(";;\n");
        stringBuilder.append("=> " + DefaultParameters.USING_CONSTANTS + ":\n");
        stringBuilder.append("\t{\n");
        stringBuilder.append(constants);
        stringBuilder.append("\t};;\n");
        stringBuilder.append("<= " + DefaultParameters.TEXT_TRANSLATION + ": ...\n");
        stringBuilder.append("\t(*\n");
        stringBuilder.append("\t\t-> " + DefaultParameters.EXAMPLE + ":\n");
        stringBuilder.append("\t\t[" + this.definition + "]" + DefaultParameters.HTML_FLAG + ";;\n");
        stringBuilder.append("\t*);;\n");
        stringBuilder.append("*);;\n\n");

        return stringBuilder.toString();
    }

    private String constantsAtList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); ++i) {
            stringBuilder.append(list.get(i));
            if (i != list.size() - 1) {
                stringBuilder.append(";\n");
            } else
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String createStatement() {
        String constants = constantsAtList(this.statementsConstants);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(systemIdentifier).append(" <- ").append(DefaultParameters.KEY_SC_ELEMENT).append(": ...\n");
        stringBuilder.append("(*\n");
        stringBuilder.append("<- " + DefaultParameters.STATEMENT + ";;\n");
        stringBuilder.append("=> " + DefaultParameters.MAIN_IDTF + ":\n");
        stringBuilder.append("\t[Утв. (").append(russianIdentifier).append(")] ").append(DefaultParameters.RUSSIAN_LANGUAGE).append(";;\n");
        ;
        stringBuilder.append("=> " + DefaultParameters.USING_CONSTANTS + ":\n");
        stringBuilder.append("\t{\n");
        stringBuilder.append(constants);
        stringBuilder.append("\t};;\n");
        stringBuilder.append("<= " + DefaultParameters.TEXT_TRANSLATION + ": ...\n");
        stringBuilder.append("\t(*\n");
        stringBuilder.append("\t\t-> " + DefaultParameters.EXAMPLE + ":\n");
        stringBuilder.append("\t\t[").append(this.statement).append("]").append(DefaultParameters.HTML_FLAG).append(";;\n");
        stringBuilder.append("\t*);;\n");
        stringBuilder.append("*);;\n\n");

        return stringBuilder.toString();
    }

    abstract protected String createHeader();

    public String getResult() {
        return result;
    }

    public String getSystemIdentifier() {
        return systemIdentifier;
    }
}
