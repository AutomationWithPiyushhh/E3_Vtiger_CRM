package advance_reports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Facebook {
	@Test
	public void adRep() {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\AdvanceReports\\rep2.html");

		spark.config().setDocumentTitle("FirstTimeRepGen");
		spark.config().setReportName("Beginning");
		spark.config().setTheme(Theme.STANDARD);

		ExtentReports report = new ExtentReports();

		report.attachReporter(spark);

		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("window", "11");
		report.setSystemInfo("IDE", "Eclipse");

		ExtentTest test = report.createTest("Method 1");
		test.log(Status.INFO, "This is information");
//		test.log(Status.SKIP, "This is skipping");
//		test.log(Status.WARNING, "This is warning");
		test.log(Status.PASS, "This is passing");
//		test.log(Status.FAIL, "This is failing");

		report.flush();

	}
}
