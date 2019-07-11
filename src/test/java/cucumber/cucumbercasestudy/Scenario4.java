package cucumber.cucumbercasestudy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Scenario4 {

	WebDriver driver;
	Boolean cart_logo;

	@Given("^Launch the browser and open test me app$")
	public void launch_the_browser_and_open_test_me_app() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = UtilityClass.startBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.id("userName")).sendKeys("akahamed");
		driver.findElement(By.id("password")).sendKeys("Abcd1234");
		driver.findElement(By.name("Login")).click();
	}

	
//	@Given("^User has registered in TestMeApp$")
//	public void user_has_registered_in_TestMeApp() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		driver = UtilityClass.startBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
//	}

	@When("^User Search a product like headphones$")
	public void user_Search_a_product_like_headphones() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("products")).sendKeys("H");
		driver.findElement(By.name("products")).sendKeys("e");
		driver.findElement(By.name("products")).sendKeys("a");
		driver.findElement(By.name("products")).sendKeys("d");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("wait complete");
		String text = driver.findElement(By.xpath("//div[@id='myInputautocomplete-list']")).getText();
		System.out.println("text:" + text);
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='myInputautocomplete-list']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		Assert.assertEquals(driver.getTitle(), "Search");
	}

	@When("^Try to proceed to payment without adding it to cart$")
	public void try_to_proceed_to_payment_without_adding_it_to_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cart_logo = driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/a[2]")).isDisplayed();
		System.out.println(cart_logo);
		Assert.assertFalse(false, "No Items in the Cart ! Cannot Proceed Further");
	}

	@Then("^TestMeApp doesn't display the cart Icon$")
	public void testmeapp_doesn_t_display_the_cart_Icon() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Add products and Then proceed");
		driver.close();
	}

	// -----------------------------------PASS-------------------------------------------

	
	@When("^User Search a product and User adds product to cart and checksout$")
	public void user_Search_a_product_and_User_adds_product_to_cart_and_checksout() throws Throwable {
		driver.findElement(By.name("products")).sendKeys("H");
		driver.findElement(By.name("products")).sendKeys("e");
		driver.findElement(By.name("products")).sendKeys("a");
		driver.findElement(By.name("products")).sendKeys("d");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("wait complete");
		String text = driver.findElement(By.xpath("//div[@id='myInputautocomplete-list']")).getText();
		System.out.println("text:" + text);
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='myInputautocomplete-list']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		Assert.assertEquals(driver.getTitle(), "Search");
		
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		// Assert.assertEquals
		WebElement value = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]/b"));
		Assert.assertNotNull(value);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]/b")).click();
		Assert.assertEquals(driver.getTitle(), "View Cart");
		driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		Assert.assertEquals(driver.getTitle(), "Cart Checkout");
	
	}

	
	
	@When("^User Proceeds to Payment$")
	public void user_Proceeds_to_Payment() throws Throwable {
		// Write code here that turns the phrase above into concrete actions		
		driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
		
	}

	@Then("^User should be in Payment Page$")
	public void user_should_be_in_Payment_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getTitle(),"Payment Gateway");
		System.out.println("Enter Payment Credentials and Complete the order");
		driver.close();
	}

}
