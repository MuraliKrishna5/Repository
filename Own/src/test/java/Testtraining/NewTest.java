package Testtraining;

import org.testng.annotations.Test;

import pageObjects.Welcome;

import org.testng.annotations.BeforeMethod;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.DOMConfigurator;
import org.eclipse.jetty.util.log.Log;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class NewTest extends BaseClass {
	
			
  @Test
  public void f() {
	  
	  Welcome.main(null);
	  Log.info("This message is from test method");
	  Reporter.log("This message is from reporter log");
	   }
}
