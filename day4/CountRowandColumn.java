package week3.day4;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountRowandColumn {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*WebElement trow=driver.findElement(By.xpath("//table[@class='attributes-list']/tbody"));
		List<WebElement> row=trow.findElements(By.tagName("tr"));
		System.out.println("Count of table row: "+row.size());
		List<WebElement> col=driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr/th"));
		System.out.println("Count of table column: "+col.size());*/
		List<WebElement> lrow=driver.findElements(By.xpath("//div[@class='render']/table//tr"));
		System.out.println("Count of 2nd table row: "+lrow.size());
		List<WebElement> lcol=driver.findElements(By.xpath("//div[@class='render']/table/thead/tr/th"));
		System.out.println("Count of 2nd table column: "+lcol.size());	
		String str=driver.findElement(By.xpath("(//div[@class='render']/table/tbody/tr)[2]/td[1]")).getText();
		for (int i = 1; i <lrow.size()-1; i++) 
		{
			for (int j = 1; j < lcol.size(); j++) 
			{
				String equ=driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(str.equals(equ))
				{
					for(int k=1;k<lcol.size();k++) {
					String absrow=driver.findElement(By.xpath("(//div[@class='render']/table/tbody/tr)[2]/td["+k+"]")).getText();
					System.out.print(absrow);
				}
				}
			}
		}
		driver.close();
	}
}