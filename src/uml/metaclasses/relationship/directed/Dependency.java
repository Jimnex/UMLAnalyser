package uml.metaclasses.relationship.directed;

import uml.metaclasses.relationship.directed.DirectedRelationship;

import uml.metaclasses.NamedElement;

public interface Dependency<T extends NamedElement> extends DirectedRelationship<T> {}
