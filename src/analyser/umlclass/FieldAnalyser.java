package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;

public class FieldAnalyser implements Analyser {
    @Override
    public Reporter analyse() {
        return new Reporter();
    }
}
