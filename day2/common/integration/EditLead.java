package week5.day2.common.integration;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class EditLead extends BaseClass {
	
	@BeforeTest
	
public void getdata() {
		
		datafile = "EditLead";
	}
	
	@Test(dataProvider = "fetch")

	public  void editdata(String ph,String nm) throws InterruptedException {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ph);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebElement clean = driver.findElement(By.id("updateLeadForm_companyName"));
		clean.clear();
		clean.sendKeys(nm);
		driver.findElement(By.name("submitButton")).click();
		
}
	
	
	
}






