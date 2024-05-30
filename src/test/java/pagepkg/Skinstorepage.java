package pagepkg;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class Skinstorepage {
	ChromeDriver driver;

	@FindBy(xpath = "//*[@id=\"omnisend-form-6324ab5a018728915f150a8a-close-action\"]")
	WebElement popup;
	
	
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/section/header/div/div/div[2]/div[2]/div")
	WebElement createaccount;
	
	@FindBy(xpath = "//*[@id=\"login-customer[email]\"]")
	WebElement emailid;
	
	@FindBy(xpath="//*[@id=\"login-customer[password]\"]")
	WebElement passwrd;
	
	@FindBy(xpath = "//*[@id=\"header_customer_login\"]/button")
	WebElement loginbutton;
	
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/section/header/div/div/h1/a/img")
	WebElement logos;
	
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/section/nav/div/div/ul/li[1]/a")
	WebElement skin;
	
	@FindBy(xpath = "//*[@id=\"desktop-menu-0-1\"]/div/div/div[1]/ul/li[2]/a")
	WebElement cleanser;
	
	@FindBy(xpath = "//*[@id=\"product_form_id_6650438385826_collection-template\"]/button[1]")
	WebElement neutrigenacart;
	
	@FindBy(xpath = "//*[@id=\"mini-cart\"]/div/div[2]/div[2]/div/a")
	WebElement viewcrt;
	
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/section/nav/div/div/ul/li[5]/a")
	WebElement babynmom;
	
	@FindBy(xpath = "//*[@id=\"shopify-section-collection-template\"]/section/div[1]/div[2]/div/div/div/div/div[2]/div[2]/div/div/a[2]")
	WebElement lotion;
	
	@FindBy(xpath = "//*[@id=\"product_form_5863724318882\"]/div[3]/div/button")
	WebElement wshlst;
	
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/section/nav/div/div/ul/li[9]/a")
	WebElement wshlstmenue;
	
	@FindBy(xpath = "//*[@id=\"swym-component-container\"]/div[2]/div/div/div[2]/div/div[2]/div/div[3]/ul/li/div/button[3]")
	WebElement addfrmwshlst;
	
	@FindBy(xpath = "/html/body/div[3]/section/header/div/div/div[2]/form/div[1]/div/div/input")
	WebElement search;
	
	@FindBy(xpath = "//*[@id=\"shopify-section-search-template\"]/section/div[1]/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div/div/a[2]")
	WebElement shampoo;
	
	@FindBy(xpath = "//*[@id=\"product_form_7361890615458\"]/div[1]/div[3]/div/div/button[2]")
	WebElement quantityincrment;
	
	@FindBy(xpath = "//*[@id=\"product_form_7361890615458\"]/div[2]/button")
	WebElement addtocartshampoo;
	
	@FindBy (xpath = "//*[@id=\"shopify-section-header\"]/section/header/div/div/div[3]/div[3]/a/div")
	WebElement carticon;
	
	@FindBy(xpath = "/html/body/div[3]/section/header/div/div/div[3]/div[3]/form/div/div[2]/div[2]/div/a")
	WebElement viewcart;
	
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/section/nav/div/div/ul")
	WebElement menu;
	
	@FindBy(xpath = "/html/body/div[2]/section/header/div/div/div[1]/a")
	WebElement home;
	
	public Skinstorepage(ChromeDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void crtacnt()
	
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		createaccount.click();
	}

	
	public void login(String email,String password) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		emailid.clear();
		emailid.sendKeys(email);
		passwrd.clear();
		//Thread.sleep(2000);
		passwrd.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	public void popups() {
		popup.click();
	}
	
	
	public void loginclick() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginbutton.submit();
	}
	
	public void logoicon() {
		Boolean logo= logos.isDisplayed();
		if(logo)
		{
			System.out.println("logo displayed");
		}
		else
		{
			System.out.println("logo not displayed");
			
		}
	}

	public void skinpdct() throws Exception
	{
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.moveToElement(skin).perform();
		cleanser.click();
		
		
	}
	public void addtocart() throws Exception {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("scroll(0,500)");
		Thread.sleep(2000);
		neutrigenacart.click();
		viewcrt.click();
		driver.navigate().back();
		
	}
	public void wishlist() throws InterruptedException {
		babynmom.click();
		lotion.click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("scroll(0,500)");
		wshlst.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().back();
		
	}
	
	public void search() {
		search.sendKeys("shampoo",Keys.ENTER);
		shampoo.click();
		quantityincrment.click();
		addtocartshampoo.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void viewcart() throws InterruptedException {
		
		driver.navigate().back();
		Thread.sleep(2000);
		carticon.click();
		viewcart.click();
		driver.navigate().refresh();
	}
	public void scrnshot() throws Exception {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./skinstorescrnshot/checkoutpage1.png"));
		Thread.sleep(2000);
		//driver.navigate().back();
	}
	public void menulist() {
		
		List<WebElement>li= menu.findElements(By.tagName("li"));
		for(WebElement men: li)
		{
			String print= men.getText();
			if(!print.isEmpty())
			{
				System.out.println(print.trim());
		
			}
		}
		
	}
	public void link()
	{
		
		home.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement>li=driver.findElements(By.tagName("a"));
		System.out.println("link count="+li.size());
	}
}
