package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.Config;


public class LoginPage {

	static Logger log=Logger.getLogger(LoginPage.class.getName());
	
	@FindBy(name = "userName")
	WebElement uname;
	
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(name = "submit")
	WebElement clk;
	
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
	WebElement next;
	public void UserLogin(String un,String ps)
	{
	
		log.info("---LOGIN PAGE OPEN---");
		uname.sendKeys(un);
		log.info("---ENTER UNAME---");
		pass.sendKeys(ps);
		log.info("---ENTER PASS---");
		clk.click();
		String Webtit=Config.driver.getTitle();
		String title="Login: Mercury Tours";
		Assert.assertEquals(Webtit,title);
		log.info("---EXPECTED = "+title+" ---ACTUAL = "+Webtit+" ---");
		
		log.info("==========================REGISTER PAGE IS VALID==========================");
		next.click();
	
	}
}
