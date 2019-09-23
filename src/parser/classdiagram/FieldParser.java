package parser.classdiagram;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Field;
import diagram.umlclass.Type;
import diagram.umlclass.Visibility;
import parser.NameParser;
import parser.Parser;

public abstract class FieldParser implements Parser<Field>, NameParser {
    @Override
    public Field parse() {
        return new Field(this.parseName(),
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

    protected abstract Aggregation parseAggregation();

    protected abstract Boolean parseIsComposite();

}
