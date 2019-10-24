package diagram;

import java.util.Collection;

public interface StructuralClassifier extends Classifier{
    Collection<StructuralFeature> getStructuralFeatures();
}
