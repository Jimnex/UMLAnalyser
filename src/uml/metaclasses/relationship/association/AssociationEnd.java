package uml.metaclasses.relationship.association;

import uml.metaclasses.Classifier;
import uml.metaclasses.Element;
import uml.metaclasses.Multiplicity;

public class AssociationEnd implements Element {
    private Classifier owner;
    private Multiplicity multiplicity;
    public final AggregationType aggregationType;
    public final Boolean isNavigableOwned;

    public Classifier getOwner() {
        return owner;
    }

    public AggregationType getAggregationType(){
        return this.aggregationType;
    }

    public Multiplicity getMultiplicity(){
        return this.multiplicity;
    }

    public AssociationEnd(Classifier owner, AggregationType aggregationType, Boolean isNavigableOwned, Multiplicity multiplicity) {
        this.owner = owner;
        this.aggregationType = aggregationType;
        this.isNavigableOwned = isNavigableOwned;
        this.multiplicity = multiplicity;
    }
}
