package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment_Six {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/camil/OneDrive/Documents/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//select checkbox 3		
		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
		
		//get the text from the checkbox label
		String option = driver.findElement(By.xpath("//input[@id='checkBoxOption3']/parent::label")).getText().trim();
		
		
		WebElement drop = driver.findElement(By.id("dropdown-class-example"));
		Select dropdownSelect = new Select(drop);
		
		//select same option as checkbox
		dropdownSelect.selectByVisibleText(option);
		
		//Enter the label in the textbox
		driver.findElement(By.id("name")).sendKeys(option);
		
		//click Alert
		driver.findElement(By.id("alertbtn")).click();
		
		//check the name in the alert
		String alertText = driver.switchTo().alert().getText().split(" ")[1].split(",")[0];
		System.out.println(alertText);
		
		Assert.assertEquals(alertText, option);
	}

}
