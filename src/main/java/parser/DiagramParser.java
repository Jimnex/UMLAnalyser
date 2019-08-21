package parser;

import java.io.File;

public abstract class DiagramParser {
    private File file;

    DiagramParser(File file){
        this.file = file;
    }

    public abstract DiagramParser parse();
}
