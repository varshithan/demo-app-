package demo.app.demo.app;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IndexTest {
	public WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/varshitha/Downloads/chromedriver");
		ChromeOptions o = new ChromeOptions();
		driver = new ChromeDriver(o);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void testTitle() {
		driver.get("http://localhost:9080/");
		assertEquals("Blogger", driver.getTitle());

	}

	@Test(priority = 2)
	public void createBlogger() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//input[@id='title']")).click();
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("hai");
		driver.findElement(By.xpath("//input[@id='author']")).click();
		driver.findElement(By.xpath("//input[@id='author']")).sendKeys("varshitha");
		driver.findElement(By.xpath("//input[@id='content']")).click();
		driver.findElement(By.xpath("//input[@id='content']")).sendKeys("Hello world");
		driver.findElement(By.xpath("//input[@id='save']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert().accept();

	}

	@Test(priority = 3)
	public void editBlogger() throws InterruptedException {
		driver.findElement(By.xpath("//tr[1]//td[5]//a[1]")).click();
		driver.findElement(By.xpath("//input[@id='title']")).clear();
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("New");
		driver.findElement(By.xpath("//input[@id='author']")).clear();
		driver.findElement(By.xpath("//input[@id='author']")).sendKeys("varshi");
		driver.findElement(By.xpath("//input[@id='content']")).clear();
		driver.findElement(By.xpath("//input[@id='content']")).sendKeys("Hello");
		driver.findElement(By.xpath("//input[@id='save']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert().accept();

	}

	@Test(priority = 4)
	public void deleteBlogger() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tr[9]//td[6]//a[1]")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert().accept();

	}
}
