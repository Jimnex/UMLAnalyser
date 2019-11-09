package analyser;

import uml.diagrams.Structure;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.List;

public abstract class GeneralizationsAnalyser extends Analyser {

    @Override
    public Reporter analyse(Structure structure) {
        for (Generalization generalization: structure.getGeneralization()) {
            reporter.addReports(analyseGeneralization(generalization));
        }
        return reporter;
    }

    protected abstract Reporter analyseGeneralization(Generalization generalization);

    protected  <T> boolean anyCommonItem(List<T> l1, List<T> l2){
        for (int i = 0; i < l1.size(); i++) {
            if (l2.contains(l1.get(i))){
                return false;
            }
        }
        return true;
    }
}
