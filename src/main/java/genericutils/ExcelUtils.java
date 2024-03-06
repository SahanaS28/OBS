package genericutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtils
{
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		String value=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		return rowCount;	
	}
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void writeDataIntoExcel(String sheetName, int row, int cell, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb= WorkbookFactory.create(fi);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fout=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	
   /**
    * 
    * @param sheetName
    * @param cell
    * @param driver
    * @return
    * @throws EncryptedDocumentException
    * @throws IOException
    */
	public HashMap<String, String> readMultipleData(String sheetName, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
	    Sheet sh = wb.getSheet(sheetName);
	    int rowCount=sh.getLastRowNum();
	    
	    HashMap<String , String> map=new HashMap<String, String>();
	    for(int i=0;i<=rowCount;i++)
	    {
	    	String key=sh.getRow(i).getCell(cell).getStringCellValue();
	    	String value=sh.getRow(i).getCell(cell+1).getStringCellValue();
	    	map.put(key, value);
	    }
	  return map;
	}
	
	public Object[][] genericDataProvider(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath);
		 Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh=wb.getSheet(SheetName);
		 int lastRow=sh.getLastRowNum()+1;
		 int lastCell=sh.getRow(0).getLastCellNum();
		 Object[][] obj=new Object[lastRow][lastCell];
		 
		 for(int i=0;i<lastRow;i++)
		 {
			 for(int j=0;j<lastCell;j++)
			 {
				 obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
						 
			 }
		 }
		 return obj;
		 
		
		
	}
	
}
