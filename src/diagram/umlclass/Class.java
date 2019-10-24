package diagram.umlclass;

import diagram.Classifier;
import diagram.Visibility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Class implements Classifier {
    private String id;
    private String name;
    private Boolean isAbstract;
    private Visibility visibility;
    private List<String> baseClassIDs = new ArrayList<>();
    private List<String> baseInterfaceIDs;
    private List<Association> associations;
    private List<Attribute> attributes;
    private Collection<Operation> operations;

    public Class(String name) {
        this.name = name;
    }

    public Class(String id, String name, Boolean isAbstract, Visibility visibility, List<Association> associations, List<Attribute> attributes, List<Operation> operations, List<String> baseClassIDs) {
        this.id = id;
        this.name = name;
        this.isAbstract = isAbstract;
        this.visibility = visibility;
        this.associations = associations;
        this.attributes = attributes;
        this.operations = operations;
        this.baseClassIDs = baseClassIDs;
    }

    @Override
    public Visibility getVisibility() {
        return visibility;
    }

    @Override
    public String getName() {
        return name;
    }

    public Boolean getAbstract() {
        return isAbstract;
    }

    public List<String> getBaseClassIDs() {
        return new ArrayList<>(this.baseClassIDs);
    }

    public List<Association> getAssociations() {
        return new ArrayList<>(this.associations);
    }

    public List<Attribute> getAttributes() {
        return new ArrayList<>(this.attributes);
    }

    public List<Operation> getOperations() {
        return new ArrayList<>(this.operations);
    }

    public List<String> getBaseInterfaceIDs() {
        return new ArrayList<>(this.baseInterfaceIDs);
    }

    @Override
    public String getIdientifier() {
        return id;
    }

    @Override
    public boolean checkIsAbstract() {
        return this.isAbstract;
    }

    @Override
    public boolean checkIsLeaf() {
        return false;
    }
}
