package parser.metaclasses.relationship.directed;

import parser.metaclasses.ClassifierParser;

import java.util.ArrayList;
import java.util.List;

public class GeneralizationParser implements DirectedRelationship<ClassifierParser> {
    /** A generalization is directed relationship between a more general
     * classifier (superclass) and a more specific classifier (subclass). */

    private ClassifierParser superClassifier;
    private List<ClassifierParser> subClassesifier;

    public Generalization(ClassifierParser superClassifier) {
        this.superClassifier = superClassifier;
        this.subClassesifier = new ArrayList<>();
    }

    public void addSubClassifier(ClassifierParser subClassifier){
        this.subClassesifier.add(subClassifier);
    }

    public ClassifierParser parseSuperClassifier() {
        return superClassifier;
    }

    public List<ClassifierParser> parseSubClassifiers() {
        return new ArrayList<>(subClassesifier);
    }
}

