package sauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public static WebDriver driver = null ;
	public static String username = "//input[@id='user-name']";
	public static String password = "//input[@id='password']";
	public static String loginBtn = "//input[@id='login-button']";
	public void launch(String browsername , String url) {
		try {
		System.out.println("launch chrome browser");
		String userdir = System.getProperty("user.dir");
		System.out.println("user directory ="+userdir);
		String path = userdir+"\\src\\main\\java\\BrowserSpecificDriver\\msedgedriver.exe";
		String chromepath = userdir+"\\src\\main\\java\\BrowserSpecificDriver\\chromedriver.exe";
		System.out.println("path = "+path);
		if(browsername.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", path);
		 driver = new EdgeDriver();
		 System.out.println("launch edge");
		 driver.manage().window().maximize();
		 Thread.sleep(4000);
		}else if(browsername.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", chromepath);
//			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			 driver = new ChromeDriver(options);
			 System.out.println("launch chrome");
			 driver.manage().window().maximize();
			 Thread.sleep(4000);
				
		}
		driver.get(url);
		System.out.println("naivgate to url"+url);
		}catch(Exception e) {
			System.out.println("Failed at launch browser"+e.getMessage());
		}
		
	}
	
	public void login(String userid , String userpassword) {
		try{
		driver.findElement(By.xpath(username)).sendKeys(userid);
		Thread.sleep(4000);
		driver.findElement(By.xpath(password)).sendKeys(userpassword);
		Thread.sleep(4000);
		driver.findElement(By.xpath(loginBtn)).click();
		
		}catch(Exception e) {
			System.out.println("Failed at login");
		}
	}
	
	
	
}
