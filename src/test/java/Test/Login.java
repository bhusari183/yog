package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utility.Config;



public class Login {
		
		static Logger log=Logger.getLogger(Login.class.getName());
		
		//beforesuite
		@BeforeSuite
		public void openBrowser()
		{
			
			System.setProperty("webdriver.chrome.driver","D:\\TESTING REQUIRED APPS JARS\\Chrome 98 drivers\\chromedriver.exe");
			Config.driver=new ChromeDriver();
			log.info("===CHROME OPEN===");
			 System.out.println("xyz");
		}
		
		@BeforeTest
		public void enterUrl()
		{
			
			Config.driver.get("https://demo.guru99.com/test/newtours/");
			log.info("===ENTER URL===");
		}
		
		@BeforeClass
		public void TimemaxWindow()
		{
			Config.driver.manage().window().maximize();
			log.info("===WINDOW MAXIMIZE===");
			
		}
		
		@BeforeMethod
		public void ScreenshotCookie() throws IOException
		{
//			File src=((TakesScreenshot)Config.driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFileToDirectory(src,new File("D:\\TESTING REQUIRED APPS JARS\\FILES\\SCREENSHOTS\\DATA DRIVERN FRAMEWORK\\DEMO WEB SHOP\\REGISTER"));
//			log.info("===TAKE SCRENSHOT BEFORE METHOD===");
//		
			
		}
		
		
		
		@Test(dataProvider = "data")
		public void Register(String uname,String pass) throws IOException
		{
			
			LoginPage l=PageFactory.initElements(Config.driver,LoginPage.class);
			l.UserLogin(uname, pass);
			
			
			
		}
		@AfterMethod
		public void Screenshot() throws IOException
		{
//			File src=((TakesScreenshot)Config.driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFileToDirectory(src,new File("D:\\TESTING REQUIRED APPS JARS\\FILES\\SCREENSHOTS\\DATA DRIVERN FRAMEWORK\\DEMO WEB SHOP\\REGISTER"));
//			log.info("===TAKE SCRENSHOT AFTER METHOD===");
			
		}
		
		@AfterClass
		public void cookieDelet()
		{
			Config.driver.manage().deleteAllCookies();
			log.info("===DELETE COOKIE===");
			
		}
		
		@AfterTest
		public void dbConnection()
		{
			log.info("===DB CONNECTION CLOSED===");
			
		}
		
		@AfterSuite
		public void Close()
		{
			//driver.close();
			log.warn("===BROWSER CLOSED===");
		}
		

		@DataProvider
		public Object[][] data() throws IOException
		{
			FileInputStream in=new FileInputStream("E:\\xyz\\yogesh\\5_6084593671896827043.xlsx");
			Sheet s=WorkbookFactory.create(in).getSheet("Sheet1");
			
			Object[][] mr=new Object[s.getLastRowNum()][s.getRow(1).getLastCellNum()];
			
			for(int i=0;i<s.getLastRowNum();i++)
			{
				for(int j=0;j<s.getRow(i).getLastCellNum();j++)
				{
					mr[i][j]=s.getRow(i+1).getCell(j).getStringCellValue();
					System.out.println(mr[i][j]);
				}
			}
			return mr;
		}
		
}
