package legalentity.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LESort {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement drop = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", drop);
		WebElement s = driver.findElement(By.xpath("//span[@title='Last Modified Date']"));
		driver.executeScript("arguments[0].click();", s);
		WebElement s1 = driver.findElement(By.xpath("//span[@title='Last Modified Date']"));
		driver.executeScript("arguments[0].click();", s1);
		String actual_Result=driver.findElement(By.xpath("//div[@class='slds-col slds-align-bottom']")).getText();
		String expected_Result="6 items • Sorted by Last Modified Date • ";
		Assert.assertEquals(actual_Result,expected_Result);
		
		
		
		
	}

}
