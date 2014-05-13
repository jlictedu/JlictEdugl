/**
 * 
 */
package com.jlict.edu.materials.util;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

/**
 * <p>Title: com.jlict.edu.materials.util.ExportExcel.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class ExportExcel
{
	private List<?> dataList;
	private String title;
	private String[] rowNames;
	private String[] getterAtt;

	/**
	 * @param dataList
	 * @param headName
	 * @param rowName
	 */
	public ExportExcel(List<?> dataList, String title, String[] rowNames, String[] getterAtt)
	{
		super();
		this.dataList = dataList;
		this.title = title;
		this.rowNames = rowNames;
		this.getterAtt = getterAtt;
	}

	/**
	 * 方法名： exportExcel
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月8日 下午2:55:02
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 String
	 */
	public String exportExcel() {
		String randomName = UUID.randomUUID().toString();
		String fileName =  "../webapps/edugl/download/" + randomName + ".xls";
		
		writeExcel(fileName);
		return "download/" + randomName + ".xls";
	}
	
	public void writeExcel(String fileName)
	{
		if(dataList.size() == 0)
			return;
		
		try
		{
			FileOutputStream fos = new FileOutputStream(fileName);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = null;
			HSSFCell cell = null;
			Object obj = dataList.get(0);
			
			//填充标题
			row = sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue(title);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, rowNames.length));
			sheet.autoSizeColumn(0, true);
			
			//填充表头
			row = sheet.createRow(1);
			for(int i=0; i<rowNames.length; i++)
			{
				cell = row.createCell(i);
				cell.setCellValue(rowNames[i]);
				sheet.autoSizeColumn(i, true); 
			}
			
			//填充正常行数据
			for(int i=2; i<=dataList.size()+1; i++)
			{
				obj = dataList.get(i-2);
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue(""+ (i - 1));
				sheet.autoSizeColumn(0, true); 
				for(int j=1; j<getterAtt.length+1; j++)
				{
					sheet.autoSizeColumn(j, true); 
					cell = row.createCell(j);
					try
					{
						cell.setCellValue(getter(obj, getterAtt[j-1]).toString());
					}
					catch(Exception e)
					{
						cell.setCellValue(""+getter(obj, getterAtt[j-1]));
					}
				}
			}
			wb.write(fos);
			fos.flush();
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Object getter(Object obj, String att)
	{
		try
		{
            Method method = obj.getClass().getMethod("get" + att);
            
            return method.invoke(obj);
        }
		catch (Exception e)
		{
            e.printStackTrace();
            return null;
        }
	}
}
