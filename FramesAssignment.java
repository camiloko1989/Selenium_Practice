package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/camil/OneDrive/Documents/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		//find the link that takes to nested frames
		driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();

		//switch to top fram
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		
		//switch to midle frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		
		System.out.println(driver.findElement(By.id("content")).getText());
	}

}
