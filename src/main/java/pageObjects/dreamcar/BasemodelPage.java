package pageObjects.dreamcar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasemodelPage extends NavigationTabs {

	private WebDriver driver;
	private By basemodelOption = By.id("#select_basemodel");
	
	public BasemodelPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public WebElement getBasemodelOption() {
		return driver.findElement(basemodelOption);
	}

}
