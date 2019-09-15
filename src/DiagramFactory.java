import analyser.ClassDiagramAnalyser;
import com.sun.xml.internal.bind.v2.TODO;
import diagram.Diagram;
import diagram.umlclass.ClassDiagram;
import org.apache.commons.io.FilenameUtils;
import parser.classdiagram.xml.visualstudio15.VS15XMLClassDiagramParser;

import java.io.File;
import java.util.*;

class DiagramFactory {

    Diagram createDiagram(String filePath){
        switch (this.getExtension(filePath)){
            case "classdiagram":
                return new ClassDiagram(new VS15XMLClassDiagramParser(filePath));
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
