package diagram;

import analyser.Analyser;
import com.sun.xml.internal.ws.api.model.Parameter;
import parser.Parser;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Diagram implements Analyser, Visualizer {
    protected final String name;
    private List<Collection<Element>> structures;

    public Diagram(String name){
        this.name = name;
        this.structures = new ArrayList<>();
    }

    public abstract void parse() throws Exception;

    protected void addRootStructure(Collection<Element> structure) throws Exception {
        if(structure.isEmpty() == false) {
            structures.add(structure);
        } else {
            throw new Exception("Cannot add empty root structure");
        }
    }

}
