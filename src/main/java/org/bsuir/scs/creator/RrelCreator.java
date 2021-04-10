package org.bsuir.scs.creator;

import org.bsuir.scs.params.DefaultParameters;

public class RrelCreator extends CustomCreator {
    public int arity;
    public String firstDomain;
    public String secondDomain;
    boolean isSymmetric;
    boolean isTransitive;
    boolean isReflexive;


    public RrelCreator(String systemIdentifier, String definition, String statement, String russianIdentifier, String englishIdentifier) {
        init(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier);
    }

    public RrelCreator(String systemIdentifier, String definition, String statement, String russianIdentifier, String englishIdentifier, int arity, String firstDomain, String secondDomain, boolean isSymmetric, boolean isReflexive, boolean isTransitive) {
        init(systemIdentifier, definition, statement, russianIdentifier, englishIdentifier);
        this.arity = arity;
        this.firstDomain = firstDomain;
        this.secondDomain = secondDomain;
        this.isReflexive = isReflexive;
        this.isSymmetric = isSymmetric;
        this.isTransitive = isTransitive;
    }

    @Override
    public void create() {
        //todo add constants parser
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(createHeader());
        stringBuilder.append(createDefinition());
        stringBuilder.append(createStatement());

        if (firstDomain != null)
            stringBuilder.append(createAdditionalInformation());


        result = stringBuilder.toString();

    }

    @Override
    protected String createHeader() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(systemIdentifier).append(" <- ").append(DefaultParameters.NREL_NODE_TYPE).append(";;\n\n");
        stringBuilder.append(systemIdentifier).append(" => ").append(DefaultParameters.MAIN_IDTF).append(":\n");
        stringBuilder.append("[").append(russianIdentifier).append("] ").append(DefaultParameters.RUSSIAN_LANGUAGE).append(";\n");
        stringBuilder.append("[").append(englishIdentifier).append("] ").append(DefaultParameters.ENGLISH_LANGUAGE).append(";;\n\n");
        stringBuilder.append(createAdditionalInformation());

        return stringBuilder.toString();
    }

    private String createAdditionalInformation(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(systemIdentifier).append("\n");

        stringBuilder.append("=> ").append(DefaultParameters.FIRST_DOMAIN).append(": ").append(firstDomain).append(";\n");
        stringBuilder.append("=> ").append(DefaultParameters.SECOND_DOMAIN).append(": ").append(secondDomain).append(";\n\n");

        stringBuilder.append("=> ").append(DefaultParameters.DEFINITIONAL_DOMAIN).append(": ...\n");
        stringBuilder.append("(*\n");
        stringBuilder.append("\t<= ").append(DefaultParameters.COMBINATION).append(":\n");
        stringBuilder.append("\t{\n");
        stringBuilder.append("\t\t").append(firstDomain).append(";\n");
        stringBuilder.append("\t\t").append(secondDomain).append(";;\n");
        stringBuilder.append("\t};;\n");
        stringBuilder.append("*);;\n\n");

        stringBuilder.append(DefaultParameters.ARITY).append(" -> ...\n");
        stringBuilder.append("(*\n");
        stringBuilder.append("\t-> ").append(systemIdentifier).append(";;\n");
        stringBuilder.append("\t=> ").append(DefaultParameters.MEASUREMENT).append(": ").append(arity).append(";;\n");
        stringBuilder.append("*);;\n\n");

        stringBuilder.append(DefaultParameters.ORIENTED_RELATION_INCLUSION).append("\n");
        stringBuilder.append("(*\n");
        stringBuilder.append("\t-> ").append(systemIdentifier).append(";;\n");
        stringBuilder.append("*);;\n\n");

        stringBuilder.append(DefaultParameters.BINARY_RELATION_INCLUSION).append("\n");
        stringBuilder.append("(*\n");

        stringBuilder.append("\t ").append(DefaultParameters.SYMMETRIC_RELATION_INCLUSION).append("\n");
        stringBuilder.append("\t(*\n");
        if(isSymmetric)
            stringBuilder.append("\t\t-> ").append(systemIdentifier).append(";;\n");
        else
            stringBuilder.append("\t\t-|> ").append(systemIdentifier).append(";;\n");
        stringBuilder.append("\t*);;\n\n");


        stringBuilder.append("\t ").append(DefaultParameters.TRANSITIVE_RELATION_INCLUSION).append("\n");
        stringBuilder.append("\t(*\n");
        if(isTransitive)
            stringBuilder.append("\t\t-> ").append(systemIdentifier).append(";;\n");
        else
            stringBuilder.append("\t\t-|> ").append(systemIdentifier).append(";;\n");
        stringBuilder.append("\t*);;\n\n");


        stringBuilder.append("\t ").append(DefaultParameters.REFLEXIVE_RELATION_INCLUSION).append("\n");
        stringBuilder.append("\t(*\n");
        if(isReflexive)
            stringBuilder.append("\t\t-> ").append(systemIdentifier).append(";;\n");
        else
            stringBuilder.append("\t\t-|> ").append(systemIdentifier).append(";;\n");
        stringBuilder.append("\t*);;\n\n");

        stringBuilder.append("*);;\n");

        return stringBuilder.toString();
    }
}
