package uml.diagrams.umlclass;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uml.metaclasses.Classifier;
import uml.metaclasses.NamedElement;
import uml.metaclasses.Visibility;
import uml.metaclasses.feature.BehavioralFeature;
import uml.metaclasses.feature.StructuralFeature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Interface implements Classifier {
    private String id;
    private String name;
    private Visibility visibility;
    private List<Operation> operations;
    private List<Attribute> staticAttributes;

    public Interface(String id, String name, Visibility visibility, List<Operation> operations, List<Attribute> staticAttributes) {
        this.id = id;
        this.name = name;
        this.visibility = visibility;
        this.operations = operations;
        this.staticAttributes = staticAttributes;
    }

    public Interface(String parseID, String parseName, List<String> parseBases, List<Operation> parseOperations) {
    }

    @Override
    public boolean checkIsAbstract() {
        return false;
    }

    @Override
    public List<StructuralFeature> getStructuralFeatures() {
        return new ArrayList<>(staticAttributes);
    }

    @Override
    public List<BehavioralFeature> getBehaviorFeatures() {
        return new ArrayList<>(operations);
    }

    @Override
    public boolean checkIsLeaf() {
        return false;
    }

    @Override
    public String getIndentifier() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Visibility getVisibility() {
        return visibility;
    }

    @Override
    public Collection<NamedElement> getOwnedNamedElements() {
        throw new NotImplementedException();
    }
}
