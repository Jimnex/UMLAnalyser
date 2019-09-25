package parser.classdiagram;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Association;
import diagram.umlclass.Multiplicity;
import parser.NameParser;
import parser.Parser;

public abstract class AssociationParser implements Parser<Association>, NameParser{
    protected Association association;

    @Override
    public Association parse() {
        return this.association = new Association(this.parseNode(true), this.parseNode(false));
    }

    private Association.Node parseNode(boolean isSource) {
        return new Association.Node(this.parseName(),
                this.parseIsComposite(),
                this.parseAggregation(),
                this.parseIsNavigableOwned(),
                this.parseMultiplicity(true),
                this.parseMultiplicity(false));
    }

    protected abstract boolean parseIsComposite();

    protected abstract Aggregation parseAggregation();

    protected abstract boolean parseIsNavigableOwned();

    protected abstract Multiplicity parseMultiplicity(boolean isLower);

}



