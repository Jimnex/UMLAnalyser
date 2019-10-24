package diagram.umlclass;

import analyser.Reporter;
import analyser.umlclass.ClassAnalyser;
import analyser.umlclass.InterfaceAnalyser;
import diagram.Diagram;

import java.util.List;

public class ClassDiagram extends Diagram {
    private final List<Interface> interfaces;
    private final List<Class> classes;


    public ClassDiagram(String name, List<Interface> interfaces, List<Class> classes) {
        super(name);
        this.interfaces = interfaces;
        this.classes = classes;
    }

    @Override
    public Reporter analyse() {
        Reporter reporter = new Reporter();
        ClassAnalyser classAnalyser;

        for (Class c: this.classes) {
            classAnalyser = new ClassAnalyser(c, classes);
            reporter.addReports(classAnalyser.analyse());
        }
        InterfaceAnalyser interfaceAnalyser;
        for (Interface i: this.interfaces) {
            interfaceAnalyser = new InterfaceAnalyser(i, interfaces);
            reporter.addReports(interfaceAnalyser.analyse());
        }

        return reporter;
    }
}
