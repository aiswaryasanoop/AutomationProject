package testpkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pagepkg.Skinstorepage;
import utilities.Skinstoreexcelutil;

public class Skinstoretest {
 
		
		ChromeDriver  driver;
		Skinstorepage ob;
		String baseurl="https://theskinstore.in";
		
	@BeforeTest
	public void setup() {
		
		
		driver =new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		driver.get(baseurl);
		driver.manage().window().maximize();
	
		
	}
	@BeforeMethod
	public void bfrmthd()
	{
	 ob=new Skinstorepage(driver);
	 
	}
	
	@Test(priority=1)
	public void logintest() throws Exception {
		ob.crtacnt();
		ob.popups();
		ob.crtacnt();
		String xl="C:\\Users\\sanoo\\OneDrive\\Desktop\\Luminar\\Book3.xlsx";
		 String sheet="sheet1";
		 int rowcount=Skinstoreexcelutil.getRowcount(xl, sheet);
		 System.out.println(rowcount);
		 for(int i=1;i<=rowcount;i++)
		 	 
		 {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 String username=Skinstoreexcelutil.getCellValue(xl, sheet, i, 0);
			 System.out.println("username----"+username);
			 String password= Skinstoreexcelutil.getCellValue(xl, sheet, i, 1);
			 System.out.println("password----"+password);
			 ob.login(username, password); 
			 ob.loginclick(); 
		 }
		 ob.logoicon();
	}
		 @Test(priority=2)
		 public void skintest() throws Exception {
			
			Thread.sleep(5000);
			 ob.skinpdct(); 
			 
		 }
		 @Test(priority=3)
		 public void addcart() throws Exception {
	
					ob.addtocart();
		 }
		 @Test(priority=4)
		 public void wishlist() throws Exception
		 {
			 ob.wishlist();
			 System.out.println("added to wishlist");
			 
		 }
	
	     @Test(priority=5)
	     public void searchtest() {
		  ob.search();
	  }
	  
	     @Test(priority=6)
	      public void viewcarttest() throws InterruptedException {
		  ob.viewcart();
	  }
	     @Test(priority=7)
	      public void scrnshottest() throws Exception {
		  ob.scrnshot();
	  }
	 
	     @Test(priority=8)
	      public void menutest() {
		  ob.menulist();
		 
	 }
	     @Test(priority=9)
	      public void linkcount() {
		  ob.link();
	}
}
