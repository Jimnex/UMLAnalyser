package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.umlclass.Class;

public class ClassAnalyser implements Analyser {
    private final Class c;


    public ClassAnalyser(Class c) {
        this.c = c;
    }

    @Override
    public Reporter analyse() {
        Reporter reporter = new Reporter();
        if(meetsClassNamingConvention() == false){
            reporter.addReport("Név konvenció", String.format("s% osztály nem nagybetűvel kezdődik", this.c.getName()));
        }

        reporter.addReports(this.createAnalyser(new AssociationAnalyser()));

        reporter.addReports(this.createAnalyser(new FieldAnalyser()));

        reporter.addReports(this.createAnalyser(new MethodAnalyser()));

        return reporter;
    }

    private  Reporter createAnalyser(Analyser analyser){
        return analyser.analyse();
    }

    private boolean meetsClassNamingConvention(){
        return Character.isUpperCase(this.c.getName().charAt(0));
    }
}
