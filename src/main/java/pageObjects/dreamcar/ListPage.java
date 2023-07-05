package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ListPage extends NavigationTabs {

	private WebDriver driver;
	private By newCarBtn = By.cssSelector("#button_new_car .mat-button-wrapper");
	
	public ListPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public WebElement getNewCarBtn() {
		return driver.findElement(newCarBtn);
	}

}
