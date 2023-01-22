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

class Test_8 {
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
		Thread.sleep(2000);
		
		WebElement fb = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[4]/footer/div[1]/div[1]/ul[1]/li[1]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", fb);
		Thread.sleep(2000);
		
		String handle1 = webDriver.getWindowHandle(); 
		fb.click();
		Thread.sleep(3500);
		
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		String currentURL = webDriver.getCurrentUrl();
		assertEquals("https://www.facebook.com/ASOS/", currentURL);
		
		webDriver.close();
		webDriver.switchTo().window(handle1);
		
	}

}
