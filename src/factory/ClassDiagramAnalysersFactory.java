package factory;

import analyser.Analyser;
import analyser.umlclass.AtLeastOneAttribiteOrOperationConvention;
import analyser.umlclass.FirstUpperCharNamingConvention;
import analyser.umlclass.association.AssociationConvention1Analyser;
import analyser.umlclass.inheritance.InheritanceConvention1Analyser;
import uml.diagrams.Structure;
import uml.diagrams.umlclass.ClassDiagramStructure;

import java.util.List;
import java.util.Optional;

public class ClassDiagramAnalysersFactory extends AnalysersFactory{
    public ClassDiagramAnalysersFactory(List<String> conventions) {
        super(conventions);
    }

    @Override
    protected Optional<Analyser> create(String convention) {
        Optional<Analyser> analyser;
        switch (convention){
            case "firstUpperNameC":
                analyser = Optional.of(new FirstUpperCharNamingConvention());
                break;
            case "atLeastOneAttributeOrOperation":
                analyser = Optional.of(new AtLeastOneAttribiteOrOperationConvention());
                break;
            default:
                analyser = Optional.empty();
                break;
        }

        return analyser;
    }
}
