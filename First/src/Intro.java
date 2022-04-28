import java.awt.Container;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Intro {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsaiakhil\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String userName = "rahul";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
//		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getPageSource());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("akhil");
		driver.findElement(By.name("inputPassword")).sendKeys("preethi123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		// Forgot Password screen
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("akhil");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("akhil143@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("preethi@gmail.com");
		driver.findElement(By.xpath("//div/form/input[3]")).sendKeys("8464060405");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector(".sign-up-container .infoMsg")).getText());
		//System.out.println(driver.findElements(By.xpath("//div/form/input")));
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		
		// Back to Login screen
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(userName);
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();
		String loginSuccessfulCheck = driver.findElement(By.xpath("//div[@class='login-container']/p[1]")).getText();
//		if(loginSuccessfulCheck == "You are successfully logged in.") {
//			driver.findElement(By.xpath("//div[@class='login-container']/button[1]")).click();
//		} else {
//			System.out.println("Not logged in");
//		}
		Assert.assertEquals(loginSuccessfulCheck, "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2[1]")).getText(), "Hello "+userName+",") ;
		
		driver.findElement(By.xpath("//div[@class='login-container']/button[1]")).click();
		
		
		
	}

}
