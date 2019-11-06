package uml.metaclasses;

import uml.metaclasses.feature.BehavioralFeature;
import uml.metaclasses.feature.StructuralFeature;

import java.util.Collection;

public interface Classifier extends RedefinableElement, Namespace{
    boolean checkIsAbstract();
    Collection<StructuralFeature> getStructuralFeatures();
    Collection<BehavioralFeature> getBehaviorFeatures();
}
