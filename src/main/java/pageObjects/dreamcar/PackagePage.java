package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PackagePage extends NavigationTabs {

	private WebDriver driver;
	private By priceOfNone = By.id("edition_price_0");
	private By priceOfSportPackage = By.id("edition_price_4");
	private By sportPackageRadioBtn = By.id("radio_edition_4-input");
	private By sportPackageLabel = By.cssSelector("[for='radio_edition_4-input'] .mat-radio-label-content");

	public PackagePage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement getPriceOfNone() {
		return driver.findElement(priceOfNone);
	}
	
	public WebElement getPriceOfSportPackage() {
		return driver.findElement(priceOfSportPackage);
	}
	
	public WebElement getSportPackageRadioBtn() {
		return driver.findElement(sportPackageRadioBtn);
	}
	
	public WebElement getSportPackageLabel() {
		return driver.findElement(sportPackageLabel);
	}

}
