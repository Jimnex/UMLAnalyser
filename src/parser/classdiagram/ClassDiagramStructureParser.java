package parser.classdiagram;

import uml.diagrams.umlclass.*;
import uml.diagrams.umlclass.Class;
import parser.Parser;
import parser.StructureParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ClassDiagramStructureParser implements StructureParser {
    protected Optional<Parser<Interface>> interfaceParser = Optional.empty();
    protected Optional<Parser<Class>> classParser = Optional.empty();


    @Override
    public ClassDiagramStructure parse(){
        return new ClassDiagramStructure(this.parseName(),this.parseInterfaces(),this.parseClasses());
    }

    protected List<Interface> parseInterfaces(){
        List<Interface> interfaces = new ArrayList<>();
        for (int i = 0; i < getNumberOfInterfaces(); i++) {
            setInterfaceParserWithData(i);
            if(interfaceParser.isPresent()){
                interfaces.add(this.interfaceParser.get().parse());
            } else {
                System.out.println("No interfaceParser has been set");
            }
        }
        return interfaces;
    }

    protected abstract int getNumberOfInterfaces();

    protected abstract void setInterfaceParserWithData(int index);

    protected List<Class> parseClasses(){
        List<Class> classes = new ArrayList<>();
        for (int i = 0; i < getNumberOfClasses(); i++) {
            setClassParserParserWithData(i);
            if(classParser.isPresent()){
                classes.add(this.classParser.get().parse());
            } else {
                System.out.println("No classParser has been set");
            }
        }
        return classes;
    }

    protected abstract int getNumberOfClasses();

    protected abstract void setClassParserParserWithData(int i);


}
