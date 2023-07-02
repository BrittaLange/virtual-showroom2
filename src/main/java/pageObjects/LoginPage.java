package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;

	By asCustomerBtn = By.cssSelector("#login_as_customer .mat-button-wrapper");

	public LoginPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public WebElement getAsCustomerBtn() {
		return driver.findElement(asCustomerBtn);
	}

}
