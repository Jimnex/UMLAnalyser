package analyser;

import uml.diagrams.Structure;

public interface Analyser {
    Reporter analyse(Structure structure);
}
