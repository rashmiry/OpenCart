package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility
{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	String path;
	
	public ExcelUtility(String path) 
	{
		this.path = path;
	}
	
	// count number of rows
		public int getRowCount(String sheetName) throws IOException 
		{
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			int rowcount = sheet.getLastRowNum();
			workbook.close();
			fi.close();
			return rowcount;
		}
		
		public int getCellCount(String sheetName, int row_num) throws IOException
		{
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(row_num);
			int cell_count = row.getLastCellNum();
			workbook.close();
			fi.close();
			return cell_count;
		}
		
		public String getCellData(String sheetName, int row_num, int col_num) throws IOException
		{
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(row_num);
			cell = row.getCell(col_num);
			
			DataFormatter formatter = new DataFormatter();
			String data;
			try
			{
				data = formatter.formatCellValue(cell); // returns the formatted value of a cell as a string regardless of the cell type 
			}
			catch (Exception e)
			{
				data = "";
			}
			workbook.close();
			fi.close();
			return data;
		}

		
		public void setCellData(String sheetName, int row_num, int col_num, String data) throws IOException
		{
			File xlfile = new File(path);
			if(!xlfile.exists())
			{
				workbook = new XSSFWorkbook();
				fo = new FileOutputStream(path);
				workbook.write(fo);
			}
			
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			
			if(workbook.getSheetIndex(sheetName) == -1) // if sheet not exists then create new sheet
				workbook.createSheet(sheetName);
			sheet = workbook.getSheet(sheetName);
			
			if(sheet.getRow(row_num) == null) // if row not exists then cretae row
				sheet.createRow(row_num);
			row = sheet.getRow(row_num);
			
			cell = row.createCell(col_num);
			cell.setCellValue(data);
			fo = new  FileOutputStream(path);
			
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();	
		}

		
		public void fillGreenColour(String sheetName, int row_num, int col_num) throws IOException
		{
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			
			row = sheet.getRow(row_num);
			cell = row.getCell(col_num);
			
			style = workbook.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());;
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}

		
		public void fillRedColour(String sheetName, int row_num, int col_num) throws IOException
		{
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(row_num);
			cell = row.getCell(col_num);
			
			style = workbook.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());;
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			fo = new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}




}
