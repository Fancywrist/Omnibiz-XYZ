package testNG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;

public class bankManagerLogin {
	private static final String Script = null;
	private static final Object Arguments = null;
	WebDriver driver;
	private Object js;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
	}

	@Test(priority = 0)
	public void managerLogin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Manager Login To Register Customer -Customer must be already existing to use
		// the platform
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[2]/button")).click();
		// Create-Customer
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".center > button:nth-of-type(1)")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bash");
		driver.findElement(By.xpath("//div[2]/input")).click();
		driver.findElement(By.xpath("//div[2]/input")).sendKeys("Hassan");
		driver.findElement(By.xpath("//body[@class='ng-scope']/div[@class='ng-scope']/div/div[@class='ng-scope']/div/div[@class='ng-scope']//form[@role='form']/div[3]/input[@type='text']")).click();
		driver.findElement(By.xpath("//body[@class='ng-scope']/div[@class='ng-scope']/div/div[@class='ng-scope']/div/div[@class='ng-scope']//form[@role='form']/div[3]/input[@type='text']")).sendKeys("100988");
		Thread.sleep(200);
		// isTextPresent("//form/button","Add Customer");
		driver.findElement(By.xpath("//form/button")).click();
		// wait declaration
		Thread.sleep(5000);
		// Assert Here ---Insert code to ascertain success message is display and id is
		// generated
		driver.switchTo().alert().accept();
		// Create-Account
		driver.findElement(By.cssSelector(".center > button:nth-of-type(2)")).click();

		Select dropdown = new Select(driver.findElement(By.id("userSelect")));
		dropdown.selectByVisibleText("Bash Hassan");
		Select dropdown1 = new Select(driver.findElement(By.id("currency")));
		dropdown1.selectByVisibleText("Dollar");
		driver.findElement(By.cssSelector("form[role='form'] > button")).click();

		// isTextPresent("form[role='form'] > button", "Process");
		// AsertHere ---Insert code to ascertain success message is display and account
		// number is generated
		driver.switchTo().alert().accept();
		// View, Search and Delete Customers Details Here
		driver.findElement(By.cssSelector(".center > button:nth-of-type(3)")).click();
		Thread.sleep(2000);
		// search for a customer
		driver.findElement(By.xpath("//input")).click();
		driver.findElement(By.xpath("//input")).sendKeys("Bash");

//  // This  will scroll down the page by  1000 pixel vertical
//     JavascriptExecutor js = (JavascriptExecutor) driver;  
//     js.executeScript(Script,Arguments);
//      js.executeScript("window.scrollBy(0,1000)");
		// delete record
		driver.findElement(By.xpath("//td[5]/button")).click();
		// driver.close();
		driver.findElement(By.cssSelector("button.btn.home")).click();
	}
//  //functions for assertion 
//  public  void isTextPresent(String ele, String text){
//      try{
//    	  WebElement checker = driver.findElement(By.cssSelector(ele));
//    	  //System.out.println(checker.getText());
//    	  assertEquals(checker.getText(), text);
//    			  
////          boolean b = driver.getPageSource().contains(text);/          
//    	  System.out.println("Text Found");
//         // return b; 
//      }
//      catch(Exception e){
//    	  System.out.println("Not Found"); 
//          //return false;
//      }
//    }
// 
}
