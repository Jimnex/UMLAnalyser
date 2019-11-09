package parser.metaclasses;

public interface NamedElementParser extends ElementParser {
    String parseIndentifier();
    String parseName();
    VisibilityParser parseVisibility();


}
