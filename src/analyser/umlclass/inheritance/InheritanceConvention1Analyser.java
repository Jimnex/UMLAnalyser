package analyser.umlclass.inheritance;

import analyser.GeneralizationsAnalyser;
import analyser.Reporter;
import uml.metaclasses.Classifier;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.List;

public class InheritanceConvention1Analyser extends GeneralizationsAnalyser {

    @Override
    protected Reporter analyseGeneralization(Generalization generalization) {
        checkAreSubclassifiersMeetsInheritanceRequirementuirement1(generalization);

        //this.reporter.addReport("Öröklés", "Osztálynak van olyan deklarált tulajdonsága vagy viselkedése amely az ősben is deklarálva van");
        //this.reporter.addReport("Öröklés", "Osztály több őssel is rendelkezik. Gyémánt probléma");
        return reporter;
    }

    /**
     * Returns true if the analysed class has ONE and ONLY ONE base class.
     * @return boolean
     */
    /*
    private boolean isClassMeetsInheritanceRequirementuirement0(){
        return c.getBaseClassIDs().size() == 1;
    }
    */

    /**
     * Returns true if analysed class has any field or method.
     * @return boolean
     * @param generalization
     */
    private void checkAreSubclassifiersMeetsInheritanceRequirementuirement1(Generalization generalization){
        for (Classifier subClassifier: generalization.getSubClassifiers()) {
            if(isSubclassifierMeetsInheritanceRequirementuirement1(subClassifier) == false){
                this.reporter.addReport("Öröklés", "Osztálynak nincsen egy tulajdonsága és viselkedése sem");
            }
        }
    }

    private boolean isSubclassifierMeetsInheritanceRequirementuirement1(Classifier subClassifier){
        return subClassifier.getBehaviorFeatures().isEmpty() == false || subClassifier.getStructuralFeatures().isEmpty() == false;
    }


}
