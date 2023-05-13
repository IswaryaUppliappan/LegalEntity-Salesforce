package legalentity.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LECreateWmf {

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
		driver.findElement(By.xpath("//a[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Testleaf");
		WebElement k = driver.findElement(By.xpath("(//textarea[contains(@class,'slds-textarea')])[2]"));
		k.sendKeys("Salesforce");
		WebElement drop1 = driver.findElement(By.xpath("//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')]"));
		driver.executeScript("arguments[0].click();", drop1);
		driver.findElement(By.xpath("//span[@title='Active']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String actual_Error=driver.findElement(By.xpath("//div[text()='Complete this field.']")).getText();
		String expected_Error= "Complete this field.";
	    Assert.assertEquals(actual_Error,expected_Error);
	    Assert.assertTrue(actual_Error.contains("Complete this field."));
	}

}
