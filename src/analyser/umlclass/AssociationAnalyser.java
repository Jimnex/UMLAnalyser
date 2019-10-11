package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.umlclass.Aggregation;
import diagram.umlclass.Association;
import diagram.umlclass.Class;
import diagram.umlclass.Field;

import java.util.List;

public class AssociationAnalyser implements Analyser {
    private final Association association;
    private final Reporter reporter;
    private final List<Field> fields;

    public AssociationAnalyser(Association association, List<Field> fields){
        this.association = association;
        this.reporter = new Reporter();
        this.fields = fields;
    }

    //region Association
    @Override
    public Reporter analyse () {
        if(isClassMeetsAssociationRequirement1(association, fields) == false) {
            this.reporter.addReport(association.getSource().getAggregation() == Aggregation.SHARED ? "Aggregáció" : "Kompozíció","A Tartalmazott osztály nincsen a tartalmazó osztályban");
        }
        if(isClassMeetsAssociationRequirement2(association, fields) == false){
            this.reporter.addReport(association.getSource().getAggregation() == Aggregation.SHARED ? "Aggregáció" : "Kompozíció", "A Tartalmazott osztály multiplicitása != kapcsolat multiplicitásával");
        }
        return reporter;
    }

    /**
     * Returns true if the owner class declares the owned class.
     * @param association
     * @param fields
     * @return boolean
     */
    private boolean isClassMeetsAssociationRequirement1(Association association, List<Field> fields) {
        for (int i = 0; i < fields.size(); i++) {
            if(fields.get(i).getType().getName().equalsIgnoreCase()) { //TODO: can we use id?
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the owned class's multiplicity in the owner class equals with association target multiplicity.
     * @param association
     * @return
     */
    private boolean isClassMeetsAssociationRequirement2 (Association association, List<Field> fields) {
        for (int i = 0; i < fields.size(); i++) {
            if(fields.get(i).getType().getName().equalsIgnoreCase(targetClassName)) { //TODO: can we use id?
                return fields.get(i).getMultiplicity() == association.getTarget().getMultiplicity();
            }
        }
        return false;
    }

    //endregion

}

