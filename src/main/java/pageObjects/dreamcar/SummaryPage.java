package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage extends NavigationTabs {

	private WebDriver driver;
	private By basemodelOption = By.id("#select_basemodel");
	private By insuranceBtn = By.id("button_calculate_insurance");
	private By configname = By.id("input_name");
	private By saveBtn = By.id("button_save");
	private By totalAmount = By.id("label_price_sum");
	private By summaryConfigNameLabel = By.cssSelector(".mat-card-title");
	private By imageOfCar = By.cssSelector(".mat-card-lg-image");
	
	public SummaryPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public WebElement getBasemodelOption() {
		return driver.findElement(basemodelOption);
	}
	
	public WebElement getInsuranceBtn() {
		return driver.findElement(insuranceBtn);
	}
	
	public WebElement getConfigname() {
		return driver.findElement(configname);
	}
	
	public WebElement getSaveBtn() {
		return driver.findElement(saveBtn);
	}
	
	public WebElement getTotalAmount() {
		return driver.findElement(totalAmount);
	}
	
	public WebElement getSummaryConfigNameLabel() {
		return driver.findElement(summaryConfigNameLabel);
	}
	
	public WebElement getImageOfCar() {
		return driver.findElement(imageOfCar);
	}

}
