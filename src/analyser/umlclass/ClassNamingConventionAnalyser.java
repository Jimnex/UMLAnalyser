package analyser.umlclass;

import analyser.ClassifiersNamingConventionAnalyser;
import analyser.Reporter;
import uml.diagrams.Structure;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;


import java.util.ArrayList;
import java.util.List;

public class ClassNamingConventionAnalyser extends ClassifiersNamingConventionAnalyser {

    @Override
    protected List<Classifier> getClassifier(Structure structure) {
        return new ArrayList<Classifier>(((ClassDiagramStructure) structure).getClasses());
    }

    @Override
    protected Reporter analyseNaming(String name) {
        Reporter reporter = new Reporter();
        if(meetsClassNamingConvention(name) == false){
            reporter.addReport("Név konvenció", String.format("s% osztály nem nagybetűvel kezdődik", name));
        }
        return reporter;
    }

    private boolean meetsClassNamingConvention(String name){
        return Character.isUpperCase(name.charAt(0));
    }
}
