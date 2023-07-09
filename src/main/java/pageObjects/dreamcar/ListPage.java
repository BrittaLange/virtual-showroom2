package pageObjects.dreamcar;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListPage extends NavigationTabs {

	private WebDriver driver;
	private By newCarBtn = By.cssSelector("#button_new_car .mat-button-wrapper");
	private List<WebElement> savedCars;
	private By myfirstcar = By.linkText("MyFirstCar");

	
	public ListPage() throws IOException {
		super();
		this.driver = getDriver();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public WebElement getNewCarBtn() {
		return driver.findElement(newCarBtn);
	}

	
	public List<WebElement> getsavedCars() {
		savedCars = driver.findElements(By.xpath("//li[*]/div[@class='HomeCardStyle boxShadow']/div[@class='HomeCarListStyle']/a[@href='/dreamcar/summary']"));
		return savedCars;
	}
	
	public WebElement deleteMyfirstcar(int index) {
		return driver.findElement(By.xpath("//li[*]/div[@class='HomeCardStyle boxShadow']/button[@id='button_delete_" + index + "']"));
	}
	
	

}
