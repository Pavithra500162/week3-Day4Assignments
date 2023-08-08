package week3.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mynthra {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions opt=new ChromeOptions(); 
		opt.addArguments("--disable-notifications"); 
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement men=driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[@class='desktop-main']"));
		Actions a=new Actions(driver);
		a.moveToElement(men).perform();
		driver.findElement(By.xpath("(//ul[@class='desktop-navBlock']/li/a[text()='Jackets'])[1]")).click();
		String totitem=driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total no of Jackets "+totitem);
		List<WebElement> count=driver.findElements(By.xpath("//span[@class='categories-num']"));
		int cnt=0;
		for(int i=0;i<count.size();i++)
		{
			String text=count.get(i).getText();
			int totcount=Integer.parseInt(text.replaceAll("[^0-9]",""));
			cnt=cnt+totcount;
		}
		System.out.println("Sum: "+cnt);
		driver.findElement(By.xpath("//label[@class='common-customCheckbox vertical-filters-label']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']/div")).click();
		driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close')]")).click();
		List<WebElement>brand=driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3"));
		Set<String> coat=new LinkedHashSet<String>();
		Thread.sleep(3000);
		for(int i=1;i<brand.size();i++)
		{
			String text=driver.findElement(By.xpath("(//div[@class='product-productMetaInfo']/h3)["+i+"]")).getText();
			coat.add(text);
		}
		System.out.println(coat);
		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-list']/li[4]/label")).click();
		String pricefirst=driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("First listed coat: "+pricefirst);
		WebElement over=driver.findElement(By.xpath("//div[@class='product-productMetaInfo']"));
		a.moveToElement(over).click().perform();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winhan = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winhan.get(1));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/coat.png");
		FileUtils.copyFile(source,des);
		driver.quit();
	}
}
