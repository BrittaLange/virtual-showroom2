package de.blange;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;
import pageObjects.DreamcarListPage;
import pageObjects.LoginPage;

@Listeners(resources.Listeners.class)
/**
 * Test refers to requirement TB4-T1
 *
 * @author Britta
 *
 */
public class LoginAsCustomerViaBtnTest extends Hooks {

	public LoginAsCustomerViaBtnTest() throws IOException {
		super();
	}

	@Test
	public void loginAsCustomerViaBtn() throws IOException {
		ExtentManager.log("Starting LoginAsCustomerViaBtnTest ...");
		LoginPage loginPage = new LoginPage();
		loginPage.getAsCustomerBtn().click();
		
		DreamcarListPage dreamcar = new DreamcarListPage();
		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(dreamcar.getNewCarBtn()));

		String expectedUrl = "https://vsr.testbench.com/dreamcar/list";
		Assert.assertEquals(dreamcar.getCurrentUrl(), expectedUrl, "Not the expected URL.");
		ExtentManager.pass("The expected start page of the subsystem DreamCar is displayed (Tabcard List)");
	}
}
