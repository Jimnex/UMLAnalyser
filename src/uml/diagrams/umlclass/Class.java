package uml.diagrams.umlclass;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uml.metaclasses.feature.BehavioralFeature;
import uml.metaclasses.feature.StructuralFeature;
import uml.metaclasses.Classifier;
import uml.metaclasses.NamedElement;
import uml.metaclasses.Visibility;
import uml.metaclasses.relationship.association.Association;
import uml.metaclasses.relationship.association.BinaryAssociation;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Class implements Classifier {
    private String id;
    private String name;
    private boolean isAbstract;
    private boolean isLeaf;
    private Visibility visibility;
    private List<Attribute> attributes;
    private List<Operation> operations;
    private List<Association> associations;
    private List<Generalization> generalizations;
    private List<Dependency> dependencies;

    public Class(String id, String name, boolean isAbstract, boolean isLeaf, Visibility visibility, List<Attribute> attributes, List<Operation> operations, List<Association> associations, List<Generalization> generalizations, List<Dependency> dependencies) {
        this.id = id;
        this.name = name;
        this.isAbstract = isAbstract;
        this.isLeaf = isLeaf;
        this.visibility = visibility;
        this.attributes = attributes;
        this.operations = operations;
        this.associations = associations;
        this.generalizations = generalizations;
        this.dependencies = dependencies;
    }

    @Override
    public Visibility getVisibility() {
        return visibility;
    }

    @Override
    public String getIndentifier() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean checkIsAbstract() {
        return this.isAbstract;
    }

    @Override
    public List<StructuralFeature> getStructuralFeatures() {
        return new ArrayList<>(this.attributes);
    }

    @Override
    public List<BehavioralFeature> getBehaviorFeatures() {
        return new ArrayList<>(operations);
    }

    @Override
    public List<BinaryAssociation> getBinaryAssocations() {
        return new ArrayList<>(associations);
    }

    @Override
    public List<Generalization> getGeneralizations() {
        return generalizations;
    }

    @Override
    public List<Dependency> getDependencies() {
        return dependencies;
    }

    @Override
    public boolean checkIsLeaf() {
        return isLeaf;
    }

}
