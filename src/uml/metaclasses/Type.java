package uml.metaclasses;

import javax.swing.text.html.parser.Element;



public class Type implements NamedElement {
    private String id;
    private String name;
    private final static String NOT_DEFINED = "N/A";


    public Type(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Type() {
        this.id = NOT_DEFINED;
        this.name = NOT_DEFINED;
    }


    public Type(String name){
        this.name = name;
        this.id = NOT_DEFINED;
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
