package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BaseClass {
	

		public static Properties prop=new Properties();
		public static WebDriver driver;
		
		
		
		public BaseClass() {
			try
			{
				FileInputStream file=new FileInputStream("C:\\Users\\Shalini\\parabank\\src\\test\\java\\Config\\config.properties");
				prop.load(file);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		public static void Initiation()
		{
			
			String browsername= prop.getProperty("browser");
			
			if(browsername.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Shalini\\parabank\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if (browsername.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Shalini\\parabank\\chromedriver.exe");
				driver= new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));;
			driver.get(prop.getProperty("url"));	
			

	}
		
	}


