package pageModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class Login extends BaseClass{

	@FindBy(name = "username") WebElement Username;
	@FindBy(name = "password") WebElement Password;
	@FindBy(xpath = "//*[@id=\"rightPanel\"]") WebElement Errormsg;
	@FindBy(xpath = "//input[@type='submit'and @value='Log In']") WebElement LoginBtn;
	@FindBy(css = "#loginPanel > p:nth-child(2) > a") WebElement FLInfoLink;
	@FindBy(xpath = "//a[contains(text(), 'Register')]") WebElement RegLink;
	
	public Login() {
		PageFactory.initElements(driver, this);}

	public String validateCLoginPageTitle() {
		return driver.getTitle();}


	 
	public void UserLogin(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		}
	
	public String LoginButton () {
		LoginBtn.click();
		return driver.getTitle();
	}
	
	public String GetErrortext() {
		return Errormsg.getText();
	}
	
	
}
