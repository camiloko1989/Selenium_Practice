package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/camil/OneDrive/Documents/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/"); //get url
		
		driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("Camilo"); //send name
		driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys("camilo@gmail.com"); //send email
		driver.findElement(By.xpath("//div/input[@type='password']")).sendKeys("12345"); //send pass
		driver.findElement(By.id("exampleCheck1")).click(); //check the checkbox
		
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select genderDropdownSelect = new Select(dropdown);
		genderDropdownSelect.selectByIndex(0); //select first option
		
		driver.findElement(By.xpath("//input[@value='option1']")).click(); //select student radio button
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("02081989"); //send date
		driver.findElement(By.xpath("//input[@type='submit']")).click(); //click on submit
		
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText()); //capture the message		
		
	}

}

