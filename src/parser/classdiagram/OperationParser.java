package parser.classdiagram;

import uml.diagrams.umlclass.Operation;
import uml.metaclasses.Type;
import uml.metaclasses.Visibility;
import uml.diagrams.umlclass.OperationParameter;
import parser.NameParser;
import parser.Parser;

import java.util.List;

public abstract class OperationParser implements Parser<Operation> , NameParser {

    @Override
    public Operation parse() {
        return new Operation(this.parseID(),
                this.parseName(),
                this.parseVisibility(),
                this.parseIsStatic(),
                this.parseIsAbstract(),
                this.parseIsLeaf(),
                this.parseReturnType(),
                this.parseParameters());
    }

    protected abstract Boolean parseIsLeaf();

    protected  abstract String parseID();

    protected abstract Boolean parseIsAbstract();

    protected abstract Type parseReturnType();

    protected abstract Boolean parseIsStatic();

    protected abstract Visibility parseVisibility();

    protected abstract List<OperationParameter> parseParameters();

}
