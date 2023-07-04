package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage extends NavigationTabs {

	private WebDriver driver;
	private By basemodelOption = By.id("#select_basemodel");
	private By insuranceBtn = By.id("button_calculate_insurance");
	
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

}
