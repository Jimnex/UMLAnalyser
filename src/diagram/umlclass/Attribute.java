package diagram.umlclass;

import diagram.*;

public class Attribute implements StructuralFeature {
    private String id;
    private String name;
    private Type type;
    private Visibility visibility;
    private Boolean isLeaf;
    private Boolean isStatic;
    private Boolean isReadOnly;
    private Boolean isUnique;
    private AggregationType aggregation;
    private Boolean isComposite;
    private Multiplicity multiplicity;

    public Attribute(String name, Type type, Visibility visibility, Boolean isStatic, Boolean isReadOnly, AggregationType aggregation, Boolean isComposite) {
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
            Attribute f = (Attribute) o;
            return f.name.equalsIgnoreCase(this.name) &&
                    f.type.getName().equalsIgnoreCase(this.type.getName());
        } else {
            return false;
        }
    }

    @Override
    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    @Override
    public boolean checkIsStatic() {
        return this.isStatic;
    }

    @Override
    public boolean checkIsLeaf() {
        return this.checkIsLeaf();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Visibility getVisibility() {
        return this.getVisibility();
    }

    @Override
    public String getIdientifier() {
        return this.id;
    }

    @Override
    public Multiplicity getMultiplicityBound() {
        return null;
    }

    public Type getType() {
        return type;
    }
}
