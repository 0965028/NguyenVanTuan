package poly.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSendMail {
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
		
		// test mail emptydata
		@Test(priority = 2)
		public void Testmail1() throws Exception {
			try {
				driver.findElement(By.cssSelector("#mail")).click();
				//driver.findElement(By.linkText("Mail")).click();
				Thread.sleep(500);

				driver.findElement(By.name("from"));
				driver.findElement(By.name("to"));
				driver.findElement(By.name("subject"));
				driver.findElement(By.name("body"));
				// click
				driver.findElement(By.name("send")).click();

				String ex = driver.findElement(By.linkText("Gửi mail thất bại !")).getText();
				String ac = "Gửi mail thất bại !";
				Assert.assertEquals(ac, ex);
//					if (expectedTitle.equals(actualtitle)) {
//						System.out.println("test pass");
//					} else {
//						System.out.println("test failse");
//					}
				Thread.sleep(500);
				TestNGResults.put("5", new Object[] { 4d, "Fill form data", "empty  data", " Pass" });
			} catch (Exception e) {
				TestNGResults.put("5", new Object[] { 4d, "Fill form data", "empty data", " Fail" });
				Assert.assertTrue(false);
			}
		}
		
		// test mail enoughdata
				@Test(priority = 3)
				public void Testmail2() throws Exception {
					try {
						Thread.sleep(500);
						driver.findElement(By.linkText("Mail ")).click();
						Thread.sleep(500);

						driver.findElement(By.name("from")).sendKeys("nvtuanlv@gmail.com");
						driver.findElement(By.name("to")).sendKeys("tuannvps09393@fpt.edu.vn");;
						driver.findElement(By.name("subject")).sendKeys("123");
						driver.findElement(By.name("body")).sendKeys("321");
						// click
						driver.findElement(By.name("send")).click();

						String ex = driver.findElement(By.linkText("Gửi mail thành công !")).getText();
						String ac = "Gửi mail thành công !";
						Assert.assertEquals(ac, ex);
//							if (expectedTitle.equals(actualtitle)) {
//								System.out.println("test pass");
//							} else {
//								System.out.println("test failse");
//							}
						Thread.sleep(500);
						TestNGResults.put("6", new Object[] { 5d, "Fill form data", "enough  data", " Pass" });
					} catch (Exception e) {
						TestNGResults.put("6", new Object[] { 5d, "Fill form data", "enough data", " Fail" });
						Assert.assertTrue(false);
					}
				}
				

				@AfterTest
				public void suiteTearDown() {
					// write excel file and file name is SaveTestNGResultToExcel.xls
					Set<String> Keyset = TestNGResults.keySet();
					int rownum = 0;
					for (String key : Keyset) {
						Row row = sheet.createRow(rownum++);
						Object[] objArr = TestNGResults.get(key);
						int cellnum = 0;
						for (Object obj : objArr) {
							Cell cell = row.createCell(cellnum++);
							if (obj instanceof Date)
								cell.setCellValue((Date) obj);
							else if (obj instanceof Boolean)
								cell.setCellValue((Boolean) obj);
							else if (obj instanceof String)
								cell.setCellValue((String) obj);
							else if (obj instanceof Double)
								cell.setCellValue((Double) obj);
						}
					}
					try {
						FileOutputStream out = new FileOutputStream(new File("testsend mail.xlsx"));
						workbook.write(out);
						out.close();
						System.out.println("Successfully saved Selenium to excel");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					driver.close();
					driver.quit();
				}

}
