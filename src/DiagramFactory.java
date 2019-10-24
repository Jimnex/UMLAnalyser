import diagram.Diagram;
import diagram.umlclass.ClassDiagram;
import org.apache.commons.io.FilenameUtils;
import parser.classdiagram.xml.visualstudio15.VS15XMLClassDiagramParser;

import java.io.File;
import java.util.Optional;

public class DiagramFactory {

    Optional<Diagram> createDiagram(String filePath){
        Optional<Diagram> diagram;
        switch (this.getExtension(filePath)){
            case "classdiagram":
                diagram = Optional.ofNullable(new VS15XMLClassDiagramParser(new File(filePath)).parse());
                break;
            default:
                diagram = Optional.empty();
        }
        return diagram;
    }

    private String getExtension(String filePath){
        String extension = FilenameUtils.getExtension(filePath);
        //TODO: Exception handling
        return extension;
    }
}
