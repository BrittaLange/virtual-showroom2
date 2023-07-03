package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class DreamcarListPage extends BasePage {

	private WebDriver driver;
	private By newCarBtn = By.cssSelector("#button_new_car .mat-button-wrapper");
	
	public DreamcarListPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public WebElement getNewCarBtn() {
		return driver.findElement(newCarBtn);
	}

}
