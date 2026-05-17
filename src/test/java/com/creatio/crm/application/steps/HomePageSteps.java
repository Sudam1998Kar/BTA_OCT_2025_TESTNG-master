package com.creatio.crm.application.steps;

import com.creatio.crm.framework.reports.Reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements {
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Method to verify whether the landing page is displayed successfully
	public void verifyApplicationLandingPageIsDisplayed(){
		waitForElement(applicationHubLink);
		Reports.startReporting("Verify Cookies popup displayed");
		log("info", "Application Landing Page is displayed successfully.");
		Reports.setupReport();
	}
	
	// Method to verify: User profile icon is getting displayed.
	public void verifyUserProfileIconIsDisplayed(){
		waitForElement(userProfileIcon);
		log("info", "User profile icon is displayed successfully.");
	}
	
	// Method to Click on the userProfileIcon.
	public void clickOnUserProfileIcon(){
		click(userProfileIcon);
		log("info", "Clicked on the user profile icon successfully.");
	}
	
	// Method to Click on the logout button.
	public void clickOnLogoutButton(){
		click(logoutButton);
		log("info", "Clicked on the logout button successfully.");
	}

}
