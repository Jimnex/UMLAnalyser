package factory;

import analyser.Analyser;
import analyser.umlclass.*;
import analyser.umlclass.association.AssociationConvention1Analyser;
import analyser.umlclass.association.AssociationConvention2Analyser;
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
            case "noCommonAttributeOrBehaviorWithSuper":
                analyser = Optional.of(new InheritanceConvention1Analyser());
                break;
            case "interfaceOrAbstractClassHasAtLeastOneDerived":
                analyser = Optional.of(new InterfaceOrAbstractClassHasAtLeastOneDerived());
                break;
            case "interfaceOnlyPublicFieldsAndOperations":
                analyser = Optional.of(new InterfaceHasOnlyPublicFieldsAndOperations());
                break;
            case "interfaceContainsFields":
                analyser = Optional.of(new InterfaceHasAttributes());
                break;
            case "interfaceOnlyStaticFields":
                analyser = Optional.of(new InterfaceHasOnlyStaticAttributes());
                break;
            case "interfaceHasPublicScope":
                analyser = Optional.of(new InterfaceHasPublicScope());
                break;
            case "association1":
                analyser = Optional.of(new AssociationConvention1Analyser());
                break;
            case "association2":
                analyser = Optional.of(new AssociationConvention2Analyser());
                break;
            default:
                analyser = Optional.empty();
        }

        return analyser;
    }
}
