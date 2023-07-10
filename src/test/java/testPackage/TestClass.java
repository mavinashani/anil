package testPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Setup - if the browser version changes, it will download correct version of webdriver.
	//	TestSelectFacebook();
	  TestRegisterUser();
	  //Identify login,for selenium it's a web element
	  //driver.findElement(By.xpath("/html/body/header/div/nav/a[6]")).click();
	 // driver.findElement(By.xpath("//a[@href='https://phptravels.org/']")).click();
	  //driver.findElement(By.xpath("/html/body/header/div/nav/a[6]")).
	  //WebElement loginbutton = driver.findElement(By.xpath("/html/body/header/div/nav/a[6]"));
	  //loginbutton.click();
	  //Identify elelemntby ID
	  //driver.findElement(By.id("PageContainer"));
	  
	}
	
	public static WebDriver TestDriverSetup(String browserName) {
		  WebDriver driver = null;
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			  //WebDriverManager.edgedriver().setup();
			   driver = new ChromeDriver();
		
		}
		if(browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			  //WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		}
		
			  //Mamxise the browser window.
		  driver.manage().window().maximize();
		  return driver;
	
	}
	
	
	//Approach duplicates for different sets of data,e.g:send keys.
	//another tc manadatory vs non mandatory fields.
	//Take Amazon for instance - flow remains same, except for validations.e.g: inventory check.TC subset
	//Code redundancy
	//break into smaller methods , eg: driver init,login. and call weherrever reqd. passing in params.
	//Reusaability
	//Phone number - send keys, clumsy code. xpath may change and send keys may change.
	public static void TestRegisterUser() {
		
		WebDriverManager.chromedriver().setup();
		  //WebDriverManager.edgedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  //Mamxise the browser window.
		  driver.manage().window().maximize();
		  driver.get("https://phptravels.org/register.php");
		  driver.findElement(By.id("inputFirstName")).sendKeys("TestFirstName");
		  driver.findElement(By.name("lastname")).sendKeys("TestLastName");
		  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("TestEmail@example.com");
		  //Drop down,ideally should be a select tag.
		  // in this case, it's a div.
		  //Select countryselect = new Select(driver.findElement(By.className("flag-container")));
		  //countryselect.selectByIndex(10);
		  //Human way of doing it, selenium can do better with select,See test facebook method
		  WebElement dropdowndiv= driver.findElement(By.className("iti-arrow"));
		  dropdowndiv.click();
		  WebElement countrycodeselect = driver.findElement(By.xpath("//li[@data-dial-code=\"1\"]"));
		  countrycodeselect.click();
		  driver.findElement(By.xpath("//input[@placeholder=\"Phone Number\"]")).sendKeys("1234567890");
		  
		  //Select-How did you find
		  Select howdidyoufind = new Select(driver.findElement(By.id("customfield1")));
		  //howdidyoufind.selectByIndex(2);
		  howdidyoufind.selectByValue("Bing");
		 // howdidyoufind.selectByVisibleText("Google");
		  
		  driver.findElement(By.xpath("//span[@class=\"bootstrap-switch-handle-off bootstrap-switch-default\"]")).click();
		  //Switch to iframe. - name/,to identify checkbox in the next line
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title=\"reCAPTCHA\"]")));
		  //Selenium is not able to click "Robot" switching to Javascript
		  //driver.findElement(By.id("recaptcha-anchor")).click();
		//Creating the JavascriptExecutor interface object by Type casting
		  //Converting driver to javascript executor to interact with the element,
	        JavascriptExecutor js = (JavascriptExecutor)driver;	
		    js.executeScript("arguments[0].click();", driver.findElement(By.id("recaptcha-anchor")));
		  
		  
	}
	
	
public static void TestSelectFacebook() {
		
		WebDriverManager.chromedriver().setup();
		  //WebDriverManager.edgedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  //Mamxise the browser window.
		  driver.manage().window().maximize();
		  driver.get("https://www.facebook.com/r.php");
		  //Drop down,ideally should be a select tag.
		  // in this case, it's a div.
		  Select select = new Select(driver.findElement(By.id("day")));
		  //Position of the element
		  select.selectByIndex(2);
		   select = new Select(driver.findElement(By.id("month")));
		   //Atribute value
		   select.selectByValue("10");
		   select = new Select(driver.findElement(By.id("year")));
		   //Actual text value.
		   select.selectByVisibleText("1947");
		   
		  
		  
	}
	
}
