package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class XLUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

    private static Logger logger  =  LogManager.getLogger("xlutils");

    public static Logger getLogger()
    {
        return logger;
    }

    public static int getRowCount(String xlfile,String xlsheet) throws IOException
    {
        File file = new File(xlfile);
        logger.info("File read successfully!!");
        fi=new FileInputStream(file);

        logger.info("FileStream created successfully!!");
        wb=new XSSFWorkbook(fi);

        logger.info("Workbook instance created!!");
        ws=wb.getSheet(xlsheet);

        logger.info("Worksheet read successfully!!");
        int rowcount=ws.getLastRowNum();

        logger.info("Row Count: " + rowcount);
        wb.close();
        fi.close();
        return rowcount;
    }


    public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        int cellcount=row.getLastCellNum();
        wb.close();
        fi.close();
        return cellcount;
    }


    public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        cell=row.getCell(colnum);
        String data;
        try
        {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            //String cellValue = cell.getRawValue();
            return cellData;
        }
        catch (Exception e)
        {
            data="";
        }
        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        cell=row.createCell(colnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }


}
