package uml.metaclasses.relationship.directed;

import uml.metaclasses.Classifier;

import java.util.ArrayList;
import java.util.List;

public class Generalization implements DirectedRelationship<Classifier> {
    /** A generalization is directed relationship between a more general
     * classifier (superclass) and a more specific classifier (subclass). */

    private Classifier superClassifier;
    private List<Classifier> subClassesifier;

    public Generalization(Classifier superClassifier) {
        this.superClassifier = superClassifier;
        this.subClassesifier = new ArrayList<>();
    }

    public void addSubClassifier(Classifier subClassifier){
        this.subClassesifier.add(subClassifier);
    }

    public Classifier getSuperClassifier() {
        return superClassifier;
    }

    public List<Classifier> getSubClassifiers() {
        return new ArrayList<>(subClassesifier);
    }
}

