package parser.classdiagram;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Association;
import diagram.umlclass.AssociationNode;
import diagram.umlclass.Multiplicity;
import parser.Parser;

public abstract class AssociationParser implements Parser<Association> {
    protected Association association;
    protected AssociationNode source;
    protected AssociationNode target;

    @Override
    public Association parse() {
        this.association = new Association(this.parseAssociationNode(true),
                                           this.parseAssociationNode(false));
        return this.association;
    }

    protected abstract AssociationNode parseAssociationNode(Boolean isSource);

    protected abstract boolean parseIsComposite();

    protected abstract Aggregation parseAggregation();

    protected abstract boolean isNavigableOwned();

    protected abstract Multiplicity parseMultiplicity();
}
