package parser;

import java.io.File;

public interface DiagramParserFactory {
    DiagramParser create(File file) throws NotSupportedDiagramParser;
}
