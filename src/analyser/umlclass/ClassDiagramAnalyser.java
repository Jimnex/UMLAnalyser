package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.AggregationType;
import diagram.umlclass.*;
import diagram.umlclass.Class;

import java.util.List;

public class ClassDiagramAnalyser implements Analyser {
    private final ClassDiagram diagram;
    private final Reporter reporter;

    public ClassDiagramAnalyser(ClassDiagram diagram) {
        this.diagram = diagram;
        this.reporter = new Reporter();
    }

    @Override
    public Reporter analyse() {
        ClassAnalyser classAnalyser;
        //for (String id : this.diagram.getIDs()) {
         //   analyseClass(this.diagram.getClass(id));
        //}
        return reporter;
    }

    private <T> boolean anyCommonItem(List<T> l1, List<T> l2){
        for (int i = 0; i < l1.size(); i++) {
            if (l2.contains(l1.get(i))){
                return false;
            }
        }
        return true;
    }

    private void analyseClass(Class c) {
        analyseClassNamingConvention(c.getName());
        analyseInheritance(c);
    }

    private void analyseClassNamingConvention(String name) {
        if (Character.isUpperCase(name.charAt(0)) == false) {
            reporter.addReport("Név konvenció", String.format("s% osztály nem nagybetűvel kezdődik", name));
        }
    }

    //region Inheritance

    private void analyseInheritance(Class c) {
        if (c.getBaseClassIDs().isEmpty() == false) {
            if (isClassMeetsInheritanceRequirementuirement0(c)) {
                if (isClassMeetsInheritanceRequirementuirement1(c) == false) {
                    this.reporter.addReport("Öröklés", "Osztálynak nincsen egy tulajdonsága vagy viselkedése sem");
                } else {
                    if (isClassMeetsInheritanceRequirementuirement2(c) == false) {
                        this.reporter.addReport("Öröklés", "Osztálynak van olyan deklarált tulajdonsága vagy viselkedése amely az ősben is deklarálva van");
                    }
                }
            } else{
                this.reporter.addReport("Öröklés", "Osztály több őssel is rendelkezik. Gyémánt probléma");
            }
        } else {
            this.reporter.addReport("Öröklés", "Osztály egy őssel sem rendelkezik");
        }
    }

    /**
     * Returns true if the analysed class has ONE and ONLY ONE base class.
     * @return boolean
     */
    private boolean isClassMeetsInheritanceRequirementuirement0(Class c){
        return c.getBaseClassIDs().size() == 1;
    }

    /**
     * Returns true if analysed class has any field or method.
     * @param c
     * @return boolean
     */
    private boolean isClassMeetsInheritanceRequirementuirement1(Class c){
        return c.getOperations().isEmpty() == false || c.getOperations().isEmpty() == false;
    }

    /**
     * Returns true if the analysed class has NO common field or method with its base class. Regulation does not include overriding base class methods or fields.
     * @return boolean
     */
    private boolean isClassMeetsInheritanceRequirementuirement2(Class c) {
        //Class baseClassifier = diagram.getClass(c.getBaseClassIDs().get(0));

        return true;// return anyCommonItem(c.getAttributes(), baseClassifier.getAttributes()) && anyCommonItem(c.getOperations(), c.getOperations());
    }

    /**
     * Returns true if analysed class has NO intersect field or method with its sibling classes.
     * @return boolean
     */
    private boolean isClassMeetsInheritanceRequirementuirement3(Class c) {
        return true;
    }

    //endregion

    //region Association

    private void analyseAssociation (Association association, List<Attribute> attributes) {
        if(isClassMeetsAssociationRequirement1(association, attributes) == false) {
            //this.reporter.addReport(association.getSource().getAggregation() == AggregationType.SHARED ? "Aggregáció" : "Kompozíció","A Tartalmazott osztály nincsen a tartalmazó osztályban");
        }
        if(isClassMeetsAssociationRequirement2(association, attributes) == false){
            //this.reporter.addReport(association.getSource().getAggregation() == AggregationType.SHARED ? "Aggregáció" : "Kompozíció", "A Tartalmazott osztály multiplicitása != kapcsolat multiplicitásával");
        }
    }

    /**
     * Returns true if the owner class declares the owned class.
     * @param association
     * @param attributes
     * @return boolean
     */
    private boolean isClassMeetsAssociationRequirement1(Association association, List<Attribute> attributes) {
        //Class targetClassifier = diagram.getClass(association.getTargetID());
        for (int i = 0; i < attributes.size(); i++) {
            //if(attributes.get(i).getType().getName().equalsIgnoreCase(targetClassifier.getName())) { //TODO: can we use id?
                return true;
            //}
        }
        return false;
    }

    /**
     * Returns true if the owned class's multiplicity in the owner class equals with association target multiplicity.
     * @param association
     * @return
     */
    private boolean isClassMeetsAssociationRequirement2 (Association association, List<Attribute> attributes) {
        //Class targetClassifier = diagram.getClass(association.getTargetID());
        for (int i = 0; i < attributes.size(); i++) {
           // if(attributes.get(i).getType().getName().equalsIgnoreCase(targetClassifier.getName())) { //TODO: can we use id?
            //    return attributes.get(i).getMultiplicity() == association.getTarget().getMultiplicity();
            //}
        }
        return false;
    }

    //endregion



}
