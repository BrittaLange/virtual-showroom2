package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnginePage extends NavigationTabs {

	private WebDriver driver;
	private By engineCombobox = By.cssSelector("mat-select#select_engine");
	private By engineItem = By.id("mat-select-value-3");
	private By option4 = By.id("option_engine_4");
	private By enginePriceLabel = By.id("label_price_component");
	
	public EnginePage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public WebElement getEngineCombobox() {
		return driver.findElement(engineCombobox);
	}
	
	public WebElement getEngineItem() {
		return driver.findElement(engineItem);
	}
	
	public WebElement getOption4() {
		return driver.findElement(option4);
	}
	
	public WebElement getEnginePriceLabel() {
		return driver.findElement(enginePriceLabel);
	}

	
}
