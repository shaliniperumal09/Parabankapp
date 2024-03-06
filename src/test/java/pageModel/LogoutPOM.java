package pageModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class LogoutPOM extends BaseClass {
	@FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
	WebElement logOutLink;

	public LogoutPOM() {
		PageFactory.initElements(driver, this);
	}

	public String Logoutclick() {
		logOutLink.click();
		return driver.getTitle();
	}

	public boolean linkvisible() {
		logOutLink.isDisplayed();
		return true;
	}
}
