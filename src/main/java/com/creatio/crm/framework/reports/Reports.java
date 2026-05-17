package com.creatio.crm.framework.reports;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	// This class will contain all the common methods to generate the report by using TestNG and ExtentReports
	public static ExtentSparkReporter html;  //white paper
	public static ExtentReports extent;  //printer
	public static ExtentTest logger; //ink
	
	// Method to setup the report
	@BeforeSuite(alwaysRun = true)
	public static void setupReport() {
		html = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\AutomationTestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	@BeforeMethod(alwaysRun = true)
	public void startTest(Method method) {
		Reports.startReporting(method.getName());
	}
	
	// Method to start the printing process.

	public static void startReporting(String testName) {
		logger = extent.createTest(testName);
	}
	
	// Method to end the printing process

	@AfterMethod(alwaysRun = true)
	public void finishTest() {
		Reports.endReport();
	}

	public static void endReport() {
		extent.flush();
	}	
	
	// Method to Attach screenshot within the report.
	public static void attachScreenshot(String screenshotPath) {
		try {
			logger.addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			System.out.println("Failed to attach screenshot: " + e.getMessage());
		}
	}


}
