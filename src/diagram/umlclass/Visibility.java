package diagram.umlclass;

public enum Visibility {
    PUBLIC,
    PRIVATE,
    INTERNAL,
    PACKAGE;

    public static Visibility createFromStr(String str) throws EnumConstantNotPresentException{
        if (str.equals("")){
            return Visibility.PUBLIC;
        } else if (str.equals("Private")){
            return Visibility.PRIVATE;
        } else if (str.equals("Internal")) {
            return Visibility.INTERNAL;
        } else if (str.equals("Package")) {
            return Visibility.PACKAGE;
        }
            throw new EnumConstantNotPresentException(Visibility.class, str);
        }
}

