package factory;

import analyser.Analyser;

import java.util.List;
import java.util.Optional;

public class ClassDiagramAnalysersFactory extends AnalysersFactory{
    public ClassDiagramAnalysersFactory(List<String> conventions) {
        super(conventions);
    }

    @Override
    protected Optional<Analyser> create(String convention) {
        return null;
    }
}
