package Implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PageStepDefs {

	private String chromDriverPath = "/src/test/resources/com/test/driver/chromedriver";
	private String currentDirectory = System.getProperty("user.dir");
	Actions builder;

	public static WebDriver driver;

	public PageStepDefs() {
		System.setProperty("webdriver.chrome.driver", currentDirectory + chromDriverPath);
		System.out.println("Chrome Driver Location:- " + currentDirectory + chromDriverPath);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Given("^I open the url (.+)")
	public void openURL(String url) {
		System.out.println("URL:- "+url);
		driver.get(url);
	}
	
	@And("^click$")
	public void clickOnElements() throws InterruptedException {
        WebElement iframe = driver.findElement(By.id("fullframe"));
        driver.switchTo().frame(iframe);
		WebElement canvas = driver.findElement(By.id("canvas"));
		
		int getX = canvas.getLocation().getX();
		int getY = canvas.getLocation().getY();
		
		System.out.println("X coordinate: " +getX); 
		System.out.println("Y coordinate: " +getY); 
		new Actions(driver).moveByOffset(getX+239, getY+321).click().build().perform();
		System.out.println("X: "+getX+" Y: "+139);
		System.out.println("X: 239"+" Y: "+getY);
		
		//clicking on 3
		new Actions(driver).moveToElement(canvas, 716,321).click().build().perform();
		//clicking on the substract sign (-)
		//new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/5)*2,(255/6)*3).click().build().perform();
		//clicking on 2
		//new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*4,(255/6)*3).click().build().perform();
		//clicking on equals to sign (=)
		//new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/5)*4,(255/6)*4).click().build().perform();
		
	}
	
	
	
	

	@After
	public void quitBrowser() {
		//driver.quit();
	}
}
