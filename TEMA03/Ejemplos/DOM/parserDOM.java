package DOM;

import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;
import java.io.*;

public class parserDOM {
    public static void main(String[] args) {

        try {
            // Crear una instancia de DocumentBuilderFactory.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Configurar la factoria para que el fichero que se carga está bien validado e
            // ignora espacios en blanco.
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            // se crea un objeto DocumentBuilder por medio de la factoría creada
            // previamente.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Especificar el archivo XML que deseas analizar.
            File file = new File("C:\\Users\\PC221\\Documents\\GitHub\\DAM2\\Acceso a datos 2\\2DAM_AD_1T_Bloque1_Public\\TEMA03\\Ejemplos\\DOM\\fichero.xml");

            // Parsear (analizar) el archivo XML y obtener un objeto Document.
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            // Acceso al nodo raíz
            Element root = doc.getDocumentElement();
            System.out.println("Elemento raíz: " + root.getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
