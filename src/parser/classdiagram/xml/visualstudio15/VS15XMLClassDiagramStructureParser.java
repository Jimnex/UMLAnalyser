package parser.classdiagram.xml.visualstudio15;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.StructureParser;
import parser.XML;
import parser.classdiagram.ClassDiagramStructureParser;;import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class VS15XMLClassDiagramStructureParser extends ClassDiagramStructureParser {
    private Optional<NodeList> classesNodeList;
    private Optional<NodeList> interfacesNodeList;
    private Optional<Document> doc;

    public VS15XMLClassDiagramStructureParser(File file){
        try {
            doc = Optional.ofNullable(XML.parseXMLDocWithDOM(file));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        if(doc.isPresent()){
            this.classesNodeList = Optional.ofNullable(doc.get().getElementsByTagName("class"));
            this.interfacesNodeList = Optional.ofNullable(doc.get().getElementsByTagName("Interface"));
        }
    }

    @Override
    protected int getNumberOfClasses() {
        if (classesNodeList.isPresent()){
            return classesNodeList.get().getLength();
        } else {
            return 0;
        }
    }

    @Override
    protected void setClassParserParserWithData(int index) {
        super.classParser = Optional.ofNullable(new VS15XMLClassParser(this.classesNodeList.get().item(index)));
    }

    @Override
    protected int getNumberOfInterfaces() {
        if(this.interfacesNodeList.isPresent()){
            return this.interfacesNodeList.get().getLength();
        } else {
            return 0;
        }
    }

    @Override
    protected void setInterfaceParserWithData(int index) {
        super.interfaceParser = Optional.ofNullable(new VS15XMLInterfaceParser(this.interfacesNodeList.get().item(index)));
    }


    @Override
    public String parseName() {
        if(this.doc.isPresent()){
            return this.doc.get().getDocumentElement().getAttribute("name");
        }
        return "N/A";
    }

}