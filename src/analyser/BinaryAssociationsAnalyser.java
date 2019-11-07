package analyser;

import uml.diagrams.Structure;
import uml.metaclasses.relationship.association.BinaryAssociation;

public abstract class BinaryAssociationsAnalyser extends Analyser {

    @Override
    public Reporter analyse(Structure structure) {
        for (BinaryAssociation binaryAssociation: structure.getBinaryAssociation()) {
            reporter.addReports(analyseAssociation(binaryAssociation));
        }
        return reporter;
    }

    protected abstract Reporter analyseAssociation(BinaryAssociation binaryAssociation);
}
