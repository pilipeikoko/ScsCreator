package org.bsuir.scs.entity;

import org.bsuir.scs.creator.CustomCreator;
import org.bsuir.scs.writer.ScsFileWriter;

import java.io.FileWriter;

public class ScsCreator {
    private CustomCreator customCreator;

    public ScsCreator(CustomCreator customCreator){
        this.customCreator = customCreator;
    }

    public CustomCreator getCustomCreator() {
        return customCreator;
    }

    public void setCustomCreator(CustomCreator customCreator) {
        this.customCreator = customCreator;
    }

    public void createFile(){
        customCreator.create();
        ScsFileWriter scsFileWriter = new ScsFileWriter(this);
    }
}
