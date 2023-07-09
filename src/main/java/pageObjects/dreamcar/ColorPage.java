package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ColorPage extends NavigationTabs {

	private WebDriver driver;
	private By lightblue = By.id("colorLight blue-input");
	private By priceColor = By.id("label_price_component");
	private By effectSelect = By.cssSelector("#select_coloreffekt");
	private By pearlEffect = By.id("option_coloreffect_2");
	private By totalAmount = By.id("label_price_sum");

	public ColorPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement getLightblue() {
		return driver.findElement(lightblue);
	}

	
	public WebElement getPriceColor() {
		return driver.findElement(priceColor);
	}
	
	public WebElement getEffectSelect() {
		return driver.findElement(effectSelect);
	}
	
	public WebElement getPearlEffect() {
		return driver.findElement(pearlEffect);
	}

	
	public WebElement getTotalAmount() {
		return driver.findElement(totalAmount);
	}
}
