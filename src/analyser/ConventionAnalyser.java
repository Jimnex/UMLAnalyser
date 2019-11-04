package analyser;

public abstract class ConventionAnalyser implements Analyser {
    protected Analyser analyser;

    public ConventionAnalyser(Analyser analyser) {
        this.analyser = analyser;
    }

}
