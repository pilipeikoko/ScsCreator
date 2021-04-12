package org.bsuir.scs.writer;

import org.bsuir.scs.entity.ScsEntity;
import org.bsuir.scs.util.DefaultParameters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ScsFileWriter {
    private ScsEntity scsEntity;

    public ScsFileWriter(ScsEntity scsEntity) {
        this.scsEntity = scsEntity;
    }

    public void write() throws IOException {
        String result = scsEntity.getCustomCreator().getResult();

        File file = new File(DefaultParameters.DEFAULT_PATH + scsEntity.getCustomCreator().getSystemIdentifier() + ".scs");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(result);
        fileWriter.close();

    }

    public void write(File file) throws IOException {
        String result = scsEntity.getCustomCreator().getResult();

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(result);
        fileWriter.close();

    }
}
