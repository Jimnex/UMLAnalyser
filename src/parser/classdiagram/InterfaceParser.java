package parser.classdiagram;

import uml.diagrams.umlclass.Attribute;
import uml.diagrams.umlclass.Interface;
import uml.diagrams.umlclass.Operation;
import parser.IDParser;
import parser.NameParser;
import parser.Parser;
import uml.metaclasses.Visibility;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.ArrayList;
import java.util.List;

public abstract class InterfaceParser implements Parser<Interface>, NameParser, IDParser {
    protected Parser<Operation> operationParser;

    public Interface parse(){
        return new Interface(this.parseID(),this.parseName(),this.parseIsLeaf(),this.parseVisibility(),this.parseOperations(),this.parseAttributes(),this.parseGeneralizations(),this.parseDependencies());
    }

    protected abstract List<Attribute> parseAttributes();

    protected abstract List<Generalization> parseGeneralizations();

    protected abstract Visibility parseVisibility();

    protected abstract boolean parseIsLeaf();

    protected abstract List<Dependency> parseDependencies();

    protected abstract List<String> parseBases();

    private List<Operation> parseOperations() {
        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < getNumberOfOperations(); i++) {
            operations.add(parseOperation(i));
        }
        return operations;
    }

    protected abstract int getNumberOfOperations();

    protected Operation parseOperation(int index) {
        getDataForOperation(index);
        return operationParser.parse();
    }

    protected abstract void getDataForOperation(int index);

}
