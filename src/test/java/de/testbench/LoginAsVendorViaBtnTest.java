package de.testbench;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;
import pageObjects.LoginPage;
import pageObjects.factbook.CustomerListPage;

@Listeners(resources.Listeners.class)
/**
 * TestCaseID cloud01-eu.testbench.com/TB4-T2
 *
 * @author Britta
 *
 */
public class LoginAsVendorViaBtnTest extends Hooks {

	public LoginAsVendorViaBtnTest() throws IOException {
		super();
	}

	@Test
	public void loginAsVendorViaBtn() throws IOException {
		ExtentManager.log("Starting " + this.getClass().getName());
		LoginPage loginPage = new LoginPage();
		loginPage.getAsVendorBtn().click();
		
		CustomerListPage factbook = new CustomerListPage();
		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(factbook.getAddCustomerBtn()));

		String expectedUrl = "https://vsr.testbench.com/factbook/list";
		Assert.assertEquals(factbook.getCurrentUrl(), expectedUrl, "Not the expected URL.");
		ExtentManager.pass("The start page of the subsystem FactBook is displayed (Tabcard Customer List)");
	}
}
