package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Association;
import org.w3c.dom.Element;
import parser.Parser;

public class VS15XMLClassAssociationParser implements Parser{
    private Element element;

    public Association getAssociation() {
        return association;
    }

    private Association association;

    public VS15XMLClassAssociationParser(Element associationElement) {
        this.element = associationElement;
    }

    @Override
    public void parse() {

    }

    @Override
    public String parseName() {
        return null;
    }
}
