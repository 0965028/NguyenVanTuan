package poly.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAP {
	public class TestStaff {
		public String baseUrl = "https://accounts.google.com/signin/oauth/identifier?client_id=578149744405-r79imovk788jhhn7j61tnnpr0c0lhu4c.apps.googleusercontent.com&redirect_uri=https%3A%2F%2Fap.poly.edu.vn%2Flogin%2Fgoogle%2Fcallback&scope=openid%20profile%20email&response_type=code&state=SXPAbiJRQUyhIyhBbbQX4FPg0VsXoQSoTYZnz49Q&hd=fpt.edu.vn&o2v=1&as=SUkkHiNys5MudNSzCsIhQw&flowName=GeneralOAuthFlow/";
		String driverPath = "E:\\fpoly\\KIEMTHUNANGCAO\\driver\\chromedriver.exe";
		public WebDriver driver;
		
		@BeforeTest
		public void launchBrowser() {
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.get(baseUrl);
		}
		// test title
		@Test
		public void veryfyHomePageTitle() {
			String expectedTitle = "Đăng nhập - Tài khoản Google";
			String actualtitle = driver.getTitle();
			Assert.assertEquals(actualtitle, expectedTitle);
		}
		@Test(priority = 1)
		public void LoginTest() throws Exception{
			Thread.sleep(100);
			//Step3
			driver.findElement(By.cssSelector("#identifierId")).sendKeys("tuannvps09393@fpt.edu.vn");
			driver.findElement(By.cssSelector("#identifierNext")).click();
			driver.findElement(By.cssSelector("#password")).sendKeys("0965028100@@");
			driver.findElement(By.cssSelector("#identifierNext")).click();
		}
}
}
