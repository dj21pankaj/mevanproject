package kiteAppPOMClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;



public class Utility1 
{
	static Sheet MySheet;
    public static String readDataFromExcel(int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException 
    {
    	FileInputStream MyFile=new FileInputStream("C:\\Users\\Pankaj\\Desktop\\Testing\\Automation\\ExcelSheet\\exceltest.xlsx");
		MySheet =WorkbookFactory.create(MyFile).getSheet("Sheet3");
		String value = MySheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
		return value;
    }
    
    public static void takescreenshot(WebDriver driver,int TCID) throws IOException 
    {

		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File desti=new File("C:\\Users\\Pankaj\\Desktop\\Testing\\Automation\\Screenshoot\\TC"+TCID+"Screenshoot.png");
		FileHandler.copy(source,desti);
		Reporter.log("Screenshoot taken form TC " +TCID,true);
    }
}
