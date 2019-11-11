package uml.diagrams;

import analyser.Analyser;
import analyser.Reporter;
import parser.Parser;
import parser.StructureParser;
import uml.diagrams.Structure;
import visualizer.Visualizer;

import java.util.List;

public class Diagram<T extends Structure> {
    protected T structure;
    protected Parser<T> structureParser;
    protected Reporter reporter;
    protected String displayedName;

    public Diagram(String displayedName, Parser<T> structureParser){
        this.displayedName = displayedName;
        this.structureParser = structureParser;
    }

    public void parse(){
        this.structure = this.structureParser.parse();
    }

    public void analyse(List<Analyser> analysers){
        this.reporter = new Reporter();
        for (Analyser analyser : analysers) {
            reporter.addReports(analyser.analyse());
        }
    }

    public void visualize(Visualizer visualizer){
        visualizer.visualize(this.reporter);
    }

    public Structure getStructure(){
        return this.structure;
    }

    public String getDisplayedName(){
        return this.displayedName;
    }
}




