package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTables {

	public static void main(String[] args) {


		//go to https://rahulshettyacademy.com/AutomationPractice/
		System.setProperty("webdriver.chrome.driver", "/Users/camil/OneDrive/Documents/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		//print number of rows
		List<WebElement> tableRows = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		System.out.println("Number of rows: " + tableRows.size());
		
		//print number of columns
		List<WebElement> tableColumns = driver.findElements(By.cssSelector(".table-display th"));
		System.out.println("Number of columns: " + tableColumns.size());
		
		//print second row
		System.out.println("Second row: "+ driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		

	}

}
