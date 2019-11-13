package uml.diagrams;

import analyser.Analyser;
import analyser.Reporter;
import parser.Parser;
import visualizer.Visualizer;

import java.util.List;
import java.util.Optional;

public class Diagram<T extends Structure> {
    protected Optional<T> structure;
    protected Parser<T> structureParser;
    protected Reporter reporter;
    protected String displayedName;

    public Diagram(String displayedName, Parser<T> structureParser){
        this.displayedName = displayedName;
        this.structureParser = structureParser;
    }

    public void parse(){
        this.structure = Optional.ofNullable(this.structureParser.parse());
    }

    public void analyse(List<Analyser> analysers){
        this.reporter = new Reporter();
        for (Analyser analyser : analysers) {
            reporter.addReports(analyser.analyse(structure.get()));
        }
    }

    public void visualize(Visualizer visualizer){
        visualizer.visualize(this.reporter);
    }

    public Structure getStructure(){
        return this.structure.get();
    }

    public boolean checkStructureIsPresent(){
        return this.structure.isPresent();
    }

    public String getDisplayedName(){
        return this.displayedName;
    }
}




