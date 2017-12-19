/************************************************************************************
 * LegoBatmanFan									3 June 2017
 * 
 * ReadExcelFile
 * Reads data from an excel file using Apache POI 
 * 		https://poi.apache.org/spreadsheet/index.html
 * 
 * -----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 * ----------------------------------------------------------------------------
 * 3 June 2017		LegoBatmanFan		Created
 * 19 Dec 2017		LegoBatmanFan		The method readMyExcelData takes the file name as a parameter
 ************************************************************************************/
package CommonActions;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


/*
 * When using this class, add the following in the pom.xml file:
 * 
  <dependency>
  	<groupId>org.apache.poi</groupId>
  	<artifactId>poi-ooxml</artifactId>
  	<version>3.15</version>
  </dependency>
 */
public class ReadExcelFile {

	public String[][] readMyExcelData(String excelFileName) throws IOException {
		FileInputStream excelFile = new FileInputStream(new File(excelFileName));
		Workbook workbook = new XSSFWorkbook(excelFile);
		DataFormatter objDefaultFormat = new DataFormatter();
		FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator(
				(XSSFWorkbook) workbook);
		Sheet datatypeSheet = workbook.getSheetAt(0);
		excelFile.close();

		int maxRows = datatypeSheet.getPhysicalNumberOfRows();
		Row checkRow = datatypeSheet.getRow(0);
		int maxColumns = checkRow.getLastCellNum();
		String[][] spreadsheetData = new String[maxRows - 1][maxColumns];
		int i = 0;
		int j = 0;

		Iterator<Row> iterator = datatypeSheet.iterator();
		Row myHeader = iterator.next();

		while (iterator.hasNext()) {
			j = 0;
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell curerrentCell = cellIterator.next();
				objFormulaEvaluator.evaluateInCell(curerrentCell);
				spreadsheetData[i][j] = objDefaultFormat.formatCellValue(
						curerrentCell, objFormulaEvaluator);
				j++;
			}
			i++;
		}

		for (int x = 0; x < i; x++) {
			for (int y = 0; y < j; y++) {
				System.out.print(spreadsheetData[x][y] + " ");
			}
			System.out.println("");
		}

		return spreadsheetData;
	}
}
