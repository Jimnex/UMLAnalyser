package parser.classdiagram;

import uml.metaclasses.Visibility;
import uml.diagrams.umlclass.*;
import uml.diagrams.umlclass.Class;
import parser.Parser;
import uml.metaclasses.relationship.association.Association;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassParser implements Parser<Class> {
    protected Parser<Operation> operationParser;
    protected Parser<Attribute> attributeParser;
    protected Parser<Association> associationParser;
    protected Parser<Generalization> generalizationParser;
    protected Parser<Dependency> dependencyParser;

    public Class parse(){
        return new Class(this.parseID(),this.parseName(),this.parseIsAbstract(),this.parseIsLeaf(),this.parseVisibility(),this.parseAttributes(),this.parseOperations(),this.parseAssociations(),this.parseGeneralization(),this.parseDependencies());
    }

    protected abstract List<Dependency> parseDependencies();

    protected abstract List<Generalization> parseGeneralization();

    protected abstract String parseID();

    protected abstract String parseName();

    abstract protected Visibility parseVisibility();

    abstract protected Boolean parseIsAbstract();

    abstract protected Boolean parseIsLeaf();

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
