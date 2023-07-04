package pageObjects.factbook;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class CustomerListPage extends BasePage {

	private WebDriver driver;
	private By addCustomerBtn = By.cssSelector("mat-grid-tile#add_customer > .mat-grid-tile-content");
	


	public CustomerListPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public WebElement getAddCustomerBtn() {
		return driver.findElement(addCustomerBtn);
	}

}
