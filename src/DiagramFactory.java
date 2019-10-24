import diagram.Diagram;
import diagram.umlclass.ClassDiagram;
import org.apache.commons.io.FilenameUtils;
import parser.classdiagram.xml.visualstudio15.VS15XMLClassDiagramParser;

import java.util.Optional;

public class DiagramFactory {

    Diagram createDiagram(String filePath){
        Optional<Diagram> diagram;
        switch (this.getExtension(filePath)){
            case "classdiagram":
                diagram = new ClassDiagram();
                diagramParser.parse();
            default:
                return null;
        }
    }

    private String getExtension(String filePath){
        String extension = FilenameUtils.getExtension(filePath);
        //TODO: Exception handling
        return extension;
    }
}
