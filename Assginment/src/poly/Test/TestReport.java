package poly.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestReport {
	public String baseUrl = "http://localhost:8080/Assginment/";
	String driverPath = "E:\\fpoly\\KIEMTHUNANGCAO\\driver\\chromedriver.exe";
	public WebDriver driver;

	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;

	// khai báo excel
	HSSFWorkbook workbook;
	// khai báo 1 bảng excel
	HSSFSheet sheet;
	// Khai báo một đối tượng Map để giữ kết quả TestNG
	Map<String, Object[]> TestNGResults;
	@BeforeTest
	public void launchBrowser() throws Exception {
		workbook = new HSSFWorkbook();

		sheet = workbook.createSheet("TestNg Result Summary");
		TestNGResults = new LinkedHashMap<String, Object[]>();

		TestNGResults.put("1", new Object[] { "Test No", "Action", "Expected Output", "Actual Output " });
		try {
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.get(baseUrl);
			driver.manage().window().maximize();
			Thread.sleep(200);
			TestNGResults.put("2", new Object[] { 1d, "Natigate", "Open Web", " Pass" });
		} catch (Exception e) {
			TestNGResults.put("2", new Object[] { 1d, "Natigate", "Open Web", " Fail" });
			Assert.assertTrue(false);
		}
	}

	@Test
	public void veryfyHomePageTitle() {
		try {
			String expectedTitle = "Assigment - Java5";
			String actualtitle = driver.getTitle();
			Assert.assertEquals(actualtitle, expectedTitle);
			Thread.sleep(200);
			TestNGResults.put("3", new Object[] { 2d, "Test Title", "Open Web", " Pass" });
		} catch (Exception e) {
			TestNGResults.put("3", new Object[] { 2d, "Test Title", "Open Web", " Fail" });
			Assert.assertTrue(false);
		}
	}

	// test login
	@Test(priority = 1)
	public void LoginTest() throws Exception {
		try {
			Thread.sleep(1000);
			// Step3
			driver.findElement(By.cssSelector("#user_login")).sendKeys("anh");
			driver.findElement(By.cssSelector("#user_pass")).sendKeys("123");
			// Step4
			driver.findElement(By.cssSelector("#submitBtn")).click();
			Thread.sleep(1000);
			// Step 5
			String expectedTitle = "Assigment - Java5";
			String actualtitle = driver.getTitle();

			if (expectedTitle.equals(actualtitle)) {
				System.out.println("test pass");
			} else {
				System.out.println("test failse");
			}
			Thread.sleep(500);
			TestNGResults.put("4", new Object[] { 3d, "Fill login form data", "User ok: Pass ok", " Pass" });
		} catch (Exception e) {
			TestNGResults.put("4", new Object[] { 3d, "Fill login form data", "User null: Pass ok", " Fail" });
			Assert.assertTrue(false);
		}
	}
	 int expMonth;
	 int expYear;
	 String expDate = null;
	 boolean dateNotFound;
	// test add record
		@Test(priority = 2)
		public void TestAdddepart1() throws Exception {
			try {
				Thread.sleep(500);
				driver.findElement(By.linkText("Thành tích và kỷ luật")).click();
				Thread.sleep(500);
				driver.findElement(By.linkText("Thêm mới đánh giá")).click();
				Thread.sleep(500);
				
				driver.findElement(By.cssSelector("#Staff.Name")).click();
				Thread.sleep(100);
				driver.findElement(By.cssSelector("#Staff.Name")).sendKeys("Tuan");
				driver.findElement(By.cssSelector("#customRadio1")).click();
				driver.findElement(By.cssSelector("#Reason"));
				WebElement fromDateBox= driver.findElement(By.cssSelector("#birthday"));
//				fromDateBox.clear();
//				fromDateBox.sendKeys("12-20-2000");
				// click
				driver.findElement(By.name("_type")).click();
				
				String ex = driver.findElement(By.linkText("TThêm thất bại")).getText();
				String ac = "Thêm thất bại";
				Assert.assertEquals(ac, ex);
//					if (expectedTitle.equals(actualtitle)) {
//						System.out.println("test pass");
//					} else {
//						System.out.println("test failse");
//					}
				Thread.sleep(500);
				TestNGResults.put("5", new Object[] { 4d, "Fill form data", "empty  data", " Pass" });
			} catch (Exception e) {
				TestNGResults.put("5", new Object[] { 4d, "Fill form data", "empty  data", " Fail" });
				Assert.assertTrue(false);
			}
		}
		// test add record
				@Test(priority = 3)
				public void TestAdddepart2() throws Exception {
					try {
						Thread.sleep(500);
						driver.findElement(By.linkText("Thành tích và kỷ luật")).click();
						Thread.sleep(500);
						driver.findElement(By.linkText("Thêm mới đánh giá")).click();
						Thread.sleep(500);
						
						driver.findElement(By.cssSelector("#Staff.Name")).click();
						Thread.sleep(100);
						driver.findElement(By.cssSelector("#Staff.Name")).sendKeys("Tuan");
						driver.findElement(By.cssSelector("#customRadio1")).click();
						driver.findElement(By.cssSelector("#Reason")).sendKeys("okkk");;
						WebElement fromDateBox= driver.findElement(By.cssSelector("#Date"));
						fromDateBox.clear();
						fromDateBox.sendKeys("12-20-2020");
						// click
						driver.findElement(By.name("_type")).click();
						
						String ex = driver.findElement(By.linkText("TThêm thất bại")).getText();
						String ac = "Thêm thất bại";
						Assert.assertEquals(ac, ex);
//							if (expectedTitle.equals(actualtitle)) {
//								System.out.println("test pass");
//							} else {
//								System.out.println("test failse");
//							}
						Thread.sleep(500);
						TestNGResults.put("6", new Object[] { 5d, "Fill form data", "enough  data", " Pass" });
					} catch (Exception e) {
						TestNGResults.put("6", new Object[] { 5d, "Fill form data", "enough  data", " Fail" });
						Assert.assertTrue(false);
					}
				}
				
				// test update record
				@Test(priority = 3)
				public void Testupdatedepart1() throws Exception {
					try {
						Thread.sleep(500);
						driver.findElement(By.linkText("Thành tích và kỷ luật")).click();
						Thread.sleep(500);
						driver.findElement(By.linkText("Quản Lý Đánh Giá")).click();
						Thread.sleep(500);
						driver.findElement(By.linkText("Update")).click();
						Thread.sleep(500);
						
						driver.findElement(By.cssSelector("#Staff.Name")).click();
						Thread.sleep(100);
						driver.findElement(By.cssSelector("#Staff.Name")).sendKeys("Tuan");
						driver.findElement(By.cssSelector("#customRadio1")).click();
						driver.findElement(By.cssSelector("#Reason")).sendKeys("okkk");;
						WebElement fromDateBox= driver.findElement(By.cssSelector("#Date"));
						fromDateBox.clear();
						fromDateBox.sendKeys("12-20-2020");
						// click
						driver.findElement(By.name("_type")).click();
						
						String ex = driver.findElement(By.linkText("TThêm thất bại")).getText();
						String ac = "Thêm thất bại";
						Assert.assertEquals(ac, ex);
//							if (expectedTitle.equals(actualtitle)) {
//								System.out.println("test pass");
//							} else {
//								System.out.println("test failse");
//							}
						Thread.sleep(500);
						TestNGResults.put("6", new Object[] { 5d, "Fill form data", "enough  data", " Pass" });
					} catch (Exception e) {
						TestNGResults.put("6", new Object[] { 5d, "Fill form data", "enough  data", " Fail" });
						Assert.assertTrue(false);
					}
				}
}
