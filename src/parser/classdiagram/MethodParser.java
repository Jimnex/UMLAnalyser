package parser.classdiagram;

import diagram.umlclass.Method;
import diagram.umlclass.Type;
import diagram.umlclass.Visibility;
import parser.NameParser;
import parser.Parser;

import java.util.List;

public abstract class MethodParser implements Parser<Method> , NameParser {

    @Override
    public Method parse() {
        return new Method(this.parseName(),
                this.parseVisibility(),
                this.parseIsStatic(),
                this.parseIsAbstract(),
                this.parseReturnType(),
                this.parseParameters());
    }

    protected abstract Boolean parseIsAbstract();

    protected abstract Type parseReturnType();

    protected abstract Boolean parseIsStatic();

    protected abstract Visibility parseVisibility();

    protected abstract List<Method.Parameter> parseParameters();

}
