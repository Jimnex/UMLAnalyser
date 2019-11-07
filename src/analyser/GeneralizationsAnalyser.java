package analyser;

import uml.diagrams.Structure;
import uml.metaclasses.relationship.directed.Generalization;

public abstract class GeneralizationsAnalyser extends Analyser {

    @Override
    Reporter analyse(Structure structure) {
        for (Generalization generalization: structure.getGeneralization()) {
            reporter.addReports(analyseGeneralization(generalization));
        }
        return reporter;
    }

    protected abstract Reporter analyseGeneralization(Generalization generalization);
}
