package com.lnx.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//import java.io.File;
//import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static int rowCount;
	
	public static String testData(String field) throws IOException {
		
//		public static  void main(String args[]) throws IOException {
		

    File file =    new File(System.getProperty("user.dir")+"//Resources//TestDataLennox.xlsx");
    FileInputStream inputStream = new FileInputStream(file);
    
    try (
	XSSFWorkbook wb = new XSSFWorkbook(inputStream)) {

		XSSFSheet sheet=wb.getSheet("TEST_DATA");
	
		 rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		 String input = null;
		 for(int i=1;i<=rowCount;i++) {
			 if(field.contains("firstName")){
			 input = sheet.getRow(i).getCell(0).getStringCellValue();
			 	}
			 if(field.contains("lastName")){
				 input = sheet.getRow(i).getCell(1).getStringCellValue();
				}
			 if(field.contains("phoneNum")){
				 input = sheet.getRow(i).getCell(2).getStringCellValue();
				}
			 if(field.contains("email")){
				 input = sheet.getRow(i).getCell(3).getStringCellValue();
				}
			 if(field.contains("date")){
				 input = sheet.getRow(i).getCell(1).getStringCellValue();
				}
		 }
         return input;
	} 
	}
	
	public static String menuData(String field) throws IOException {

    File file =    new File(System.getProperty("user.dir")+"//Resources//TestDataLennox.xlsx");

    System.out.println(System.getProperty("user.dir"));
    FileInputStream inputStream = new FileInputStream(file);
    
    try (
	XSSFWorkbook wb = new XSSFWorkbook(inputStream)) {

		XSSFSheet sheet=wb.getSheet("MenuNavigation");
	
		 rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		 String input = null;
		 for(int i=1;i<=rowCount;i++) {
			 if(field.contains("step1")){
			 input = sheet.getRow(i).getCell(0).getStringCellValue();
			 	}
			 if(field.contains("step2")){
				 input = sheet.getRow(i).getCell(1).getStringCellValue();
				}
		 }
         return input;
	} 
	}
	

}
