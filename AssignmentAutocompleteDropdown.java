package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

public class AssignmentAutocompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		//navigate to url
		System.setProperty("webdriver.chrome.driver", "/Users/camil/OneDrive/Documents/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//select any country with any letters
		String country = "unit";
		String countryExpected = "United States (USA)";
		driver.findElement(By.id("autocomplete")).sendKeys(country);
		Thread.sleep(3000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		
		//move mouse to desired country
		List<WebElement> countries = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li div"));
		int i=0;
		while(!countries.get(i).getText().equals(countryExpected)) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			i++;
		}
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"), countryExpected);
		

	}

}
