package diagram.umlclass;

import java.util.Objects;

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
    private Multiplicity multiplicity;

    public Field(String name, Type type, Visibility visibility, Boolean isStatic, Boolean isReadOnly, Aggregation aggregation, Boolean isComposite) {
        this.name = name;
        this.type = type;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isReadOnly = isReadOnly;
        this.aggregation = aggregation;
        this.isComposite = isComposite;
    }

    @Override
    public boolean equals(Object o) {
        if (Object.class.equals(this.getClass())){
            Field f = (Field) o;
            return f.name.equalsIgnoreCase(this.name) &&
                    f.type.getName().equalsIgnoreCase(this.type.getName());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public Boolean getStatic() {
        return isStatic;
    }

    public Aggregation getAggregation() {
        return aggregation;
    }

    public Boolean getComposite() {
        return isComposite;
    }

    public Multiplicity getMultiplicity() {
        return multiplicity;
    }
}
