package diagram.umlclass;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private Boolean isAbstract;
    private Boolean isStatic;
    private String id;
    private Visibility visibility;
    private List<String> childIds = new ArrayList<>();
    private List<String> baseIds = new ArrayList<>();
    private List<Association> associations = new ArrayList<Association>();
    private List<Field> fields = new ArrayList<Field>();
    private List<Method> methods = new ArrayList<Method>();
    private List<Dependency> dependencies = new ArrayList<Dependency>();

    public Class(String name) {
        this.name = name;
    }

    public Class(String name, Boolean isAbstract, Boolean isStatic, Visibility visibility, List<Association> associations, List<Field> fields, List<Method> methods) {
        this.name = name;
        this.isAbstract = isAbstract;
        this.isStatic = isStatic;
        this.visibility = visibility;
        this.associations = associations;
        this.fields = fields;
        this.methods = methods;
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

    public String getId() {
        return id;
    }

    public List<String> getChilds() {
        return new ArrayList<>(this.childIds);
    }

    public List<String> getBaseIds() {
        return new ArrayList<>(this.baseIds);
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

    public List<Dependency> getDependencies() {
        return dependencies;
    }

}
