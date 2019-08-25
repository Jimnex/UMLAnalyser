package diagram.umlclass;

public enum Visibility {
    PUBLIC,
    PRIVATE,
    INTERNAL;

    public static Visibility createFromStr(String str){
        if (str == "Public"){
            return Visibility.PUBLIC;
        } else if (str == "Private"){
            return Visibility.PRIVATE;
        } else {
            return Visibility.INTERNAL;
        }
    }

}
