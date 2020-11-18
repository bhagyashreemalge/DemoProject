package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import freemarker.core.ReturnInstruction.Return;

public class DataDrive {
		
	public ArrayList<String> getData(String user) throws IOException
	{
		ArrayList<String> al=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C:\\Users\\ganes\\Desktop\\New folder\\testdata.xlsx");
	    XSSFWorkbook workbook=new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheet("testdata");
	    Iterator<Row> rowit=sheet.rowIterator();
	    int column=0;
	   // Row columheaders=rowit.next();
	    if(rowit.hasNext())
	    {
	    	Iterator<Cell> cellit=rowit.next().cellIterator();
	    while(cellit.hasNext())
	    {
	    	if(cellit.next().getStringCellValue().equalsIgnoreCase("user"))
	    	{
	    		System.out.println("found user column");
	    		while(rowit.hasNext())
	    		{
	    			Iterator<Cell> dyncellit=rowit.next().cellIterator();
	    			while(dyncellit.hasNext())
	    			{
	    				if(dyncellit.next().getStringCellValue().equalsIgnoreCase(user))
	    				{
	    					al.add(dyncellit.next().getStringCellValue());
	    					al.add(dyncellit.next().getStringCellValue());
	    				}
	    			}
	    		}
					
			}
	  
	    }
	    }return al;
	}	   

}

