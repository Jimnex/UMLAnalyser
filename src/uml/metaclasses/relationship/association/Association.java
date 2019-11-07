package uml.metaclasses.relationship.association;

public class Association implements BinaryAssociation {
    private AssociationEnd source;
    private AssociationEnd target;

    public Association(AssociationEnd source, AssociationEnd target){
        this.source = source;
        this.target = target;
    }
    @Override
    public AssociationEnd getSourceEnd() {
        return this.source;
    }

    @Override
    public AssociationEnd getTargetEnd() {
        return this.target;
    }

}
