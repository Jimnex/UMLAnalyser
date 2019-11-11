package uml.metaclasses;

import uml.metaclasses.feature.BehavioralFeature;
import uml.metaclasses.feature.StructuralFeature;
import uml.metaclasses.relationship.association.BinaryAssociation;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.Collection;
import java.util.List;

public interface Classifier extends RedefinableElement{
    boolean checkIsAbstract();
    List<StructuralFeature> getStructuralFeatures();
    List<BehavioralFeature> getBehaviorFeatures();
    List<BinaryAssociation> getBinaryAssocations();
    List<Generalization> getGeneralizations();
    List<Dependency> getDependencies();
}
