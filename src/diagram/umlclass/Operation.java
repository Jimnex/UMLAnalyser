package diagram.umlclass;

import diagram.BehavioralFeature;
import diagram.Type;
import diagram.Visibility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operation implements BehavioralFeature {
    private final String id;
    private final String name;
    private final Visibility visibility;
    private final Boolean isStatic;
    private final Boolean isAbstract;
    private final Boolean isLeaf;
    private final Type returnType;
    private List<OperationParameter> parameters;

    public Operation(String id, String name, Visibility visibility, Boolean isStatic, Boolean isAbstract, Boolean isLeaf, Type returnType, List<OperationParameter> parameters) {
        this.id = id;
        this.name = name;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.isLeaf = isLeaf;
        this.returnType = returnType;
        this.parameters = new ArrayList<>();
    }

    public void addParameter(OperationParameter parameter){
        this.parameters.add(parameter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(name, operation.name) &&
                Objects.equals(returnType, operation.returnType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, returnType);
    }

    public OperationParameter getParameter(int index){
        return this.parameters.get(index);
    }

    @Override
    public boolean checkIsAbstract() {
        return false;
    }

    @Override
    public boolean checkIsStatic() {
        return this.isStatic;
    }

    @Override
    public boolean checkIsLeaf() {
        return this.isLeaf;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public String getIdientifier() {
        return this.id;
    }

    public class Parameter {

    }
}
