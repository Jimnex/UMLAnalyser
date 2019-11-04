package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.AggregationType;
import diagram.umlclass.Association;
import diagram.umlclass.Attribute;
import diagram.umlclass.Class;
import parser.classdiagram.AttributeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClassAnalyser implements Analyser {
    private final Class c;
    private final List<Class> classes;
    Reporter reporter;


    public ClassAnalyser(Class c, List<Class> classes) {
        this.c = c;
        this.classes = classes;
        this.reporter = new Reporter();
    }

    public Reporter analyse() {
        if(meetsClassNamingConvention() == false){
            reporter.addReport("Név konvenció", String.format("s% osztály nem nagybetűvel kezdődik", this.c.getName()));
        }

        analyseAssociations();
        analyseAttributes();
        analyseInheritance();

        return reporter;
    }

    private boolean meetsClassNamingConvention(){
        return Character.isUpperCase(this.c.getName().charAt(0));
    }

    //region Association

    private void analyseAssociations() {
        for(Association association: c.getAssociations()){
            analyseAssociation(association);
        }
    }

    private void analyseAssociation (Association association) {
        if(isClassMeetsAssociationRequirement1(association) == false) {
            this.reporter.addReport(association.getSourceEnd().getAggregationType() == AggregationType.SHARED ? "Aggregáció" : "Kompozíció","A Tartalmazott osztály nincsen a tartalmazó osztályban");
        }
        if(isClassMeetsAssociationRequirement2(association) == false){
            this.reporter.addReport(association.getSourceEnd().getAggregationType() == AggregationType.SHARED ? "Aggregáció" : "Kompozíció", "A Tartalmazott osztály multiplicitása != kapcsolat multiplicitásával");
        }
    }

    /**
     * Returns true if the owner class declares the owned class.
     * @param  association
     * @return boolean
     */
    private boolean isClassMeetsAssociationRequirement1(Association association) {
        Optional<Class> targetClass = getClass(association.getTargetEnd().getIdientifier());
        if(targetClass.isPresent()) {
            for (int i = 0; i < this.c.getAttributes().size(); i++) {
                if (this.c.getAttributes().get(i).getType().getName().equalsIgnoreCase(targetClass.get().getName())) { //TODO: can we use id?
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if the owned class's multiplicity in the owner class equals with association target multiplicity.
     * @param association
     * @return
     */
    private boolean isClassMeetsAssociationRequirement2 (Association association) {
        Optional<Class> targetClass = getClass(association.getTargetEnd().getIdientifier());
        if(targetClass.isPresent()){
            for (int i = 0; i < this.c.getAttributes().size(); i++) {
                if(this.c.getAttributes().get(i).getType().getName().equalsIgnoreCase(targetClass.get().getName())) { //TODO: can we use id?
                    return this.c.getAttributes().get(i).getMultiplicityBound().equals(association.getTargetEnd().getMultiplicity());
                }
            }
        }
        return false;
    }

    //endregion

    //region Attributes

    private  void analyseAttributes(){
           /*
        for(Attribute attribute: c.getAttributes()){
            reporter.addReports(new (attribute).analyse());
        }
        */
    }

    private Optional<Class> getClass(String identifier){
        for (Class c: this.classes) {
            if(c.equals(c.getIdientifier()))
                return Optional.ofNullable(c);
        }
        return Optional.empty();
    }

    //endregion

    //region Inheritance

    private void analyseInheritance() {
        if (c.getBaseClassIDs().isEmpty() == false) {
            if (isClassMeetsInheritanceRequirementuirement0()) {
                if (isClassMeetsInheritanceRequirementuirement1() == false) {
                    this.reporter.addReport("Öröklés", "Osztálynak nincsen egy tulajdonsága vagy viselkedése sem");
                } else {
                    if (isClassMeetsInheritanceRequirementuirement2() == false) {
                        this.reporter.addReport("Öröklés", "Osztálynak van olyan deklarált tulajdonsága vagy viselkedése amely az ősben is deklarálva van");
                    }
                    if(isClassMeetsInheritanceRequirementuirement3() == false){
                        this.reporter.addReport("Öröklés", "Osztálynak van olyan deklarált tulajdonsága vagy viselkedése amely az egyik testvérében is deklarálva van");
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
    private boolean isClassMeetsInheritanceRequirementuirement0(){
        return c.getBaseClassIDs().size() == 1;
    }

    /**
     * Returns true if analysed class has any field or method.
     * @return boolean
     */
    private boolean isClassMeetsInheritanceRequirementuirement1(){
        return c.getOperations().isEmpty() == false || c.getOperations().isEmpty() == false;
    }

    /**
     * Returns true if the analysed class has NO common field or method with its base class. Regulation does not include overriding base class methods or fields.
     * @return boolean
     */
    private boolean isClassMeetsInheritanceRequirementuirement2() {
        Class baseClass = getClass(this.c.getBaseClassIDs().get(0)).get();
        return anyCommonItem(c.getAttributes(), baseClass.getAttributes()) &&
                anyCommonItem(c.getOperations(), baseClass.getOperations());
    }

    /**
     * Returns true if analysed class has NO intersect field or method with its sibling classes.
     * @return boolean
     */
    private boolean isClassMeetsInheritanceRequirementuirement3() {
        List<Class> siblingClasses = this.classes.stream().filter(x -> x.getBaseInterfaceIDs().get(0) == this.c.getBaseInterfaceIDs().get(0)
                                                               && x.getIdientifier() != c.getIdientifier())
                                                               .collect(Collectors.toList());
        for (Class sibling: siblingClasses) {
            if(anyCommonItem(sibling.getOperations(), c.getOperations()) || anyCommonItem(sibling.getAttributes(), sibling.getAttributes())){
                return false;
            }
        }
        return true;
    }

    private <T> boolean anyCommonItem(List<T> l1, List<T> l2){
        for (int i = 0; i < l1.size(); i++) {
            if (l2.contains(l1.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public <T> Reporter analyse(T structure) {
        return null;
    }

    //endregion


}
