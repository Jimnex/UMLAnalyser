package parser;
import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class XMLDiagramParserFactory implements DiagramParserFactory {

    @Override
    public DiagramParser create(File file) throws NotSupportedXMLDiagramParser {
        String extension = this.getExtension(file.getPath());
        if ("classdiagram".equals(extension)) {
            return new XMLClassDiagramParser(file);
        }
        throw new NotSupportedXMLDiagramParser();
    }

    private String getExtension(String filePath){
        String fileExtension = FilenameUtils.getExtension(filePath);
        return fileExtension;
    }
}
