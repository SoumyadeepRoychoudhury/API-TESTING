import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeToExcel {
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet();
	public writeToExcel(List<String[]> Data) {
		int rowNum = 0;
		for(String[] result : Data) {
			Row row = sheet.createRow(rowNum++);
			int cellNum = 0;
			for(String values: result) {
				Cell cell = row.createCell(cellNum++);
				if(values instanceof String) {
					cell.setCellValue((String) values);
				}
			}
		}
		try {
			FileOutputStream fos = new FileOutputStream("result.xlsx");
			workbook.write(fos);
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
