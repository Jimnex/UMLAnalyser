package diagram.umlclass;

public class Association {
    AssociationNode source;
    AssociationNode target;

    public Association(AssociationNode source, AssociationNode target){
        this.source = source;
        this.target = target;
    }

    public class AssociationNode {

        public AssociationNode(String name, Boolean isLeaf, Boolean isStatic, Boolean isReadOnly, Boolean isDerived, Boolean isDerivedUnion, Boolean isComposite, Aggregation aggregation, Boolean isNavigableOwned, Multiplicity lower, Multiplicity upper) {
            this.name = name;
            this.isLeaf = isLeaf;
            this.isStatic = isStatic;
            this.isReadOnly = isReadOnly;
            this.isDerived = isDerived;
            this.isDerivedUnion = isDerivedUnion;
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
}
