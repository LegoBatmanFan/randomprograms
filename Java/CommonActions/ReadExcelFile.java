/************************************************************************************
 * LegoBatmanFan									3 June 2017
 * 
 * OLD_ReadExcelFile
 * Reads data from an excel file using Apache POI 
 * 		https://poi.apache.org/spreadsheet/index.html
 * 
 * -----------------------------------------------------------------------------
 * Modification History
 * Date				Author				Description
 * ----------------------------------------------------------------------------
 * 3 June 2017		LegoBatmanFan		Created
 * 19 Dec 2017		LegoBatmanFan		The method readMyExcelData takes the file name as a parameter
 * 28 April 2019	LegoBatmanFan		Updated packages and removed code that printed data
 ************************************************************************************/
package com.legobatmanfan.commonactions;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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

	public static String[][]  readMyExcelData(String excelFileName) throws IOException {

		FileInputStream excelFileInputStream = new FileInputStream(new File(excelFileName));

		XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = spreadsheet.iterator();
		int maxRows = spreadsheet.getPhysicalNumberOfRows();
		int maxColumns = spreadsheet.getRow(0).getLastCellNum();
		String[][] spreadsheetData = new String[maxRows][maxColumns];
		int i = 0;
		int j = 0;
		String cellValue;
		
		while (rowIterator.hasNext()) {
			Row row = (XSSFRow) rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			j = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				if (cell.getCellTypeEnum() == CellType.NUMERIC) {
					cellValue = Integer.toString((int) cell.getNumericCellValue());
				} else {
					cellValue = cell.getStringCellValue();
				}
				spreadsheetData[i][j] = cellValue;

				j++;
				cellValue = "";
			}
			i++;
		}
		excelFileInputStream.close();

		return spreadsheetData;
	}
}