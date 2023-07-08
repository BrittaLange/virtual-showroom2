package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver;

	private By asCustomerBtn = By.cssSelector("#login_as_customer .mat-button-wrapper");
	private By asVendorBtn = By.cssSelector("#login_as_vendor .mat-button-wrapper");
	private By username = By.id("input_username");
	private By password = By.id("input_password");
	private By submitBtn = By.id("button_login");

	public LoginPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public WebElement getAsCustomerBtn() {
		return driver.findElement(asCustomerBtn);
	}
	
	public WebElement getAsVendorBtn() {
		return driver.findElement(asVendorBtn);
	}
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getSubmitBtn() {
		return driver.findElement(submitBtn);
	}
}
