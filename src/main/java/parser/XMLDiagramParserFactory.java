package parser;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class XMLDiagramParserFactory implements DiagramParserFactory {

    @Override
    public DiagramParser create(File file) throws NotSupportedDiagramParser, IOException, SAXException, ParserConfigurationException {
        String extension = this.getExtension(file.getPath());
        if ("classdiagram".equals(extension)) {
            return new XMLClassDiagramParser(file);
        }
        throw new NotSupportedDiagramParser();
    }

    private String getExtension(String filePath){
        String fileExtension = FilenameUtils.getExtension(filePath);
        return fileExtension;
    }
}
