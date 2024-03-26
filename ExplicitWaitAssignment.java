package assignments;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAssignment {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/camil/OneDrive/Documents/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String username = "rahulshettyacademy";
		String pass = "learning";
		
		login(driver, wait, username, pass);
		
		//waint until url changes
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		
		//create a list of the items
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='card h-100']"));
		
		//add each item
		for (int i=0; i<items.size(); i++) {
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
		}
		
		//click on checkout
		driver.findElement(By.xpath("//li/a[@class='nav-link btn btn-primary']")).click();	
		

	}
	
	public static void login(WebDriver driver, WebDriverWait wait, String username, String pass) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pass);
		
		//select user radiobutton
		driver.findElement(By.xpath("//input[@value='user']")).click();
		
		//wait until the pop up appears
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("okayBtn")));
		
		//close the popup
		driver.findElement(By.id("okayBtn")).click();
		
		//select dropdown
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select userOption = new Select(dropdown);
		userOption.selectByIndex(2);
		
		//select agree checkbox
		driver.findElement(By.id("terms")).click();
		
		//click Sign In
		driver.findElement(By.id("signInBtn")).click();
	}

}
