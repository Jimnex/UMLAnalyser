package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.umlclass.Method;

public class MethodAnalyser implements Analyser {

    private final Method method;

    public MethodAnalyser(Method method){
        this.method = method;
    }

    @Override
    public Reporter analyse() {
        return null;
    }
}
