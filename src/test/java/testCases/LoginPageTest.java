package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageModel.Login;
import util.TestUtil;

public class LoginPageTest extends BaseClass {

	TestUtil testUtil;
	Login Login;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initiation();
		Login = new Login();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void validateCLoginPageTitleTest() {
		String title = Login.validateCLoginPageTitle();
		Assert.assertEquals(title, "ParaBank | Welcome | Online Banking");
	}

	@Test
	public void LoginTest() {
		Login.UserLogin(prop.getProperty("username"), prop.getProperty("password"));
		Login.LoginButton();
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, "ParaBank | Accounts Overview");
	}

	@Test
	public void InvalidUsername() {
		Login.UserLogin("123", prop.getProperty("password"));
		Login.LoginButton();
		String actualmsg = Login.GetErrortext();
		Assert.assertTrue(actualmsg.contains("An internal error has occurred and has been logged."));
	}

	@Test

	public void InvalidPassword() {
		Login.UserLogin((prop.getProperty("username")), "4tyuhfds");
		Login.LoginButton();
		String actualmsg = Login.GetErrortext();
		Assert.assertTrue(actualmsg.contains("An internal error has occurred and has been logged."));
	}
	
	@Test
	public void InvalidInput() {
		Login.UserLogin("123", "###");
		Login.LoginButton();
		String actualmsg = Login.GetErrortext();
		Assert.assertTrue(actualmsg.contains("An internal error has occurred and has been logged."));
	}
	
	@Test
	public void EmptyInputs() {
		Login.UserLogin("", "");
		Login.LoginButton();
		String actualmsg = Login.GetErrortext();
		Assert.assertTrue(actualmsg.contains("Please enter a username and password."));
	}

}
