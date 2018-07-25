package testCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import utility.ScreenShot;
import utility.XlsReader;

public class TestCore_NormalClass {
	
	public WebDriver driver;
	public Properties Config = new Properties();
	public XlsReader Reader = new XlsReader("C:\\\\Users\\\\IBM_ADMIN\\\\Desktop\\\\selenium\\\\Workspace_Automation_Selenium\\\\TestDataForScript.xlsx");
	public Logger log = Logger.getLogger("devpinoyLogger");
	public ScreenShot evidence = new ScreenShot();

	@BeforeClass
	public void init() throws IOException {
	
		FileInputStream fis1 = new FileInputStream("C:\\Users\\IBM_ADMIN\\Desktop\\selenium\\Workspace_Automation_Selenium\\NASRegFramework\\src\\properties\\Config.properties");
		Config.load(fis1);
		
		System.out.println("Logging to url " +Config.getProperty("url"));
		
		if(Config.getProperty("browser").equals("firefox")) {
			log.debug("Opening Firefox Browser");
			driver = new FirefoxDriver();
		}
		/*else if(Config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Jar\\chromedriver.exe");
			log.debug("Opening Chrome Browser");
			driver = new ChromeDriver();
		}*/
		else if(Config.getProperty("browser").equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
			log.debug("Opening IE Browser");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.debug("Opening "+Config.getProperty("url"));
		driver.get(Config.getProperty("url"));
			}
	
	@AfterTest
	public void End() {
		log.debug("Closing Browser....");
		driver.quit();
		
	}
	
	
		
	}

