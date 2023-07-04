package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class NavigationTabs extends BasePage {

	private WebDriver driver;

	protected By basemodelNavBtn = By.id("navigationbar_list");
	protected By listNavBtn = By.id("navigationbar_list");
	protected By engineNavBtn = By.id("navigationbar_engine");
	protected By packageNavBtn = By.id("navigationbar_package");
	protected By extrasNavBtn = By.id("navigationbar_extras");
	protected By colorNavBtn = By.id("navigationbar_color");
	protected By summaryNavBtn = By.id("navigationbar_summary");
	
	public NavigationTabs() throws IOException {
		super();
		this.driver = getDriver();
	}
	
	public WebElement getSummaryNavBtn() {
		return driver.findElement(summaryNavBtn);
	}
	
	public WebElement getBasemodelNavBtn() {
		return driver.findElement(basemodelNavBtn);
	}
	
	public WebElement getListNavBtn() {
		return driver.findElement(listNavBtn);
	}
	
	public WebElement getEngineNavBtn() {
		return driver.findElement(engineNavBtn);
	}
	
	public WebElement getPackageNavBtn() {
		return driver.findElement(packageNavBtn);
	}
	
	public WebElement getExtrasNavBtn() {
		return driver.findElement(extrasNavBtn);
	}
	
	public WebElement getColorNavBtn() {
		return driver.findElement(colorNavBtn);
	}

}
