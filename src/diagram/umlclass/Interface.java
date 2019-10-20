package diagram.umlclass;

import diagram.Classifier;
import diagram.Visibility;

import java.util.List;

public class Interface implements Classifier {
    private String id;
    private String name;
    private List<String> baseIDs;
    private List<Operation> operations;

    public Interface(String name, List<String> baseIDs, List<Operation> operations) {
        this.name = name;
        this.baseIDs = baseIDs;
        this.operations = operations;
    }

    @Override
    public String getIdientifier() {
        return id;
    }

    @Override
    public boolean checkIsAbstract() {
        return false;
    }

    @Override
    public boolean checkIsLeaf() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Visibility getVisibility() {
        return null;
    }
}
