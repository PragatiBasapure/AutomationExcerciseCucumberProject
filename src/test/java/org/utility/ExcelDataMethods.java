package org.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataMethods {
	private static Workbook excelFile;
	public void getExcelFileName() throws Exception
	{
		FileInputStream fis=new FileInputStream("D:/kapilPracticeProgram/TestData/TestAutomationData.xlsx");
		excelFile=WorkbookFactory.create(fis);
	}
	
	public String getStringValue(String sheetName,int row,int cell) throws Exception
	{
		if(excelFile==null)
		{
			throw new FileNotFoundException();
		}
		else
		{
			return excelFile.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		}
	}
	public double getNumericValue(String sheetName,int row,int cell) throws Exception
	{
		if(excelFile==null)
		{
			throw new FileNotFoundException();
		}
		else
		{
			return excelFile.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		}
	}
}
