package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ReadExcel {
	
	public static int rowCount;

	
	
	@Test
	public void read() throws IOException {
	
	
	
	
	String[][] data = null ;

	try {
		
		
		FileInputStream fis = new FileInputStream("airlines.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);	

		// get the number of rows
		 rowCount = sheet.getLastRowNum();

		// get the number of columns
		int columnCount = sheet.getRow(0).getLastCellNum();
		data = new String[rowCount][columnCount];

		System.out.println(rowCount);
		// loop through the rows
		for(int i=1; i <rowCount+1; i++){
			try {
				XSSFRow row = sheet.getRow(i);
				for(int j=0; j <columnCount; j++){ // loop through the columns
					try {
						String cellValue = "";
						try{
							//	cellValue = row.getCell(j).getStringCellValue();
							CellType cellType = row.getCell(j).getCellTypeEnum();	
							if (cellType != CellType.STRING) {
								row.getCell(j).setCellType(CellType.STRING);
							}
							cellValue = row.getCell(j).getStringCellValue();
						}catch(NullPointerException e){}

						data[i-1][j]  = cellValue; // add to the data array
					} catch (Exception e) {
						e.printStackTrace();
					}				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		fis.close();
		workbook.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

	
	for(int i=0;i<data.length;i++) {
		
		for(int j=0;j<data[i].length;j++) {
			
	       	System.out.println(data[i][j]);

		}
	}
	

	
	
	
	}
	

}
