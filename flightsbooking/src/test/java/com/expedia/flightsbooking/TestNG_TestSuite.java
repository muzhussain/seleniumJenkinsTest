package com.expedia.flightsbooking;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageclasses.SearchPage;

public class TestNG_TestSuite {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = LogManager.getLogger(TestNG_TestSuite.class.getName());

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximise the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(baseUrl);
	}

	@Test
	public void fillBasicInfo() throws Exception {
		SearchPage.navigateToFlightsTab(driver);
		log.info("Clicked on Flights tab class (info) ");
		SearchPage.fillOriginTextBox(driver, "New York");
		SearchPage.selectOptionOriginSuggestBox(driver, "New York (LGA - LaGuardia)");
		SearchPage.fillDestinationTextBox(driver, "chicago");
		SearchPage.selectOptionDestinationSuggestBox(driver, "Kenosha (ENW - Kenosha Regional)");
//		SearchPage.fillDepartureDateTextBox(driver);
//		SearchPage.fillReturnDateTextBox(driver);
//		SearchPage.clickDoneButton(driver);
		SearchPage.clickOnSearchButton(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
