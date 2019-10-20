package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.umlclass.Association;

public class AssociationAnalyser implements Analyser {
    private final Association association;

    public AssociationAnalyser(Association association){
        this.association = association;
    }

    @Override
    public Reporter analyse() {
        Reporter reporter = new Reporter(); //TODO: Check whether association is null
        //boolean isReq1Correct = isClassMeetsAggregationReq1();
        //boolean isReq2Correct = isClassMeetsAggregationReq2();

        //if(isReq1Correct == false) {
         //   reporter.addReport( "Kompozíció", "A Tartalmazott osztály nincsen a tartalmazó osztályban");
        //} else if (isReq2Correct == false) {
         //   reporter.addReport( "Kompozíció", "A Tartalmazott osztály multiplicitása != kapcsolat multiplicitásával");
        //}
        return reporter;
    }

    private boolean isAggregation() {
        //return this.association(&& this == "None" && a.Target.IsComposite == true);
        return false;
    }

    /// <summary>
    /// returns true if the owner class declears the owned class.
    /// </summary>
    private boolean isClassMeetsAggregationReq1(Association aggregation) {
        return false; //.Fields.Any(f => f.Type.Name == aggregation.Target.ClassName);
    }

    /// <summary>
    /// returns true if the owned class's multiplicity in the owner class meets with aggregation target multiplicity.
    /// </summary>
    private boolean isClassMeetsAggregationReq2 (Association aggregation) {
        //if(isReq1Correct){
            //Field ownedClassfield = c.Fields.Find(f => f.Type.Name == aggregation.Target.ClassName);
            //return ownedClassfield.Multiplicity.Value == aggregation.Target.LowerMulti.Value || ownedClassfield.Multiplicity.Value == aggregation.Target.UpperMulti.Value;
        //} else return false;
        return false;
    }

}

