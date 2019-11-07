package uml.metaclasses.relationship.association;

import uml.metaclasses.relationship.Relationship;

public interface BinaryAssociation extends Relationship {
    AssociationEnd getSourceEnd();
    AssociationEnd getTargetEnd();
}
