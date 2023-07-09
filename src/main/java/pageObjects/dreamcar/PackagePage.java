package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PackagePage extends NavigationTabs {

	private WebDriver driver;
	private By priceOfNone = By.id("edition_price_0");
	private By sportPackageRadioBtn = By.id("radio_edition_4-input");

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
	public WebElement getSportPackageRadioBtn() {
		return driver.findElement(sportPackageRadioBtn);
	}

}
