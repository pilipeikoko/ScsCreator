package org.bsuir.scs.writer;

import org.bsuir.scs.entity.ScsCreator;
import org.bsuir.scs.params.DefaultParameters;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScsFileWriter {
    private ScsCreator scsCreator;

    public ScsFileWriter(ScsCreator scsCreator){
        this.scsCreator = scsCreator;
    }

    public void write(){
        String result = scsCreator.getCustomCreator().getResult();
        try {
            File file = new File(DefaultParameters.DEFAULT_PATH + scsCreator.getCustomCreator().getSystemIdentifier() + ".scs");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(result);
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
