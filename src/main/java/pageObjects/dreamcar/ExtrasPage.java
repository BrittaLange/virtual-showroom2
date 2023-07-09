package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtrasPage extends NavigationTabs {

	private WebDriver driver;
	private By autopilot = By.id("checkbox_extra_0-input");
	private By floormats = By.id("checkbox_extra_3-input");
	private By lighting = By.id("checkbox_extra_7-input");
	private By leatherwheel = By.id("checkbox_extra_4-input");
	private By navigationsystem = By.id("checkbox_extra_2-input");
	private By soundsystem = By.id("checkbox_extra_5-input");
	private By sportssuspension = By.id("checkbox_extra_6-input");
	private By wintertires = By.id("checkbox_extra_1-input");
	private By priceWinterTires = By.id("extra_price_1");

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
	public WebElement getFloormats() {
		return driver.findElement(floormats);
	}
	public WebElement getLighting() {
		return driver.findElement(lighting);
	}
	public WebElement getLeatherwheel() {
		return driver.findElement(leatherwheel);
	}
	public WebElement getNavigationsystem() {
		return driver.findElement(navigationsystem);
	}
	public WebElement getSoundsystem() {
		return driver.findElement(soundsystem);
	}
	public WebElement getSportssuspension() {
		return driver.findElement(sportssuspension);
	}
	public WebElement getWintertires() {
		return driver.findElement(wintertires);
	}
	public WebElement getPriceWinterTires() {
		return driver.findElement(priceWinterTires);
	}


}
