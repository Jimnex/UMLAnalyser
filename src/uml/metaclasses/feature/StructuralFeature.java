package uml.metaclasses.feature;

import uml.metaclasses.Multiplicity;
import uml.metaclasses.MultiplicityElement;

public interface StructuralFeature extends Feature, MultiplicityElement {
    boolean isReadOnly();
}
