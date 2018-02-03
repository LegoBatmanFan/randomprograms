/************************************************************************************
 * LegoBatmanFan									9 January 2018
 * 
 * CreateSimpleXML.java
 * Creates a simple XML file. Nothing fancy. 
 * After running this program, you can run ReadSimpleXML.java
 * -----------------------------------------------------------------------------
 * Modification History
 * Date					Author				Description
 * ----------------------------------------------------------------------------
 * 9 January 2018		LegoBatmanFan		Created
 ************************************************************************************/
package Scratch;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Common.ReadExcelFile;

public class CreateSimpleXML {

	public static void main(String[] args) throws IOException {
		String fileDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_";
		String filePath = "/Users/lenahorsley/Documents/Lena/JavaAutomation/";

		ReadExcelFile myExcelFile = new ReadExcelFile();
		String myPokemonFile = "//Users//lenahorsley//Documents//Lena//SpreadsheetData//RandomPokemon.xlsx";

		// read the data from the excel file into a two-dimensional array and get the dimensions
		String[][] myPokemonData = myExcelFile.readMyExcelData(myPokemonFile);
		int rowMax = myPokemonData.length;
		int colMax = myPokemonData[0].length;
		Stack<String> myPokemonStack = new Stack<String>();
		String nodeAttribute;
		
		List<String> columnHeader = Arrays.asList("type", "type", "type", "Height", "Weight", "NumberCaught", "NumberSeen", "Name", "PokeDexNum");
		
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("PokeDex");
			doc.appendChild(rootElement);

			for (int i = 0; i < rowMax; i++) {
				for (int j = 0; j < colMax; j++) {
					myPokemonStack.push(myPokemonData[i][j].toString());
				}
				
				nodeAttribute = Integer.toString(i + 1);

				//Create the root element
				Element pokemon = doc.createElement("Pokemon");
				rootElement.appendChild(pokemon);
				
				//Create the attribute
				pokemon.setAttribute("id", nodeAttribute);
				
				//Generate the node
				Document pokemonDoc = generateXMLNode(doc, myPokemonStack, columnHeader, colMax, pokemon);
				doc = pokemonDoc;

			}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath + fileDate + "simple.xml"));

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	//Create a child node
	public static Document generateXMLNode(Document myDoc, Stack<String> myStack, List<String> myHeader, int cols, Element myElement){
		List<String> characteristics = new ArrayList<String>();
		Element pokemonProperty = null;
		
		for (int m = 0; m < cols; m++){
			characteristics.add(myStack.pop());
		}
		
		for (int k = cols - 1; k > -1; k--){
			pokemonProperty = myDoc.createElement(myHeader.get(k));
			pokemonProperty.appendChild(myDoc.createTextNode(characteristics.get(k)));
			myElement.appendChild(pokemonProperty);			
		}
				
		return myDoc;
	}
}
