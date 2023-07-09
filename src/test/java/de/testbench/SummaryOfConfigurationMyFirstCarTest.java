package de.testbench;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		ExtentManager.pass("Selected base model 10.");
		basemodel.getEngineNavBtn().click();

		EnginePage engine = new EnginePage();
		wait1.until(ExpectedConditions.visibilityOf(engine.getEngineItem()));
		engine.getEngineCombobox().click();
		engine.getOption4().click();
		ExtentManager.pass("Selected engine ECOtech with hybrid.");
		engine.getPackageNavBtn().click();

		PackagePage pack = new PackagePage();
		wait1.until(ExpectedConditions.textToBePresentInElement(pack.getPriceOfNone(), "0,00 €"));
		System.out.println(pack.getSportPackageRadioBtn().isDisplayed());
		js.executeScript("arguments[0].click()", pack.getSportPackageRadioBtn());
//		pack.getSportPackageRadioBtn().click();
		ExtentManager.pass("Selected Sport Package OutRun");
		pack.getExtrasNavBtn().click();

		ExtrasPage extras = new ExtrasPage();
		wait1.until(ExpectedConditions.textToBePresentInElement(extras.getPriceWinterTires(), "210,00 €"));
		js.executeScript("arguments[0].click()", extras.getAutopilot());
		js.executeScript("arguments[0].click()", extras.getFloormats());
		js.executeScript("arguments[0].click()", extras.getNavigationsystem());
		js.executeScript("arguments[0].click()", extras.getSoundsystem());
		js.executeScript("arguments[0].click()", extras.getWintertires());
		ExtentManager.pass(
				"Selected all possible extras via the checkboxes: Autopilot Don'tCare, Floor mats, Navigation System, Sound System OverDrive and Winter tires");
		extras.getColorNavBtn().click();

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
			System.out.println("Schleife");
			if (cars.get(i).getText().equals("MyFirstCar")) {
				System.out.println("Firstcar gefunden");
				// delete WebElement mit id=button_delete_i
				dreamcar.deleteMyfirstcar(i).click();

			}
		}
	}

	public String getTestCaseID() {
		return TestCaseID;
	}
}
