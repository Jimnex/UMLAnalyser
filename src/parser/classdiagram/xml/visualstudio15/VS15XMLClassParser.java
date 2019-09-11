package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.*;
import diagram.umlclass.Class;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import parser.classdiagram.ClassParser;
import parser.classdiagram.xml.XMLFileParser;

import java.util.Collection;

public class VS15XMLClassParser extends XMLFileParser implements ClassParser {
    private final Node classNode;
    private Class c;

    public VS15XMLClassParser(Node classNode) {
        this.classNode = classNode;
    }

    @Override
    public void parse() {
        String className = parseName();
        this.c = new Class(className);

    }

    @Override
    public String parseName() {
        return super.getValue(classNode, "name");
    }

    @Override
    public Visibility parseVisibility() {
        String strVisibility = super.getValue(this.classNode, "visibility");
        Visibility visibility = Visibility.createFromStr(strVisibility);
        return visibility;
    }

    @Override
    public Boolean parseIsAbstract() {
        return null;
    }

    @Override
    public Collection<Association> getAssociations() {
        return null;
    }

    @Override
    public Collection<Field> getFields() {
        return null;
    }

    @Override
    public Collection<Method> getMethods() {
        return null;
    }

    @Override
    public Collection<Dependency> getDependencies() {
        return null;
    }

    @Override
    public String parseClassName() {
        return null;
    }
}
