package svvt_project.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class Test_4 {
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
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[2]/div[2]/nav/div/div/button[5]/span/span")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[2]/div[2]/nav/div/div/div[5]/div/div[2]/div/div[1]/ul/li[9]/a")).click();
		Thread.sleep(2500);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[1]/div/div/div[1]/ul/li[4]/div/button/div")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[1]/div/div/div[1]/ul/li[4]/div/div/div/ul/li[1]/div/label/div/span")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/div[2]/div/div[1]/section[1]/article[6]/a/div[1]/img")).click();
		Thread.sleep(1500);
		
		String delivery = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[5]/section/div/div[2]/div[2]/div[2]/div[3]/div/div[1]")).getText();
		assertEquals("Free Delivery.", delivery);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[5]/section/div/div[2]/div[3]/div/ul/li[1]/div/h2/button")).click();
		Thread.sleep(1000);
		
		String code = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div[5]/section/div/div[2]/div[3]/div/ul/li[1]/div/div/div/div/p")).getText();
		assertEquals("Product Code: 118690789", code);
		
		
	}

}
