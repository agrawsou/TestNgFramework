package com.qa.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] getDataFromSheet(String workbookLocation, String workSheetName) throws IOException {
	    XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\" + workbookLocation);
	    XSSFSheet workSheet = workbook.getSheet(workSheetName);

	    int noOfRows = workSheet.getLastRowNum();
	    int noOfColumns = workSheet.getRow(0).getLastCellNum();
	    Object[][] dataTable = new String[noOfRows][noOfColumns];

	    for (int i = 0; i < workSheet.getLastRowNum(); i++) {
	        for (int j = 0; j < workSheet.getRow(0).getLastCellNum(); j++) {
	            dataTable[i][j] = workSheet.getRow(i+1).getCell(j).getStringCellValue();
	        }
	    }

	    workbook.close();
	    return dataTable;
	}

}
