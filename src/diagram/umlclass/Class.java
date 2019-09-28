package diagram.umlclass;

import java.util.ArrayList;
import java.util.Collection;

public class Class {
    public Class(String name) {
        this.name = name;
    }
    private String name;
    private Boolean isAbstract;
    private Boolean isStatic;
    private String id;

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    private Visibility visibility;
    private Collection<Class> childs = new ArrayList<Class>();
    private Collection<Class> bases = new ArrayList<Class>();
    private Collection<String> baseIds = new ArrayList<String>();

    private Collection<Association> associations = new ArrayList<Association>();
    private Collection<Field> fields = new ArrayList<Field>();
    private Collection<Method> methods = new ArrayList<Method>();
    private Collection<Dependency> dependencies = new ArrayList<Dependency>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAbstract() {
        return isAbstract;
    }

    public void setAbstract(Boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Class> getChilds() {
        return childs;
    }

    public void setChilds(Collection<Class> childs) {
        this.childs = childs;
    }

    public Collection<Class> getBases() {
        return bases;
    }

    public void setBases(Collection<Class> bases) {
        this.bases = bases;
    }

    public Collection<String> getBaseIds() {
        return baseIds;
    }

    public void setBaseIds(Collection<String> baseIds) {
        this.baseIds = baseIds;
    }

    public Collection<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(Collection<Association> associations) {
        this.associations = associations;
    }

    public Collection<Field> getFields() {
        return fields;
    }

    public void setFields(Collection<Field> fields) {
        this.fields = fields;
    }

    public Collection<Method> getMethods() {
        return methods;
    }

    public void setMethods(Collection<Method> methods) {
        this.methods = methods;
    }

    public Collection<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Collection<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public Class(String name, Boolean isAbstract, Boolean isStatic, Visibility visibility, Collection<Association> associations, Collection<Field> fields, Collection<Method> methods) {
        this.name = name;
        this.isAbstract = isAbstract;
        this.isStatic = isStatic;
        this.visibility = visibility;
        this.associations = associations;
        this.fields = fields;
        this.methods = methods;
    }
}
