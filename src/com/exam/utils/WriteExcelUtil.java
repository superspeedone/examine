package com.exam.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * excel写入工具
 * @author yww
 *
 */
public class WriteExcelUtil {
	private WritableWorkbook wwb = null;
	private WritableSheet sheet = null;
	
	/**
	 * 创建可写的Workbook对象
	 * @param targetfile 目标文件
	 * @throws IOException
	 */
	public void createWorkbook(String targetfile) throws IOException{
		this.wwb = Workbook.createWorkbook(new File(targetfile));
	}
	
	/**
	 * 创建sheet表格
	 * @param name
	 * @param index
	 */
	public void createSheet(String name, int index){
		this.wwb.createSheet(name, index);
	}
	
	/**
	 * 添加文本单元格
	 * @param row
	 * @param column
	 * @param content 单元格内容
	 * @throws Exception
	 */
	public void addCellLabel(int row, int column, String content) throws Exception {
		Label label = new Label(column, row, content);
		this.sheet.addCell(label);
	}
	
	/**
	 * 插入double类型单元格
	 * @param row
	 * @param column
	 * @param num
	 * @throws Exception
	 */
	public void addCellNumber(int row, int column, Double num) throws Exception {
		Number number = new Number(column, row, num);
		this.sheet.addCell(number);
	}
	
	/**
	 * 添加日期格式单元格
	 * @param row
	 * @param column
	 * @param time
	 * @throws Exception
	 */
	public void addCellDate(int row, int column, Date time) throws Exception { 
		DateFormat fomater = new DateFormat("yyyy-MM-dd hh:mm:ss");
		WritableCellFormat wcFomater = new WritableCellFormat(fomater);
		DateTime dt =  new DateTime(column, row, time, wcFomater);
		this.sheet.addCell(dt);
	}
	
	/**
	 * 保存并关闭WritableWorkbook对象
	 * @throws Exception
	 */
	public void saveAndClose() throws Exception {
		this.wwb.write();
		if (this.wwb != null) {
			this.wwb.close();
		}
	}

}
