package diagram.umlclass;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private Boolean isAbstract;
    private Boolean isStatic;
    private Visibility visibility;
    private List<String> baseClassIDs = new ArrayList<>();
    private List<String> baseInterfaceIDs = new ArrayList<>();
    private List<Association> associations = new ArrayList<Association>();
    private List<Field> fields = new ArrayList<Field>();
    private List<Method> methods = new ArrayList<Method>();;

    public Class(String name) {
        this.name = name;
    }

    public Class(String name, Boolean isAbstract, Boolean isStatic, Visibility visibility, List<Association> associations, List<Field> fields, List<Method> methods, List<String> baseClassIDs) {
        this.name = name;
        this.isAbstract = isAbstract;
        this.isStatic = isStatic;
        this.visibility = visibility;
        this.associations = associations;
        this.fields = fields;
        this.methods = methods;
        this.baseClassIDs = baseClassIDs;
    }

    public Visibility getVisibility() {
        return visibility;
    }

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

    public List<Field> getFields() {
        return new ArrayList<>(this.fields);
    }

    public List<Method> getMethods() {
        return new ArrayList<>(this.methods);
    }

    public List<String> getBaseInterfaceIDs() {
        return new ArrayList<>(this.baseInterfaceIDs);
    }
}
