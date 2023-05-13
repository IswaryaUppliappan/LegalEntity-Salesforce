package legalentity.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LEEdit {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys("Salesforce Automation by Iswarya");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]")).click();
	    WebElement k = driver.findElement(By.xpath("//div[@title='Edit']"));
	    driver.executeScript("arguments[0].click();", k);
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Testleaf");
	    WebElement d = driver.findElement(By.xpath("(//textarea[contains(@class,'slds-textarea')])[2]"));
	    d.sendKeys("SalesForce");
	    WebElement a = driver.findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"));
	    driver.executeScript("arguments[0].click();", a);
	    driver.findElement(By.xpath("//span[@title='Active']")).click();
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String  expected_Result= "Legal Entity \"Salesforce Automation by Iswarya\" was saved.";
        Assert.assertEquals(actual_Result,expected_Result);
	    
	}

}
