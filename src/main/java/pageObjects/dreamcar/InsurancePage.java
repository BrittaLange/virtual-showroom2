package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsurancePage extends NavigationTabs {

	private WebDriver driver;
	private By basePriceLabel = By.cssSelector("#basePrice");
	private By orderBtn = By.cssSelector("button#No_Risk_go_to_order");
	
	public InsurancePage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public By getBasePriceLabelSelector() {
		return basePriceLabel;
	}
	public WebElement getBasePriceLabel() {
		return driver.findElement(basePriceLabel);
	}
	
	public WebElement getOrderBtn() {
		return driver.findElement(orderBtn);
	}
	
}
