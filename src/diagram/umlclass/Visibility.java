package diagram.umlclass;

public enum Visibility {
    PUBLIC,
    PRIVATE,
    INTERNAL,
    PACKAGE;

    public static Visibility createFromStr(String str) throws EnumConstantNotPresentException{
        if (str.equalsIgnoreCase("")){
            return Visibility.PUBLIC;
        } else if (str.equalsIgnoreCase("Private")){
            return Visibility.PRIVATE;
        } else if (str.equalsIgnoreCase("Internal")) {
            return Visibility.INTERNAL;
        } else if (str.equalsIgnoreCase("Package")) {
            return Visibility.PACKAGE;
        }
            throw new EnumConstantNotPresentException(Visibility.class, str);
        }
}

