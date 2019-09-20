import diagram.Diagram;
import org.apache.commons.io.FilenameUtils;
import parser.Parser;
import parser.classdiagram.xml.visualstudio15.VS15XMLClassDiagramParser;

class DiagramFactory {

    Diagram createDiagram(String filePath){
        switch (this.getExtension(filePath)){
            case "classdiagram":
                VS15XMLClassDiagramParser diagramParser = new VS15XMLClassDiagramParser(filePath);
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
