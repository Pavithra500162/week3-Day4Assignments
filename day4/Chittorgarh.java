package week3.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chittorgarh {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@id='splashBackURL']")).click();
		driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<WebElement> tableRow = driver.findElements(By.xpath("//td[@class='left-align']//a"));
		List<String> sname=new ArrayList<String>();
		System.out.println(tableRow.size());		
		for(int i=0;i<tableRow.size();i++)
		{
			sname.add(tableRow.get(i).getText());
		}
		System.out.println(sname.size());
		Set<String> sname1=new HashSet<String>(sname);
		if(sname.size()==sname1.size())
		{
			System.out.println("No duplicate found");
		}
		else
		{
			System.out.println(sname1.size());
		}
		driver.close();
	}

}
