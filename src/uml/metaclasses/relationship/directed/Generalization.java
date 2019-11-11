package uml.metaclasses.relationship.directed;

import uml.metaclasses.Classifier;

import java.util.ArrayList;
import java.util.List;

public class Generalization implements DirectedRelationship<Classifier> {
    /** A generalization is directed relationship between a more general
     * classifier (superclass) and a more specific classifier (subclass). */

    private Classifier superClassifier;
    private String superClassifierID;

    public Generalization(String superClassifierID) {
        this.superClassifierID = superClassifierID;
    }

    public Classifier getSuperClassifier() {
        return superClassifier;
    }

    public void setSuperClassifier(Classifier superClassifier) {
        this.superClassifier = superClassifier;
    }
}

