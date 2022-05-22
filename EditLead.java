package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vignesh");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("VM");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing Team");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("I'm from Chennai");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("v.m@gmail.com");

		WebElement srclist = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		Select srclist1 = new Select(srclist);
		srclist1.selectByVisibleText("New York");

		driver.findElement(By.className("smallSubmit")).click();

		Thread.sleep(5000);

		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("I'm from Chennai");
		driver.findElement(By.className("smallSubmit")).click();
		
		String titleHeader = driver.getTitle();

		System.out.println("The title of the Result page is \" "+titleHeader+" \"");

		Thread.sleep(5000);
		
		String impcon = driver.findElement(By.id("viewLead_importantNote_sp")).getText();
		
		if (impcon.equals("I'm from Chennai")) {
				System.out.println("The Important Note is updated ");
		}
		//driver.close();
		
	}
}
