package variousConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class learnTestNG {
	WebDriver driver;
	
	//Storing WebElement using By Class
			By addEntry = By.xpath("/html/body/div[4]/input[1]");
			By addButton = By.xpath("/html/body/div[4]/input[2]");
			By addCategoryEntry = By.xpath("//*[@id=\"extra\"]/input[1]");
			By addCategoryButton = By.xpath("//*[@id=\"extra\"]/input[2]");
	
	//Test data
			  String firstCategory = "junit23";
		
	@BeforeMethod
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTest() throws InterruptedException
	{
		//Test 1: Validate a user is able to add a category 
		//and once the category is added it should display.
		driver.findElement(addEntry).sendKeys(firstCategory);
		Thread.sleep(2000);
		driver.findElement(addButton).click();
		
		
		//Test 2: Validate a user is not able to add a duplicated category. 
		//If it does then the following message will display:
		//"The category you want to add already exists: <duplicated category name>."
		driver.findElement(addCategoryEntry).sendKeys(firstCategory);
		Thread.sleep(2000);
		driver.findElement(addCategoryButton).click();
		
		//Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
		WebElement monthDropdown=driver.findElement(By.name("due_month"));
		Select month_dd=new Select(monthDropdown);
		List<WebElement> month_list=month_dd.getOptions();
		for(WebElement ele:month_list)
		{
			String month_name=ele.getText();
			System.out.println("Months are ==="+month_name);
		}
	
		
}
}
