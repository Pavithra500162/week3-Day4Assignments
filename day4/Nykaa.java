package week3.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement brands=driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		Actions a=new Actions(driver);
		a.moveToElement(brands).perform();
		driver.findElement(By.xpath("(//img[@alt='banner'])[5]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String Filter=driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		System.out.println("Filter Appliter for Shampoo: "+Filter);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winhan = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winhan.get(1));
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'MRP')]/following-sibling::span")).click();
		driver.findElement(By.xpath("//span[@class='btn-text']/parent::button")).click();
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		Thread.sleep(3000);
		String price=driver.findElement(By.xpath("//div[@data-test-id='footer']//span")).getText();
		price=price.replaceAll("[^0-9]", "");
		System.out.println(price);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		String checkPrice=driver.findElement(By.xpath("//p[text()='Price Details']/following::p")).getText();
		checkPrice=checkPrice.replaceAll("[^0-9]", "");
		if(price.equals(checkPrice))
		{
			System.out.println("Same price");
		}
		else
		{
			System.out.println("Different Price");
		}
		driver.quit();
		}

}
