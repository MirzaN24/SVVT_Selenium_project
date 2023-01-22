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
import org.openqa.selenium.support.ui.Select;

class Test_7 {
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
		
		WebElement tnf = webDriver.findElement(By.xpath("/html/body/div[2]/div/main/section[6]/article/div[3]/ul/li[2]/a/img"));
		js.executeScript("arguments[0].scrollIntoView(true);", tnf);
		Thread.sleep(1000);
		tnf.click();
		Thread.sleep(3000);
		
		WebElement loadMore = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[2]/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);", loadMore);
		Thread.sleep(1000);
		loadMore.click();
		Thread.sleep(2500);
		
		WebElement tshirt = webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[2]/div/div[1]/section[2]/article[20]/a/div[1]/img"));
		js.executeScript("arguments[0].scrollIntoView(true);", tshirt);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[1]/div[2]/div/div[1]/section[2]/article[20]/a/div[2]/div/div/h2")).click();
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);
		
		webDriver.findElement(By.id("fit-upper")).click();
		Thread.sleep(2000);
		
		WebElement height = webDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div/div/div[1]/div/div[1]/div/div[1]/input"));
		height.sendKeys("190");
		WebElement wheight = webDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[1]/div/div[2]/div/div[3]/div/div[2]/div/div/div[1]/div/div[1]/div[1]/input"));
		wheight.sendKeys("90");
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[1]/div/div[2]/div/div[4]/button")).click();
		Thread.sleep(2000); 
		webDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(1500); 
		webDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(1500); 
		WebElement age = webDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/input"));
		age.sendKeys("21");
		webDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/div/button")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/div[1]/div[3]/div/div[2]/button")).click();
		Thread.sleep(1500); 
		//for some reason can not assert that the size is false and this feature does not work properly
	}

}
