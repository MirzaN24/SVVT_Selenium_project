package svvt_project.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class Test_10 {
	
	private static WebDriver webDriver;
	private static String baseUrl;
	JavascriptExecutor js = (JavascriptExecutor) webDriver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chromedriver", "C:\\\\Users\\\\38761\\\\Desktop\\\\FAX\\\\SVVT\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver();
		baseUrl = "https://www.asos.com/men/";
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
		
		WebElement fp = webDriver.findElement(By.xpath("/html/body/div[2]/div/main/section[3]/ul/li[4]/a/div[1]/div/img"));
		js.executeScript("arguments[0].scrollIntoView(true);", fp);
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div/main/section[3]/ul/li[4]/a/div[2]/div[1]")).click();
		Thread.sleep(2000);
		
		WebElement hat = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[2]/div/div[1]/section/article[20]/a/div[1]/img"));
		js.executeScript("arguments[0].scrollIntoView(true);", hat);
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[2]/div/div[1]/section/article[20]/a/div[2]/div")).click();
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[5]/section/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/button")).click();
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[5]/section/div/div[2]/div[3]/div/ul/li[2]/div/h2/button")).click();
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(3000);
	}

}
