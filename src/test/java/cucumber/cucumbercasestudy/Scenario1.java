package cucumber.cucumbercasestudy;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Scenario1 {
	WebDriver driver;

	@Given("^User should be in TestMeApp and SignUP page\\.$")
	public void user_should_be_in_TestMeApp_and_SignUP_page() throws Throwable {
		driver = UtilityClass.startBrowser("chrome", "http://10.232.237.143:443/TestMeApp/");
		driver.findElement(By.linkText("SignUp")).click();		
	}
	

	 @Given("^User provides all valid details$")
	public void user_provides_all_valid_details(DataTable data) throws Throwable {
		List<Map<String, String>> val = data.asMaps(String.class, String.class);
		for (int i = 0; i < val.size(); i++) {
			driver.findElement(By.id("userName")).sendKeys(val.get(i).get("username"));
			driver.findElement(By.name("firstName")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='err']")).getText(), "Available");
			driver.findElement(By.name("firstName")).sendKeys(val.get(i).get("First Name"));
			driver.findElement(By.name("lastName")).sendKeys(val.get(i).get("Last Name"));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(val.get(i).get("Password"));
			driver.findElement(By.xpath("//input[@name='confirmPassword']"))
					.sendKeys(val.get(i).get("Confirm Password"));
			driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[6]/div/div/label/span[1]")).click();
			// email and address
			driver.findElement(By.id("emailAddress")).sendKeys(val.get(i).get("E-Mail"));
			driver.findElement(By.name("mobileNumber")).sendKeys(val.get(i).get("Mobile Number"));
			driver.findElement(By.name("dob")).sendKeys(val.get(i).get("DOB"));
			driver.findElement(By.name("address")).sendKeys(val.get(i).get("Address"));			
			driver.findElement(By.name("answer")).sendKeys(val.get(i).get("Answer"));

		}

	}

	@When("^User Clicks on the Register$")
	public void user_Clicks_on_the_Register() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).click();
	}

	@Then("^User should be in Login page$")
	public void user_should_be_in_Login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.close();
		
	}
}
