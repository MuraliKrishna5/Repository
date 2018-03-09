package Testtraining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import sun.awt.image.BadDepthException;

public class BaseClass {
	
	Logger Log = LogManager.getLogger(NewTest.class);
	WebDriver driver;
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
		    XSSFSheet sheet1 = wb.getSheet("Sheet1");

			int totalNoOfCols = 2;
			int totalNoOfRows = sheet1.getLastRowNum();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j]= sheet1.getRow(i).getCell(j).getStringCellValue();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	@DataProvider
	  public Object[][] Logindata() {
		Object[][] arrayObject = getExcelData("C:/Users/menjam/Desktop/Newexcel.xls","Sheet1");
		return arrayObject;
	   
	      
	    }
	    
	 @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		  PropertyConfigurator.configure("Log4j.properties");
		  ProfilesIni prof = new ProfilesIni();			
  		FirefoxProfile ffProfile= prof.getProfile ("Murali");
  		ffProfile.setAcceptUntrustedCertificates(true) ;
  		ffProfile.setAssumeUntrustedCertificateIssuer(false);
  		System.setProperty("webdriver.gecko.driver","c:\\Workspace\\Softwares\\geckodriver-v0.13.0-win64\\geckodriver.exe");
  		 driver = new FirefoxDriver(ffProfile);
  		driver.get("https://paytm.com/");
  		Thread.sleep(1000);
		  //System.out.println("This is from before method");
		  Log.debug("This Log message is from Before method");
	  }
	 @AfterMethod
	  public void afterMethod() {
		  //System.out.println("This is from after method");
		  Log.debug("This Log message is from after method");
		  driver.quit();
	  }
	 
	 }


