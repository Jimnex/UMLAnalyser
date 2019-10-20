package parser.classdiagram.xml.visualstudio15;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import parser.classdiagram.ClassesParser;;import java.util.Optional;

public class VS15XMLClassesParser extends ClassesParser {
    private Optional<NodeList> classifiersNodeList;

    VS15XMLClassesParser(Document doc){
        this.classifiersNodeList = Optional.ofNullable(doc.getElementsByTagName("class"));
    }

    @Override
    protected int getNumberOfClassifiers() {
        if (classifiersNodeList.isPresent()){
            return classifiersNodeList.get().getLength();
        } else {
            return 0;
        }

    }

    @Override
    protected void setClassifierParserWithData(int index) {
        super.classParser = new VS15XMLClassParser(classifiersNodeList.get().item(index));
    }
}