package week5.day1;



import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLead extends BaseClass{
		
	@Test(dataProvider="Create")

	public  void createdata(String cn,String fn,String ln) {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cn);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fn);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(ln);
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider(name="Create")
	public String[][] fetchData() {
		
		String [][] data=new String[2][3];
		
		data[0][0]="TestLeaf";
		data[0][1]="Prabu";
		data[0][2]="V";
		
		data[1][0]="TestLeaf";
		data[1][1]="Hari";
		data[1][2]="A";
		
		return data;
	}
	
}






