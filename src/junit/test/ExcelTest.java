package junit.test;

import java.util.Date;
import jxl.Cell;
import jxl.DateCell;
import org.junit.Test;
import com.exam.utils.ReadExcelUtil;

public class ExcelTest {

	@Test
	public void test() {
		try {
			ReadExcelUtil excel= new ReadExcelUtil("C:\\Users\\Administrator\\Desktop\\1.xls");
			Cell cell = excel.getSheet(0).getCell(4, 1);
			String cellType =cell.getType().toString();
			System.out.println(cellType);
			if(cellType.equals("Date")){
				Date cellContent = ((DateCell) cell).getDate();
				System.out.println(cellContent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
