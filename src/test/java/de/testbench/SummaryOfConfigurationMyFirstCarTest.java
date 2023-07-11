package de.testbench;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;

import pageObjects.LoginPage;
import pageObjects.dreamcar.BasemodelPage;
import pageObjects.dreamcar.ColorPage;
import pageObjects.dreamcar.EnginePage;
import pageObjects.dreamcar.ExtrasPage;
import pageObjects.dreamcar.ListPage;
import pageObjects.dreamcar.PackagePage;
import pageObjects.dreamcar.SummaryPage;

@Listeners(resources.Listeners.class)
/**
 * TestCaseID cloud01-eu.testbench.com/TB4-T7
 *
 * @author Britta
 *
 */
public class SummaryOfConfigurationMyFirstCarTest extends Hooks {

	private String TestCaseID = "cloud01-eu.testbench.com/TB4-T7";

	public SummaryOfConfigurationMyFirstCarTest() throws IOException {
		super();
	}

	@Test
	public void summarizeConfigurationOfMyFirstCar() throws IOException {
		ExtentManager.log("Starting " + this.getClass().getName());
		ExtentManager.log("TestCaseID " + this.getTestCaseID());
		LoginPage loginPage = new LoginPage();
		loginPage.getUsername().sendKeys("WebTestBench_c02");
		loginPage.getPassword().sendKeys("password_c02");
		loginPage.getSubmitBtn().click();
		ExtentManager.pass("Logged in with credentials as customer.");

		ListPage dreamcar = new ListPage();
		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.elementToBeClickable(dreamcar.getNewCarBtn()));
		dreamcar.getNewCarBtn().click();
		ExtentManager.pass("Clicked new car button.");

		BasemodelPage basemodel = new BasemodelPage();
		wait1.until(ExpectedConditions.visibilityOf(basemodel.getBasemodelItem()));
		basemodel.getBasemodelCombobox().click();

		// Scroll to option 10.
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", basemodel.getOption10());
		basemodel.getOption10().click();
		String expectedOption = "Model 10 (Rolo XL)";
		String expectedModelPrice = "24.999,00 €";
		Assert.assertEquals(basemodel.getBasemodelItem().getText(), expectedOption, "Not the expected base model: ");
		ExtentManager.pass("Selected base model: " + basemodel.getBasemodelItem().getText());
		Assert.assertEquals(basemodel.getPriceLabel().getText().trim(), expectedModelPrice, "Not the expected price: ");
		ExtentManager.pass("Correct price for the selected base model: " + basemodel.getPriceLabel().getText().trim());
		basemodel.getEngineNavBtn().click();

		EnginePage engine = new EnginePage();
		wait1.until(ExpectedConditions.visibilityOf(engine.getEngineItem()));
		engine.getEngineCombobox().click();
		engine.getOption4().click();
		String expectedEngine = "ECOtech with Hybrid";
		String expectedEnginePrice = "4.999,00 €";
		Assert.assertEquals(engine.getEngineItem().getText(), expectedEngine, "Not the expected engine: ");
		ExtentManager.pass("Selected engine is : " + engine.getEngineItem().getText());
		Assert.assertEquals(engine.getEnginePriceLabel().getText(), expectedEnginePrice,
				"Not the expected price of engine: ");
		ExtentManager.pass("Correct price for engine is displayed: " + engine.getEnginePriceLabel().getText());
		engine.getPackageNavBtn().click();
		
		PackagePage pack = new PackagePage();
		wait1.until(ExpectedConditions.textToBePresentInElement(pack.getPriceOfNone(), "0,00 €"));
		js.executeScript("arguments[0].click()", pack.getSportPackageRadioBtn());
//		pack.getSportPackageRadioBtn().click();
		String expectedPackagePrice = "2.999,99 €";
		String expectedPackage = "Sport Package \"OutRun\"";
		Assert.assertEquals(pack.getSportPackageRadioBtn().isSelected(), true, "Not the expected option selected: ");
		ExtentManager.pass("Sport Package is selected: " + pack.getSportPackageRadioBtn().isSelected());
		Assert.assertEquals(pack.getSportPackageLabel().getText().trim(), expectedPackage, "Not the expected package: ");
		ExtentManager.pass("The selected package is: " + pack.getSportPackageLabel().getText());
		Assert.assertEquals(pack.getPriceOfSportPackage().getText(), expectedPackagePrice, "Not the expected price: ");
		ExtentManager.pass("Correct price for sport package is displayed: " + pack.getPriceOfSportPackage().getText());
		pack.getExtrasNavBtn().click();
		
		ExtrasPage extras = new ExtrasPage();
		wait1.until(ExpectedConditions.textToBePresentInElement(extras.getPriceWinterTires(), "210,00 €"));
		js.executeScript("arguments[0].click()", extras.getAutopilot());
		js.executeScript("arguments[0].click()", extras.getFloormats());
		js.executeScript("arguments[0].click()", extras.getNavigationsystem());
		js.executeScript("arguments[0].click()", extras.getSoundsystem());
		js.executeScript("arguments[0].click()", extras.getWintertires());
		String expectedAutopilotPrice ="2.900,00 €";
		String expectedFloormatsPrice ="46,00 €";
		String expectedNavigationsystemPrice ="1.490,00 €";
		String expectedSoundsystemPrice ="470,00 €";
		String expectedWintertiresPrice ="210,00 €";
		Assert.assertEquals(extras.getAutopilot().isSelected(), true, "Checkbox is not selected: ");
		ExtentManager.pass("Checkbox is selected: " + extras.getAutopilotLabel().getText());
		Assert.assertEquals(extras.getPriceAutopilot().getText().trim(), expectedAutopilotPrice, "Not the expected price: ");
		ExtentManager.pass("Correct price is displayed: " + extras.getPriceAutopilot().getText());
		
		Assert.assertEquals(extras.getFloormats().isSelected(), true, "Checkbox is not selected: ");
		ExtentManager.pass("Checkbox is selected: " + extras.getFloormatsLabel().getText());
		Assert.assertEquals(extras.getPriceFloormats().getText().trim(), expectedFloormatsPrice, "Not the expected price: ");
		ExtentManager.pass("Correct price is displayed: " + extras.getPriceFloormats().getText());
		
		Assert.assertEquals(extras.getNavigationsystem().isSelected(), true, "Checkbox is not selected: ");
		ExtentManager.pass("Checkbox is selected: " + extras.getNavigationsystemLabel().getText());
		Assert.assertEquals(extras.getPriceNavigationsystem().getText().trim(), expectedNavigationsystemPrice, "Not the expected price: ");
		ExtentManager.pass("Correct price is displayed: " + extras.getPriceNavigationsystem().getText());
		
		Assert.assertEquals(extras.getSoundsystem().isSelected(), true, "Checkbox is not selected: ");
		ExtentManager.pass("Checkbox is selected: " + extras.getSoundsystemLabel().getText());
		Assert.assertEquals(extras.getPriceSoundsystem().getText().trim(), expectedSoundsystemPrice, "Not the expected price: ");
		ExtentManager.pass("Correct price is displayed: " + extras.getPriceSoundsystem().getText());
		
		Assert.assertEquals(extras.getWintertires().isSelected(), true, "Checkbox is not selected: ");
		ExtentManager.pass("Checkbox is selected: " + extras.getWintertiresLabel().getText());
		Assert.assertEquals(extras.getPriceWinterTires().getText().trim(), expectedWintertiresPrice, "Not the expected price: ");
		ExtentManager.pass("Correct price is displayed: " + extras.getPriceWinterTires().getText());
		ExtentManager.pass(
				"Selected all possible extras via the checkboxes: Autopilot Don'tCare, Floor mats, Navigation System, Sound System OverDrive and Winter tires");
		extras.getColorNavBtn().click();

		// TODO Check if discount is granted.
		// TODO Proceed to write assertions.
		ColorPage color = new ColorPage();
		wait1.until(ExpectedConditions.textToBePresentInElement(color.getPriceColor(), "0,00 €"));
//		color.getLightblue().click();
		js.executeScript("arguments[0].click()", color.getLightblue());
		ExtentManager.pass("Selected color light blue.");
		color.getEffectSelect().click();
		color.getPearlEffect().click();
		ExtentManager.pass("Selected varnish effect Pearl Effect.");
		color.getSummaryNavBtn().click();

		SummaryPage summary = new SummaryPage();
		wait1.until(ExpectedConditions.textToBePresentInElement(summary.getTotalAmount(), "39.345,59 €"));
		summary.getConfigname().clear();
		summary.getConfigname().sendKeys("MyFirstCar");
		wait1.until(ExpectedConditions.visibilityOf(summary.getImageOfCar()));
		summary.getSaveBtn().click();
		ExtentManager.pass("Saved car configuration with name MyFirstCar.");

		// Konfiguration wieder löschen.
		summary.getListNavBtn().click();
		wait1.until(ExpectedConditions.elementToBeClickable(dreamcar.getNewCarBtn()));
		List<WebElement> cars = dreamcar.getsavedCars();
		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i).getText().equals("MyFirstCar")) {
				// delete WebElement mit id=button_delete_i
				dreamcar.deleteMyfirstcar(i).click();

			}
		}
	}

	public String getTestCaseID() {
		return TestCaseID;
	}
}
