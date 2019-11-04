package diagram;

import analyser.Analyser;
import analyser.Reporter;

import java.util.List;

public abstract class Diagram {
    protected String name;
    protected Structure structure;

    public abstract String getDisplayedName();

    public void parse(){
        this.name = parseName();
    }

    public abstract String parseName();

    public Reporter analyse(List<Analyser> analysers){
        Reporter reporter = new Reporter();
        for (Analyser analyser : analysers) {
            reporter.addReports(analyser.analyse(this.structure));
        }
        return reporter;
    }
}
