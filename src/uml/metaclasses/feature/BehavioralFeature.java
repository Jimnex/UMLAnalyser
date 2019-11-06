package uml.metaclasses.feature;

public interface BehavioralFeature extends Feature{
    boolean checkIsAbstract();

    @Override
    default String getQuilifiedName() {
        return null;
    }
}
