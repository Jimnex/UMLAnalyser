package parser.metaclasses.relationship.association;

import parser.metaclasses.relationship.Relationship;

public interface BinaryAssociation extends Relationship {
    AssociationEnd parseSourceEnd();
    AssociationEnd parseTarparseEnd();
}
