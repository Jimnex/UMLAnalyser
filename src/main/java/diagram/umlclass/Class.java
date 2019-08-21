package diagram.umlclass;

import java.util.ArrayList;
import java.util.Collection;

public class Class {
    private String name;
    private Boolean isAbstract;
    private String id;
    private Collection<Class> childs = new ArrayList<Class>();
    private Collection<Class> bases = new ArrayList<Class>();
    private Collection<String> baseIds = new ArrayList<String>();

    private Collection<Association> associations = new ArrayList<Association>();
    private Collection<Field> fields = new ArrayList<Field>();
    private Collection<Method> methods = new ArrayList<Method>();
    private Collection<Dependency> dependencies = new ArrayList<Dependency>();
}
