import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/************************************************************************************
 * LegoBatmanFan									3 June 2017
 * 
 * ReadExcelFile
 * Reads data from an excel file using Apache POI 
 * 		https://poi.apache.org/spreadsheet/index.html
 * 
 * Use with ReadExcelFileTest.java
 ************************************************************************************/
public class ReadExcelFile {
	private static String excelFileName = "//Users//lenahorsley//Documents//Lena//SpreadsheetData//RandomPokemon.xlsx";

	public String [][] readMyExcelData() throws IOException {
		//Get the data from the spreadsheet 
		FileInputStream excelFile = new FileInputStream(new File(excelFileName));
		
		//Create a new workbook (using Apache POI XSSFWorkbook)
		Workbook workbook = new XSSFWorkbook(excelFile);
		
		//Used to format the excel data into strings
		DataFormatter objDefaultFormat = new DataFormatter();
		FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator(
				(XSSFWorkbook) workbook);
		
		//Put the data in a spreadsheet
		Sheet datatypeSheet = workbook.getSheetAt(0);

		//Find the # of rows
		int maxRows = datatypeSheet.getPhysicalNumberOfRows();
		
		//Find the # of columns
		Row checkRow = datatypeSheet.getRow(0);
		int maxColumns = checkRow.getLastCellNum();
		
		//Initialize the 2D array that will hold the spreadsheet data
		String[][] spreadsheetData = new String[maxRows - 1][maxColumns];
		int i = 0;
		int j = 0;

		//Row iterator
		Iterator<Row> iterator = datatypeSheet.iterator();
		
		//Get the first row. This assumes the excel file has a header row (not counted as data)
		Row myHeader = iterator.next();

		//While there are rows
		while (iterator.hasNext()) {
			j = 0;
			Row currentRow = iterator.next();  											//Get the current row
			Iterator<Cell> cellIterator = currentRow.iterator();						//create an iterator for the cells
			while (cellIterator.hasNext()) {											//while there are cells in the row
				Cell curerrentCell = cellIterator.next();								//get the next cell
				objFormulaEvaluator.evaluateInCell(curerrentCell); 						//evaluate the cell contents 
				spreadsheetData[i][j] = objDefaultFormat.formatCellValue(curerrentCell, //save the formatted cell contents to the array
						objFormulaEvaluator);	
				j++; 																	//increment the counter for the cell
			}
			i++; 																		//increment the counter for the row
		}
		return spreadsheetData; 														//return the 2D array
	}
}

