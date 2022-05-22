package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("01");
		
		WebElement  srclist = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		Select srclist1= new Select(srclist);
		srclist1.selectByIndex(4);
		Thread.sleep(5000);
		
		srclist1.selectByValue("LEAD_COLDCALL");
		Thread.sleep(5000);
		
		srclist1.selectByVisibleText("Conference");
		Thread.sleep(5000);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		System.out.println("Completed");
	}
}
