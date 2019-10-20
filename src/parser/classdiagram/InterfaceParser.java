package parser.classdiagram;

import diagram.umlclass.Interface;
import diagram.umlclass.Operation;
import parser.IDParser;
import parser.NameParser;
import parser.Parser;

import java.util.List;

public abstract class InterfaceParser implements Parser<Interface>, NameParser, IDParser {
    @Override
    public Interface parse() {
        return new Interface(this.parseName(), this.parseBaseIDs(), this.parseMethods());
    }

    protected abstract List<Operation> parseMethods();

    protected abstract List<String> parseBaseIDs();
}
