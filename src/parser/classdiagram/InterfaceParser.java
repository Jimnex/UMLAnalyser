package parser.classdiagram;

import diagram.umlclass.Interface;
import diagram.umlclass.Operation;
import parser.IDParser;
import parser.NameParser;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;

public abstract class InterfaceParser implements Parser<Interface>, NameParser, IDParser {
    protected Parser<Operation> operationParser;

    public Interface parse(){
        return new Interface(this.parseID(),
                this.parseName(),
                this.parseBases(),
                this.parseOperations());
    }

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
