package svvt_project.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

class Test_5 {
	private static WebDriver webDriver;
	private static String baseUrl;
	

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
		
		WebElement search = webDriver.findElement(By.name("q"));
		search.sendKeys("Nike Air Max 90");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[1]/div/div/div/form/div/button[2]")).click();
		Thread.sleep(2000);
		
		String currentUrl = webDriver.getCurrentUrl();
		assertEquals("https://www.asos.com/search/?q=nike+air+max+90", currentUrl);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[3]/div/div[1]/section/article[1]/button")).click();
		Thread.sleep(500);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[3]/div/div[1]/section/article[3]/button")).click();
		Thread.sleep(500);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[3]/div/div[1]/section/article[30]/button")).click();
		Thread.sleep(500);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div[3]/div/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/main/div/div/section/ol/li[2]/div/div/div/button[2]")).click();
		Thread.sleep(1000);
		
		Select size1 = new Select(webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/main/div/div/section/ol/li[1]/div/div/div/div[3]/select")));
		size1.selectByValue("202888776");
		Thread.sleep(1000);
		
		Select size2 = new Select(webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/main/div/div/section/ol/li[2]/div/div/div/div[3]/select")));
		size2.selectByValue("203627433");
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/main/div/div/section/ol/li[1]/div/div/div/button[1]")).click();
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/main/div/div/section/ol/li/div/div/div/button[1]")).click();
		Thread.sleep(1000);
		
		
	}

}
