import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocFactory {

    public Document Doc(ResultSet resultSet) throws ParserConfigurationException, SQLException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element entries = document.createElement("entries");
        document.appendChild(entries);

        while ((resultSet.next())) {
            int string = (resultSet.getInt("FIELD"));
            Element entry = document.createElement("entry");
            entries.appendChild(entry);
            Element field = document.createElement("field");
            entry.appendChild(field);
            Text text = document.createTextNode(String.valueOf(string));
            field.appendChild(text);
            System.out.println(string);
        }
        return document;
    }
}
