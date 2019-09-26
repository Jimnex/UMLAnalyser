package parser.classdiagram;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Association;
import diagram.umlclass.Multiplicity;
import parser.NameParser;
import parser.Parser;

public abstract class AssociationParser implements Parser<Association>{
    protected Association association;

    @Override
    public Association parse() {
        return this.association = new Association(this.parseNode(true), this.parseNode(false));
    }

    protected abstract Association.Node parseNode(boolean isSource);
/*
    protected abstract boolean parseIsComposite(boolean isSource);

    protected abstract Aggregation parseAggregation(boolean isSource);

    protected abstract boolean parseIsNavigableOwned(boolean isSource);

    protected abstract Multiplicity parseMultiplicity(boolean isLower);
*/
}



