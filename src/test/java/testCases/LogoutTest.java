package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageModel.Login;
import pageModel.LogoutPOM;
import util.TestUtil;

public class LogoutTest extends BaseClass {

	TestUtil testUtil;
	LogoutPOM logout;
	Login login;

	public LogoutTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initiation();
		logout = new LogoutPOM();
		login = new Login();
		login.UserLogin((prop.getProperty("username")), prop.getProperty("password"));
		login.LoginButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void LogOutbuttontest() {
		String actualmsg = logout.Logoutclick();
		Assert.assertTrue(actualmsg.contains("ParaBank | Welcome | Online Banking"));
	}

	@Test
	public void LogoutButtonCheck() {
		boolean linkvisible = logout.linkvisible();
		Assert.assertEquals(linkvisible, true);
	}

}
