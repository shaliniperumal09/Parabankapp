package pageModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseClass;

public class TransferFunds extends BaseClass {
	
	@FindBy(id = "amount") WebElement Amount;
	@FindBy(id = "fromAccountId") WebElement FromAccount;
	@FindBy(id = "toAccountId") WebElement ToAccount;
	@FindBy(xpath = "//input[@value = 'Transfer']") WebElement TransferBtn;
	@FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/h1") WebElement TransferResult;
	@FindBy(linkText = "Transfer Funds") WebElement TransferFundsLink;
	@FindBy(xpath="//*[@id=\"amount.errors\"]") WebElement amountError;

public TransferFunds() {
	PageFactory.initElements(driver, this);}

public String validateTransferfundsPageTitle() {
	return driver.getTitle();
	}

public void validateAmount(String amt) {
	Amount.sendKeys(amt);
	}

public void validateFromAccount(String fromacc) {
	Select FromList = new Select(FromAccount);
	FromList.selectByValue(fromacc);
	}

public void validateToAccount(String toacc) {
	Select ToList = new Select(ToAccount);
	ToList.selectByValue(toacc);
	}

public void validateTransferBtn() {
	TransferBtn.click();
	}

public void ClickTransferFunds() {
	TransferFundsLink.click();
	}


public boolean validateTransferResults() {
 return TransferResult.isDisplayed();
	}

public String validateTransferResultsText() {
	return TransferResult.getText();
	}

public String InvalidAmount() {
	 return amountError.getText();
		}
	
}

