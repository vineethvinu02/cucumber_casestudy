package cucumber.cucumbercasestudy;

	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;

	public class ClassFactory {
		WebDriver driver;
		
		public ClassFactory(WebDriver driver) {
			this.driver=driver;
		}
		
		@FindBy(how = How.LINK_TEXT,using = "SignIn")
		@CacheLookup
		WebElement link;
		
	@FindBy(name= "userName")
	@CacheLookup
	WebElement username;

	@FindBy(how=How.NAME,using ="password")
	@CacheLookup
	WebElement pass;

	@FindBy(how=How.NAME,using ="Login")
	@CacheLookup
	WebElement btn;
	


	
	public void Login_new(String uid,String pwd)
	{
		link.click();
		username.sendKeys(uid);
		pass.sendKeys(pwd);
		btn.click();
	}
		

	}
	

