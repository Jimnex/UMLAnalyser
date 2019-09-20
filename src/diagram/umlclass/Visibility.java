package diagram.umlclass;

public enum Visibility {
    PUBLIC,
    PRIVATE,
    INTERNAL;

    public static Visibility createFromStr(String str) throws EnumConstantNotPresentException{
        if (str.equals("Public")){
            return Visibility.PUBLIC;
        } else if (str.equals("Private")){
            return Visibility.PRIVATE;
        } else if (str.equals("Internal")) {
            return Visibility.INTERNAL;
        } else throw new EnumConstantNotPresentException(Visibility.class, str);
    }

}
