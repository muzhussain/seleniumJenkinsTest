package pageclasses;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement element = null;
	public static WebElement suggestBox = null;
	static Logger log = LogManager.getLogger(SearchPage.class);
//	public static String element

	/**
	 * Clear all the fields on the Search page
	 * 
	 * @param driver
	 */
	public static void clearAllFields(WebDriver driver) {
		driver.findElement(By.cssSelector("[data-stid='location-field-leg1-origin'] .uitk-faux-input")).clear();
		driver.findElement(By.cssSelector("[data-stid='location-field-leg1-destination'] .uitk-faux-input")).clear();
		driver.findElement(By.cssSelector("#d1-btn")).clear();
		driver.findElement(By.cssSelector("#d2-btn")).clear();
	}

	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[data-stid='location-field-leg1-origin'] .uitk-faux-input"));
		log.info("Origin text box element found");
		return element;
	}

	/**
	 * Fill origin city in origin text box
	 * 
	 * @param driver
	 * @param origin
	 */
	public static void fillOriginTextBox(WebDriver driver, String origin) throws InterruptedException {
		element = originTextBox(driver);
//		element.click();
//		Thread.sleep(2000);
		element.sendKeys(origin);
//		Thread.sleep(2000);
//		element.sendKeys(Keys.TAB);
		log.info("Enter origin city as " + origin);
	}

	/**
	 * finds the search flight origin suggestion box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement originSuggestBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[data-stid='location-field-leg1-origin-results']"));
		log.info("Origin search Suggestion box element found");
		return element;
	}

	/**
	 * Selects option from search flight origin suggestion box
	 * 
	 * @param driver
	 * @param origin
	 */
	public static void selectOptionOriginSuggestBox(WebDriver driver, String originTextToSelect)
			throws InterruptedException {

		element = originSuggestBox(driver);

		List<WebElement> liElements = element.findElements(By.tagName("li"));
//		Thread.sleep(3000);

		int size = liElements.size();

		System.out.println("The size of the list is: " + size);

		for (int i = 0; i < size; i++) {
			System.out.println(liElements.get(i).getText());
		}

		for (WebElement elementText : liElements) {
			System.out.println(element.getText());
			if (elementText.getText().contains(originTextToSelect)) {
				log.info("selected oring option from suggestion box: " + originTextToSelect);
				elementText.click();
				break;
			}
		}
	}

	/**
	 * Returns the flight destination text box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[data-stid='location-field-leg1-destination'] .uitk-faux-input"));
		log.info("Destination text box element found");
		return element;
	}

	/**
	 * Fill destination city in destination text box
	 * 
	 * @param driver
	 * @param origin
	 */
	public static void fillDestinationTextBox(WebDriver driver, String destination) throws InterruptedException {
		element = destinationTextBox(driver);
		element.sendKeys(destination);
		log.info("Enter destination city as " + destination);

	}

	/**
	 * finds the search flight destination suggestion box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement destinationSuggestBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[data-stid='location-field-leg1-destination-results']"));
		log.info("destination search Suggestion box element found");
		return element;
	}

	/**
	 * Selects option from search flight destination suggestion box
	 * 
	 * @param driver
	 * @param origin
	 */
	public static void selectOptionDestinationSuggestBox(WebDriver driver, String destinationTextToSelect)
			throws InterruptedException {

		element = destinationSuggestBox(driver);

		List<WebElement> liElements = element.findElements(By.tagName("li"));
//		Thread.sleep(3000);

		int size = liElements.size();

		System.out.println("The size of the list is: " + size);

		for (int i = 0; i < size; i++) {
			System.out.println(liElements.get(i).getText());
		}

		for (WebElement elementText : liElements) {
//			 System.out.println(element.getText());
			if (elementText.getText().contains(destinationTextToSelect)) {
				log.info("destiantion search Suggestion box element option selected: " + destinationTextToSelect);
				elementText.click();
				break;
			}
		}
	}

	/**
	 * Returns the departure date text box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='d1-btn']"));
		element.click();
		log.info("Found departure date field");
		return element;
	}

	/**
	 * Fill departure date in departure date text box
	 * 
	 * @param driver
	 * @param datePick
	 */
	public static void fillDepartureDateTextBox(WebDriver driver) throws InterruptedException {
		element = departureDateTextBox(driver);
		WebElement datePick = driver.findElement(By.cssSelector("[data-stid='date-picker-month']:nth-of-type(1) [data-day='28']"));
		datePick.click();
		Thread.sleep(2000);
		log.info("Entered departure date as " + datePick);
	}

	/**
	 * Returns the return date text box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#d2-btn"));
		element.click();
		log.info("Found return date field");
		return element;
	}

	/**
	 * Fill Return date in departure date text box
	 * 
	 * @param driver
	 * @param datePick
	 */
	public static void fillReturnDateTextBox(WebDriver driver) throws InterruptedException {
		element = returnDateTextBox(driver);
		WebElement datePick = driver
				.findElement(By.cssSelector("[data-stid='date-picker-month']:nth-of-type(1) [data-day='30']"));
		datePick.click();
		log.info("Entered return date as " + datePick);
	}

	/**
	 * Returns the Done button box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement doneButton(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".dialog-done.uitk-button.uitk-button-has-text.uitk-button-primary.uitk-button-small.uitk-flex-align-self-flex-end.uitk-flex-item.uitk-flex-shrink-0 > span"));
		return element;
	}

	
	/**
	 * Click on Done button
	 * 
	 * @param driver
	 */
	public static void clickDoneButton(WebDriver driver) {
		element = doneButton(driver);
		element.click();
	}
	
	/**
	 * Returns the search button box element
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
		return element;
	}
	
	/**
	 * Click on search button
	 * 
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
		log.info("Clicked on Search Button");
		
	}

	/**
	 * Navigate to flights tab
	 * 
	 * @param driver
	 */
	public static void navigateToFlightsTab(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[aria-controls='wizard-flight-pwa']"));
		element.click();
		log.info("Clicked on Flights Tab");

	}
}
