package uml.metaclasses;

import javax.swing.text.html.parser.Element;

public class Type implements NamedElement {
    private final String id;
    private final String name;

    public Type(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Type(){
        this.id = "N/A";
        this.name = "N/A";
    }

    @Override
    public String getIndentifier() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Visibility getVisibility() {
        return Visibility.NONE;
    }

}
