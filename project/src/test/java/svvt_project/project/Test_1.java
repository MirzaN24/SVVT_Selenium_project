package svvt_project.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class Test_1 {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chromedriver", "C:\\\\Users\\\\38761\\\\Desktop\\\\FAX\\\\SVVT\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled"); //should work but it does not :(
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver();
		baseUrl = "https://www.asos.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[1]/div/ul/li[1]/div/div/div/button/span")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[1]/div/ul/li[1]/div/div/div/div/div/div/div/div[1]/div/span/a[1]")).click();
		Thread.sleep(1000);
		WebElement username = webDriver.findElement(By.name("Username"));
		username.sendKeys("m.novalic23@gmail.com");
		Thread.sleep(500);
		WebElement pass = webDriver.findElement(By.name("Password"));
		pass.sendKeys("mirza12345");
		Thread.sleep(500);
		webDriver.findElement(By.id("signin")).click();
		Thread.sleep(2000);
	}
}
