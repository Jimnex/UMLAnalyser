package uml.diagrams.umlclass;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uml.metaclasses.Classifier;
import uml.metaclasses.NamedElement;
import uml.metaclasses.Visibility;
import uml.metaclasses.feature.BehavioralFeature;
import uml.metaclasses.feature.StructuralFeature;

import javax.naming.directory.AttributeInUseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Interface implements Classifier {
    private String id;
    private String name;
    private Visibility visibility;
    private List<String> baseIDs;
    private List<Operation> operations;
    private List<Attribute> staticAttributes;

    public Interface(String id, String name, Visibility visibility, List<String> baseIDs, List<Operation> operations, List<Attribute> staticAttributes) {
        this.id = id;
        this.name = name;
        this.visibility = visibility;
        this.baseIDs = baseIDs;
        this.operations = operations;
        this.staticAttributes = staticAttributes;
    }

    @Override
    public String getIdentifier() {
        return id;
    }

    @Override
    public boolean checkIsAbstract() {
        return false;
    }

    @Override
    public Collection<StructuralFeature> getStructuralFeatures() {
        return new ArrayList<>(staticAttributes);
    }

    @Override
    public Collection<BehavioralFeature> getBehaviorFeatures() {
        return new ArrayList<>(operations);
    }

    @Override
    public boolean checkIsLeaf() {
        return false;
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