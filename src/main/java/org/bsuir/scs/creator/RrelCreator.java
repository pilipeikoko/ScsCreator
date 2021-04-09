package org.bsuir.scs.creator;

public class RrelCreator extends CustomCreator{

    public RrelCreator(String systemIdentifier,String definition,String statement){
        this.definition = definition;
        this.statement = statement;
        this.systemIdentifier = systemIdentifier;
    }

    @Override
    public void create() {

    }
}
