package Testtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	public static By Login = By.xpath("html/body/div[1]/div/div[2]/div[2]/div[3]/div[3]/div");
	static By Uname = By.xpath("html/body/div[1]/div/div[4]/div[2]/form/div/md-content/md-input-container[1]/input");
	static By Pwd = By.xpath("html/body/div[1]/div/div[4]/div[2]/form/div/md-content/md-input-container[2]/input");
	static By Submit = By .xpath("html/body/div[1]/div/div[4]/div[2]/form/div/md-content/button[1]");
  @Test
  public void f() throws InterruptedException {
	  
	  ProfilesIni prof = new ProfilesIni();			
		FirefoxProfile ffProfile= prof.getProfile ("Murali");
		ffProfile.setAcceptUntrustedCertificates(true) ;
		ffProfile.setAssumeUntrustedCertificateIssuer(false);
		System.setProperty("webdriver.gecko.driver","c:\\Workspace\\Softwares\\geckodriver-v0.13.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(ffProfile);
		driver.get("https://paytm.com/");
		Thread.sleep(3000);
		driver.findElement(Login).click();
		Thread.sleep(5000);
//		int i = driver.findElements(By.tagName("iframe")).size();
//		System.out.println(i);
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@src='/v1/api/login?isIframe=true&theme=mp-web']")));
		Thread.sleep(1000);
		driver.findElement(Uname).sendKeys("adsfsda");
		driver.findElement(Pwd).sendKeys("adsf");
		driver.findElement(Submit).click();
		String errormsg = driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[2]/form/div/md-content/md-input-container[1]/div/span[1]/span[2]")).getText();
		System.out.println(errormsg);
		Assert.assertEquals(errormsg, "Email incorrect");
  }
}
