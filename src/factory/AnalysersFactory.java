package factory;

import analyser.Analyser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AnalysersFactory implements Factory<List<Analyser>> {
    private final List<String> conventions;

    public AnalysersFactory(List<String> conventions) {
        this.conventions = conventions;
    }

    @Override
    public List<Analyser> create() {
        List<Analyser> analysers = new ArrayList<>();
        for (String convention: conventions) {
            Optional<Analyser> analyser = create(convention);
            if(analyser.isPresent()){
                analysers.add(analyser.get());
            }
        }
        return analysers;
    }

    abstract Optional<Analyser> create(String convention);
}
