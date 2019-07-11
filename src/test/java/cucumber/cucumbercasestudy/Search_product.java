package cucumber.cucumbercasestudy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_product {
	WebDriver driver;
	
	@Given("^Searching  for the product$")
	public void searching_for_the_product() throws Throwable {
		driver = UtilityClass.startBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@When("^user enters the Headphone in the search field$")
	public void user_enters_the_Headphone_in_the_search_field() throws Throwable 
	{
		driver.findElement(By.name("products")).sendKeys("H");	
		driver.findElement(By.name("products")).sendKeys("e");
		driver.findElement(By.name("products")).sendKeys("a");
		driver.findElement(By.name("products")).sendKeys("d");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("wait complete");
		String text = driver.findElement(By.xpath("//div[@id='myInputautocomplete-list']")).getText();	
		System.out.println("text:" +text);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='myInputautocomplete-list']")).click();		
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		
	}
	
	@Then("^User must select Headphone from options$")
	public void user_must_select_Headphone_from_options() throws Throwable {
		System.out.println("Choose your product");
		Assert.assertEquals(driver.getTitle(), "Search");
	}

}
