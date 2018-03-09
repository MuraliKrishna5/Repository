package Testtraining;

import org.testng.annotations.Test;

import pageObjects.PayTmLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class PayTmLogin extends BaseClass {
  @Test(dataProvider = "Logindata")
  public void LoginTest(String username, String Password) throws InterruptedException {
	  PayTmLoginPage Login = new PayTmLoginPage(driver);
	  //PayTmLoginPage.Login(username, Password);
	  Login.Login(username, Password);
	  String errormsg = driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[2]/form/div/md-content/md-input-container[1]/div/span[1]/span[2]")).getText();
	  String actualerrmsg = "Email incorrect.";
	  Assert.assertEquals(errormsg, actualerrmsg);
  }
 
}
