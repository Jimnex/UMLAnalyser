package diagram.umlclass;

public class AssociationNode {
    public AssociationNode(String name, Boolean isComposite, Aggregation aggregation, Boolean isNavigableOwned, Multiplicity lower, Multiplicity upper) {
        this.name = name;
        this.isComposite = isComposite;
        this.aggregation = aggregation;
        this.isNavigableOwned = isNavigableOwned;
        this.lower = lower;
        this.upper = upper;
    }

    private String name;
    private Boolean isLeaf;
    private Boolean isStatic;
    private Boolean isReadOnly;
    private Boolean isDerived;
    private Boolean isDerivedUnion;
    private Boolean isComposite;
    private Aggregation aggregation;
    private Boolean isNavigableOwned;
    private Multiplicity lower;
    private Multiplicity upper;
}

