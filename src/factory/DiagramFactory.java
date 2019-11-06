package factory;

import uml.diagrams.Diagram;
import org.apache.commons.io.FilenameUtils;
import parser.classdiagram.xml.visualstudio15.VS15XMLClassDiagramStructureParser;

import java.io.File;
import java.util.Optional;

public class DiagramFactory implements Factory<Optional<Diagram>> {
    private final String filePath;

    public DiagramFactory(String filePath) {
        this.filePath = filePath;
    }

    private String getExtension(String filePath){
        String extension = FilenameUtils.getExtension(filePath);
        //TODO: Exception handling
        return extension;
    }

    @Override
    public Optional<Diagram> create() {
        Optional<Diagram> diagram;
        switch (this.getExtension(filePath)){
            case "classdiagram":
                diagram = Optional.ofNullable(new Diagram("Class diagram",
                                                           new VS15XMLClassDiagramStructureParser(new File(filePath))));
                break;
            default:
                diagram = Optional.empty();
        }
        return diagram;
    }
}
