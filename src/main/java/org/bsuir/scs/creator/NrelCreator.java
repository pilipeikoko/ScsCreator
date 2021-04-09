package org.bsuir.scs.creator;

public class NrelCreator extends CustomCreator{
    public NrelCreator(String systemIdentifier,String definition,String statement){
        this.definition = definition;
        this.statement = statement;
        this.systemIdentifier = systemIdentifier;
    }

    @Override
    public void create() {

    }
}
