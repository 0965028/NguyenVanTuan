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
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUser {
	public String baseUrl = "http://localhost:8080/Assginment/";
	String driverPath = "E:\\fpoly\\KIEMTHUNANGCAO\\driver\\chromedriver.exe";
	public WebDriver driver;
	
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	
	//khai báo excel
			HSSFWorkbook workbook;
			//khai báo 1 bảng excel
			HSSFSheet sheet;
			//Khai báo một đối tượng Map để giữ kết quả TestNG
			Map<String,Object[]>TestNGResults;

	
			@BeforeTest
			public void launchBrowser() throws Exception{
				workbook = new HSSFWorkbook();

				sheet = workbook.createSheet("TestNg Result Summary");
				TestNGResults = new LinkedHashMap<String, Object[]>();

				TestNGResults.put("1", new Object[] { "Test No","Action","Expected Output","Actual Output " });
				try {
				System.out.println("launching chrome browser");
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				driver.get(baseUrl);
				driver.manage().window().maximize();
				Thread.sleep(200);
				TestNGResults.put("2", new Object[] {1d,"Natigate","Open Web"," Pass"});
			}catch(Exception e) {
				TestNGResults.put("2", new Object[] {1d,"Natigate","Open Web"," Fail"});
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
				TestNGResults.put("3", new Object[] {2d,"Test Title","Open Web"," Pass"});
			}catch(Exception e) {
				TestNGResults.put("3", new Object[] {2d,"Test Title","Open Web"," Fail"});
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
				TestNGResults.put("4", new Object[]{3d,"Fill login form data","User ok: Pass ok"," Pass"});
			}catch(Exception e){
				TestNGResults.put("4", new Object[] {3d,"Fill login form data","User null: Pass ok"," Fail"});
				Assert.assertTrue(false);
			}
		}

	
	// test ADDstaff
	@Test(priority = 2)
	public void TestAddUser1() throws Exception {
		try {
		Thread.sleep(500);
		driver.findElement(By.linkText("Tài Khoản")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Thêm Mới Người Dùng")).click();
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#Username"));
		driver.findElement(By.cssSelector("#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("#name")).sendKeys("Nguyễn Văn Tuấn");
		driver.findElement(By.cssSelector("#role")).click();
		Thread.sleep(50);
		driver.findElement(By.cssSelector("#admin")).click();
		driver.findElement(By.cssSelector("#role")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("#btnadd")).click();
		
		String expectedTitle=driver.getCurrentUrl();
		String actualtitle="http://localhost:8080/Assginment/admin/user/adduser.htm";
		Assert.assertEquals(actualtitle, expectedTitle);
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		} else {
			System.out.println("test failse");
		}
		Thread.sleep(500);
		TestNGResults.put("5", new Object[]{4d,"Fill form data","empty user data"," Pass"});
	}catch(Exception e) {
		TestNGResults.put("5", new Object[]{4d,"Fill form data","empty user data"," Fail"});
		Assert.assertTrue(false);
	}
	}
	
	// test ADDstaff
		@Test(priority = 3)
		public void TestAddUser2() throws Exception {
			try {
			Thread.sleep(500);
			driver.findElement(By.linkText("Tài Khoản")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Thêm Mới Người Dùng")).click();
			Thread.sleep(500);
			
			driver.findElement(By.cssSelector("#Username")).sendKeys("nvtuanlv");
			driver.findElement(By.cssSelector("#Password")).sendKeys("123");
			driver.findElement(By.cssSelector("#name")).sendKeys("Nguyễn Văn Tuấn");
			driver.findElement(By.cssSelector("#role")).click();
			Thread.sleep(50);
			driver.findElement(By.cssSelector("#admin")).click();
			driver.findElement(By.cssSelector("#role")).click();
			Thread.sleep(100);
			driver.findElement(By.cssSelector("#btnadd")).click();
			
			String expectedTitle=driver.getCurrentUrl();
			String actualtitle="http://localhost:8080/Assginment/admin/user/adduser.htm";
			Assert.assertEquals(actualtitle, expectedTitle);
			if (expectedTitle.equals(actualtitle)) {
				System.out.println("test pass");
			} else {
				System.out.println("test failse");
			}
			Thread.sleep(500);
			TestNGResults.put("6", new Object[]{5d,"Fill form data","enough data"," Pass"});
		}catch(Exception e) {
			TestNGResults.put("6", new Object[]{5d,"Fill form data","enough data"," Pass"});
			Assert.assertTrue(false);
		}
		}
	
	//test update
	@Test(priority = 4)
	public void TestUpdateUser1() throws Exception {
		Thread.sleep(500);
		driver.findElement(By.linkText("Tài Khoản")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Quản Lý Người Dùng")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#btnupdate")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("#Username")).clear();
		driver.findElement(By.cssSelector("#Username"));
		driver.findElement(By.cssSelector("#Password")).clear();
		driver.findElement(By.cssSelector("#Password")).sendKeys("123");
		Thread.sleep(50);
		driver.findElement(By.cssSelector("#customRadio2")).click();
		Thread.sleep(100);
		driver.findElement(By.name("_type")).click();
		
		String expectedTitle=driver.findElement(By.linkText("Update Thành Công")).getText();
		 String actualtitle="Update Thành Công";
		 Assert.assertEquals(actualtitle, expectedTitle);
		 if (expectedTitle.equals(actualtitle)) {
				System.out.println("test pass");
			} else {
				System.out.println("test failse");
			}
	}
	//test update
		@Test(priority = 5)
		public void TestUpdateUser2() throws Exception {
			Thread.sleep(500);
			driver.findElement(By.linkText("Tài Khoản")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Quản Lý Người Dùng")).click();
			Thread.sleep(500);
			driver.findElement(By.cssSelector("#btnupdate")).click();
			Thread.sleep(100);
			driver.findElement(By.cssSelector("#Username")).clear();
			driver.findElement(By.cssSelector("#Username")).sendKeys("PhamAnh");
			driver.findElement(By.cssSelector("#Password")).clear();
			driver.findElement(By.cssSelector("#Password")).sendKeys("123");
			Thread.sleep(50);
			driver.findElement(By.cssSelector("#customRadio2")).click();
			Thread.sleep(100);
			driver.findElement(By.name("_type")).click();
			
			String expectedTitle=driver.findElement(By.linkText("Update Thành Công")).getText();
			 String actualtitle="Update Thành Công";
			 Assert.assertEquals(actualtitle, expectedTitle);
			 if (expectedTitle.equals(actualtitle)) {
					System.out.println("test pass");
				} else {
					System.out.println("test failse");
				}
		}
	//delete staff
	@Test(priority = 6)
	public void DeleteUsers() throws Exception {	
		Thread.sleep(500);
		driver.findElement(By.linkText("Tài Khoản")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Quản Lý Người Dùng")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#delete")).click();
		

		 String ex=driver.findElement(By.linkText("Xóa Thành Công")).getText();
		 String ac="Xóa Thành Công";
		 Assert.assertEquals(ac, ex);		
	}
	 @AfterTest
	 public void suiteTearDown() {
		 //write excel file and file name is SaveTestNGResultToExcel.xls
		Set<String> Keyset = TestNGResults.keySet(); 
		int rownum = 0;
		for(String key : Keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for(Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if(obj instanceof Boolean)
					cell.setCellValue((Boolean)obj);
				else if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Double)
					cell.setCellValue((Double)obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("TestUser.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium to excel");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	 }

}
