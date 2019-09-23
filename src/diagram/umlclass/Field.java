package diagram.umlclass;

public class Field {
    private String name;
    private Type type;
    private Visibility visibility;
    private Boolean isLeaf;
    private Boolean isStatic;
    private Boolean isReadOnly;
    private Boolean isUnique;
    private Boolean isDerived;
    private Boolean isDerivedUnion;
    private Aggregation aggregation;
    private Boolean isComposite;

    public Field(String name, Type type, Visibility visibility, Boolean isStatic, Boolean isReadOnly, Aggregation aggregation, Boolean isComposite) {
        this.name = name;
        this.type = type;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isReadOnly = isReadOnly;
        this.aggregation = aggregation;
        this.isComposite = isComposite;
    }
}
