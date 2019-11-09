package parser.metaclasses;

public class TypeParser implements NamedElementParser {
    private final String id;
    private final String name;

    public TypeParser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeParser(){
        this.id = "N/A";
        this.name = "N/A";
    }

    @Override
    public String parseIndentifier() {
        return id;
    }

    @Override
    public String parseName() {
        return this.name;
    }

    @Override
    public VisibilityParser parseVisibility() {
        return VisibilityParser.NONE;
    }

}
