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

public class TestData {
	public String baseUrl = "http://localhost:8080/Assginment/";
	String driverPath = "E:\\fpoly\\KIEMTHUNANGCAO\\driver\\chromedriver.exe";
	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	
	//khai báo excel
	HSSFWorkbook workbook;
	//khai báo 1 b\u1EA3ng excel
	HSSFSheet sheet;
	//Khai báo m\u1ED9t \u0111\u1ED1i t\u01B0\u1EE3ng Map \u0111\u1EC3 gi\u1EEF k\u1EBFt qu\u1EA3 TestNG
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
	@Test(priority = 1)
	public void FillLoginDetails() throws Exception{
		try {
			//get user element
			WebElement username = driver.findElement(uimap.getLocator("Username_field"));
			username.sendKeys(datafile.getData("username"));
			//get pass element
			WebElement password = driver.findElement(uimap.getLocator("Password_field"));
			username.sendKeys(datafile.getData("password"));
			// click login
			WebElement login = driver.findElement(uimap.getLocator("Login_button"));
			login.click();
			Thread.sleep(500);
			WebElement onlineuser = driver.findElement(uimap.getLocator("online_user"));
			AssertJUnit.assertEquals("Top 10 nhân viên ưu tú ", onlineuser.getText());
			TestNGResults.put("3", new Object[] {2d,"Fill login form data","User ok: Pass ok"," Pass"});
		} catch (Exception e) {
			TestNGResults.put("3", new Object[] {2d,"Fill login form data","User null or Pass null"," Fail"});
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
