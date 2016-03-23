package com.exam.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * excel读取工具
 * @author yww
 *
 */

public class ReadExcelUtil {
	private  Workbook workbook = null;
	private Sheet sheet = null;
	private Cell cell = null;
	
	public ReadExcelUtil(){}
	
	/**
	 * 构造方法
	 * @param filepath 文件路径
	 * @throws Exception
	 */
	public ReadExcelUtil(String filepath) throws Exception{
		getWorkBook(filepath);
	}
	
	/**
	 * 根据路径读取Excel文件，返回一个Workbook对象
	 * @param filepath Excle文件路径
	 * @return Workbook
	 * @throws Exception
	 */
	public Workbook getWorkBook(String filepath) throws  Exception{
		InputStream in= new FileInputStream(filepath);
		this.workbook = Workbook.getWorkbook(in);
		return workbook;
	}
	
	/**
	 * 关闭WorkBook对象
	 * @throws Exception
	 */
	public void clolseWorkBook() throws  Exception{
		if (this.workbook != null) {
			this.workbook.close();
		}
	}
	
	/**
	 * 获取sheet表格个数
	 * @return
	 */
	public int getSheetsNum(){
		return this.workbook.getNumberOfSheets();
	}
	
	/**
	 * 获取Sheet对象
	 * @param index Sheet索引
	 * @return Sheet
	 */
	public Sheet getSheet (int index){
		this.sheet = this.workbook.getSheet(index);
		return sheet;
	}
	
	/**
	 * 获取Sheet表格行数
	 */
	public int getRows (){
		return this.sheet.getRows();
	}
	
	/**
	 * 获取Sheet表格列数
	 */
	public int getColumns (){
		return this.sheet.getColumns();
	}
	
	/**
	 * 获取单元格类型
	 * @param row 
	 * @param column
	 * @return
	 */
	public CellType getCellType(int row, int column){
		this.cell = this.sheet.getCell(column, row);
		return cell.getType();
	}
	
	/**
	 * 获取单元格内容(文本格式)
	 * @param row
	 * @param column
	 */
	public String getCellCotent(int row, int column){
		return this.sheet.getCell(column, row).getContents();
	}
	
	/**
	 * 获取单元格内容(日期格式)
	 * @param row
	 * @param column
	 */
	public Date getCellDate(int row, int column){
		return ((DateCell) this.sheet.getCell(column, row)).getDate();
	}
	
	/**
	 * 获取单元格内容(整数格式)
	 * @param row
	 * @param column
	 */
	public Integer getCellIntege(int row, int column){
		return Integer.parseInt(this.sheet.getCell(column, row).getContents());
	}
	
	/**
	 * 获取单元格内容(浮点型格式)
	 * @param row
	 * @param column
	 */
	public Float getCellFloat(int row, int column){
		return Float.parseFloat(this.sheet.getCell(column, row).getContents());
	}
	
	/**
	 * 获取单元格内容(双精度格式)
	 * @param row
	 * @param column
	 */
	public Double getCellDouble(int row, int column){
		return Double.parseDouble(this.sheet.getCell(column, row).getContents());
	}
	
	/**
	 * 获取单元格内容(布尔类型格式)
	 * @param row
	 * @param column
	 */
	public Boolean getCellBool(int row, int column){
		return Boolean.parseBoolean(this.sheet.getCell(column, row).getContents());
	}

}
