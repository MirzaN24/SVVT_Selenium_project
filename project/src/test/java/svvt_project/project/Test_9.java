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

class Test_9 {
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
		
		WebElement help = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[4]/footer/div[1]/div[3]/div/section[1]/ul/li[1]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", help);
		Thread.sleep(2000);
		help.click();
		Thread.sleep(2000);
		
		WebElement search = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/div[1]/div/div/form/input"));
		search.sendKeys("payment");
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/div[1]/div/div/form/button")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/div/ul/li[1]/a/div[2]")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(1000);
		
		WebElement authorisation = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/div[1]/div/p[3]"));
		assertEquals("If your card is not authorised, payment will not be taken and we'll email to let you know that your bank or card issuer wouldn't authorise the payment.", authorisation.getText());
	
		Thread.sleep(1000);
	}

}
