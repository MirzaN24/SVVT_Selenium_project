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

class Test_3 {
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
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[2]/div[2]/nav/div/div/button[3]")).click();
		Thread.sleep(500);
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div[3]/div/div[2]/div[2]/nav/div/div/div[3]/div/div[2]/div/div[3]/ul/li[4]/a/div/div")).click();
		Thread.sleep(1000);
		String currentUrl = webDriver.getCurrentUrl();
		assertEquals("https://www.asos.com/gift-vouchers/", currentUrl);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/form/div[1]/div/fieldset/div/div[3]/label/div")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/form/div[2]/div/fieldset/div[1]/div[5]/label/div")).click();
		Thread.sleep(2000);
		
		WebElement to = webDriver.findElement(By.id("voucher-toName"));
		to.sendKeys("Jasmina");
		WebElement from = webDriver.findElement(By.id("voucher-fromName"));
		from.sendKeys("Mirza");
		Thread.sleep(1000);
		
		Select dropdown = new Select(webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/form/div[3]/div/div/fieldset[2]/div[2]/div/select")));
		dropdown.selectByValue("2023-01-26");
		Thread.sleep(1000);
		
		WebElement message = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/form/div[3]/div/div/fieldset[2]/div[3]/textarea"));
		message.sendKeys("Happy birthday, Jasmina! :)");
		Thread.sleep(2000);
	}

}
