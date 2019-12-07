package uml.diagrams;

import analyser.Analyser;
import analyser.Reporter;
import parser.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Diagram<T extends Structure> {
    private Optional<T> structure;
    private Parser<T> structureParser;
    private Reporter reporter;
    private String displayedName;

    public Diagram(String displayedName, Parser<T> structureParser){
        this.displayedName = displayedName;
        this.structureParser = structureParser;
    }

    public void parse(){
        this.structure = Optional.ofNullable(this.structureParser.parse());
    }

    public void analyse(List<Analyser> analysers){
        reporter = new Reporter();
        for (Analyser analyser : analysers) {
            reporter.addReports(analyser.analyse(structure.get()));
        }
    }

    public String getStructureName(){
        return this.structure.get().getName();
    }

    public boolean checkStructureIsPresent(){
        return this.structure.isPresent();
    }

    public String getDisplayedName(){
        return this.displayedName;
    }
    
    public boolean isReportEmpty(){
        return reporter.getReports().isEmpty();
    }

    public HashMap<String,String> getReports(){
        return reporter.getReports();
    }
}








