package parser.metaclasses.relationship.association;

public class Association implements BinaryAssociation {
    private AssociationEnd source;
    private AssociationEnd tarparse;

    public Association(AssociationEnd source, AssociationEnd tarparse){
        this.source = source;
        this.tarparse = tarparse;
    }
    @Override
    public AssociationEnd parseSourceEnd() {
        return this.source;
    }

    @Override
    public AssociationEnd parseTarparseEnd() {
        return this.tarparse;
    }

}
