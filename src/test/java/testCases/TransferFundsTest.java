package testCases;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageModel.Login;
import pageModel.TransferFunds;
import util.TestUtil;

public class TransferFundsTest extends BaseClass {
	Login Login;
	TestUtil testUtil;
	TransferFunds Tfunds;

	public TransferFundsTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		Initiation();
		Login = new Login();
		Login.UserLogin(prop.getProperty("username"), prop.getProperty("password"));
		Login.LoginButton();
		Tfunds = new TransferFunds();
		Tfunds.ClickTransferFunds();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void TransferfundsTitle() {
		String Title = Tfunds.validateTransferfundsPageTitle();
		Assert.assertEquals(Title, "ParaBank | Transfer Funds");
	}

	@Test
	public void TransferResultsTest() {
		boolean result_actual = Tfunds.validateTransferResults();
		boolean result_expected = true;
		Assert.assertEquals(result_actual, result_expected);
	}

	@Test(priority = 2)
	public void TransferTest() {
		Tfunds.ClickTransferFunds();

		Tfunds.validateFromAccount("13566");

		Tfunds.validateToAccount("13566");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		Tfunds.validateAmount("1000");
		Tfunds.validateTransferBtn();
	}

	@Test(priority = 2)
	public void EmptyAmount() {
		Tfunds.ClickTransferFunds();

		Tfunds.validateFromAccount("13566");

		Tfunds.validateToAccount("13566");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Tfunds.validateTransferBtn();
		String actualtext = Tfunds.InvalidAmount();
		Assert.assertTrue(actualtext.contains("The amount cannot be empty"));
	}

	@Test
	public void ValidateTransferCompletion() {

		Tfunds.ClickTransferFunds();
		Tfunds.validateFromAccount("13566"); //
		Tfunds.validateToAccount("13566");
		Tfunds.validateAmount("1000");
		Tfunds.validateTransferBtn();
		String actualtext = Tfunds.validateTransferResultsText();
		System.out.print(actualtext);
		Assert.assertTrue(actualtext.contains("Transfer Complete!"));
	}

}
