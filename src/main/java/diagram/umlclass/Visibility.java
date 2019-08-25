package diagram.umlclass;

public enum Visibility {
    PUBLIC,
    PRIVATE,
    INTERNAL;

    public static Visibility createFromStr(String str) throws EnumConstantNotPresentException{
        if (str == "Public"){
            return Visibility.PUBLIC;
        } else if (str == "Private"){
            return Visibility.PRIVATE;
        } else if (str == "Internal") {
            return Visibility.INTERNAL;
        } else throw new EnumConstantNotPresentException(Visibility.class, str);
    }

}
