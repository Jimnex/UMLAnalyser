package parser.classdiagram;

import diagram.Visibility;
import diagram.umlclass.*;
import diagram.umlclass.Class;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassParser implements Parser<Class> {
    protected Parser<Operation> operationParser;
    protected Parser<Attribute> attributeParser;
    protected Parser<Association> associationParser;

    public Class parse(){
        return new Class(this.parseID(),
                this.parseName(),
                this.parseIsAbstract(),
                this.parseVisibility(),
                this.parseAssociations(),
                this.parseAttributes(),
                this.parseOperations(),
                this.getBaseIDs());
    }

    protected abstract List<String> getBaseIDs();

    protected abstract String parseID();

    protected abstract List<String> parseBaseClasses();

    protected abstract String parseName();

    abstract protected Visibility parseVisibility();

    abstract protected Boolean parseIsAbstract();

    //region Attributes

    private List<Attribute> parseAttributes() {
        List<Attribute> attributes = new ArrayList<>();
        for (int i = 0; i < getNumberOfAttributes(); i++) {
            attributes.add(parseAttribute(i));
        }
        return attributes;
    }

    protected abstract int getNumberOfAttributes();

    protected Attribute parseAttribute(int index) {
        getDataForAttribute(index);
        return attributeParser.parse();
    }

    protected abstract void getDataForAttribute(int index);

    //endregion

    //region Operations

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


    //endregion

    //region Associations

    private List<Association> parseAssociations() {
        List<Association> attributes = new ArrayList<>();
        for (int i = 0; i < getNumberOfAssociations(); i++) {
            attributes.add(parseAssociation(i));
        }
        return attributes;
    }

    protected abstract int getNumberOfAssociations();

    protected Association parseAssociation(int index){
        getDataForAssociation(index);
        return this.associationParser.parse();
    }

    protected abstract void getDataForAssociation(int index);

    //endregion

}
