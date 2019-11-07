package analyser.umlclass;

import analyser.BinaryAssociationsAnalyser;
import analyser.Reporter;
import uml.diagrams.umlclass.Attribute;
import uml.diagrams.umlclass.Class;
import uml.metaclasses.Classifier;
import uml.metaclasses.feature.BehavioralFeature;
import uml.metaclasses.relationship.association.AggregationType;
import uml.metaclasses.relationship.association.Association;
import uml.metaclasses.relationship.association.BinaryAssociation;

import java.util.List;
import java.util.Optional;

public class AssociationConventionAnalyser extends BinaryAssociationsAnalyser {

    @Override
    protected Reporter analyseAssociation(BinaryAssociation binaryAssociation) {
        if(isClassMeetsAssociationRequirement1(binaryAssociation) == false) {
            reporter.addReport(binaryAssociation.getSourceEnd().getAggregationType() == AggregationType.SHARED ? "Aggregáció" : "Kompozíció","A Tartalmazott osztály nincsen a tartalmazó osztályban");
        }
        if(isClassMeetsAssociationRequirement2(binaryAssociation) == false){
            reporter.addReport(binaryAssociation.getSourceEnd().getAggregationType() == AggregationType.SHARED ? "Aggregáció" : "Kompozíció", "A Tartalmazott osztály multiplicitása != kapcsolat multiplicitásával");
        }
        return reporter;
    }

    /**
     * Returns true if the owner class declares the owned class.
     * @param  association
     * @return boolean
     */
    private boolean isClassMeetsAssociationRequirement1(BinaryAssociation association) {
        Classifier targetClass = association.getTargetEnd().getOwner();
        List<BehavioralFeature> ownerClassAttributes =  association.getSourceEnd().getOwner().getBehaviorFeatures();
            for (int i = 0; i < ownerClassAttributes.size(); i++) {
                Attribute a = (Attribute) ownerClassAttributes.get(i);
                if (a.getType().getName().equalsIgnoreCase(targetClass.getName())) { //TODO: can we use id?
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
    private boolean isClassMeetsAssociationRequirement2 (BinaryAssociation association) {
        Classifier targetClass = association.getTargetEnd().getOwner();
        List<BehavioralFeature> ownerClassAttributes =  association.getSourceEnd().getOwner().getBehaviorFeatures();
            for (int i = 0; i < ownerClassAttributes.size(); i++) {
                Attribute a = (Attribute) ownerClassAttributes.get(i);
                if(a.getType().getName().equalsIgnoreCase(targetClass.getName())) { //TODO: can we use id?
                    return a.getMultiplicityBound().equals(association.getTargetEnd().getMultiplicity());
                }
            }
        return false;
    }

}
