package diagram.umlclass;

public enum Aggregation {
    NONE,
    SHARED,
    COMPOSITE;

    public static Aggregation createFromStr(String str) throws EnumConstantNotPresentException{
        if (str.equalsIgnoreCase("None")){
            return Aggregation.NONE;
        } else if (str.equalsIgnoreCase("Shared")){
            return Aggregation.SHARED;
        } else if (str.equalsIgnoreCase("Composite")) {
            return Aggregation.COMPOSITE;
        } else throw new EnumConstantNotPresentException(Aggregation.class, str);
    }
}
