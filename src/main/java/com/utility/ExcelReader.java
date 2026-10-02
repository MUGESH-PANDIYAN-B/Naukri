package com.utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ExcelReader {
    @DataProvider(name = "excelData")
    public static Object[][] getExcelData() throws IOException {
        return excelReader("loginExcelPath", 0);
    }
    public static Object[][] excelReader(String propertyKey,int sheetNumber) throws IOException {
File file=new File("D:\\WorkSpace\\Naukri\\src\\main\\resources\\Test.properties");
        FileInputStream fileInputStream=new FileInputStream(file);
        Properties properties=new Properties();
        properties.load(fileInputStream);
        String value=properties.getProperty(propertyKey);
FileInputStream excelFile=new FileInputStream(value);
        Workbook workbook=new XSSFWorkbook(excelFile);
        int sheetCount=workbook.getNumberOfSheets();
        System.out.println("sheetCount="+sheetCount);
        Sheet getSheet=workbook.getSheetAt(sheetNumber);
        int rowCount=getSheet.getPhysicalNumberOfRows();
        System.out.println("rowCount="+rowCount);
        int columnCount=getSheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("columnCount="+columnCount);
        Object[][] data=new Object[rowCount-1][columnCount];
        for(int i=1;i<rowCount;i++) {
            Row getRow=getSheet.getRow(i);
            for(int j=0;j<columnCount;j++) {
                String cellValue=getRow.getCell(j).toString();
               // System.out.println("cellValue="+cellValue);
                data[i-1][j]=cellValue;
                System.out.println("data="+data[i-1][j]);
            }
        }

        return data;
    }
    public static void main(String[] args) throws IOException {
        excelReader("loginExcelPath",0);
    }
}
