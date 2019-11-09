package parser.metaclasses.relationship.association;

import parser.metaclasses.ClassifierParser;
import parser.metaclasses.ElementParser;
import parser.metaclasses.Multiplicity;

public class AssociationEnd implements ElementParser {
    private ClassifierParser owner;
    private Multiplicity multiplicity;
    public final AggregationType aggregationType;
    public final Boolean isNavigableOwned;

    public ClassifierParser parseOwner() {
        return owner;
    }

    public AggregationType parseAggregationType(){
        return this.aggregationType;
    }

    public Multiplicity parseMultiplicity(){
        return this.multiplicity;
    }

    public AssociationEnd(ClassifierParser owner, AggregationType aggregationType, Boolean isNavigableOwned, Multiplicity multiplicity) {
        this.owner = owner;
        this.aggregationType = aggregationType;
        this.isNavigableOwned = isNavigableOwned;
        this.multiplicity = multiplicity;
    }
}
