package uml.metaclasses;

import uml.metaclasses.feature.BehavioralFeature;
import uml.metaclasses.feature.StructuralFeature;

import java.util.Collection;
import java.util.List;

public interface Classifier extends RedefinableElement, Namespace{
    boolean checkIsAbstract();
    List<StructuralFeature> getStructuralFeatures();
    List<BehavioralFeature> getBehaviorFeatures();
}
