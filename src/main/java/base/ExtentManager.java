package base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Hier wird ein ExtentReport für jeden einzelnen Thread erzeugt.
 * Es werden synchronisierte Methoden zum Anfügen von Log-Nachrichten 
 * und von Screenshots zur Nutzung in den Testklassen zur Verfügung gestellt.
 * In der Klasse Listener werden die Methoden zum Erzeugen des Reports und
 * der Tests und zum Anhängen von Screenshots verwendet. 
 * 
 * @author Britta
 *
 */
public class ExtentManager extends BasePage {

	private static ExtentReports extentReport;
	private static String extentReportPrefix;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public ExtentManager() throws IOException {
		super();
	}

	public synchronized static ExtentTest getTest() {
		return extentTest.get();
	}

	public synchronized static ExtentTest createTest(String name, String description) {
		ExtentTest test = extentReport.createTest(name, description);
		extentTest.set(test);
		return getTest();
	}

	/**
	 * Der Name des Extent Reports wird aus dem Namen des Projekts erzeugt.
	 * 
	 * @return gibt einen ExtentRport zurück, wenn noch keiner existiert.
	 */
	public static ExtentReports getReport() {
		if (extentReport == null) {
			StringBuffer projectName = new StringBuffer(System.getProperty("user.dir"));
			projectName.reverse();
			int indexOfSlash = projectName.indexOf("\\");
			String name = projectName.substring(0, indexOfSlash);
			name = new StringBuffer(name).reverse().toString();
			setupExtentReport(name);
		}
		return extentReport;
	}

	/**
	 * Hier werden Informationen zum Report wie der Reportname, der Titel der HTML-Seite und 
	 * der Name des Testers festgelegt. Es können noch weitere Informationen mit setSystemInfo()
	 * hinzugefügt werden.
	 * Außerdem wird hier das Theme des Reports gesetzt.
	 * 
	 * @param testName der Name des Testprojekts.
	 * @return gibt eine konfigurierte Instanz des ExtentReports zurück.
	 */
	private static ExtentReports setupExtentReport(String projectName) {
		extentReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/report/" + extentReportsPrefix_Name(projectName) + ".html");
		extentReport.attachReporter(spark);
		extentReport.setSystemInfo("Tester", "Tester Name");

		spark.config().setReportName("Regression");
		spark.config().setDocumentTitle("Test Results");
		spark.config().setTheme(Theme.STANDARD);

		return extentReport;
	}

	private static String extentReportsPrefix_Name(String projectName) {
		String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		extentReportPrefix = date + "_" + projectName;
		return extentReportPrefix;
	}

	public static void flushReport() {
		extentReport.flush();
	}

	// Logging Methoden.
	public synchronized static void log(String message) {
		getTest().info(message);
	}

	public synchronized static void pass(String message) {
		getTest().pass(message);
	}

	public synchronized static void fail(String message) {
		getTest().fail(message);
	}

	public synchronized static void attachImage() {
		getTest().addScreenCaptureFromPath(getScreenshotDestinationPath());
	}
}
