import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Intro2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsaiakhil\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String password = getPassword(driver);
		String userName = "akhil";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
//		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getPageSource());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p[1]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p[1]")).getText(), "You are successfully logged in.");
		driver.findElement(By.xpath("//div[@class='login-container']/button[1]")).click();
		
		
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"forgot-pwd-btn-conainer\"]/button[@class=\"reset-pwd-btn\"]")).click();
		String password = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String[] passwordarray = password.split("'");
		System.out.println(passwordarray[1]);
		
		return passwordarray[1];
			
				
		
	}

}
