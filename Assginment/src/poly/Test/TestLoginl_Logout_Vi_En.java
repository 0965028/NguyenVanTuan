package poly.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginl_Logout_Vi_En {
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
	//test title
	@Test(priority = 1)
	public void veryfyHomePageTitle() throws Exception {
		try {
		String expectedTitle= "Assigment - Java5";
		String actualtitle= driver.getTitle();
		AssertJUnit.assertEquals(actualtitle, expectedTitle);
		Thread.sleep(200);
		TestNGResults.put("3", new Object[] {2d,"Test Title","Open Web"," Pass"});
	}catch(Exception e) {
		TestNGResults.put("3", new Object[] {2d,"Test Title","Open Web"," Fail"});
		Assert.assertTrue(false);
	}
	}
	//test login
	@Test(priority = 2)
	public void LoginTestAccount1() throws Exception{
		try {
		Thread.sleep(100);
		//Step 1 get the username element
		driver.findElement(By.cssSelector("#user_login"));
		driver.findElement(By.cssSelector("#user_pass")).sendKeys("123");
		//Step4
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#submitBtn")).click();
	
		//Step 5
		String expectedTitle="Assigment - Java5";
		String actualtitle=driver.getTitle();
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		}else {
			System.out.println("test failse");
		}
		Thread.sleep(500);
		TestNGResults.put("4", new Object[]{3d,"Fill login form data","User ok: Pass ok"," Pass"});
		
	}catch(Exception e){
		TestNGResults.put("4", new Object[] {3d,"Fill login form data","User null: Pass ok"," Fail"});
		Assert.assertTrue(false);
	}
	}
	//test login
	@Test(priority = 3)
	public void LoginTestAccount2() throws Exception{
		try {
		Thread.sleep(100);
		//Step3
		driver.findElement(By.cssSelector("#user_login")).sendKeys("anh");
		driver.findElement(By.cssSelector("#user_pass"));
		//Step4
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#submitBtn")).click();
	
		//Step 5
		String expectedTitle="Assigment - Java5";
		String actualtitle=driver.getTitle();
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		}else {
			System.out.println("test failse");
		}
		Thread.sleep(500);
		TestNGResults.put("5", new Object[]{4d,"Fill login form data","User ok: Pass ok"," Pass"});
	}catch(Exception e){
		TestNGResults.put("5", new Object[]{4d,"Fill login form data","User ok: Pass null"," Fail"});
		Assert.assertTrue(false);
	}
	}

	@Test(priority = 4)
	public void LoginTest() throws Exception{
		try {
		Thread.sleep(100);
		//Step3
		driver.findElement(By.cssSelector("#user_login")).sendKeys("anh");
		driver.findElement(By.cssSelector("#user_pass")).sendKeys("123");
		//Step4
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#submitBtn")).click();
	
		//Step 5
		String expectedTitle="Trang Quản Lý";
		String actualtitle=driver.getTitle();
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		}else {
			System.out.println("test failse");
		}
		Thread.sleep(200);
		TestNGResults.put("6", new Object[]{5d,"Fill login form data","User ok: Pass ok"," Pass"});
		
	}catch(Exception e) {
		TestNGResults.put("6", new Object[]{5d,"Fill login form data","User ok: Pass ok"," Fail"});
		Assert.assertTrue(false);
	}
	}
	// click en
	@Test(priority = 5)
	public void En() throws Exception{
		Thread.sleep(500);
		try {
			Thread.sleep(500);
			driver.findElement(By.linkText("English")).click();
			String expected="Home";
			WebElement actual=driver.findElement(By.linkText("Home"));
			AssertJUnit.assertEquals(actual, expected);
			if (expected.equals(actual)) {
				System.out.println("test pass");
			}else {
				System.out.println("test failse");
			}
			Thread.sleep(200);
			TestNGResults.put("7", new Object[]{6d,"CLick English","Web change language english"," Pass"});
		}catch(Exception e){
			TestNGResults.put("7", new Object[]{6d,"CLick English","Web unchanged language english"," Fail"});
			Assert.assertTrue(false);
		}
	}
	// click vi
		@Test(priority = 6)
		public void Vi() throws Exception{
			Thread.sleep(500);
			try {
				Thread.sleep(500);
				driver.findElement(By.linkText("Tiếng Việt")).click();
				String expected="Trang Chủ";
				WebElement actual=driver.findElement(By.linkText("Trang Chủ"));
				AssertJUnit.assertEquals(actual, expected);
				if (expected.equals(actual)) {
					System.out.println("test pass");
				}else {
					System.out.println("test failse");
				}
				Thread.sleep(200);
				TestNGResults.put("8", new Object[]{7d,"CLick VietNam","Web change language VietNames"," Pass"});
			}catch(Exception e){
				TestNGResults.put("8", new Object[]{7d,"CLick VietNam","Web unchanged language VietNames"," Fail"});
				Assert.assertTrue(false);
			}
		}
	//test logout
	@Test(priority = 7)
	public void LogoutTest() throws Exception{
		try {
		driver.navigate().to("http://localhost:8080/Assginment/");
		//Step2
		Thread.sleep(500);
		//Step3
		//Step4
		driver.findElement(By.cssSelector("#logout")).click();

		
		//Step 5
		String expectedTitle="Assigment - Java5";
		String actualtitle=driver.getTitle();
		
		if (expectedTitle.equals(actualtitle)) {
			System.out.println("test pass");
		}else {
			System.out.println("test failse");
		}
		Thread.sleep(500);
		Thread.sleep(200);
		TestNGResults.put("9", new Object[]{8d,"CLick Loguot","Back to login"," Pass"});
	}catch(Exception e){
		TestNGResults.put("9", new Object[]{8d,"CLick Loguot","Back to login"," Fail"});
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
			FileOutputStream out = new FileOutputStream(new File("TestLoginl_Logout_Vi_En.xlsx"));
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
