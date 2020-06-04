package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageClass {
	
	@FindBy(how=How.ID,id="userId")
	private WebElement username;
	@FindBy(how=How.ID,id="password")
	private WebElement password;
	@FindBy(how=How.LINK_TEXT,linkText="Forgot password ?")
	private WebElement forgotLink;
	@FindBy(how=How.XPATH,xpath="/html/body/div[2]/div[1]/div/div[2]/form/button")
	private WebElement loginButton;
	
	// login operation
	public void login(String uname, String passkey) {
	
		username.sendKeys(uname);
		password.sendKeys(passkey);
		
		loginButton.click();
	
	}


	public WebElement getUsername() {
		return username;
	}


	public void setUsername(WebElement username) {
		this.username = username;
	}


	public WebElement getPassword() {
		return password;
	}


	public void setPassword(WebElement password) {
		this.password = password;
	}


	public WebElement getForgotLink() {
		return forgotLink;
	}


	public void setForgotLink(WebElement forgotLink) {
		this.forgotLink = forgotLink;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}


	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	
}
