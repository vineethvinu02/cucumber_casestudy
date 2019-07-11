package cucumber.cucumbercasestudy;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.cucumbercasestudy.UtilityClass;

public class Login1 {
	WebDriver driver;

	@Given("^user is on the home page and user must click on Signin button$")
	public void user_is_on_the_home_page_and_user_must_click_on_Signin_button() throws Throwable {
		driver = UtilityClass.startBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@When("^user enter the valid credentails and user must click on the Login button$")
	public void user_enter_the_valid_credentails_and_user_must_click_on_the_Login_butston(DataTable dot)
			throws Throwable {

		List<Map<String, String>> data = dot.asMaps(String.class, String.class);
		for (int i = 0; i < data.size() - 1; i++) {
			System.out.println(data.size());
			ClassFactory login = PageFactory.initElements(driver, ClassFactory.class);
			login.Login_new(data.get(i).get("value"), data.get(i + 1).get("value"));
		}

	}

	@Then("^user must in home page and display success message$")
	public void user_must_in_home_page_and_display_success_message() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "Home");
		System.out.println("Logged in successfully");
	}


	
}
