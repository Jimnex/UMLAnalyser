package diagram.umlclass;

import java.util.ArrayList;
import java.util.List;

public class Interface {
    private String name;
    private List<String> baseIDs;
    private List<Method> methods;

    public Interface(String name, List<String> baseIDs, List<Method> methods) {
        this.name = name;
        this.baseIDs = baseIDs;
        this.methods = methods;
    }
}
