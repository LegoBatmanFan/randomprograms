/************************************************************************************
 * LegoBatmanFan									9 January 2018
 * 
 * CreateComplexXML.java
 * Creates a simple XML file. Nothing fancy. 
 * After running this program, you can run ReadComplexXML.java
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

public class CreateComplexXML {

	public static void main(String[] args) throws IOException {
		String fileDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_";
		String filePath = "/Users/lenahorsley/Documents/Lena/JavaAutomation/";

		ReadExcelFile myExcelFile = new ReadExcelFile();
		String myPokemonFile = "//Users//lenahorsley//Documents//Lena//SpreadsheetData//20180107_Pokedex.xlsx";

		// read the data from the excel file into a two-dimensional array and get the dimensions
		String[][] myPokemonData = myExcelFile.readMyExcelData(myPokemonFile);
		int rowMax = myPokemonData.length;
		int colMax = myPokemonData[0].length;
		Stack<String> myPokemonStack = new Stack<String>();
		String nodeAttribute;
		
		//These lists will be used to create the nodes in the XML file
		List<String> simpleID = new ArrayList<String>();
		List<String> characteristics = new ArrayList<String>();
		List<String> pokeType = new ArrayList<String>();
		List<String> weatherBoost = new ArrayList<String>();
		List<String> catchType = new ArrayList<String>();
		
		List<String> simpleIDHeader = Arrays.asList("Name", "PokeDexNum");
		List<String> characteristicsHeader = Arrays.asList("Weight", "Height", "Generation");
		List<String> pokeTypeHeader = Arrays.asList("type003", "type002", "type001");
		List<String> weatherHeader = Arrays.asList("boost003", "boost002", "boost001");
		List<String> catchHeader = Arrays.asList("catch003", "catch002", "catch001");
		
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
				
				//Add the information to the lists
				catchType.add(myPokemonStack.pop());
				catchType.add(myPokemonStack.pop());
				catchType.add(myPokemonStack.pop());
				weatherBoost.add(myPokemonStack.pop());
				weatherBoost.add(myPokemonStack.pop());
				weatherBoost.add(myPokemonStack.pop());
				pokeType.add(myPokemonStack.pop());
				pokeType.add(myPokemonStack.pop());
				pokeType.add(myPokemonStack.pop());
				characteristics.add(myPokemonStack.pop());
				characteristics.add(myPokemonStack.pop());
				characteristics.add(myPokemonStack.pop());
				simpleID.add(myPokemonStack.pop());
				simpleID.add(myPokemonStack.pop());
				
				//Create the node attribute
				nodeAttribute = Integer.toString(i + 1);
				
				//Create the element
				Element pokemon = doc.createElement("Pokemon");
				rootElement.appendChild(pokemon);
				
				//Set the attribute
				pokemon.setAttribute("id", nodeAttribute);
				
				//Generate a child node and add it to the document
				Document genPokemonDoc = generateXMLNode(doc, simpleID, simpleIDHeader, simpleIDHeader.size(), pokemon);
				
				//Create the different nodes - "grand-children nodes" and add the nodes to the document
				Document charPokemonDoc = generateComplexXMLNode(genPokemonDoc, "Characteristics", characteristics, characteristicsHeader, characteristicsHeader.size(), pokemon);
				Document typePokemonDoc = generateComplexXMLNode(charPokemonDoc, "Type", pokeType, pokeTypeHeader, pokeTypeHeader.size(), pokemon);
				Document weatherPokemonDoc = generateComplexXMLNode(typePokemonDoc, "WeatherBoost", weatherBoost, weatherHeader, weatherHeader.size(), pokemon);
				Document catchPokemonDoc = generateComplexXMLNode(weatherPokemonDoc, "CatchType", catchType, catchHeader, catchHeader.size(), pokemon);
				
				//Reset the document variable
				doc = catchPokemonDoc;
				
				//Clear the lists
				simpleID.clear();
				characteristics.clear();
				pokeType.clear();
				weatherBoost.clear();
				catchType.clear();
			}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath + fileDate + "complex.xml"));

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	//Create a child node
	public static Document generateXMLNode(Document myDoc, List<String> myCharacteristics, List<String> myHeader, int cols, Element myElement){
		Element pokemonProperty = null;
		
		for (int k = cols - 1; k > -1; k--){
			pokemonProperty = myDoc.createElement(myHeader.get(k));
			pokemonProperty.appendChild(myDoc.createTextNode(myCharacteristics.get(k)));
			myElement.appendChild(pokemonProperty);			
		}
				
		return myDoc;
	}
	
	//Create a "grand-child" node
	public static Document generateComplexXMLNode(Document myComplexDoc, String nodeTitle, List<String> myComplexChar, List<String> myComplexHeader, int cols, Element myComplexElement){
		Element complexPokemonProperty = null;
		Element mainPokemonProperty = myComplexDoc.createElement(nodeTitle);
		myComplexElement.appendChild(mainPokemonProperty);
		
		for (int m = cols - 1; m > -1; m--){
			complexPokemonProperty = myComplexDoc.createElement(myComplexHeader.get(m));
			complexPokemonProperty.appendChild(myComplexDoc.createTextNode(myComplexChar.get(m)));
			mainPokemonProperty.appendChild(complexPokemonProperty);			
		}
				
		return myComplexDoc;
	}
}
