package diagram.umlclass;

public enum Multiplicity {
    ZERO,
    ZERO_ONE,
    ONE,
    ONE_MANY,
    MANY;

    public static Multiplicity createFromStr(String str) throws EnumConstantNotPresentException{
        if (str.equalsIgnoreCase("0")){
            return Multiplicity.ZERO;
        } else if (str.equalsIgnoreCase("-")){
            return Multiplicity.ZERO_ONE;
        } else if (str.equalsIgnoreCase("1")) {
            return Multiplicity.ONE;
        } else if (str.equalsIgnoreCase("-")){
            return Multiplicity.ONE_MANY;
        } else if (str.equalsIgnoreCase("*")){
            return Multiplicity.MANY;
        } else throw new EnumConstantNotPresentException(Visibility.class, str);
    }
}
