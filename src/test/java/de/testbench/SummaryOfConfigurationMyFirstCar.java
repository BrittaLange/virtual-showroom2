package de.testbench;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
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
 * TestCaseID cloud01-eu.testbench.com/TB4-T7
 *
 * @author Britta
 *
 */
public class SummaryOfConfigurationMyFirstCar extends Hooks {

	public SummaryOfConfigurationMyFirstCar() throws IOException {
		super();
	}
	
	@Test
	public void summarizeConfigurationOfMyFirstCar() throws IOException {
		ExtentManager.log("Starting " + this.getClass().getName());
		LoginPage loginPage = new LoginPage();
		loginPage.getUsername().sendKeys("WebTestBench_c01");
		loginPage.getPassword().sendKeys("password_c01");
		loginPage.getSubmitBtn().click();
		ExtentManager.pass("Logged in as customer.");
		
		ListPage dreamcar = new ListPage();
		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(dreamcar.getNewCarBtn()));
		dreamcar.getNewCarBtn().click();
		ExtentManager.pass("Selected new car.");
		
		BasemodelPage basemodel = new BasemodelPage();
		// TODO tbc
		
	
	}
}
