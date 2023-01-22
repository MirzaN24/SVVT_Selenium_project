package svvt_project.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class Test_2 {
	private static WebDriver webDriver;
	private static String baseUrl;
	JavascriptExecutor js = (JavascriptExecutor) webDriver;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chromedriver", "C:\\\\Users\\\\38761\\\\Desktop\\\\FAX\\\\SVVT\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver();
		baseUrl = "https://www.asos.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		webDriver.findElement(By.id("men-floor")).click();
		Thread.sleep(1000);
		
		String currentUrl = webDriver.getCurrentUrl();
		assertEquals("https://www.asos.com/men/", currentUrl);
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div/main/section[1]/div/a/div/div[2]/div/h2")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/section/div/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0, 300)");
		Thread.sleep(2000);
		
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[1]/div/div/div[1]/ul/li[6]/div/button")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[1]/div/div/div[1]/ul/li[6]/div/div/div/ul/li[1]/div/label/div[2]")).click();
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[1]/div/div/div[1]/ul/li[6]/div/button")).click();
		Thread.sleep(1000); //close the dropdown so it can scroll
		
		js.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(2000);
		
		
		WebElement firstHoodie = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/div[2]/div/div[1]/section/article[1]/a/div[2]/div/div/h2"));
		
	//	js.executeScript("arguments[0].scrollIntoView(true);", firstHoodie); does not perform scroll to where it should
		
		assertEquals("Le Breve centre stitch crew neck sweatshirt in black", firstHoodie.getText());
		Thread.sleep(2000);
	}

}
