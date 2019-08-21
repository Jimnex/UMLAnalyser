package parser;
import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class XMLDiagramParserFactory implements DiagramParserFactory {

    @Override
    public DiagramParser create(File file) throws NotSupportedDiagramParser {
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
