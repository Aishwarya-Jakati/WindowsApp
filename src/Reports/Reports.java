package Reports;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	@Test
	public void loginTest() throws IOException {

		ExtentHtmlReporter r1 = new ExtentHtmlReporter("./Reports/ExtentReport.html");
		ExtentReports r2 = new ExtentReports();
		r2.attachReporter(r1);
		ExtentTest logger = r2.createTest("login test");
		logger.log(Status.INFO, "Login to amazon");
		logger.log(Status.PASS, "Title  verified");
		r2.flush();

		// Flush method will write the test in report- This is mandatory step

		// You can call createTest method multiple times depends on your requirement
		// In our case we are calling twice which will add 2 testcases in our report
		ExtentTest logger2 = r2.createTest("Logoff Test");

		logger2.log(Status.FAIL, "Title verified");

		logger2.fail("Failed because of some issues",
				MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());

		logger2.pass("Failed because of some issues",
				MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());

		// This will add another test in report
		r2.flush();

	}

}