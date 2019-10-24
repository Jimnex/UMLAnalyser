package diagram.umlclass;

import diagram.AssociationEnd;
import diagram.BinaryAssociation;

public class Association implements BinaryAssociation {
    private AssociationEnd source;
    private AssociationEnd target;

    public Association(AssociationEnd source, AssociationEnd target){
        this.source = source;
        this.target = target;
    }

    @Override
    public AssociationEnd getsourceEnd() {
        return this.source;
    }

    @Override
    public AssociationEnd getTargetEnd() {
        return this.target;
    }
}
