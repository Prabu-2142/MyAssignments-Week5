package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/CreateLead.xlsx");
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int rowNum = sheet.getLastRowNum();
		System.out.println("Total number of Rows :"+rowNum);
		
		int cellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("the total number of Columns :"+cellNum);
		
		for(int i = 1; i<=rowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cellNum; j++) {
				XSSFCell cell = row.getCell(j);
				String data = cell.getStringCellValue();
				System.out.println(data);
				wb.close();
			}
			
		}
		
	}

}
