package assignments;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAssigment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/camil/OneDrive/Documents/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		//find the link that takes to window
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		
		//find and click the link to open new window
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> iteratator = tabs.iterator();
		
		String parentId = iteratator.next();
		String childId = iteratator.next();
		
		//switch to new tab
		driver.switchTo().window(childId);
		
		//get the text and print it
		System.out.println(driver.findElement(By.cssSelector(".example>h3")).getText());
		
		//switch back to original tab
		driver.switchTo().window(parentId);
		
		//get the text and print it
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

	}

}
