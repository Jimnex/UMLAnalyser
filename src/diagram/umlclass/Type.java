package diagram.umlclass;

public class Type {
    private final String id;
    private final String name;

    public Type(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
