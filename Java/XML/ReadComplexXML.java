/************************************************************************************
 * LegoBatmanFan									9 January 2018
 * 
 * ReadComplexXML.java
 * Creates a simple XML file. Nothing fancy. 
 * Run this program after running CreateComplexXML.java. Add the name of the file created 
 * by CreateComplexXML.java to the variable filePath.
 * -----------------------------------------------------------------------------
 * Modification History
 * Date					Author				Description
 * ----------------------------------------------------------------------------
 * 9 January 2018		LegoBatmanFan		Created
 ************************************************************************************/
package Scratch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ReadComplexXML {

	public static void main(String[] args) {
		String filePath = "/Users/lenahorsley/Documents/Lena/JavaAutomation/ReadXMLTest/20180115153247_complex.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(filePath);
            
            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();
            System.out.println("XPathFactory object created");

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            System.out.println("XPath object created");

            //Get the pokemon from the XML and print the name
            List<String> names = getThatPokemon(doc, xpath);
            System.out.println("Gen 1 pokemon:");
            for(int i = 0; i < names.size(); i++){
            	System.out.println(names.get(i).toString());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<String> getThatPokemon(Document doc, XPath xpath) {
        List<String> list = new ArrayList<>();
        String pokemonType = "Fog";
        String myBoost = "boost001='";
        try {
        	//Look through the "boost001" elements, return the pokemon where boost001 = "Fog"
            XPathExpression expr = xpath.compile("/PokeDex/Pokemon[./WeatherBoost/" + myBoost + pokemonType + "']/Name/text()");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getNodeValue());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
