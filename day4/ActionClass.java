package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement drag=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(drag);
		WebElement dragMeAround = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		Actions ac=new Actions(driver);
		ac.dragAndDropBy(dragMeAround,0,200).perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		driver.switchTo().frame(0);
		WebElement source=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement des=driver.findElement(By.xpath("//p[text()='Drop here']"));
		ac.dragAndDrop(source, des).perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Resizable']")).click();
		driver.switchTo().frame(0);
		WebElement resize=driver.findElement(By.xpath("(//div[contains(@class,'ui-resizable-handle')])[3]"));
		ac.dragAndDropBy(resize, 0, 300);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Selectable']")).click();
		driver.switchTo().frame(0);
		WebElement item1=driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item3=driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item5=driver.findElement(By.xpath("//li[text()='Item 5']"));
		ac.keyDown(Keys.CONTROL).click(item1).pause(2000).click(item3).pause(2000).click(item5).keyUp(Keys.CONTROL).perform();
		driver.close();
	}
}
