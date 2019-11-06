package parser.classdiagram;

import uml.metaclasses.relationship.association.AssociationEnd;
import uml.metaclasses.relationship.association.Association;
import parser.Parser;

public abstract class AssociationParser implements Parser<Association>{
    protected Association association;

    @Override
    public Association parse() {
        return this.association = new Association(this.parseEnd(true), this.parseEnd(false));
    }

    protected abstract AssociationEnd parseEnd(boolean isSource);
/*
    protected abstract boolean parseIsComposite(boolean isSource);

    protected abstract Aggregation parseAggregation(boolean isSource);

    protected abstract boolean parseIsNavigableOwned(boolean isSource);

    protected abstract Multiplicity parseMultiplicity(boolean isLower);
*/
}



