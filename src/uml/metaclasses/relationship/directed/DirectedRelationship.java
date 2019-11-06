package uml.metaclasses.relationship.directed;

import uml.metaclasses.Element;
import uml.metaclasses.relationship.Relationship;

public interface DirectedRelationship<T extends Element> extends Relationship {
    /** A directed relationship is an
     * abstract relationship between
     * a collection of source elements
     * and a collection of target elements. */

    T getSourceElement();
    T getTargetElement();
}
