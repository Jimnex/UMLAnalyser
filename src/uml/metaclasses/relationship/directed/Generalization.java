package uml.metaclasses.relationship.directed;

import uml.metaclasses.Classifier;
import uml.metaclasses.relationship.directed.DirectedRelationship;

public interface Generalization extends DirectedRelationship<Classifier> {
    /** A generalization is directed relationship between a more general
     * classifier (superclass) and a more specific classifier (subclass). */
}

