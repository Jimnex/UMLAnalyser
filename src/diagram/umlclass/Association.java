package diagram.umlclass;

public class Association {
    private Node source;
    private Node target;
    private final String targetID;

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
    }

    public String getTargetID() {
        return targetID;
    }

    public Association(Node source, Node target, String targetID){
        this.source = source;
        this.target = target;
        this.targetID = targetID;
    }

    public class Node {
        public Node(String name, Boolean isComposite, Aggregation aggregation, Boolean isNavigableOwned, Multiplicity multiplicity) {
            this.name = name;
            this.isComposite = isComposite;
            this.aggregation = aggregation;
            this.isNavigableOwned = isNavigableOwned;
            this.multiplicity = multiplicity;
        }

        public Node(String name) {
            this.name = name;
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
        private Multiplicity multiplicity;


        public String getName() {
            return name;
        }

        public Boolean getLeaf() {
            return isLeaf;
        }

        public Boolean getStatic() {
            return isStatic;
        }

        public Boolean getReadOnly() {
            return isReadOnly;
        }

        public Boolean getDerived() {
            return isDerived;
        }

        public Boolean getDerivedUnion() {
            return isDerivedUnion;
        }

        public Boolean getComposite() {
            return isComposite;
        }

        public Aggregation getAggregation() {
            return aggregation;
        }

        public Boolean getNavigableOwned() {
            return isNavigableOwned;
        }

        public Multiplicity getMultiplicity() {
            return multiplicity;
        }

    }
}
