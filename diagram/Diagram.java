package diagram;

import analyser.Analyser;
import com.sun.xml.internal.ws.api.model.Parameter;
import parser.NameParser;
import parser.Parser;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Diagram implements Analyser, Visualizer {
    protected String name;
    protected final String filePath;
    private List<Collection<Element>> structures;

    public Diagram(String filePath){
        this.filePath = filePath;
        this.name = parseName();
        this.structures = new ArrayList<>();
    }

    public abstract void parse();

    protected void addRootStructure(Collection<Element> structure)  {
        if(structure.isEmpty() == false) {
            structures.add(structure);
        } else {
            System.out.println("Cannot add empty root structure");
        }
    }

    protected abstract String parseName();
}
