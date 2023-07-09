package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasemodelPage extends NavigationTabs {

	private WebDriver driver;
	private By basemodelCombobox = By.cssSelector("mat-select#select_basemodel");
	private By basemodelItem = By.id("mat-select-value-1");
	private By option10 = By.id("option_basemodel_10");
	private By priceLabel = By.id("label_price_component");

	public BasemodelPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement getBasemodelCombobox() {
		return driver.findElement(basemodelCombobox);
	}

	public WebElement getBasemodelItem() {
		return driver.findElement(basemodelItem);
	}

	public WebElement getOption10() {
		return driver.findElement(option10);
	}

	public WebElement getPriceLabel() {
		return driver.findElement(priceLabel);
	}

}
