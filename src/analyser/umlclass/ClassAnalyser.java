package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.umlclass.Association;
import diagram.umlclass.Class;
import diagram.umlclass.Field;
import diagram.umlclass.Method;

import java.util.HashMap;
import java.util.List;

public class ClassAnalyser implements Analyser {
    private final Class c;
    private final Reporter reporter;


    public ClassAnalyser(Class c, HashMap<String, Class> cs) {
        this.c = c;
        this.reporter = new Reporter();
    }

    @Override
    public Reporter analyse() {
        if(meetsClassNamingConvention() == false){
            reporter.addReport("Név konvenció", String.format("s% osztály nem nagybetűvel kezdődik", this.c.getName()));
        }

        FieldAnalyser fieldAnalyser;
        for (Field field: this.c.getFields()) {
            fieldAnalyser = new FieldAnalyser(field);
            this.reporter.addReports(fieldAnalyser.analyse());
        }

        MethodAnalyser methodAnalyser;
        for (Method method: this.c.getMethods()) {
            methodAnalyser = new MethodAnalyser(method);
            this.reporter.addReports(methodAnalyser.analyse());
        }

        AssociationAnalyser associationAnalyser;
        for (Association association: this.c.getAssociations()) {
            associationAnalyser = new AssociationAnalyser(association, this.c.getFields());
            this.reporter.addReports(associationAnalyser.analyse());

        }

        return reporter;
    }

    private boolean meetsClassNamingConvention(){
        return Character.isUpperCase(this.c.getName().charAt(0));
    }
}
