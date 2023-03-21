package week5.day2.common.integration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public RemoteWebDriver driver;
	public String datafile;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void precondition(String browser,String url,String username,String password ) {
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("edge")){
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	}
	
	@AfterMethod
	public void postcondition() {
		
		driver.close();
	}
	
	@DataProvider(name="fetch")
	public String[][] fetchData() throws IOException {
		
		return ReadIntegrationWithCreateLead.readData(datafile);
		
	}

}
