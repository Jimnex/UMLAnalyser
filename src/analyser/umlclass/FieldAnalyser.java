package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.umlclass.Field;

public class FieldAnalyser implements Analyser {
    private final Field field ;

    public FieldAnalyser(Field field){
         this.field = field;
    }

    @Override
    public Reporter analyse() {
        return null;
    }
}
