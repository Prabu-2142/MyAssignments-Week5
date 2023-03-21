package week5.day1;




import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class EditLead extends BaseClass {
	
	@Test(dataProvider = "Edit")

	public  void editdata(String ph,String nm) throws InterruptedException {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ph);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(nm);
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider(name="Edit")
	public String[][] fetchData(){
		
		String[][] d= new String [2][2];
		d[0][0] = "99";
		d[0][1] = "CTS";
		
		d[1][0] = "99";
		d[1][1] = "TechMahindra";
		
		return d;
		
	}
	
	
}






