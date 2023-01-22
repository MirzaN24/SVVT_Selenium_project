package svvt_project.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class Test_6 {
	private static WebDriver webDriver;
	private static String baseUrl;
	JavascriptExecutor js = (JavascriptExecutor) webDriver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chromedriver", "C:\\\\Users\\\\38761\\\\Desktop\\\\FAX\\\\SVVT\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver();
		baseUrl = "https://www.asos.com/women/";
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
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[2]/div[1]/nav/div/div/button[11]")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[2]/div[1]/nav/div/div/div[11]/div/div[2]/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
		webDriver.navigate().back();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[2]/div[1]/nav/div/div/button[11]")).click();
		Thread.sleep(1500);
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[2]/div[1]/nav/div/div/div[11]/div/div[2]/div/div[1]/ul/li[3]/a")).click();
		Thread.sleep(1500);
		
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[2]/div/div[1]/section/article[1]/a")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(2000);
		
		String price = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[5]/section/div/div[2]/div[1]/div[1]/span[2]")).getText();
		assertEquals("£32.00", price);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[5]/section/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/button")).click();
		Thread.sleep(4000);
		
		//problem with adding to the bag
		
	}

}
