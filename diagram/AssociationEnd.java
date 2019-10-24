package diagram;

public class AssociationEnd implements Element {
    private String ownerIdentifier;
    private AggregationType aggregationType;
    private Boolean isNavigableOwned;
    private Multiplicity multiplicity;

    @Override
    public String getIdientifier() {
        return ownerIdentifier;
    }

    public AssociationEnd(String ownerIdentifier, AggregationType aggregationType, Boolean isNavigableOwned, Multiplicity multiplicity) {
        this.ownerIdentifier = ownerIdentifier;
        this.aggregationType = aggregationType;
        this.isNavigableOwned = isNavigableOwned;
        this.multiplicity = multiplicity;
    }

    public AssociationEnd() {
    }
}
