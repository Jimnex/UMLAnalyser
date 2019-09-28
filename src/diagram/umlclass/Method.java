package diagram.umlclass;

import java.util.ArrayList;
import java.util.List;

public class Method {
    private final String name;
    private final Visibility visibility;
    private final Boolean isStatic;
    private final Boolean isAbstract;
    private final Type returnType;
    private List<Parameter> parameters;

    public Method(String name, Visibility visibility, Boolean isStatic, Boolean isAbstract, Type returnType, List<Parameter> parameters) {
        this.name = name;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.returnType = returnType;
        this.parameters = parameters;
    }

    public Method(String name, Visibility visibility, Boolean isStatic, Boolean isAbstract, Type returnType) {
        this.name = name;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.returnType = returnType;
        this.parameters = new ArrayList<>();
    }

    public void addParameter(String parameterName, Type parameterType){
        this.parameters.add(new Parameter(parameterName,parameterType));
    }

    public Parameter getParameter(int index){
        return this.parameters.get(index);
    }

    public static class Parameter {
        private final String name;
        private final Type type;

        public Parameter(String name, Type type) {
            this.name = name;
            this.type = type;
        }
    }
}
