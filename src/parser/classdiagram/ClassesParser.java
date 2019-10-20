package parser.classdiagram;

import diagram.umlclass.Class;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassesParser implements Parser<List<Class>>{
    protected ClassParser classParser;

    @Override
    public List<Class> parse() {
        List<Class> classifiers = new ArrayList<>();
        for (int i = 0; i < getNumberOfClassifiers(); i++) {
            setClassifierParserWithData(i);
            classifiers.add(classParser.parse());
        }
        return classifiers;
    }

    protected abstract int getNumberOfClassifiers();

    protected abstract void setClassifierParserWithData(int index);

}
