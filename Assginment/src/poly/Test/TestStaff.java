package poly.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestStaff {
	public String baseUrl = "http://localhost:8080/Assginment/";
	String driverPath = "E:\\fpoly\\KIEMTHUNANGCAO\\driver\\chromedriver.exe";
	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	
	 int expMonth;
	 int expYear;
	 String expDate = null;
	 boolean dateNotFound;
	 
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
	

	// test title
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
	// test staff
		@Test(priority = 2)
		public void TestAddNewStafffail() throws Exception {
			try {
			// Step2 click nhanvien
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#nhanvien")).click();
			// Step3 click quan ly nhan vien
			Thread.sleep(1000);
			driver.findElement(By.linkText("Thêm Mới Nhân Viên")).click();
			
			driver.findElement(By.cssSelector("#name")).clear();
			
			driver.findElement(By.cssSelector("#customRadio1")).click();
			
			driver.findElement(By.cssSelector("#images"))
					.sendKeys("E:\\fpoly\\KIEMTHUNANGCAO\\PS09393_ASSIGNMENT\\Assginment\\WebContent\\img\\tuan.jpg");
			
			WebElement fromDateBox= driver.findElement(By.cssSelector("#birthday"));
			fromDateBox.clear();
			fromDateBox.sendKeys("12-20-2000");
			driver.findElement(By.cssSelector("#email")).clear();;
			
			driver.findElement(By.cssSelector("#phone")).clear();;
			
			driver.findElement(By.cssSelector("#salary")).sendKeys("5600000");
			
			driver.findElement(By.cssSelector("#notes")).sendKeys("okeee");
			
			driver.findElement(By.cssSelector("#depart")).click();
			Thread.sleep(100);
			driver.findElement(By.cssSelector("#depart")).sendKeys("Kế Toán");
		
			driver.findElement(By.cssSelector("#btnsave")).click();
			
			String expectedTitle=driver.getCurrentUrl();
			
			String actualtitle="http://localhost:8080/Assginment/admin/staff/addstaff.htm?message=them+that+bai";
			Assert.assertEquals(actualtitle, expectedTitle);
			
//			if (expectedTitle.equals(actualtitle)) {
//				System.out.println("test pass");
//			} else {
//				System.out.println("test failse");
//			}
			Thread.sleep(500);
			TestNGResults.put("5", new Object[]{4d,"Fill form data","empty name data"," Pass"});
		}catch(Exception e){
			TestNGResults.put("5", new Object[]{4d,"Fill form data","empty name data"," Fail"});
			Assert.assertTrue(false);
		}
		}
		// test staff
				@Test(priority = 3)
				public void TestAddNewStafffail1() throws Exception {
					try {
					// Step2 click nhanvien
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("#nhanvien")).click();
					// Step3 click quan ly nhan vien
					Thread.sleep(1000);
					driver.findElement(By.linkText("Thêm Mới Nhân Viên")).click();
					
					driver.findElement(By.cssSelector("#name")).sendKeys("Tuan");
					
					driver.findElement(By.cssSelector("#customRadio1")).click();
					
					driver.findElement(By.cssSelector("#images"))
							.sendKeys("E:\\fpoly\\KIEMTHUNANGCAO\\PS09393_ASSIGNMENT\\Assginment\\WebContent\\img\\tuan.jpg");
					
					WebElement fromDateBox= driver.findElement(By.cssSelector("#birthday"));
					fromDateBox.clear();
					fromDateBox.sendKeys("12-20-2000");
					driver.findElement(By.cssSelector("#email")).clear();
					driver.findElement(By.cssSelector("#phone")).clear();
					
					driver.findElement(By.cssSelector("#salary")).sendKeys("5600000");
					
					driver.findElement(By.cssSelector("#notes")).sendKeys("okeee");
					
					driver.findElement(By.cssSelector("#depart")).click();
					Thread.sleep(100);
					driver.findElement(By.cssSelector("#depart")).sendKeys("Kế Toán");
				
					driver.findElement(By.cssSelector("#btnsave")).click();
					
					String expectedTitle=driver.getCurrentUrl();
					
					String actualtitle="http://localhost:8080/Assginment/admin/staff/addstaff.htm?message=them+that+bai";
					Assert.assertEquals(actualtitle, expectedTitle);
					
//					if (expectedTitle.equals(actualtitle)) {
//						System.out.println("test pass");
//					} else {
//						System.out.println("test failse");
//					}
					Thread.sleep(500);
					TestNGResults.put("6", new Object[]{5d,"Fill form data","empty email data"," Pass"});
				}catch(Exception e){
					TestNGResults.put("6", new Object[]{5d,"Fill form data","empty email data"," Fail"});
					Assert.assertTrue(false);
				}
				}
				
				// test staff
				@Test(priority = 4)
				public void TestAddNewStafffail2() throws Exception {
					try {
					// Step2 click nhanvien
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("#nhanvien")).click();
					// Step3 click quan ly nhan vien
					Thread.sleep(1000);
					driver.findElement(By.linkText("Thêm Mới Nhân Viên")).click();
					
					driver.findElement(By.cssSelector("#name")).sendKeys("Tuan");
					
					driver.findElement(By.cssSelector("#customRadio1")).click();
					
					driver.findElement(By.cssSelector("#images"))
							.sendKeys("E:\\fpoly\\KIEMTHUNANGCAO\\PS09393_ASSIGNMENT\\Assginment\\WebContent\\img\\tuan.jpg");
					
					WebElement fromDateBox= driver.findElement(By.cssSelector("#birthday"));
					fromDateBox.clear();
					fromDateBox.sendKeys("12-20-2000");
					driver.findElement(By.cssSelector("#email")).sendKeys("nvtuanlv@gmail.com");
					
					driver.findElement(By.cssSelector("#phone")).clear();
					
					driver.findElement(By.cssSelector("#salary")).sendKeys("5600000");
					
					driver.findElement(By.cssSelector("#notes")).sendKeys("okeee");
					
					driver.findElement(By.cssSelector("#depart")).click();
					Thread.sleep(100);
					driver.findElement(By.cssSelector("#depart")).sendKeys("Kế Toán");
				
					driver.findElement(By.cssSelector("#btnsave")).click();
					
					String expectedTitle=driver.getCurrentUrl();
					
					String actualtitle="http://localhost:8080/Assginment/admin/staff/addstaff.htm?message=them+that+bai";
					Assert.assertEquals(actualtitle, expectedTitle);
					
					Thread.sleep(500);
					TestNGResults.put("7", new Object[]{6d,"Fill form data","empty phone data"," Pass"});
				}catch(Exception e){
					TestNGResults.put("7", new Object[]{6d,"Fill form data","empty phone data"," Fail"});
					Assert.assertTrue(false);
				}
				}
				
	// test staff
	@Test(priority = 5)
	public void TestAddNewStaff() throws Exception {
		try {
		// Step2 click nhanvien
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#nhanvien")).click();
		// Step3 click quan ly nhan vien
		Thread.sleep(1000);
		driver.findElement(By.linkText("Thêm Mới Nhân Viên")).click();
		
		driver.findElement(By.cssSelector("#name")).sendKeys("Tuan");
		
		driver.findElement(By.cssSelector("#customRadio1")).click();
		
		driver.findElement(By.cssSelector("#images"))
				.sendKeys("E:\\fpoly\\KIEMTHUNANGCAO\\PS09393_ASSIGNMENT\\Assginment\\WebContent\\img\\tuan.jpg");
		
		WebElement fromDateBox= driver.findElement(By.cssSelector("#birthday"));
		fromDateBox.clear();
		fromDateBox.sendKeys("12-20-2000");
		driver.findElement(By.cssSelector("#email")).sendKeys("nvtuanlv@gmail.com");
		
		driver.findElement(By.cssSelector("#phone")).sendKeys("0965028100");
		
		driver.findElement(By.cssSelector("#salary")).sendKeys("5600000");
		
		driver.findElement(By.cssSelector("#notes")).sendKeys("okeee");
		
		driver.findElement(By.cssSelector("#depart")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("#depart")).sendKeys("Kế Toán");
	
		driver.findElement(By.cssSelector("#btnsave")).click();
		
		String expectedTitle=driver.getCurrentUrl();
		String actualtitle="http://localhost:8080/Assginment/admin/staff/addstaff.htm?message=them+thanh+cong";
		Assert.assertEquals(actualtitle, expectedTitle);
		
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		} else {
			System.out.println("test failse");
		}
		Thread.sleep(500);
		TestNGResults.put("8", new Object[]{7d,"Fill form data","enough data"," Pass"});
	}catch(Exception e){
		TestNGResults.put("8", new Object[]{7d,"Fill form data","enough data"," Fail"});
		Assert.assertTrue(false);
	}
	}

	// test click trang updateStaff and chức năng
	@Test(priority = 6)
	public void TestStaffUdateEmail() throws Exception {
		try {
		// Step2 click qlnv
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#nhanvien")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Quản Lý Nhân Viên")).click();
		Thread.sleep(500);
		// Step4 click update
		driver.findElement(By.cssSelector("#btnupdate")).click();
		
		//test update
		driver.findElement(By.cssSelector("#email")).clear();
		driver.findElement(By.cssSelector("#email"));
		
		driver.findElement(By.cssSelector("#save")).click();
		
		String expectedTitle=driver.getCurrentUrl();
		String actualtitle="http://localhost:8080/Assginment/admin/staff/updatestaff.htm";
		Assert.assertEquals(actualtitle, expectedTitle);
		// Step3 click quan ly nhan vien
		
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		} else {
			System.out.println("test failse");
		}
		Thread.sleep(500);
		TestNGResults.put("9", new Object[]{8d,"Fill form data","empty email data"," Pass"});
	}catch(Exception e){
		TestNGResults.put("9", new Object[]{8d,"Fill form data","empty email data"," Fail"});
		Assert.assertTrue(false);
	}
	}
	
	// test click trang updateStaff and chức năng
	@Test(priority = 7)
	public void TestStaffUdateName() throws Exception {
		try {
		// Step2 click qlnv
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#nhanvien")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Quản Lý Nhân Viên")).click();
		Thread.sleep(500);
		// Step4 click update
		driver.findElement(By.cssSelector("#btnupdate")).click();
		
		//test update
		driver.findElement(By.cssSelector("#name")).clear();
		driver.findElement(By.cssSelector("#name"));
		
		
		driver.findElement(By.cssSelector("#save")).click();
		
		String expectedTitle=driver.getCurrentUrl();
		String actualtitle="http://localhost:8080/Assginment/admin/staff/updatestaff.htm";
		Assert.assertEquals(actualtitle, expectedTitle);
		// Step3 click quan ly nhan vien
		
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		} else {
			System.out.println("test failse");
		}
		Thread.sleep(500);
		TestNGResults.put("10", new Object[]{9d,"Fill form data","empty name data"," Pass"});
	}catch(Exception e){
		TestNGResults.put("10", new Object[]{9d,"Fill form data","empty name data"," Fail"});
		Assert.assertTrue(false);
	}
	}
	
	// test click trang updateStaff and chức năng
	@Test(priority = 8)
	public void TestStaffUdatePhone() throws Exception {
		try {
		// Step2 click qlnv
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#nhanvien")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Quản Lý Nhân Viên")).click();
		Thread.sleep(500);
		// Step4 click update
		driver.findElement(By.cssSelector("#btnupdate")).click();
		
		
		driver.findElement(By.cssSelector("#phone")).clear();
		driver.findElement(By.cssSelector("#phone"));
		
		driver.findElement(By.cssSelector("#save")).click();
		
		String expectedTitle=driver.getCurrentUrl();
		String actualtitle="http://localhost:8080/Assginment/admin/staff/updatestaff.htm";
		Assert.assertEquals(actualtitle, expectedTitle);
		// Step3 click quan ly nhan vien
		
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		} else {
			System.out.println("test failse");
		}
		Thread.sleep(500);
		TestNGResults.put("11", new Object[]{10d,"Fill form data","empty phone data"," Pass"});
	}catch(Exception e){
		TestNGResults.put("11", new Object[]{10d,"Fill form data","empty phone data"," Fail"});
		Assert.assertTrue(false);
	}
	}
	
	//delete staff
	@Test(priority = 9)
	public void DeleteUsers() throws Exception {	
		try {
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#nhanvien")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Quản Lý Nhân Viên")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#delete")).click();
		

		 String ex=driver.findElement(By.linkText("Xóa thàng công !")).getText();
		 String ac="Xóa thàng công !";
		 Assert.assertEquals(ac, ex);
		 Thread.sleep(500);
		 TestNGResults.put("12", new Object[]{11d,"click delete","delete one member"," Pass"});
			
	}catch(Exception e){
		TestNGResults.put("12", new Object[]{11d,"click delete","delete one member"," fail"});
		Assert.assertTrue(false);
	}
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
			FileOutputStream out = new FileOutputStream(new File("TestStaff.xlsx"));
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
