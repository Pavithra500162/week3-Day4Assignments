package week3.day4;			
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mongodb.annotations.ThreadSafe;
			
			public class SneapDeal {
			
				public static void main(String[] args) throws InterruptedException, IOException {
					ChromeDriver driver=new ChromeDriver();
					driver.get("https://www.snapdeal.com/");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.findElement(By.xpath("//button[@id='pushDenied']")).click();
					WebElement men = driver.findElement(By.xpath("//span[@class='catText']"));
					Actions a=new Actions(driver);
					a.moveToElement(men).perform();
					driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
					String sportsshoe=driver.findElement(By.xpath("//div[@class='child-cat-count ']")).getText();
					System.out.println("Sports Shoe Count: "+sportsshoe);
					driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
					driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
					Thread.sleep(5000);
					List<WebElement> price=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
					List<String> sortprice=new ArrayList<String>();
					for(int i=0;i<price.size();i++)
					{
							String strprice = price.get(i).getText();
							sortprice.add(strprice);
					}
					System.out.println(sortprice);	
					List<String> checksortPrice=new ArrayList<String>(sortprice);
					Collections.sort(checksortPrice);
					System.out.println(checksortPrice);
					if(sortprice.equals(checksortPrice))
					{
						System.out.println("Sorted price from low to high");	
					}
					else
					{
						System.out.println("Price not sorted");
					}
					WebElement amtfilter = driver.findElement(By.xpath("(//div[@class='filter-type-name lfloat'])[1]"));		
					Actions act =new Actions(driver);
					act.moveToElement(amtfilter).perform();
					driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
					driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
					driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//a[text()=' White & Blue']/parent::label")).click();
					String fromamt=driver.findElement(By.xpath("//span[@class='from-price-text']")).getText();
					String toamt=driver.findElement(By.xpath("//span[@class='to-price-text']")).getText();
					String colour=driver.findElement(By.xpath("//a[text()=' White & Blue']")).getText();
					System.out.println("From Amount: "+fromamt+"\tTo Amount: "+toamt+"\tShoe Colour: "+colour);
					Thread.sleep(3000);
					WebElement mo=driver.findElement(By.xpath("//div[@class='clearfix row-disc']"));
					a.moveToElement(mo).perform();
					driver.findElement(By.xpath("//div[@class='clearfix row-disc']//div[@supc='SDL743288175']")).click();
					String bsprice=driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
					System.out.println("Shoe Price: "+bsprice);
					String bsdiscount=driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
					System.out.println("Shoe Discount: "+bsdiscount);
					File source = driver.getScreenshotAs(OutputType.FILE);
					File des = new File("./snap/pic1.png");
					FileUtils.copyFile(source,des);
					driver.quit();
	}

}
