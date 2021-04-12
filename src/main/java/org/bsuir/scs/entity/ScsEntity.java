package org.bsuir.scs.entity;

import org.bsuir.scs.creator.CustomCreator;
import org.bsuir.scs.writer.ScsFileWriter;

import java.io.File;
import java.io.IOException;

public class ScsEntity {
    private CustomCreator customCreator;

    public ScsEntity(CustomCreator customCreator){
        this.customCreator = customCreator;
    }

    public CustomCreator getCustomCreator() {
        return customCreator;
    }

    public void setCustomCreator(CustomCreator customCreator) {
        this.customCreator = customCreator;
    }

    public void createFile() throws IOException {
        customCreator.create();
        ScsFileWriter scsFileWriter = new ScsFileWriter(this);
        scsFileWriter.write();
    }

    public void createFile(File file) throws IOException {
        customCreator.create();
        ScsFileWriter scsFileWriter = new ScsFileWriter(this);
        scsFileWriter.write(file);
    }
}
