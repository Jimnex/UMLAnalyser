package analyser;

import uml.diagrams.Structure;
import uml.metaclasses.Classifier;


import java.util.List;

public abstract class ClassifiersNamingConventionAnalyser extends Analyser {

    @Override
    public Reporter analyse(Structure structure) {
        Reporter reporter = new Reporter();
        List<Classifier> classifiers = this.getClassifier(structure);
        for (Classifier classifier: classifiers) {
            reporter.addReports(analyseNaming(classifier.getName()));
        }
        return reporter;
    }

    protected abstract List<Classifier> getClassifier(Structure structure);

    protected abstract Reporter analyseNaming(String name);

}
