package uml.metaclasses.relationship.association;

import uml.metaclasses.Element;
import uml.metaclasses.Multiplicity;

public class AssociationEnd implements Element {
    private String id;
    private Multiplicity multiplicity;
    public final AggregationType aggregationType;
    public final Boolean isNavigableOwned;

    public AggregationType getAggregationType(){
        return this.aggregationType;
    }

    public Multiplicity getMultiplicity(){
        return this.multiplicity;
    }

    public AssociationEnd(AggregationType aggregationType, Boolean isNavigableOwned, Multiplicity multiplicity) {
        this.aggregationType = aggregationType;
        this.isNavigableOwned = isNavigableOwned;
        this.multiplicity = multiplicity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getNavigableOwned() {
        return isNavigableOwned;
    }
}
