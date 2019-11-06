package parser.classdiagram;

import uml.metaclasses.Multiplicity;
import uml.metaclasses.relationship.association.AggregationType;
import uml.diagrams.umlclass.Attribute;
import uml.metaclasses.Type;
import uml.metaclasses.Visibility;
import parser.NameParser;
import parser.Parser;

public abstract class AttributeParser implements Parser<Attribute>, NameParser {
    @Override
    public Attribute parse() {
        return new Attribute(this.parseName(),
                this.parseType(),
                this.parseVisibility(),
                this.parseIsStatic(),
                this.parseIsReadOnly(),
                this.parseIsLeaf(),
                this.parseMultiplicity(),
                this.parseAggregation(),
                this.parseIsComposite());
    }

    protected abstract Multiplicity parseMultiplicity();

    protected abstract Boolean parseIsLeaf();

    protected abstract Type parseType();

    protected abstract Visibility parseVisibility();

    protected abstract Boolean parseIsStatic();

    protected abstract Boolean parseIsReadOnly();

    protected abstract AggregationType parseAggregation();

    protected abstract Boolean parseIsComposite();

}
