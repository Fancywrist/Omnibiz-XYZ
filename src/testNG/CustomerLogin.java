package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomerLogin {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
	}

	@Test
	public void customerLogin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Customer Login To perform Transactions
		driver.findElement(By.xpath("//div[2]/div/div/div/button")).click();
		Select dropdown2 = new Select(driver.findElement(By.id("userSelect")));
		dropdown2.selectByVisibleText("Albus Dumbledore");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Select dropdown3 = new Select(driver.findElement(By.id("accountSelect")));
		dropdown3.selectByVisibleText("1011");
		// Click Transactions button to view all transactions ----See all list of
		// Existing  transactions for Albus Dumbledore 
		driver.findElement(By.xpath("//div[3]/button")).click();
		// date picker
		//((JavascriptExecutor) driver).executeScript("document.getElementById('dates').removeAttribute('readonly',0);");
		// Enables the from date box
		//WebElement toStartBox = driver.findElement(By.id("start"));
		//toStartBox.clear();
		//toStartBox.sendKeys("10-28-2021"); // Enter date in required format
		//WebElement toEndBox = driver.findElement(By.id("end"));
		//toEndBox.clear();
		//toEndBox.sendKeys("10-29-2021");
		driver.findElement(By.cssSelector("div.fixedTopBox &gt; button.btn")).click();// Go Back
		//driver.findElement(By.xpath("//div[2]/div/div/button[2]")).click();// Reset
		driver.findElement(By.xpath("//button[2]")).click();// Logout
		driver.findElement(By.cssSelector("button.btn.home")).click();// homepage

		// Perform Deposit Here
		driver.findElement(By.xpath("//div[3]/button[2]")).click();
		driver.findElement(By.xpath("//input")).click();
		driver.findElement(By.xpath("//input")).sendKeys("50000");
		driver.findElement(By.xpath("//form/button")).click();

		// Perform Withdrawal Here
		driver.findElement(By.xpath("//div[3]/button[3]")).click();
		driver.findElement(By.xpath("//input[@type='number']")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("20000");
		driver.findElement(By.xpath("//form/button")).click();
		// Logout
		driver.findElement(By.xpath("//button[2]")).click();
		// Go back to  Homepage
		driver.findElement(By.cssSelector("button.btn.home")).click();
	}

}
