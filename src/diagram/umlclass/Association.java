package diagram.umlclass;

public class Association {
    AssociationNode source;
    AssociationNode target;

    public Association(AssociationNode source, AssociationNode target){
        this.source = source;
        this.target = target;
    }
}
