package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.umlclass.Interface;

import java.util.List;

public class InterfaceAnalyser implements Analyser {
    private final Interface i;
    private final List<Interface> interfaces;

    public InterfaceAnalyser(Interface i, List<Interface> interfaces){
        this.i = i;
        this.interfaces = interfaces;
    }

    @Override
    public Reporter analyse() {
        return null;
    }
}
