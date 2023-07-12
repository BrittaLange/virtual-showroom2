package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtrasPage extends NavigationTabs {

	private WebDriver driver;
	private By autopilot = By.id("checkbox_extra_0-input");
	private By priceAutopilot = By.id("extra_price_0");
	private By autopilotLabel = By.cssSelector("[for='checkbox_extra_0-input'] .mat-checkbox-label");
	private By floormats = By.id("checkbox_extra_3-input");
	private By priceFloormats = By.id("extra_price_3");
	private By floormatsLabel = By.cssSelector("[for='checkbox_extra_3-input'] .mat-checkbox-label");
	private By lighting = By.id("checkbox_extra_7");
	private By lightingLabel = By.cssSelector("[for='checkbox_extra_7-input'] .mat-checkbox-label");
	private By priceLighting = By.id("extra_price_7");
	private By leatherwheel = By.id("checkbox_extra_4-input");
	private By leatherwheelLabel = By.cssSelector("[for='checkbox_extra_4-input'] .mat-checkbox-label");
	private By navigationsystem = By.id("checkbox_extra_2-input");
	private By priceNavigationsystem = By.id("extra_price_2");
	private By navigationsystemLabel = By.cssSelector("[for='checkbox_extra_2-input'] .mat-checkbox-label");
	private By soundsystem = By.id("checkbox_extra_5-input");
	private By priceSoundsystem = By.id("extra_price_5");
	private By soundsystemLabel = By.cssSelector("[for='checkbox_extra_5-input'] .mat-checkbox-label");
	private By sportssuspension = By.id("checkbox_extra_6-input");
	private By priceSportssuspension = By.id("extra_price_6");
	private By sportssuspensionLabel = By.cssSelector("[for='checkbox_extra_6-input'] .mat-checkbox-label");
	private By wintertires = By.id("checkbox_extra_1-input");
	private By wintertiresLabel = By.cssSelector("[for='checkbox_extra_1-input'] .mat-checkbox-label");
	private By priceWinterTires = By.id("extra_price_1");
	private By discountPercentage = By.id("label_discount");
	private By discountAmount = By.cssSelector("ul#included_extras > label:nth-of-type(2)");
	private By totalAmount = By.id("label_price_sum");

	public ExtrasPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement getAutopilot() {
		return driver.findElement(autopilot);
	}
	
	public WebElement getPriceAutopilot() {
		return driver.findElement(priceAutopilot);
	}
	
	public WebElement getAutopilotLabel() {
		return driver.findElement(autopilotLabel);
	}
	
	public WebElement getFloormats() {
		return driver.findElement(floormats);
	}
	
	public WebElement getPriceFloormats() {
		return driver.findElement(priceFloormats);
	}
	public WebElement getFloormatsLabel() {
		return driver.findElement(floormatsLabel);
	}
	
	public WebElement getLighting() {
		return driver.findElement(lighting);
	}
	
	public WebElement getPriceLighting() {
		return driver.findElement(priceLighting);
	}
	
	public WebElement getLightingLabel() {
		return driver.findElement(lightingLabel);
	}
	
	public WebElement getLeatherwheel() {
		return driver.findElement(leatherwheel);
	}
	
	public WebElement getLeatherwheelLabel() {
		return driver.findElement(leatherwheelLabel);
	}
	
	public WebElement getNavigationsystem() {
		return driver.findElement(navigationsystem);
	}
	
	public WebElement getPriceNavigationsystem() {
		return driver.findElement(priceNavigationsystem);
	}
	
	public WebElement getNavigationsystemLabel() {
		return driver.findElement(navigationsystemLabel);
	}
	
	public WebElement getSoundsystem() {
		return driver.findElement(soundsystem);
	}
	
	public WebElement getPriceSoundsystem() {
		return driver.findElement(priceSoundsystem);
	}
	
	public WebElement getSoundsystemLabel() {
		return driver.findElement(soundsystemLabel);
	}
	
	public WebElement getSportssuspension() {
		return driver.findElement(sportssuspension);
	}
	
	public WebElement getPriceSportssuspension() {
		return driver.findElement(priceSportssuspension);
	}
	
	public WebElement getSportssuspensionLabel() {
		return driver.findElement(sportssuspensionLabel);
	}
	
	public WebElement getWintertires() {
		return driver.findElement(wintertires);
	}
	
	public WebElement getWintertiresLabel() {
		return driver.findElement(wintertiresLabel);
	}
	
	public WebElement getPriceWinterTires() {
		return driver.findElement(priceWinterTires);
	}
	
	public WebElement getDiscountPercentage() {
		return driver.findElement(discountPercentage);
	}
	
	public WebElement getDiscountAmount() {
		return driver.findElement(discountAmount);
	}
	
	public WebElement getTotalAmount() {
		return driver.findElement(totalAmount);
	}

}
