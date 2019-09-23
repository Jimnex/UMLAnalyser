package diagram.umlclass;

public enum Multiplicity {
    ZERO,
    ZERO_ONE,
    ONE,
    ONE_MANY,
    MANY;

    public static Multiplicity createFromStr(String str) throws EnumConstantNotPresentException{
        if (str.equals("-")){
            return Multiplicity.ZERO;
        } else if (str.equals("-")){
            return Multiplicity.ZERO_ONE;
        } else if (str.equals("1")) {
            return Multiplicity.ONE;
        } else if (str.equals("-")){
            return Multiplicity.ONE_MANY;
        } else if (str.equals("*")){
            return Multiplicity.MANY;
        } else throw new EnumConstantNotPresentException(Visibility.class, str);
    }
}
