package parser.classdiagram;

import diagram.AggregationType;
import diagram.umlclass.Attribute;
import diagram.Type;
import diagram.Visibility;
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
                this.parseAggregation(),
                this.parseIsComposite());
    }
    protected abstract Type parseType();

    protected abstract Visibility parseVisibility();

    protected abstract Boolean parseIsStatic();

    protected abstract Boolean parseIsReadOnly();

    protected abstract AggregationType parseAggregation();

    protected abstract Boolean parseIsComposite();

}
