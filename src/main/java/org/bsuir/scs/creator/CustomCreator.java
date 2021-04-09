package org.bsuir.scs.creator;

public abstract class CustomCreator {
    protected String result;
    protected String systemIdentifier;
    protected String definition;
    protected String statement;
    protected String russianIdentifier;
    protected String englishIdentifier;

    abstract public void create();

    public String getResult() {
        return result;
    }

    public String getDefinition() {
        return definition;
    }

    public String getStatement() {
        return statement;
    }

    public String getSystemIdentifier() {
        return systemIdentifier;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getEnglishIdentifier() {
        return englishIdentifier;
    }

    public String getRussianIdentifier() {
        return russianIdentifier;
    }

    public void setEnglishIdentifier(String englishIdentifier) {
        this.englishIdentifier = englishIdentifier;
    }

    public void setRussianIdentifier(String russianIdentifier) {
        this.russianIdentifier = russianIdentifier;
    }
}
