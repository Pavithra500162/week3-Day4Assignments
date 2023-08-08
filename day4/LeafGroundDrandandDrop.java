package week3.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class LeafGroundDrandandDrop {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement dragMeAround = driver.findElement(By.xpath("//span[text()='Drag me around']"));
		Actions ac=new Actions(driver);
		ac.dragAndDropBy(dragMeAround, 200, 0).perform();
		WebElement source = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement destn = driver.findElement(By.xpath("//p[text()='Drop here']"));
		ac.dragAndDrop(source, destn).perform();
		driver.close();
	}

}
