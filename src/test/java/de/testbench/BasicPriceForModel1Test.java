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
import pageObjects.dreamcar.BasemodelPage;
import pageObjects.dreamcar.InsurancePage;
import pageObjects.dreamcar.ListPage;
import pageObjects.dreamcar.SummaryPage;

@Listeners(resources.Listeners.class)
/**
 * TestCaseID cloud01-eu.testbench.com/TB4-T12
 *
 * @author Britta
 *
 */
public class BasicPriceForModel1Test extends Hooks {

	public BasicPriceForModel1Test() throws IOException {
		super();
	}

	@Test
	public void basicPriceForModel1() throws IOException {
		ExtentManager.log("Starting " + this.getClass().getName());
		LoginPage loginPage = new LoginPage();
		loginPage.getAsCustomerBtn().click();
		ExtentManager.pass("Logged in as customer.");
		
		ListPage dreamcar = new ListPage();
		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(dreamcar.getNewCarBtn()));
		dreamcar.getNewCarBtn().click();
		ExtentManager.pass("Selected new car.");
		
		BasemodelPage basemodel = new BasemodelPage();
		basemodel.getSummaryNavBtn().click();
		ExtentManager.pass("Navigated to summary tab.");
		
		SummaryPage summary = new SummaryPage();
		summary.getInsuranceBtn().click();
		ExtentManager.pass("Navigated to insurance page.");
		
		InsurancePage insurance = new InsurancePage();
		
		wait1.until(ExpectedConditions.textToBe(insurance.getBasePriceLabelSelector(), "1.200,00 €"));
		String expectedPrice = "1.200,00 €";
		Assert.assertEquals(insurance.getBasePriceLabel().getText(), expectedPrice, "Not the expected base price.");
		ExtentManager.pass("The Basic price of 1.200€ is displayed.");
	}
}
