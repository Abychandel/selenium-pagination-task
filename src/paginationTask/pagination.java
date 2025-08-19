package paginationTask;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pagination {

	public static void main(String[] args)
	{
		//webdriver setup and open browser and navigate Flipkart
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			    WebDriver driver = new ChromeDriver();
			 	driver.manage().deleteAllCookies();
			 	driver.manage().window().maximize();
			 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 	driver.get("https://testautomationpractice.blogspot.com/");	
 
			 	List<WebElement> pages= driver.findElements(By.cssSelector("ul#pagination li a"));
			 	int page_count= pages.size();
			 	System.out.println(page_count);
	
	            for ( int a = 0; a < page_count; a++ )
	            {
	            pages= driver.findElements(By.cssSelector("ul#pagination li a"));
	            pages.get(a).click();
	            try {Thread.sleep(2000);
	            }
	            catch (InterruptedException e) 
	            {
				e.printStackTrace();
	            }
	            List<WebElement> all_checkbox = driver.findElements(By.cssSelector("#productTable tbody tr td input[type= 'checkbox']"));
	            for (WebElement el : all_checkbox)
	            {
	            	el.click();
	            }
	            try {
	            	Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            for (WebElement el : all_checkbox) {
	            	if (el.isSelected()) {
	            		el.click();
	            	}
	    
	            }
	            }
	            
	}
	

}
