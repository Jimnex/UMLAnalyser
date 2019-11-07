package uml.diagrams;

import uml.metaclasses.relationship.association.BinaryAssociation;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.List;

public interface Structure {
    String getName();
    List<BinaryAssociation> getBinaryAssociation();
    List<Generalization> getGeneralization();
}
