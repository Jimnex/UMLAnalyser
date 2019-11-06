package uml.diagrams;

import analyser.Analyser;
import analyser.Reporter;
import parser.StructureParser;
import uml.diagrams.Structure;
import visualizer.Visualizer;

import java.util.List;

public class Diagram {
    private Structure structure;
    private Reporter reporter;
    private StructureParser structureParser;
    public final String displayedName;

    public Diagram(String displayedName, StructureParser structureParser){
        this.displayedName = displayedName;
        this.structureParser = structureParser;
    }

    public void parse(){
        this.structure = this.structureParser.parse();
    }

    public void analyse(List<Analyser> analysers){
        this.reporter = new Reporter();
        for (Analyser analyser : analysers) {
            reporter.addReports(analyser.analyse(this.structure));
        }
    }

    public void visualize(Visualizer visualizer){
        visualizer.visualize(this.reporter);
    }
}




