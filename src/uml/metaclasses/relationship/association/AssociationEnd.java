package uml.metaclasses.relationship.association;

import uml.metaclasses.Element;
import uml.metaclasses.Multiplicity;

public class AssociationEnd implements Element {
    private String ownerIdentifier;
    private Multiplicity multiplicity;
    public final AggregationType aggregationType;
    public final Boolean isNavigableOwned;

    @Override
    public String getIdentifier() {
        return ownerIdentifier;
    }

    public AggregationType getAggregationType(){
        return this.aggregationType;
    }

    public Multiplicity getMultiplicity(){
        return this.multiplicity;
    }

    public AssociationEnd(String ownerIdentifier, AggregationType aggregationType, Boolean isNavigableOwned, Multiplicity multiplicity) {
        this.ownerIdentifier = ownerIdentifier;
        this.aggregationType = aggregationType;
        this.isNavigableOwned = isNavigableOwned;
        this.multiplicity = multiplicity;
    }
}
