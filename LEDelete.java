package legalentity.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LEDelete {

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
		WebElement a = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
		a.sendKeys("Salesforce Automation by Iswarya");  
        a.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]")).click();
        WebElement s = driver.findElement(By.xpath("//div[@title='Delete']"));
        driver.executeScript("arguments[0].click();", s);
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Legal Entity \"Salesforce Automation by Iswarya\" was deleted. Undo";
		Assert.assertEquals(actual_Result,expected_Result);

	}

}
