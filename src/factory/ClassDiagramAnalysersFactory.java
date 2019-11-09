package factory;

import analyser.Analyser;
import analyser.umlclass.association.AssociationConvention1Analyser;
import analyser.umlclass.inheritance.InheritanceConvention1Analyser;

import java.util.List;
import java.util.Optional;

public class ClassDiagramAnalysersFactory extends AnalysersFactory{
    public ClassDiagramAnalysersFactory(List<String> conventions) {
        super(conventions);
    }

    @Override
    protected Optional<Analyser> create(String convention) {
        Optional<Analyser> analyser = Optional.empty();
        switch (convention){
            case "a":
                Optional.of(new AssociationConvention1Analyser());
                break;
            case "b":
                Optional.of(new InheritanceConvention1Analyser());
                break;
            default:
                Optional.empty();
        }

        return analyser;
    }
}
