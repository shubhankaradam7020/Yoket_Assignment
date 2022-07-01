package Yoket_Assignment.Yoket_Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Testing {
	
	
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://yocket.com/college-finder/masters/results");
		
		driver.findElement(By.xpath("(//span[@class='text-sm hidden xl:block'])[2]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Masters')]")).click();
		System.out.println("Clicked on Masters Button");
		
		WebElement countrySelect = driver.findElement(By.xpath("//div[@id='vs1__combobox']"));
		Actions s = new Actions(driver);
		s.click(countrySelect).perform();
		s.sendKeys(Keys.ARROW_DOWN).perform();
		s.sendKeys(Keys.ARROW_DOWN).perform();
		s.sendKeys(Keys.ENTER).perform();
		System.out.println("Country Selected");
		
		WebElement MajorSelect = driver.findElement(By.xpath("//div[@id='vs2__combobox']"));
		//Actions a = new Actions(driver);
		s.click(MajorSelect).perform();
		s.sendKeys("Electrical Engineering").perform();
		Thread.sleep(2000);
		s.sendKeys(Keys.ENTER).perform();
		System.out.println("Major Selected");
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		System.out.println("Form 1 Completed");
		
		WebElement College= driver.findElement(By.xpath("//div[@id='vs4__combobox']"));
		s.click(College).perform();
		s.sendKeys("MIT, Aurangabad").perform();
		Thread.sleep(2000);
		s.sendKeys(Keys.ENTER).perform();
		System.out.println("College Selected");
		
		WebElement mjr= driver.findElement(By.xpath("//div[@id='vs6__combobox']"));
		s.click(mjr).perform();
		s.sendKeys("Electrical Engineering").perform();
		Thread.sleep(2000);
		s.sendKeys(Keys.ENTER).perform();
		System.out.println("mjr Selected");
		driver.findElement(By.id("marks")).sendKeys("8");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Form 2 Completed");

		
		WebElement wb=driver.findElement(By.xpath("//div[contains(text(),'IELTS')]"));
		System.out.println("IELTS Selected");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", wb);
		driver.findElement(By.id("ielts_overall_score")).sendKeys("9");
		System.out.println("IELTS Score entered");
		
		WebElement at=driver.findElement(By.xpath("//div[contains(text(),'GMAT')]"));
		System.out.println("GMAT Selected");
		JavascriptExecutor jss= (JavascriptExecutor)driver;
		jss.executeScript("arguments[0].click();", at);
		driver.findElement(By.id("total_gmat_score")).sendKeys("800");
		System.out.println("GMAT score entered");
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		System.out.println("Form 3 Completed");
		
		driver.findElement(By.id("work_exp")).sendKeys("33");
		System.out.println("Work experience entered");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Form 4 completed");
		WebElement sortby = driver.findElement(By.xpath("//select[@xpath='1']"));
		Select se = new Select(sortby);
		se.selectByValue("1");
		System.out.println("Sorting Done");
		driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/span[1]/span[1]")).click();
		System.out.println("Shortlisted first college");
	}

}
