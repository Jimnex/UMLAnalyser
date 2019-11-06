package uml.diagrams.umlclass;

import uml.metaclasses.Type;

public class OperationParameter {
    private final String name;
    private final Type type;

    public OperationParameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public OperationParameter(){
        this.name = "N/A";
        this.type = new Type();
    }
}
