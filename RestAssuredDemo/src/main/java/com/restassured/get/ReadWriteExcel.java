package com.restassured.get;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ReadWriteExcel {
	static FileInputStream fis;
	static HSSFWorkbook wb;
	HSSFSheet sheet;
	FileOutputStream fout;
	static String path;
	static String Resource="Resources";
	ReadWriteExcel rr = new ReadWriteExcel();

	public static String readPath() throws Exception {

		ReadConfig.readConfigs();
		try {
			
			path = System.getProperty("user.dir")+ReadConfig.ExcelPath;
			System.out.println("The file  path from config:" + path);
			//test.log(Status.INFO, "The environment patah is: " + path);
			File file = new File(path);
			fis = new FileInputStream(file);
			wb = new HSSFWorkbook(fis);

		} catch (FileNotFoundException e) {
			System.out.println("The error in reading files due to"
					+ e.getMessage());
		}
		return path;
	}
	

	public String getStringData(int sheetNum, int row, int column) {
		try {
			sheet = wb.getSheetAt(sheetNum);
			String data = sheet.getRow(row).getCell(column).getStringCellValue();
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The error occure due to " + e.getMessage());
		}
		return "";
	}

	public double getNumericalData(int sheetNum, int row, int column) {
		try {
			sheet = wb.getSheetAt(sheetNum);
			double data = sheet.getRow(row).getCell(column).getNumericCellValue();
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The error occure due to " + e.getMessage());
		}
		return column;
	}

	public int getRowCount(int sheetNum, String path) throws Exception {
		try {
			sheet = wb.getSheetAt(sheetNum);
			int Rcount = sheet.getLastRowNum();
			return Rcount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The error occure due to " + e.getMessage());
		}
		return 0;
	}

	 public Object[][] gettestData() throws Exception
	    {
		 readPath();
	        Object[][] excelData = null;
/*	        eat = new ExcelApiTest(xlFilePath);
	        int rows = eat.getRowCount(sheetName);
	        int columns = sheet.getColumnCount(sheetName);*/
	        int rows =  rr.getRowCount(0, path);
	        excelData = new Object[rows-1][3];
	         
	        for(int i=1; i<rows; i++)
	        {
	            for(int j=3; j<6; j++)
	            {
	                excelData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
	            }
	             
	        }
	        return excelData;
	    }

}
