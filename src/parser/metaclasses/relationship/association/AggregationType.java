package parser.metaclasses.relationship.association;

public enum AggregationType {
    NONE,
    SHARED,
    COMPOSITE;

    public static AggregationType createFromStr(String str) throws EnumConstantNotPresentException{
        if (str.equalsIgnoreCase("None")){
            return AggregationType.NONE;
        } else if (str.equalsIgnoreCase("Shared")){
            return AggregationType.SHARED;
        } else if (str.equalsIgnoreCase("Composite")) {
            return AggregationType.COMPOSITE;
        } else throw new EnumConstantNotPresentException(AggregationType.class, str);
    }
}
