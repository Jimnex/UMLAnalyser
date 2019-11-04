package analyser;

public interface Analyser {
    public <T> Reporter analyse(T structure);
}
