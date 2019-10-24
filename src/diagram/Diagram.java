package diagram;

import analyser.Analyser;
import com.sun.xml.internal.ws.api.model.Parameter;
import parser.NameParser;
import parser.Parser;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Diagram implements Analyser {
    private final String name;

    public Diagram(String name){
        this.name = name;
    }
}
