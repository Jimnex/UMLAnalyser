package diagram.umlclass;

public enum Aggregation {
    NONE,
    SHARED,
    NOTYETKNOWN;

    public static Aggregation createFromStr(String str) throws EnumConstantNotPresentException{
        if (str.equals("None")){
            return Aggregation.NONE;
        } else if (str.equals("Shared")){
            return Aggregation.SHARED;
        } else if (str.equals("--")) {
            return Aggregation.NOTYETKNOWN;
        } else throw new EnumConstantNotPresentException(Aggregation.class, str);
    }
}
