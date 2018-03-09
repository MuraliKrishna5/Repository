package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayTmLoginPage {
	
	public static By Login = By.xpath("html/body/div[1]/div/div[2]/div[2]/div[3]/div[3]/div");
	public static By Uname = By.xpath("html/body/div[1]/div/div[4]/div[2]/form/div/md-content/md-input-container[1]/input");
	public static By Pwd = By.xpath("html/body/div[1]/div/div[4]/div[2]/form/div/md-content/md-input-container[2]/input");
	public static By Submit = By .xpath("html/body/div[1]/div/div[4]/div[2]/form/div/md-content/button[1]");
	WebDriver driver;

	public void Login(String username, String Password) throws InterruptedException{
		driver.findElement(Login).click();
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@src='/v1/api/login?isIframe=true&theme=mp-web']")));
		driver.findElement(Uname).sendKeys(username);
		driver.findElement(Pwd).sendKeys(Password);
		driver.findElement(Submit).click();
		}

     public PayTmLoginPage(WebDriver driver){
    	 this.driver = driver;
   }

}
