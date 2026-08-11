package TestBase;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class BaseClass
{
	public static WebDriver driver;
//	public Logger logger; // Log4j
	public static Logger logger;
	public static Properties p; 
//	public Properties p; 
	
	@BeforeSuite(groups = {"Sanity", "Regression","Master"})
	@Parameters({"os","browser"})
	
	public void setup(String os, String br) throws IOException
	{
		// loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties(); // read key-value pairs from a .properties file.
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch (br.toLowerCase())
		{
		case "chrome": 
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-features=PasswordLeakDetection");
		    options.setExperimentalOption("prefs", Map.of(
		        "credentials_enable_service", false,
		        "profile.password_manager_enabled", false
		    ));
		    
			driver = new ChromeDriver();
			break;
		case "edge": driver = new EdgeDriver();
			break;
		case "firefox": driver = new FirefoxDriver();
			break;
		default: System.out.println("Invalid browser name...");
			return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL")); // reading url from config.properties file
		driver.manage().window().maximize();
	}
	
//	@AfterClass(groups = {"Sanity", "Regression","Master"})
//	public void teardown()
//	{
//		driver.close();
//	}
	
//	@AfterClass(groups = {"Sanity", "Regression", "Master"})
//	public void tearDown() {
//	    if (driver != null) {
//	        driver.quit();
//	    }
//	}
	
	public String randomString()
	{
		String gen_str = RandomStringUtils.randomAlphabetic(5);
		return gen_str;	
	}
	
	public String randomNumber()
	{
		String gen_num = RandomStringUtils.randomNumeric(10);
		return gen_num;
	}
	
	public String randomPwd()
	{
//		String gen_pwd = RandomStringUtils.randomAlphanumeric(10);
//		return gen_pwd;
		String genStr = RandomStringUtils.randomAlphabetic(3);
		String genNum = RandomStringUtils.randomNumeric(3);
		return (genStr + "@" + genNum);
	}
	
	
	public String captureScreen(String tname) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp + ".png";
		File targeFile = new File(targetFilePath);
		
		sourceFile.renameTo(targeFile);
		
		return targetFilePath;
	}
	

}
