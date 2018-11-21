import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class TransformFactory {
    public long transFactory(Document document) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("1.xml"));
        transformer.transform(source, result);
        transformer = transformerFactory.newTransformer(new StreamSource("xslt.xml"));
        transformer.transform(new StreamSource("1.xml"), new StreamResult("2.xml"));
        System.out.println("complete");
        //---------------------------------------------------------------------------------
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("2.xml");
        Document document2 = builder.parse(file);
        NodeList nodeList = document2.getElementsByTagName("entry");
        long finalResult = 0;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                int c = (Integer.valueOf(element.getAttribute("field")));
                finalResult = finalResult + c;
            }
        }
        return finalResult;
    }
}

